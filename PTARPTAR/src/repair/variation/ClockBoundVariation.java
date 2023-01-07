package repair.variation;
import npta.*;
import repair.repairComputation.*;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.ToSMT2;
import run.*;
import utility.*;

import java.util.*;

public class ClockBoundVariation {
	
	public static String clockBoundVariation(List<List<Constraint>> guards, List<List<Constraint>> invariants, 
			List<Clock> clocks, List<VariationVariable> varVars){
		List<String> res = new ArrayList<>();
		res.addAll(getGuardBounds(guards,clocks,varVars));
		res.addAll(getInvariantBounds(invariants,clocks,varVars));
		res.addAll(getPositivityConstraints(varVars));
		return Utility.concatPretty("and", res);
	}
	
	public static List<String> getPositivityConstraints(List<VariationVariable> varVars){
		List<String> posCons = new ArrayList<>();
		for (VariationVariable varVar : varVars) {
			String exp = varVar.getConstraint().getRhs().toSMTString();
			posCons.add(ToSMT2.positityConstraint(exp, varVar.getName()));
		}
		return posCons;
	}
	
	public static List<String> getGuardBounds(List<List<Constraint>> guards, List<Clock> clocks, List<VariationVariable> varVars){
		HashMap<Constraint,VariationVariable> vvToC = new HashMap<>();
		List<String> gBounds = new ArrayList<>();
		VariationVariable guardBoundVar;
		int j = 0;
		for(int i = 0;i < guards.size(); i++) {
			List<Constraint> guard_set = guards.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = bounds(guard_set,c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						if(bound.isBoolean()) {
							continue;
						}
						guardBoundVar = vvToC.get(bound);
						if(guardBoundVar == null);{
							guardBoundVar = new VariationVariable("bvg"+Integer.toString(j++), VarType.ClockBound, bound);
							varVars.add(guardBoundVar);
							vvToC.put(bound, guardBoundVar);
						}
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String var = guardBoundVar.getName();
						String gBound = ToSMT2.transitionGuard(alias, bound, delta, var);
						gBounds.add(gBound);
					}
				}
			}
		}
		return gBounds;
	}
	
	public static List<String> getInvariantBounds(List<List<Constraint>> invariants, List<Clock> clocks, List<VariationVariable> varVars){
		HashMap<Constraint,VariationVariable> vvToC = new HashMap<>();
		VariationVariable invariantBoundVar;
		List<String> iBounds = new ArrayList<>();
		int j = 0;
		for(int i = 0;i < invariants.size(); i++) {
			List<Constraint> invariant_set = invariants.get(i);
			for(Clock c : clocks) {
				List<Constraint> bounds = bounds(invariant_set,c);
				if (!bounds.isEmpty()) {
					for(Constraint bound : bounds) {
						if(bound.isBoolean()) {
							continue;
						}
						invariantBoundVar = vvToC.get(bound);
						if(!vvToC.containsKey(bound) && invariantBoundVar == null)
						{
							System.out.println("not Exists");							
							invariantBoundVar = new VariationVariable("bvi"+Integer.toString(j++), VarType.ClockBound, bound);
							vvToC.put(bound, invariantBoundVar);
							System.out.println("Hashmap size: " + Integer.toString(vvToC.size()));
							varVars.add(invariantBoundVar);
						}
						String alias = c.getName() + Integer.toString(i);
						String delta = "delta"+Integer.toString(i);
						String var = invariantBoundVar.getName();
						List<String> iBound = ToSMT2.locationInvariant(alias, bound, delta, var);
						iBounds.addAll(iBound);
					}
				}
			}
		}
		return iBounds;
	}
	
	private static List<Constraint> bounds(List<Constraint> cons, Clock c){
		List<Constraint> iBounds = new ArrayList<>();
		for(Constraint con : cons) {
			if (con.constrainsClock(c)) {
				iBounds.add(con);
			}
		}
		return iBounds;
	}
}
