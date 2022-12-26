package ConstraintSystem.Variation;

import Run.State;
import Utility.Utility;

import java.util.*;

import ConstraintSystem.ToSMT2;
import ConstraintSystem.VariationVariable;
import ConstraintSystem.RepairComputation.*;
import ConstraintSystem.VariationVariable.VarType;

public class UrgentLocationVariation {
	
	public static String urgentLocationString(List<State> states, List<VariationVariable> vvs) {
		return Utility.concatPretty("and", urgentLocation(states,vvs));
	}
	
	public static List<String> urgentLocation(List<State> states, List<VariationVariable> vvs){
		List<String> clauses = new ArrayList<>();
		for(int i = 0; i < states.size(); i++) {
			State s  = states.get(i);
			String varName = "ulv"+Integer.toString(i);
			String delta = "delta"+Integer.toString(i);
			VariationVariable vv = new VariationVariable(varName,VarType.UrgentLocation);
			vvs.add(vv);
			String l1,l2,l3;
			l1 = ToSMT2.formatSMT(varName, "0", "=");
			l2 = ToSMT2.formatSMT(delta, "0", "=");
			if (s.isUrgent()) {
				l3 = ToSMT2.formatSMT(l1, l2, "=>");
			} else {
				l1 = ToSMT2.par("not " + l1);
				l3 = ToSMT2.formatSMT(l1, l2, "=>");
			}
			clauses.add(l3);
		}
		return clauses;
	}
}
