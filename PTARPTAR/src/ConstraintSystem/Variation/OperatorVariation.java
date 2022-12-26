package ConstraintSystem.Variation;

import Run.*;
import Utility.Utility;
import NPTA.*;
import java.util.*;

import ConstraintSystem.ToSMT2;
import ConstraintSystem.VariationVariable;
import ConstraintSystem.RepairComputation.*;
import ConstraintSystem.VariationVariable.VarType;

public class OperatorVariation {

	public static String operatorVariation(List<OuterTransition> transitions, List<State> states, 
			List<Clock> clocks, List<VariationVariable> varVars, List<String> ops){
		List<List<String>> res = new ArrayList<>();
		res.addAll(getGuardBounds(transitions,clocks,varVars,ops));
		res.addAll(getInvariantBounds(states,clocks,varVars,ops));
		return Utility.concatPretty("and", "xor", res);
	}
	
	/**
	 * For every state and every invariant, create a list of strings representing clauses that are to be connected
	 * with xor.
	 * @param states
	 * @param clocks
	 * @param vars
	 * @param ops
	 * @return
	 */
	public static List<List<String>> getInvariantBounds(List<State> states, List<Clock> clocks, List<VariationVariable> vars, List<String> ops) {
		List<List<String>> allClauses = new ArrayList<>();
		for(int i = 0;i < states.size(); i++) {
			State state = states.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = state.iBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						List<String> varClauses = new ArrayList<>();
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String varName = "ovi"+Integer.toString(i);
						VariationVariable ov = new VariationVariable(varName, VarType.Operator);
						ov.setConstraint(bound);
						vars.add(ov);
						for(int j = 0; j < ops.size(); j++) {
							String op = ops.get(j);
							if (bound.getOperator().equals(op)) {
								ov.setNeutralRepairValue(Integer.toString(j));
							}
							String variation = ToSMT2.formatSMT(varName, Integer.toString(j), "=");
							List<String> iBound = ToSMT2.locationInvariantOV(alias, bound, delta, op);
							iBound.add(variation);
							String merged = ToSMT2.connectClauses(iBound, "and");
							varClauses.add(merged);
						}
						allClauses.add(varClauses);
					}
				}
			}
		}
		return allClauses;
	}
	
	/**
	 * For every transition, create a list of strings representing clauses that are to be connected with
	 * xor.
	 * @param ots
	 * @param clocks
	 * @param vars
	 * @param ops
	 * @return
	 */
	public static List<List<String>> getGuardBounds(List<OuterTransition> ots, List<Clock> clocks, List<VariationVariable> vars, List<String> ops) {
		List<List<String>> allgBounds = new ArrayList<>();
		for(int i = 0;i < ots.size(); i++) {
			OuterTransition t = ots.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = t.gBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						List<String> gBounds = new ArrayList<>();
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String varName = "ovg"+Integer.toString(i);
						VariationVariable ov = new VariationVariable(varName, VarType.Operator);
						ov.setConstraint(bound);
						vars.add(ov);							
						for(int j = 0; j < ops.size(); j++) {
							String op = ops.get(j);
							String variation = ToSMT2.formatSMT(varName, Integer.toString(j), "=");
							String gBound = ToSMT2.transitionGuardOV(alias, bound, delta, op);
							gBounds.add(ToSMT2.formatSMT(gBound, variation, "and"));
						}
						allgBounds.add(gBounds);
					}
				}
			}
		}
		return allgBounds;
	}
}
