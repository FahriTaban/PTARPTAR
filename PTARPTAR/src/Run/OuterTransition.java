package Run;

import java.util.ArrayList;
import java.util.List;

import NPTA.*;

public class OuterTransition {
	private State prestate;
	private int duration;
	private String action;
	List<Transition> transitions;
	private State poststate;
	
	public OuterTransition(int dur, String a, List<Transition> t) {
		this.duration = dur;
		this.action = a;
		this.transitions = t;
	}
	
	public int getDuration() {
		return duration;
	}

	public String getAction() {
		return action;
	}
	
	public List<Transition> getTransitions() {
		return transitions;
	}
	
	public List<Constraint> getGuards(){
		List<Constraint> guards = new ArrayList<>();
		for (Transition t : this.transitions) {
			guards.addAll(t.getGuards());
		}
		return guards;
	}
	
	public void printInfo() {
		System.out.println("OUTER TRANSITION");
		System.out.println("PRESTATE");		
		this.prestate.printInfo();
		System.out.println("DURATION: " + Integer.toString(duration));
		System.out.println("ACTION: " + this.action);
		System.out.println("INNER TRANSITIONS");
		for(Transition t : this.transitions) {
			t.printInfo();
		}
		System.out.println("POSTSTATE");
	}
}
