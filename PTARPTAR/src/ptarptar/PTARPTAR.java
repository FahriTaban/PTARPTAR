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
		long startTime = System.currentTimeMillis();
		String unrepairedFile = "files/example";
		String repairedFile = unrepairedFile + "_repaired";
		String repairedModelFilePath = repairedFile+".imi";
		String unrepairedModelFilePath = unrepairedFile+".imi";
		String resultFile = unrepairedFile+".res";
		String repairedStatespaceFile = repairedFile+"-statespace.states";
		String unrepairedStatespaceFile = unrepairedFile+"-statespace.states";
		String smt2libFilePath = "files/tdtcs.txt";
		String evalFilePath = "files/satEvals.txt";
		int evalSetNr = 1;
		NPTA unrepaired = ConvertModelToNPTA.createNPTA(unrepairedModelFilePath);
		Run run = ConvertResToRun.createRun(resultFile, unrepaired);
		VarType vType = VarType.ClockBound;
		List<VariationVariable> vvs = new ArrayList<>();
		repairModel(run, unrepaired, vType, vvs, smt2libFilePath, evalFilePath, evalSetNr, repairedModelFilePath);
		for(VariationVariable vv : vvs) {
			vv.printRepairInfo();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("TOTAL COMPUTATION TIME: " + Long.toString(endTime - startTime));
	}
	
	public static void repairModel(Run run, NPTA npta, VarType vType, 
			List<VariationVariable> vvs, String smt2libFilePath, String evalFilePath, int evalSetNr
			, String repairedModelFilePath) {
		RepairProcess.conductRepair(run, npta, vType, vvs, smt2libFilePath, evalFilePath, repairedModelFilePath);
	}

}
