package admissibility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import convert.statespaceToNFA.ConvertSSToNFA;
import parse.evaluation.Eval_Lexer;
import parse.evaluation.Eval_Parser;
import repair.repairComputation.VariationVariable;

public class Admissibility {
	
	public static boolean checkLanguageEquivalence(String repairedModel, String unrepairedModel,String violatingTrace) {
		NFA unrepaired = ConvertSSToNFA.createNFA(unrepairedModel);
		NFA repaired = ConvertSSToNFA.createNFA(repairedModel);
		unrepaired.genLanguage();
		repaired.genLanguage();
		HashSet<String> unrepairedL = unrepaired.getLanguage();
		System.out.println("Violating trace removed: "+unrepairedL.remove(violatingTrace));
		HashSet<String> repairedL = repaired.getLanguage();
		boolean equal = true;
		for(String word : unrepairedL) {
			if(!repairedL.contains(word)) {
				equal = false;
				break;
			}
		}
		return equal;
	}
}
