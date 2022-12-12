package Run;

import java.util.ArrayList;
import java.util.List;

import NPTA.Clock;
import NPTA.Constraint;
import NPTA.NetworkPTA;
import NPTA.Transition;


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

	public List<OuterTransition> getTransitions() {
		return transitions;
	}

	public List<Constraint> getInitialConstraints() {
		return initialConstraints;
	}

	public void setInitialConstraints(List<Constraint> initialConstraints) {
		this.initialConstraints = initialConstraints;
	}
	
}
