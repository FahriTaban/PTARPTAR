package Run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import NPTA.Clock;
import NPTA.Constraint;
import NPTA.NetworkPTA;
import NPTA.Transition;
import NPTA.Update;


public class Run {
	private List<Constraint> initialConstraints;
	private List<State> states;
	private List<OuterTransition> transitions;
	
	public Run(List<Constraint> initCons, List<State> states, List<OuterTransition> transitions) {
		this.states = states;
		this.transitions = transitions;
		this.initialConstraints = initCons;
	}

	public int numberOfStates() {
		return this.states.size();
	}
	
	public int numberOfTransitions() {
		return this.transitions.size();
	}
	
	public List<State> getStates() {
		return states;
	}
	
	public List<Constraint> getPropertyConstraints(){
		List<Constraint> cons = new ArrayList<>();
		OuterTransition lastTrans = this.getTransitions().get(this.getTransitions().size()-1);
		for(Transition t : lastTrans.getTransitions()) {
			cons.addAll(t.getGuards());
		}
		return cons;
	}

	public List<OuterTransition> getTransitions() {
		return transitions;
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
	
	public List<List<Constraint>> getGuards() {
		List<List<Constraint>> guards = new ArrayList<>();
		for(OuterTransition ot : this.transitions) {
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
	
	public List<List<Clock>> getAllResetClocks(List<Clock> clocks){
		List<List<Clock>> resetClocks = new ArrayList<>();
		for(List<Update> us : this.getUpdates()) {
			List<Clock> rClocks = new ArrayList<>();
			rClocks.addAll(getResetClocks(us,clocks));
			resetClocks.add(rClocks);
		}
		return resetClocks;
	}
	
	public List<List<Clock>> getAllNonResetClocks(List<Clock> clocks){
		List<List<Clock>> nonResetClockss = new ArrayList<>();
		for(List<Clock> rcs : this.getAllResetClocks(clocks)) {
			List<Clock> nonResetClocks = getNonResetClocks(rcs,clocks);
			nonResetClocks.removeAll(rcs);
			nonResetClockss.add(nonResetClocks);
		}
		return nonResetClockss;
	}
	
	public List<Clock> getNonResetClocks(List<Clock> resetClocks, List<Clock> clocks){
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
	
}
