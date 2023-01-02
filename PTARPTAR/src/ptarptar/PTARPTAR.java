package ptarptar;

import java.util.ArrayList;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.nptaToModel.ConvertNPTAToModel;
import convert.resToRun.ConvertResToRun;
import npta.NPTA;
import repair.RepairProcess;
import repair.repairComputation.MaxSMT;
import repair.repairComputation.RepairComputation;
import repair.repairComputation.VariationVariable;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.SMT2Encoding;
import run.Run;

public class PTARPTAR {
	
	public static void main(String[] args) {
		String repairedFile = "example_model";
		String unrepairedFile = "example";
		String repairedModelFilePath = repairedFile+".imi";
		String unrepairedModelFilePath = unrepairedFile+".imi";
		String resultFile = unrepairedFile+".res";
		String repairedStatespaceFile = repairedFile+"-statespace.states";
		String unrepairedStatespaceFile = unrepairedFile+"-statespace.states";
		String smt2libFilePath = "tdtcs.txt";
		String evalFilePath = "satEvals.txt";
		int evalSetNr = 1;
		NPTA unrepaired = ConvertModelToNPTA.createNPTA(unrepairedModelFilePath);
		Run run = ConvertResToRun.createRun(resultFile, unrepaired);
		VarType vType = VarType.ClockBound;
		List<VariationVariable> vvs = new ArrayList<>();
		repairModel(run, unrepaired, vType, vvs, smt2libFilePath, evalFilePath, evalSetNr, repairedModelFilePath);
		for(VariationVariable vv : vvs) {
			vv.printRepairInfo();
		}
	}
	
	public static void repairModel(Run run, NPTA npta, VarType vType, 
			List<VariationVariable> vvs, String smt2libFilePath, String evalFilePath, int evalSetNr
			, String repairedModelFilePath) {
		RepairProcess.conductRepair(run, npta, vType, vvs, smt2libFilePath, evalFilePath, evalSetNr);
		ConvertNPTAToModel.nptaToModel(npta, repairedModelFilePath);
	}

}
