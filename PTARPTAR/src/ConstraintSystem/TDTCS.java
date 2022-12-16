package ConstraintSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import NPTA.*;
import Run.*;

public class TDTCS {
		
	public static String createTDTCS(Run run, NetworkPTA npta) {
		// initialize run structure
		List<Clock> clocks = npta.getClocks();
		List<Parameter> parameters = npta.getParameter();
		List<State> states = run.getStates();
		List<List<Constraint>> invariants = run.getInvariants();
		List<List<Constraint>> guards = run.getGuards();
		List<OuterTransition> transitions = run.getTransitions();
		List<List<Update>> updates = run.getUpdates();
		List<List<Clock>> resetClocks = getAllResetClocks(updates,clocks);
		List<List<Clock>> nonResetClocks = getAllNonResetClocks(resetClocks,clocks);
		int numberOfStates = states.size();
		int numberOfTransitions = run.getTransitions().size();
		
		// get SMT2 strings
		String clockDecl = ToSMT2.declareClocks(clocks,numberOfStates);
		String paramDecl = ToSMT2.declareParameters(parameters);
		String initCons = ToSMT2.initializeInitConstraints(run.getInitialConstraints(),clocks);
		String timeAdvancement = ToSMT2.timeAdvancement(numberOfTransitions);
		String clockResets = ToSMT2.clockResets(resetClocks);
		String sojournTime = ToSMT2.sojournTime(nonResetClocks);
		String locationInvariants = ToSMT2.getInvariantBounds(states,clocks);
		String transitionGuards = ToSMT2.getTransitionGuards(transitions,clocks);
		return "";
	}
	
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
	
	public static List<List<Clock>> getAllResetClocks(List<List<Update>> updates, List<Clock> clocks){
		List<List<Clock>> resetClocks = new ArrayList<>();
		for(List<Update> us : updates) {
			List<Clock> rClocks = new ArrayList<>();
			rClocks.addAll(getResetClocks(us,clocks));
			resetClocks.add(rClocks);
		}
		return resetClocks;
	}
	
	public static List<List<Clock>> getAllNonResetClocks(List<List<Clock>> resetClocks, List<Clock> clocks){
		List<List<Clock>> nonResetClockss = new ArrayList<>();
		for(List<Clock> rcs : resetClocks) {
			List<Clock> nonResetClocks = getNonResetClocks(rcs,clocks);
			nonResetClocks.removeAll(rcs);
			nonResetClockss.add(nonResetClocks);
		}
		return nonResetClockss;
	}
	
	public static List<Clock> getNonResetClocks(List<Clock> resetClocks, List<Clock> clocks){
		List<Clock> nonResetClocks = new ArrayList<>();
		for(Clock c : clocks) {
			boolean in = false;
			for(Clock rc : resetClocks) {
				if (rc.getName().equals(c.getName())) {
					in = true;
					break;
				}
			}
			if (!in) {
				nonResetClocks.add(c);
			}
		}
		return nonResetClocks;
	}
	
	public static HashSet<Clock> getResetClocks(List<Update> updates, List<Clock> clocks){
		HashSet<Clock> clocks_set = new HashSet<>();
		for(Update update : updates) {
			String var = update.getVariable();
			clocks_set.add(findClock(var,clocks));
		}
		return clocks_set;
	}
	
	public static String par(String s) {
		return "\\("+s+"\\)";
	}
	
	/**
	 * Returns the variable from the list of variable with the given variable name
	 * @param varName
	 * @return
	 */
	private static Clock findClock(String varName, List<Clock> clocks) {
		for(Clock v : clocks) {
			if (v.getName().equals(varName)) {
				return v;
			}
		}
		System.out.println("Failed to find variable " + varName);
		return null;
	}
}
