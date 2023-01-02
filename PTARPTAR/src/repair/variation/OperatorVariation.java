package repair.variation;

import npta.*;
import repair.repairComputation.*;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.ToSMT2;
import run.*;
import utility.Utility;

import java.util.*;

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
		int j = 0;
		for(int i = 0;i < states.size(); i++) {
			State state = states.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = state.iBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						bound.printInfo();
						List<String> varClauses = new ArrayList<>();
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String varName = "ovi"+Integer.toString(j++);
						VariationVariable ov = new VariationVariable(varName, VarType.Operator);
						ov.setConstraint(bound);
						vars.add(ov);
						for(int k = 0; k < ops.size(); k++) {
							String op = ops.get(k);
							if (bound.getOperator().equals(op)) {
								ov.setNeutralRepairValue(Integer.toString(k));
							}
							String variation = ToSMT2.formatSMT(varName, Integer.toString(k), "=");
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
		int j = 0;
		for(int i = 0;i < ots.size(); i++) {
			OuterTransition t = ots.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = t.gBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						bound.printInfo();
						List<String> gBounds = new ArrayList<>();
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String varName = "ovg"+Integer.toString(j++);
						VariationVariable ov = new VariationVariable(varName, VarType.Operator);
						ov.setConstraint(bound);
						vars.add(ov);							
						for(int k = 0; k < ops.size(); k++) {
							String op = ops.get(k);
							if (bound.getOperator().equals(op)) {
								ov.setNeutralRepairValue(Integer.toString(k));
							}
							String variation = ToSMT2.formatSMT(varName, Integer.toString(k), "=");
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
