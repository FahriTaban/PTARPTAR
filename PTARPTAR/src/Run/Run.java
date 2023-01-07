package run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import npta.Clock;
import npta.Constraint;
import npta.NPTA;
import npta.Transition;
import npta.Update;


public class Run {
	private NPTA npta;
	private List<Constraint> initialConstraints;
	private List<State> states;
	private List<OuterTransition> transitions;
	
	public Run(List<Constraint> initCons, List<State> states, List<OuterTransition> transitions, NPTA npta) {
		this.states = states;
		this.transitions = transitions;
		this.initialConstraints = initCons;
		this.npta = npta;
	}
	
	public List<String> getViolatingTrace(){
		List<String> trace = new ArrayList<>();
		for(OuterTransition ot : this.transitions) {
			trace.add(ot.getAction());
		}
		return trace;
	}
	
	public int numberOfStates() {
		return this.states.size();
	}
	
	public int numberOfValidTransitions() {
		return this.transitions.size()-1;
	}
	
	public List<State> getStates() {
		return states;
	}
	
	public List<State> getValidStates() {
		return states.subList(0, states.size()-1);
	}
	
	public List<Constraint> getPropertyConstraints(){
		List<Constraint> cons = new ArrayList<>();
		OuterTransition lastTrans = this.getTransitions().get(this.getTransitions().size()-1);
		for(Transition t : lastTrans.getTransitions()) {
			cons.addAll(t.getGuards());
		}
		for(Constraint c : cons) {
			c.setDoNotModify(true);
		}
		return cons;
	}

	public List<OuterTransition> getTransitions() {
		return transitions;
	}
	
	public List<OuterTransition> getValidTransitions() {
		return transitions.subList(0, transitions.size()-1);
	}

	public List<Constraint> getInitialConstraints() {
		return initialConstraints;
	}
	
	public List<List<Update>> getUpdates(){
		List<List<Update>> updates = new ArrayList<>();
		for(OuterTransition ot : this.transitions) {
			updates.add(ot.getUpdates());
		}
		return updates;
	}
	
	public List<List<Update>> getValidUpdates(){
		List<List<Update>> updates = new ArrayList<>();
		for(OuterTransition ot : this.getValidTransitions()) {
			updates.add(ot.getUpdates());
		}
		return updates;
	}

	public void setInitialConstraints(List<Constraint> initialConstraints) {
		this.initialConstraints = initialConstraints;
	}
	
	public void printInfo() {
		System.out.println("RUN INFORMATION");
		System.out.println("INITIAL CONSTRAINTS");
		for(Constraint c : this.initialConstraints) {
			c.printInfo();
		}
		System.out.println("STATES");
		for(State s : this.states) {
			s.printInfo();
		}
		System.out.println("OUTER TRANSITIONS");
		for(OuterTransition ot : this.transitions) {
			ot.printInfo();
		}
	}

	public List<List<Constraint>> getInvariants() {
		List<List<Constraint>> invariants = new ArrayList<>();
		for(State s : this.states) {
			invariants.add(s.getInvariants());
		}
		return invariants;
	}
	
	public List<List<Constraint>> getValidInvariants() {
		List<List<Constraint>> invariants = new ArrayList<>();
		for(State s : this.getValidStates()) {
			invariants.add(s.getInvariants());
		}
		return invariants;
	}
	
	public List<List<Constraint>> getGuards() {
		List<List<Constraint>> guards = new ArrayList<>();
		for(OuterTransition ot : this.transitions) {
			guards.add(ot.getGuards());
		}
		return guards;
	}
	
	public List<List<Constraint>> getValidGuards() {
		List<List<Constraint>> guards = new ArrayList<>();
		for(OuterTransition ot : this.getValidTransitions()) {
			guards.add(ot.getGuards());
		}
		return guards;
	}
	
	public HashMap<Integer,State> getUrgentLocations(){
		HashMap<Integer,State> urgLocs = new HashMap<>();
		for(int i = 0; i < this.states.size(); i++) {
			State s = this.states.get(i);
			if (s.isUrgent()) {
				urgLocs.put(i,s);
			}
		}
		return urgLocs;
	}
	
	public HashMap<Integer,State> getValidUrgentLocations(){
		HashMap<Integer,State> urgLocs = new HashMap<>();
		for(int i = 0; i < this.states.size()-1; i++) {
			State s = this.states.get(i);
			if (s.isUrgent()) {
				urgLocs.put(i,s);
			}
		}
		return urgLocs;
	}
	
	public List<List<Clock>> getAllResetClocks(){
		List<Clock> clocks = this.npta.getClocks();
		List<List<Clock>> resetClocks = new ArrayList<>();
		for(List<Update> us : this.getUpdates()) {
			List<Clock> rClocks = new ArrayList<>();
			rClocks.addAll(getResetClocks(us,clocks));
			resetClocks.add(rClocks);
		}
		return resetClocks;
	}
	
	public List<List<Clock>> getAllValidResetClocks(){
		List<Clock> clocks = this.npta.getClocks();
		List<List<Clock>> resetClocks = new ArrayList<>();
		for(List<Update> us : this.getValidUpdates()) {
			List<Clock> rClocks = new ArrayList<>();
			rClocks.addAll(getResetClocks(us,clocks));
			resetClocks.add(rClocks);
		}
		return resetClocks;
	}
	
	public List<List<Clock>> getAllNonResetClocks(){
		List<List<Clock>> nonResetClockss = new ArrayList<>();
		for(List<Clock> rcs : this.getAllResetClocks()) {
			List<Clock> nonResetClocks = getNonResetClocks(rcs);
			nonResetClocks.removeAll(rcs);
			nonResetClockss.add(nonResetClocks);
		}
		return nonResetClockss;
	}
	
	public List<List<Clock>> getAllValidNonResetClocks(){
		List<List<Clock>> nonResetClockss = new ArrayList<>();
		for(List<Clock> rcs : this.getAllValidResetClocks()) {
			List<Clock> nonResetClocks = getNonResetClocks(rcs);
			nonResetClocks.removeAll(rcs);
			nonResetClockss.add(nonResetClocks);
		}
		return nonResetClockss;
	}
	
	public List<Clock> getNonResetClocks(List<Clock> resetClocks){
		List<Clock> clocks = this.npta.getClocks();
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
	
	public HashSet<Clock> getResetClocks(List<Update> updates, List<Clock> clocks){
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

	public NPTA getNPTA() {
		return this.npta;
	}
	
}
