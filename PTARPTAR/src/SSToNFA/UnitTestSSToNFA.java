package SSToNFA;

import Admissibility.NFA;

public class UnitTestSSToNFA {

	public static void main(String[] args) {
		String fp = "example_model-statespace.states";
		NFA nfa = ConvertSSToNFA.createNFA(fp);
		nfa.printInfo();
	}

}
