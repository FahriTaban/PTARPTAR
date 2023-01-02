package repair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.resToRun.ConvertResToRun;
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
			List<VariationVariable> vvs, String smt2libFilePath, String evalFilePath, int evalSetNr) {
		SMT2Encoding.createSMT2Encoding(run, npta, vType, vvs, smt2libFilePath);
		MaxSMT.repairValuesComputation(smt2libFilePath, vvs, evalFilePath);
		File evalFile = new File(evalFilePath);
		if(!Utility.isFileEmpty(evalFilePath)) {
			RepairComputation.repairNPTA(vvs, evalFilePath, evalSetNr);
		}	
	}
}
