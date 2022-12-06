package PTA;
import java.util.List;

import org.javatuples.Pair;  

/**
 * Location in a (component) PTA.
 * @author 49173
 *
 */
public class Location {
	private String name;
	private List<Constraint> invariants;
	private List<Transition> transitions;
	private boolean urgent;

	public Location(String n, List<Constraint> inv, boolean urg) {
		this.name = n;
		this.invariants = List.copyOf(inv);
		this.urgent = urg;
	}
	
	public Location(String n) {
		this.name = n;
	}

	public List<Constraint> getInvariants() {
		return invariants;
	}
	
	public void setInvariants(List<Constraint> inv) {
		this.invariants = inv;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
}
