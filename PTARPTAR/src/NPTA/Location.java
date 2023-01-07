package npta;
import java.util.ArrayList;
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

	public Location(String n, List<Constraint> inv, List<Transition> transitions) {
		this.name = n;
		this.transitions = transitions;
		this.invariants = inv;
	}
	
	public Location(String n, List<Constraint> inv) {
		this.name = n;
		this.invariants = List.copyOf(inv);
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

	public List<Constraint> getModifiableInvariants(){
		List<Constraint> cons = new ArrayList<>();
		for(Constraint c : this.invariants) {
			if(!c.isDoNotModify()) {
				cons.add(c);
			}
		}
		return cons;
	}
	
	public List<Constraint> getModifiableGuards(){
		List<Constraint> cons = new ArrayList<>();
		for(Transition t : this.getTransitions()) {
			for(Constraint c : t.getGuards()) {
				if(!c.isDoNotModify()) {
					cons.add(c);
				}
			}
		}
		return cons;
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
	
	public void setUrgent(boolean urg) {
		this.urgent = urg;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
	
	public void printInfo() {
		System.out.println("Location " + this.name);
		System.out.println("Invariants");
		for(Constraint i : this.invariants) {
			i.printInfo();
		}
		System.out.println("Transitions");
		for(Transition t : this.transitions) {
			t.printInfo();
		}
	}
}
