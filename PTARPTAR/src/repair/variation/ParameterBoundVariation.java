package repair.variation;

import npta.*;
import repair.repairComputation.VariationVariable;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.ToSMT2;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class ParameterBoundVariation {
	
	public static String parameterBoundString(List<Parameter> params, List<VariationVariable> vvs) {
		return Utility.concatPretty("and", parameterBound(params,vvs));
	}
	
	public static List<String> parameterBound(List<Parameter> params, List<VariationVariable> vvs){
		List<String> s = new ArrayList<>();
		int j = 0;
		for(Parameter p: params) {
			String varNameLower = "pbl"+Integer.toString(j);
			String varNameUpper = "pbu"+Integer.toString(j++);
			String param = p.getName();
			VariationVariable pbl = new VariationVariable(varNameLower, VarType.ParameterBound);
			VariationVariable pbu = new VariationVariable(varNameUpper, VarType.ParameterBound);
			pbl.setNeutralRepairValue("0");
			pbu.setNeutralRepairValue("100");
			vvs.add(pbl);
			vvs.add(pbu);
			String l1 = ToSMT2.formatSMT(param, varNameLower, ">=");
			String l2 = ToSMT2.formatSMT(param, varNameUpper, "<=");
			String l3 = l1 + " " + l2;
			s.add(ToSMT2.formatSMT(varNameLower, "0", ">="));
			s.add(ToSMT2.formatSMT(varNameUpper, "0", ">="));
			s.add(l3);
		}
		return s;
	}
}