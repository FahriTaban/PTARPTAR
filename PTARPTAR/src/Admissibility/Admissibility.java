package Admissibility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ConstraintSystem.RepairComputation.VariationVariable;
import Parsing.Evaluation.Eval_Lexer;
import Parsing.Evaluation.Eval_Parser;
import SSToNFA.ConvertSSToNFA;

public class Admissibility {
	
	public static boolean checkLanguageEquivalence(String repairedModel, String unrepairedModel,String violatingTrace) {
		NFA unrepaired = ConvertSSToNFA.createNFA(unrepairedModel);
		NFA repaired = ConvertSSToNFA.createNFA(repairedModel);
		unrepaired.genLanguage();
		repaired.genLanguage();
		HashSet<String> unrepairedL = unrepaired.getLanguage();
		unrepairedL.remove(violatingTrace);
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
