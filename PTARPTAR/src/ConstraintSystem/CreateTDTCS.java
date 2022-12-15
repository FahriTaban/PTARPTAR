package ConstraintSystem;

import java.util.ArrayList;
import java.util.List;

import NPTA.Clock;

public class CreateTDTCS {
	
	public static List<SMT2Clock> createSMT2Clocks(int numberOfStates, List<Clock> clocks) {
		List<SMT2Clock> smt2clocks = new ArrayList<>();
		for(Clock c : clocks) {
			List<String> aliases = new ArrayList<>();
			for(int i = 0;i<numberOfStates;i++) {
				String alias = c.getName()+Integer.toString(i);
				aliases.add(alias);
			}
			smt2clocks.add(new SMT2Clock(c,aliases));
		}
		return smt2clocks;
	}
	
	public static String par(String s) {
		return "\\("+s+"\\)";
	}
}
