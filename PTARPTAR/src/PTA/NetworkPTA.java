package PTA;

import java.util.List;

public class NetworkPTA {
	private final List<Automaton> automata;
	private final List<Clock> clocks;
	private final List<Parameter> parameters;
	private final List<Boolean> bools;
	private final List<Location> initial_locations;
	private final List<Constraint> initial_constraints;
	
	public NetworkPTA(List<Automaton> a, List<Clock> c,
			List<Parameter> p, List<Boolean> b, List<Location> locs, List<Constraint> cons) {
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

	public List<Location> getInitial_Locations() {
		return initial_locations;
	}

	public List<Constraint> getInitial_Constraints() {
		return initial_constraints;
	}
}
