package ConstraintSystem.Variation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import ConstraintSystem.ToSMT2;
import ConstraintSystem.RepairComputation.VariationVariable;
import ConstraintSystem.RepairComputation.VariationVariable.VarType;
import NPTA.Clock;
import NPTA.Constraint;
import Run.OuterTransition;
import Run.State;
import Utility.Utility;

public class ClockReferenceVariation {
	
	
	public static String clockReferenceVariation(List<OuterTransition> transitions, List<State> states, 
			List<Clock> clocks, List<VariationVariable> vvs){
		List<List<String>> res = new ArrayList<>();
		res.addAll(getGuardBounds(transitions,clocks,vvs));
		res.addAll(getInvariantBounds(states,clocks,vvs));
		return Utility.concatPretty("and", "xor", res);
	}
	
	
	/**
	 * For every state and every invariant, create a list of strings representing clauses that are to be connected
	 * with xor.
	 * @param states
	 * @param clocks
	 * @param vvs
	 * @param ops
	 * @return
	 */
	public static List<List<String>> getInvariantBounds(List<State> states, List<Clock> clocks, List<VariationVariable> vvs) {
		List<List<String>> allClauses = new ArrayList<>();
		int l = 0;
		for(int i = 0; i < states.size(); i++) {
			State state = states.get(i);
			for(int j = 0; j < clocks.size(); j++) {
				Clock c = clocks.get(j);
				List<Constraint> bounds = state.iBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						List<String> varClauses = new ArrayList<>();
						String delta = "delta"+Integer.toString(i);
						String varName = "crvi"+Integer.toString(l++);
						VariationVariable crv = new VariationVariable(varName, VarType.ClockReference);
						crv.setConstraint(bound);
						vvs.add(crv);
						for(int k = 0; k < clocks.size(); k++) {
							Clock altC = clocks.get(k);
							if (altC == c) {
								crv.setNeutralRepairValue(Integer.toString(k));
							}
							String alias = altC.getName() + Integer.toString(i);
							crv.addClock(altC);
							String variation = ToSMT2.formatSMT(varName, Integer.toString(k), "=");
							List<String> iBound = ToSMT2.locationInvariant(alias, bound, delta);
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
	
	public static List<List<String>> getGuardBounds(List<OuterTransition> ots, List<Clock> clocks, List<VariationVariable> vvs) {
		List<List<String>> allgBounds = new ArrayList<>();
		int l = 0;
		for(int i = 0;i < ots.size(); i++) {
			OuterTransition t = ots.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = t.gBounds(c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						List<String> gBounds = new ArrayList<>();
						String delta = "delta"+Integer.toString(i);
						String varName = "crvg"+Integer.toString(l++);		
						VariationVariable crv = new VariationVariable(varName, VarType.Operator);
						crv.setConstraint(bound);
						vvs.add(crv);							
						for(int k = 0; k < clocks.size(); k++) {
							Clock altC = clocks.get(k);
							if (altC == c) {
								crv.setNeutralRepairValue(Integer.toString(k));
							}
							String alias = altC.getName() + Integer.toString(i);
							crv.addClock(altC);
							String variation = ToSMT2.formatSMT(varName, Integer.toString(k), "=");
							List<String> iBound = ToSMT2.locationInvariant(alias, bound, delta);
							iBound.add(variation);
							String merged = ToSMT2.connectClauses(iBound, "and");
							gBounds.add(merged);
						}
						allgBounds.add(gBounds);
					}
				}
			}
		}
		return allgBounds;
	}
	
}
