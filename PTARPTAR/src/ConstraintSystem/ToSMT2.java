package ConstraintSystem;

import java.util.ArrayList;
import java.util.List;

import NPTA.*;
import Run.OuterTransition;

public class ToSMT2 {
		
	public static String assertion(Constraint c) {
		String cons = declareConstraint(c);
		return par("assert " + cons);
	}
	
	public static String declareConstraint(Constraint c) {
		return par(c.getOperator()+" "+c.getEx1().toString() + " " + c.getEx2().toString());
	}
	
	
	public static String declareReal(Variable v) {
		return par("declare-fun " + v.getName() + " " + par("") + " " + " Real");
	}
	
	public static String declareReal(String v) {
		return par("declare-fun " + v + " " + par("") + " " + " Real");
	}
	
	public static String initValue(Variable v) {
		return par("");
	}
	
	public static String par(String s) {
		return "\\("+s+"\\)";
	}
	
	public static String declareVariable(List<Variable> variables) {
		StringBuilder s = new StringBuilder();
		for(Variable v : variables) {
			s.append(declareReal(v) + "\n");
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
	public static String initializeClocks(List<Clock> clocks) {
		StringBuilder s = new StringBuilder();
		for(Clock c : clocks) {
			s.append(par(c.getName() + " = 0")+ " ");
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
	
	public static String clockResets(List<List<Update>> updatess) {
		if (updatess.isEmpty()) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for(List<Update> updates : updatess) {
			for(int i = 0; i < updates.size(); i++) {
				Update up = updates.get(i);
				String var = up.getVariable();
				String value = up.getSetToValue();
				s.append(par(var+Integer.toString(i+1) + " = " + value) + " ");
			}
		}
		return s.toString().strip();	
	}
	
	public String sojournTime(List<List<Clock>> clocks) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < clocks.size();i++) {
			List<Clock> cs = clocks.get(i);
			for(Clock c : cs) {
				String name_left = c.getName()+Integer.toString(i+1);
				String name_right = c.getName()+Integer.toString(i);
				String delta = "delta"+Integer.toString(i);
				s.append(par(name_left + " = " + name_right + " + " + delta));
			}
		}
		return s.toString().strip();
	}
	
}
