package ConstraintSystem.Variation;
import Run.*;
import Utility.Utility;
import NPTA.*;
import java.util.*;

import ConstraintSystem.ToSMT2;
import ConstraintSystem.VariationVariable;
import ConstraintSystem.VariationVariable.VarType;

public class ClockResetVariation {
	
	public static String changeResetsString(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs, boolean getResetClocks) {
		return Utility.concatPretty("and", changeResets(ots,clocks,vvs,getResetClocks));
	}
	
	public static List<String> changeResets(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs, boolean getResetClocks) {
		List<String> clauses = new ArrayList<>();
		for(int i = 0; i < ots.size(); i++) {
			OuterTransition ot = ots.get(i);
			List<Clock> resetClocks;
			if (getResetClocks) {
				resetClocks = ot.getResetClocks(clocks);
			} else {
				resetClocks = ot.getNonResetClocks(clocks);
			}
			for(int j = 0; j < resetClocks.size(); j++) {
				Clock rc = resetClocks.get(j);
				String alias = rc.getName()+Integer.toString(i);
				String aliasPost = rc.getName()+Integer.toString(i+1);
				String delta = "delta"+Integer.toString(i);
				String varName = "rcv"+Integer.toString(i)+"_"+Integer.toString(j);
				VariationVariable vv = new VariationVariable(varName,VarType.ClockReset);
				vv.setClock(rc);
				vvs.add(vv);
				String l1,l2,l3;
				if (getResetClocks) {
					l1 = ToSMT2.formatSMT(delta, alias, "+");
					l2 = ToSMT2.formatSMT(aliasPost, l1, "=");
					l3 = ToSMT2.formatSMT(varName,"0" ,"=");
				} else {
					l2 = ToSMT2.formatSMT(aliasPost, "0", "=");
					l3 = ToSMT2.formatSMT(varName, "0", "=");
				}
				String clause = ToSMT2.formatSMT(l2, l3, "xor");
				clauses.add(clause);
			}
		}
		return clauses;
	}
}
