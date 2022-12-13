package Run;

import java.util.ArrayList;
import java.util.List;

import NPTA.*;
/**
 * Representing a state in a run
 * @author 49173
 *
 */
public class State {
	private String id;
	private List<StateLocation> stateLocations;
	
	public State(String id, List<StateLocation> locations) {
		this.id = id;
		this.stateLocations = List.copyOf(locations);
	}

	public List<StateLocation> getStateLocations() {
		return stateLocations;
	}
	
	public List<Location> getLocations(){
		List<Location> locations = new ArrayList<>();
		for(StateLocation s : this.stateLocations) {
			locations.add(s.getLocation());
		}
		return locations;
	}
	
	public List<Constraint> getInvariants(){
		List<Constraint> invariants = new ArrayList<>();
		for(Location loc : this.getLocations()) {
			invariants.addAll(loc.getInvariants());
		}
		return invariants;
	}

	public Location findLocation(Automaton a) {
		for(StateLocation sl : this.stateLocations) {
			if (a.getName().equals(sl.getAutomaton().getName())) {
				return sl.getLocation();
			}
		}
		System.out.println("Location of automaton " + a.getName() + " in state " + this.id + " not found.");
		return null;
	}
	
	public String getId() {
		return id;
	}
	
	public void printInfo() {
		System.out.println("STATE WITH ID " + this.id);
		for(StateLocation sl : this.stateLocations) {
			sl.printInfo();
		}
	}
}
