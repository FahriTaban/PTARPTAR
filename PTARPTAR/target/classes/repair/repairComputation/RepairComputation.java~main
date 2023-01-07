package repair.repairComputation;

import java.util.HashMap;
import java.util.List;

import parse.Element;
import parse.Evaluation.Eval_Lexer;
import parse.Evaluation.Eval_Parser;

public class RepairComputation {
	
	public static void repairNPTA(List<VariationVariable> vvs, String pathToEvals, int evaluationSetNr) {
		Eval_Lexer lex = new Eval_Lexer(pathToEvals);
		lex.findTokens();
		List<Element> evals = lex.getTokens();
		Eval_Parser parser = new Eval_Parser();
		HashMap<String,String> repairValues = parser.getParameterValuation(evals, evaluationSetNr);
		for(VariationVariable vv : vvs) {
			String vName = vv.getName();
			String repairValue = repairValues.get(vName);
			vv.setRepairValue(repairValue);
			vv.repairNPTA();
		}
	}
} 