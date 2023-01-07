package repair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.nptaToModel.ConvertNPTAToModel;
import convert.resToRun.ConvertResToRun;
import npta.Constraint;
import npta.NPTA;
import repair.repairComputation.MaxSMT;
import repair.repairComputation.RepairComputation;
import repair.repairComputation.VariationVariable;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.SMT2Encoding;
import run.Run;
import utility.Utility;

public class RepairProcess {
	public static void conductRepair(Run run, NPTA npta, VarType vType, 
			List<VariationVariable> vvs, String smt2libFilePath, String evalFilePath,
			String repairedModelFilePath) {
		SMT2Encoding.createSMT2Encoding(run, vType, vvs, smt2libFilePath);
		int nrSatEvals = MaxSMT.repairValuesComputation(smt2libFilePath, vvs, evalFilePath);
		File evalFile = new File(evalFilePath);
		if(!Utility.isFileEmpty(evalFilePath)) {
			for(int i = 1; i <= 1; i++) {
				List<Constraint> cons = RepairComputation.repairNPTA(vvs, evalFilePath, i);
				String temp = repairedModelFilePath.replace(".", Integer.toString(i)+".");
				ConvertNPTAToModel.nptaToModel(npta, temp);
				for(Constraint c : cons) {
					c.restore();
				}
			}
		}	
	}
}
