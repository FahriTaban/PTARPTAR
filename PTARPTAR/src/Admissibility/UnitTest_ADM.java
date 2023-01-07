package admissibility;

import java.util.HashSet;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.resToRun.ConvertResToRun;
import convert.statespaceToNFA.ConvertSSToNFA;
import npta.NPTA;
import parse.result.Result_Lexer;
import parse.result.Result_Parser;
import run.Run;

public class UnitTest_ADM {
	public static void main(String[] args) {
		String repairedFile = "example_model";
		NPTA npta = ConvertModelToNPTA.createNPTA(repairedFile+".imi");
		Run run = ConvertResToRun.createRun(repairedFile+".res", npta);
		String statespaceFile = repairedFile+"-statespace.states";
		String unrepairedFile = "example-statespace.states";
		NFA nfa = ConvertSSToNFA.createNFA(statespaceFile);
		nfa.printInfo();
		nfa.genLanguage();
		NFA nfa2 = ConvertSSToNFA.createNFA(unrepairedFile);
		nfa2.printInfo();
		nfa2.genLanguage();
		String violatingTrace = ConvertSSToNFA.renameTrace(run.getViolatingTrace());
		System.out.println("Violating Trace: "+violatingTrace);
		System.out.println(Admissibility.checkLanguageEquivalence(statespaceFile, unrepairedFile, violatingTrace));
		printSet(nfa.getLanguage());
		printSet(nfa2.getLanguage());
	}
	
	
	public static void printSet(HashSet<String> language) {
		for(String word : language) {
			if(word.contains(" ")) {
				System.out.println(word + " has blank");
			}
			System.out.println(word);
		}
	}
}
