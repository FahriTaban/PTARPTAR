package PTA;

import java.util.List;

public class NetworkPTA {
	private List<Automaton> automata;
	private List<Clock> clocks;
	private List<Parameter> parameters;
	private List<Boolean> bools;
	private List<Constraint> initial_locations;
	private List<Constraint> initial_constraints;
	
	public NetworkPTA(List<Automaton> a, List<Clock> c,
			List<Parameter> p, List<Constraint> locs, List<Constraint> cons) {
		this.automata = a;
		this.clocks = c;
		this.parameters = p;
		this.initial_locations = locs;
		this.initial_constraints = cons;
	}
	
	public NetworkPTA(List<Automaton> a, List<Clock> c,
			List<Parameter> p, List<Boolean> b, List<Constraint> locs, List<Constraint> cons) {
		this.automata = a;
		this.clocks = c;
		this.parameters = p;
		this.bools = b;
		this.initial_locations = locs;
		this.initial_constraints = cons;
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
}
