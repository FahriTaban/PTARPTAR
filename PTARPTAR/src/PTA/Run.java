package PTA;

import java.util.ArrayList;
import java.util.List;

public class Run {
	private final NetworkPTA pta;
	private final List<State> states;
	private final List<List<Transition>> transitions;
	
	public Run(NetworkPTA pta, List<State> states, List<List<Transition>> transitions) {
		this.pta = pta;
		this.states = states;
		this.transitions = transitions;
	}

	public NetworkPTA getPta() {
		return pta;
	}

	public List<State> getStates() {
		return states;
	}

	public List<List<Transition>> getTransitions() {
		return transitions;
	}
	
	public List<Clock> getInitialValuation(){
		return this.states.get(0).getClocks();
	}
	
	public int getDuration(int stateNr) {
		return this.states.get(stateNr).getDuration();
	}
	
	public List<Constraint> getInvariants(int stateNr){
		List<Constraint> invariants = new ArrayList<>();
		for(State s : this.states) {
			for(Location loc : s.getLocations()) {
				invariants.addAll(List.copyOf(loc.getInvariants()));
			}
		}
		return invariants;
	}
	
	public List<Constraint> getGuards(int transitionNr){
		List<Constraint> guards = new ArrayList<>();
		for(Transition t : this.transitions.get(transitionNr)) {
			for(Constraint con : t.getGuards()) {
				guards.add(con);
			}
		}
		return guards;
	}
	
	public List<Location> getLocations(int stateNr){
		List<Location> locations = new ArrayList<>();
		for(State s : this.states) {
			for(Location loc : s.getLocations()) {
				locations.add(loc);
			}
		}
		return locations;
	}
	
	
}
