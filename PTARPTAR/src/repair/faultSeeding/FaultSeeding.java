package repair.faultSeeding;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import npta.NPTA;
import repair.repairComputation.VariationVariable.VarType;
import run.Run;

public class FaultSeeding {
	public static void seedFault(NPTA npta, Run run, VarType vType) {
		run.getPropertyConstraints();
		switch(vType) {
		case ClockBound:
			int m = npta.getHighestBound();
			int[] vals = {-10,-1,+1,0.1,
			int clockNr = ThreadLocalRandom.current().nextInt(0, npta.getModifiableConstraints().size());
			int 
			break;
		case ClockReference:
			sequence = List.of(0,1,-2,4,5);
			lower = "0";
			upper = Integer.toString(clocks.size());
			break;
		case ClockReset:
			sequence = List.of(-3,2,3,4,5);
			lower = "0";
			upper = "1";
			break;
		case Operator:
			sequence = List.of(0,1,-4,4,5);
			lower = "0";
			upper = "4";
			break;
		case UrgentLocation:
			sequence = List.of(0,1,2,3,-5,5);
			lower = "0";
			upper = "1";
			break;
		case ParameterBound:
			sequence = List.of(0,1,2,3,4,5,-6);
			break;
		default:
			sequence = List.of();
			break;
		}
	}
}
