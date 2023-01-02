package repair.variation;
import npta.*;
import repair.repairComputation.VariationVariable;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.ToSMT2;
import run.*;
import utility.Utility;

import java.util.*;

public class ClockResetVariation {
	
	public static String changeResetsString(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs, boolean getResetClocks) {
		return Utility.concatPretty("and", changeResets(ots,clocks,vvs,getResetClocks));
	}
	
	public static List<String> changeResets(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs, boolean getResetClocks) {
		List<String> clauses = new ArrayList<>();
		String type;
		for(int i = 0; i < ots.size(); i++) {
			OuterTransition ot = ots.get(i);
			List<Clock> resetClocks;
			if (getResetClocks) {
				resetClocks = ot.getResetClocks(clocks);
				type = "r2nr";
			} else {
				resetClocks = ot.getNonResetClocks(clocks);
				type = "nr2r";
			}
			for(int j = 0; j < resetClocks.size(); j++) {
				Clock rc = resetClocks.get(j);
				String alias = rc.getName()+Integer.toString(i);
				String aliasPost = rc.getName()+Integer.toString(i+1);
				String delta = "delta"+Integer.toString(i);
				String varName = type+Integer.toString(i)+"_"+Integer.toString(j);
				VariationVariable vv = new VariationVariable(varName,VarType.ClockReset);
				vv.setClock(rc);
				if(getResetClocks) {
					vv.setTransition(ot.getUpdatingTransition(rc));
					vv.setUpdate(vv.getTransition().getClockUpdate(rc));
				} else {
					vv.setTransition(ot.getTransitions().get(0));
				}
				vv.setReset(!getResetClocks);
				vvs.add(vv);
				clauses.add(getResetClause(getResetClocks,varName,delta,alias,aliasPost));
			}
		}
		return clauses;
	}
	
	public static String getResetClause(boolean getResetClocks, String varName, String delta, String alias, String aliasPost) {
		String l1,l2,l3,im1,l4,l5,im2,res;
		if (getResetClocks) {
			// im1 is string for changing reset, im2 for not changing
			// sojourn time
			l1 = ToSMT2.formatSMT(delta, alias, "+");
			// poststate valuation
			l2 = ToSMT2.formatSMT(aliasPost, l1, "=");
			// variation var set to 1, meaning change
			l3 = ToSMT2.formatSMT(varName,"1" ,"=");
			// combine
			im1 = ToSMT2.formatSMT(l2, l3, "and");
			// no change
			l4 = ToSMT2.formatSMT(aliasPost, "0", "=");
			l5 = ToSMT2.formatSMT(varName, "0", "=");
			im2 = ToSMT2.formatSMT(l4, l5, "and");
			res = ToSMT2.formatSMT(im1, im2, "xor");
		} else {
			// im1 is string for changing reset, im2 for not changing
			// sojourn time
			l1 = ToSMT2.formatSMT(delta, alias, "+");
			// poststate valuation
			l2 = ToSMT2.formatSMT(aliasPost, l1, "=");
			// variation var set to 0, meaning no change
			l3 = ToSMT2.formatSMT(varName,"0" ,"=");
			// combine
			im1 = ToSMT2.formatSMT(l2, l3, "and");
			// change
			l4 = ToSMT2.formatSMT(aliasPost, "0", "=");
			l5 = ToSMT2.formatSMT(varName, "1", "=");
			im2 = ToSMT2.formatSMT(l4, l5, "and");
			res = ToSMT2.formatSMT(im1, im2, "xor");
		}
		return res;
	}
}
