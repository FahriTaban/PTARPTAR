package repair.repairComputation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import npta.Constraint;
import parse.Element;
import parse.evaluation.Eval_Lexer;
import parse.evaluation.Eval_Parser;

public class RepairComputation {
	
	public static List<Constraint> repairNPTA(List<VariationVariable> vvs, String pathToEvals, int evaluationSetNr) {
		Eval_Lexer lex = new Eval_Lexer(pathToEvals);
		lex.findTokens();
		List<Element> evals = lex.getTokens();
		Eval_Parser parser = new Eval_Parser();
		HashMap<String,String> repairValues = parser.getParameterValuation(evals, evaluationSetNr);
		List<Constraint> cons = new ArrayList<>();
		for(VariationVariable vv : vvs) {
			String vName = vv.getName();
			String repairValue = repairValues.get(vName);
			vv.setRepairValue(repairValue);
			Constraint c = vv.getConstraint();
			c.backUp();
			cons.add(c);
			vv.repairNPTA();
		}
		return cons;
	}
} 