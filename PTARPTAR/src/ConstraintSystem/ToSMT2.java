package ConstraintSystem;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import ConstraintSystem.RepairComputation.VariationVariable;
import NPTA.*;
import Run.OuterTransition;
import Run.State;
import Utility.Utility;

public class ToSMT2 {
	
	public static List<String> declareBoundVariables(List<Clock> clocks, List<Parameter> params,
			int numberOfStates,int numberOfTransitions) {
		List<String> res = new ArrayList<>();
		res.addAll(declareVariables(clocks, numberOfStates,true));
		res.addAll(declareVariables(params, 0, true));
		res.addAll(declareDelays(numberOfTransitions,true));
		return res;
	}
	
	public static String concatWith(String op, String s) {
		return par(op + " " + s);
	}
	
	public static String declareConstraint(Constraint c) {
		return par(c.getOperator()+" "+c.getLhs().toString() + " " + c.getRhs().toString());
	}	
	
	public static String declareInt(String v) {
		return par("declare-fun " + v + " " + par("") + " Int");
	}
	
	public static String declareReal(String v) {
		return par("declare-fun " + v + " " + par("") + " Real");
	}
	
	public static String declareBoundReal(String v) {
		return par(v + " Real");
	}
	
	public static String par(String s) {
		if (s.equals("")) {
			return "()";
		} 
		else if (!s.contains(" ") && !s.contains("-")){
			return s;
		} 
		else {
		return "("+s+")";
		}
	}
	
	public static <T extends Variable> List<String> declareVariables(List<T> vars, 
			int numberOfStates, boolean bound) {
		List<String> s = new ArrayList<>();
 		for(T v : vars) {
			String alias = v.getName();
 			if (v instanceof Clock) {
				for(int i = 0; i < numberOfStates; i++) {
					if (!bound) {
						s.add(declareReal(alias+Integer.toString(i)));
					} else {
						s.add(declareBoundReal(alias+Integer.toString(i)));
					}
				}
 			} else {
 				if (!bound) {
					s.add(declareReal(alias));
				} else {
					s.add(declareBoundReal(alias));
				}
 			}
		}
		return s;
	}
	
	public static List<String> constrainVariationVariables(List<VariationVariable> vvs, String upper,
			String lower) {
		List<String> strings = new ArrayList<>();
		String uBound, lBound, and;
		for(VariationVariable vv : vvs) {
			String varName = vv.getName();
			uBound = ToSMT2.formatSMT(varName, upper, "<=");
			lBound = ToSMT2.formatSMT(varName, lower, ">=");
			and = ToSMT2.formatSMT(uBound, lBound, "and");
			strings.add(and);
		}
		return strings;
	}
	
	public static List<String> declareVariationVariables(List<VariationVariable> vvs){
		List<String> s = new ArrayList<>();
		for(VariationVariable vv : vvs) {
			s.add(declareInt(vv.getName()));
		}
		return s;
	}
	
	public static List<String> declareParameters(List<Parameter> params) {
		List<String> s = new ArrayList<>();
		for(Parameter p : params) {
			s.add(declareReal(p.getName()));
		}
		return s;
	}
	
	public static List<String> declareDelays(int numberOfTransitions,boolean bound) {
		List<String> s = new ArrayList<>();
		for(int i = 0; i < numberOfTransitions; i++) {
			String delta = "delta"+Integer.toString(i);
			if (!bound) {
				s.add(declareReal(delta));
			} else {
				s.add(declareBoundReal(delta));
			}
		}
		return s;
	}
	
	/**
	 * Encode clock initialization
	 * @param clocks
	 * @return
	 */
	public static String initializeInitConstraints(List<Constraint> constraints, List<Clock> clocks) {
		List<String> s = new ArrayList<>();
		for(Constraint c : constraints) {
			Variable var = c.getLhs().getVariables().get(0);
			if (!isVariableClock(var,clocks)) {
				s.add(par(c.getOperator() + " " + var.getName() + " " + par(c.getRhs().toString())));
			} else {
				String alias = c.getLhs().toString() + "0";
				String op = c.getOperator();
				String rhs = c.getRhs().toString();
				s.add(par(op + " " + alias + " " + par(rhs)));
			}
		}
		return Utility.concatPretty("and", s);
	}
	
	/**
	 * Encode time advancement
	 * @param durations
	 * @return
	 */
	public static String timeAdvancement(int numberOfTransitions) {
		List<String> s = new ArrayList<>();
		for(int i = 0; i < numberOfTransitions; i++) {
			String tA = formatSMT("delta" + Integer.toString(i),"0", ">=");
			s.add(tA);
		}
		return Utility.concatPretty("and", s);
	}
	
	public static String clockResets(List<List<Clock>> resetClocks) {
		List<String> s = new ArrayList<>();
		for(int i = 0; i < resetClocks.size(); i++) {
			List<Clock> rcs = resetClocks.get(i);
				for(Clock clock : rcs) {
					String var = clock.getName()+Integer.toString(i+1);
					String cR = par("= " + var + " 0");
					s.add(cR);
				}
		}
		return Utility.concatPretty("and", s);	
	}
	
	public static String sojournTime(List<List<Clock>> clocks) {
		List<String> s = new ArrayList<>();
		for(int i = 0; i < clocks.size();i++) {
			List<Clock> cs = clocks.get(i);
			for(Clock c : cs) {
				String name_left = c.getName()+Integer.toString(i+1);
				String name_right = c.getName()+Integer.toString(i);
				String delta = "delta"+Integer.toString(i);
				String sT = formatSMT(name_left, addVar(name_right,delta),"=");
				s.add(sT);
			}
		}
		return Utility.concatPretty("and", s);
	}
	
	public static String getInvariantBounds(List<State> states, List<Clock> clocks) {
		List<String> iBounds = new ArrayList<>();
		for(int i = 0;i < states.size(); i++) {
			State state = states.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = state.iBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						List<String> gBound = locationInvariant(alias, bound, delta);
						iBounds.addAll(gBound);
					}
				}
			}
		}
		return Utility.concatPretty("and", iBounds);
	}
	
	public static String getTransitionGuards(List<OuterTransition> transitions, List<Clock> clocks) {
		List<String> gBounds = new ArrayList<>();
		for(int i = 0;i < transitions.size(); i++) {
			OuterTransition trans = transitions.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = trans.gBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String gBound = transitionGuard(alias, bound, delta);
						gBounds.add(gBound);
					}
				}
			}
		}
		return Utility.concatPretty("and", gBounds);
	}
	
	public static String transitionGuard(String clock, Constraint c, String delta) {
		return par(c.getOperator() +  " " + clock + " " + par(c.getRhs().toSMTString()));
	}
	
	public static String transitionGuard(String clock, Constraint c, String delta, String varVar) {
		return par(c.getOperator() +  " " + clock + " " + addVar(par(c.getRhs().toSMTString()),varVar));
	}
	
	public static String transitionGuardOV(String clock, Constraint c, String delta, String op) {
		return par(op +  " " + clock + " " + par(c.getRhs().toSMTString()));
	}
	
	public static String transitionGuard(String clock, Constraint c, String delta, String varVar, String op) {
		return par(op +  " " + clock + " " + addVar(par(c.getRhs().toSMTString()),varVar));
	}

	public static List<String> locationInvariant(String clock, Constraint c, String delta) {
		List<String> lI = new ArrayList<>();
		String op = c.getOperator();
		String rhs = c.getRhs().toSMTString();
		lI.add(par(op + " " + clock + " " + par(rhs)));
		lI.add(par(op + " " + addVar(clock,delta) + " " + par(rhs)));
		return lI;
	}
	
	public static List<String> locationInvariant(String clock, Constraint c, String delta, String var) {
		List<String> lI = new ArrayList<>();
		String op = c.getOperator();
		String rhs = c.getRhs().toSMTString();
		lI.add(par(op + " " + clock + " " + addVar(par(rhs),var)));
		lI.add(par(op + " " + addVar(clock,delta) + " " + addVar(par(rhs),var)));
		return lI;
	}
	
	public static List<String> locationInvariantOV(String clock, Constraint c, String delta, String op) {
		List<String> lI = new ArrayList<>();
		String rhs = c.getRhs().toSMTString();
		lI.add(par(op + " " + clock + " " + par(rhs)));
		lI.add(par(op + " " + addVar(clock,delta) + " " + par(rhs)));
		return lI;
	}
	
	public static List<String> locationInvariant(String clock, Constraint c, String delta, String var, String op) {
		List<String> lI = new ArrayList<>();
		String rhs = c.getRhs().toSMTString();
		lI.add(par(op + " " + clock + " " + addVar(par(rhs),var)));
		lI.add(par(op + " " + addVar(clock,delta) + " " + addVar(par(rhs),var)));
		return lI;
	}
	
	public static String connectClauses(List<String> clauses, String operation) {
		StringBuilder s = new StringBuilder();
		s.append(operation + " ");
		for(String c : clauses) {
			s.append(c + " ");
		}
		return par(s.toString().strip());
	}
	
	public static String connectClausesPretty(List<String> clauses, String operation) {
		StringBuilder s = new StringBuilder();
		s.append(operation+ " ");
		return par(s.toString().strip());
	}
	
	public static String positityConstraint(String exp, String var) {
		return par(">= " + addVar(exp,var) + " 0");
	}
	
	public static String urgentLocations(HashMap<Integer,State> locs) {
		List<String> s = new ArrayList<>();
		for(Integer i : locs.keySet()) {
			String delta = "delta"+i.toString();
			s.add(formatSMT(delta,"0","="));
		}
		return Utility.concatPretty("and", s);
	}

	private static boolean isVariableClock(Variable var, List<Clock> clocks) {
		for(Clock c : clocks) {
			if (c.getName().equals(var.getName())){
				return true;
			}
		}
		return false;
	}
	
	private static String addVar(String exp, String var) {
		return par("+ " + exp + " " + var);
	}
	
	public static String formatSMT(String l1, String l2, String op) {
		return par(op + " " + l1 + " " + l2);
	}
	
}
