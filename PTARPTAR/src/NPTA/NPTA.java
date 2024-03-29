package npta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NPTA {
	private List<Automaton> automata;
	private List<Clock> clocks;
	private List<Parameter> parameters;
	private List<Boolean> bools;
	private List<Constraint> initial_locations;
	private List<Constraint> initial_constraints;
	
	public NPTA(List<Automaton> a, List<Clock> c,
			List<Parameter> p, List<Constraint> locs, List<Constraint> cons) {
		this.automata = a;
		this.clocks = c;
		this.parameters = p;
		this.initial_locations = locs;
		this.initial_constraints = cons;
	}
	
	public NPTA(List<Automaton> a, List<Clock> c,
			List<Parameter> p, List<Boolean> b, List<Constraint> locs, List<Constraint> cons) {
		this.automata = a;
		this.clocks = c;
		this.parameters = p;
		this.bools = b;
		this.initial_locations = locs;
		this.initial_constraints = cons;
	}
	
	public int getHighestBound() {
		int biggest = 0;
		int curr = 0;
		for(Constraint c : this.getModifiableConstraints()) {
			curr = c.getHighestBound();
			if (curr > biggest) {
				biggest = curr;
			}
		}
		if(biggest == 0) {
			biggest = 10;
		}
		return biggest;
	}
	
	public List<Constraint> getModifiableConstraints(){
		List<Constraint> cons = new ArrayList<>();
		for(Automaton a : this.automata) {
			for(Location l : a.getLocations()) {
				cons.addAll(l.getModifiableInvariants());
				cons.addAll(l.getModifiableGuards());
			}
		}
		return cons;
	}

	public Automaton findAutomaton(String name) {
		for(Automaton a : this.automata) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	public List<Update> getUpdates(){
		List<Update> res = new ArrayList<>();
		for(Automaton a : this.automata) {
			for(Location l : a.getLocations()) {
				for(Transition t : l.getTransitions()) {
					res.addAll(t.getUpdateRules());
				}
			}
		}
		return res;
	}
	
	public List<Automaton> getAutomata() {
		return automata;
	}

	public List<Clock> getClocks() {
		return clocks;
	}

	public List<Parameter> getParameter() {
		return parameters;
	}

	public List<Boolean> getBools() {
		return bools;
	}

	public List<Constraint> getInitial_Locations() {
		return initial_locations;
	}

	public List<Constraint> getInitial_Constraints() {
		return initial_constraints;
	}
	
	public void printInfo() {
		System.out.println("Clocks");
		for(Clock c : this.clocks) {
			c.printInfo(true);
		}
		System.out.println("Parameters");
		for(Parameter p : this.parameters) {
			p.printInfo(false);
		}
		System.out.println("Automata");
		for(Automaton a : this.automata) {
			a.printInfo();
		}
		System.out.println("Initial Locations");
		for(Constraint c : this.initial_locations) {
			c.printInfo();
		}
		System.out.println("Initial Constraints");
		for(Constraint c : this.initial_constraints) {
			c.printInfo();
		}
	}
}
