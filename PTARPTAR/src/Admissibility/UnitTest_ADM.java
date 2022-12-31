package Admissibility;

import java.util.HashSet;

import SSToNFA.ConvertSSToNFA;

public class UnitTest_ADM {
	public static void main(String[] args) {
		String fp = "example_model-statespace.states";
		String fp2 = "example-statespace.states";
		NFA nfa = ConvertSSToNFA.createNFA(fp);
		nfa.genLanguage();
		NFA nfa2 = ConvertSSToNFA.createNFA(fp2);
		nfa2.genLanguage();
		System.out.println(Admissibility.checkLanguageEquivalence(fp, fp2, ""));
		printSet(nfa.getLanguage());
		printSet(nfa.getLanguage());
	}
	
	
	public static void printSet(HashSet<String> language) {
		for(String word : language) {
			System.out.println(word);
		}
	}
}
