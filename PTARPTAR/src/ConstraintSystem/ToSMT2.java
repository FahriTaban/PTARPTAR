package ConstraintSystem;

import java.util.ArrayList;
import java.util.List;

import NPTA.*;
import Run.OuterTransition;
import Run.State;

public class ToSMT2 {
		
	public static String assertion(Constraint c) {
		String cons = declareConstraint(c);
		return par("assert " + cons);
	}
	
	public static String declareConstraint(Constraint c) {
		return par(c.getOperator()+" "+c.getLhs().toString() + " " + c.getRhs().toString());
	}
	
	
	public static String declareReal(Variable v) {
		return par("declare-fun " + v.getName() + " " + par("") + " Real");
	}
	
	public static String declareReal(String v) {
		return par("declare-fun " + v + " " + par("") + " Real");
	}
	
	public static String initValue(Variable v) {
		return par("");
	}
	
	public static String par(String s) {
		if (s.equals("")) {
			return "()";
		} else if (!s.contains(" ")){
			return s;
		} else {
		return "("+s+")";
		}
	}
	
	public static String declareClocks(List<Clock> clocks, int numberOfStates) {
		StringBuilder s = new StringBuilder();
		for(Clock c : clocks) {
			for(int i = 0; i < numberOfStates; i++) {
				String alias = c.getName()+Integer.toString(i);
				s.append(declareReal(alias) + "\n");
			}
		}
		return s.toString().strip();
	}
	
	public static String declareParameters(List<Parameter> params) {
		StringBuilder s = new StringBuilder();
		for(Parameter p : params) {
			s.append(declareReal(p) + "\n");
		}
		return s.toString().strip();
	}
	
	public static String declareDelays(int numberOfTransitions) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < numberOfTransitions; i++) {
			s.append(declareReal("delta"+Integer.toString(i)) + "\n");
		}
		return s.toString().strip();
	}
	
	/**
	 * Encode clock initialization
	 * @param clocks
	 * @return
	 */
	public static String initializeInitConstraints(List<Constraint> constraints, List<Clock> clocks) {
		StringBuilder s = new StringBuilder();
		for(Constraint c : constraints) {
			Variable var = c.getLhs().getVariables().get(0);
			if (!isVariableClock(var,clocks)) {
				s.append(par(c.getOperator() + " " + var.getName() + " " + par(c.getRhs().toString())) + " ");
			} else {
				String alias = c.getLhs().toString() + "0";
				String op = c.getOperator();
				String rhs = c.getRhs().toString();
				s.append(par(op + " " + alias + " " + par(rhs))+ " ");
			}
		}
		return s.toString().strip();
	}
	
	/**
	 * Encode time advancement
	 * @param durations
	 * @return
	 */
	public static String timeAdvancement(int numberOfTransitions) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < numberOfTransitions; i++) {
			s.append(par("delta" + Integer.toString(i) +" >= 0") + " ");
		}
		return s.toString().strip();
	}
	
	public static String clockResets(List<List<Clock>> resetClocks) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < resetClocks.size(); i++) {
			List<Clock> rcs = resetClocks.get(i);
				for(Clock clock : rcs) {
					String var = clock.getName();
					s.append(par("= " + var+Integer.toString(i+1) + " 0") + " ");
				}
		}
		return s.toString().strip();	
	}
	
	public static String sojournTime(List<List<Clock>> clocks) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < clocks.size();i++) {
			List<Clock> cs = clocks.get(i);
			for(Clock c : cs) {
				String name_left = c.getName()+Integer.toString(i+1);
				String name_right = c.getName()+Integer.toString(i);
				String delta = "delta"+Integer.toString(i);
				s.append(par("= " + name_left + " " + par("+ " + name_right + " " + delta)));
			}
		}
		return s.toString().strip();
	}
	
	public static String getInvariantBounds(List<State> states, List<Clock> clocks){
		StringBuilder iBounds = new StringBuilder();
		for(int i = 0;i < states.size(); i++) {
			State state = states.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = state.iBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						iBounds.append(locationInvariants(alias, bound, delta) + " ");
					}
				}
			}
		}
		return iBounds.toString().strip();
	}
	
	public static String getTransitionGuards(List<OuterTransition> transitions, List<Clock> clocks) {
		StringBuilder gBounds = new StringBuilder();
		for(int i = 0;i < transitions.size(); i++) {
			OuterTransition trans = transitions.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = trans.gBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						gBounds.append(transitionGuards(alias, bound, delta) + " ");
					}
				}
			}
		}
		return gBounds.toString().strip();
	}
	
	private static String transitionGuards(String clock, Constraint c, String delta) {
		return par(c.getOperator() +  " " + clock + " " + par(c.getRhs().toSMTString()));
	}

	public static String locationInvariants(String clock, Constraint c, String delta) {
		String op = c.getOperator();
		String rhs = c.getRhs().toSMTString();
		return par(op + " " + clock + " " + par(rhs)) + " " + 
				par(op + " " + par("+ " + clock + " "+ delta) + " " + par(rhs));
	}
	
	private static boolean isVariableClock(Variable var, List<Clock> clocks) {
		for(Clock c : clocks) {
			if (c.getName().equals(var.getName())){
				return true;
			}
		}
		return false;
	}
	
}
