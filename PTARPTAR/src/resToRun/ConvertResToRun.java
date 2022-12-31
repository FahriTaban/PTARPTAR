package resToRun;
import java.util.ArrayList;
import java.util.List;

import NPTA.*;
import Parsing.*;
import Run.*;
import Run.State;

public class ConvertResToRun {
	private static Result_Parser parser = new Result_Parser();
	private static NetworkPTA npta;
	
	public static Run createRun(String fileName, NetworkPTA n) {
		npta = n;
		Result_Lexer r_lex = new Result_Lexer(fileName);		
		r_lex.findTokens();
		List<Element> run = parser.getValidRun(r_lex.getTokens());
		List<State> states = createStates(parser.getStates(run));
		List<OuterTransition> transitions = createOuterTransitions(states, parser.getOuterTransitions(run));
		List<Constraint> initialConstraints = npta.getInitial_Constraints();
		return new Run(initialConstraints,states,transitions);
	}
	
	public static NetworkPTA getNPTA() {
		return npta;
	}
	
	public static void setNPTA(NetworkPTA n) {
		npta = n;
	}
	
	public static List<State> createStates(List<List<Element>> states){
		List<State> s = new ArrayList<>();
		int size = states.size();
		for(int i = 0; i < size; i++) {
			List<List<Element>> stateLocElems = parser.getLocations(states.get(i));
			List<StateLocation> stateLocs = createStateLocations(stateLocElems);
			s.add(new State("s"+Integer.toString(i),stateLocs));
		}
		return s;
	}
	
	public static List<StateLocation> createStateLocations(List<List<Element>> stateLocations){
		List<StateLocation> stateLs = new ArrayList<>();
		String automaton;
		String location;
		for(List<Element> sl : stateLocations) {
			automaton = sl.get(0).getContent();
			location = sl.get(1).getContent();
			stateLs.add(new StateLocation(findAutomaton(automaton),findLocation(automaton,location)));
		}
		return stateLs;
	}
	
	public static Automaton findAutomaton(String name) {
		for(Automaton a : npta.getAutomata()) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		System.out.println("AUTOMATON " + name +" NOT FOUND");
		return null;
	}
	
	public static Location findLocation(String automaton, String location) {
		for(Automaton a : npta.getAutomata()) {
			if (a.getName().equals(automaton)) {
				for(Location l : a.getLocations()) {
					if(l.getName().equals(location)) {
						System.out.println("LOCATION " + location + " FOUND");
						return l;
					}
				}
			}
		}
		System.out.println("LOCATION " + location + " OF AUTOMATON " + automaton + " NOT FOUND");
		return null;
	}
	
	public static List<OuterTransition> createOuterTransitions(List<State> states,List<List<Element>> outerTransitions){
		List<OuterTransition> ot = new ArrayList<>();
		int size = states.size();
		State pre, post;
		for(int i = 0; i < size - 1; i++) {
			pre = states.get(i);
			post = states.get(i+1);
			List<Element> outerTransition = outerTransitions.get(i);
			ot.add(createOuterTransition(pre,post,outerTransition));
		}
		return ot;
	}
	
	public static OuterTransition createOuterTransition(State prestate, State poststate, List<Element> outerTransition) {
		List<Transition> transitions = new ArrayList<>();
		int duration = Integer.valueOf(parser.getDuration(outerTransition).getContent());
		String action = parser.getAction(outerTransition).getContent();
		for(List<Element> innerT : parser.getInnerTransitions(outerTransition)) {
			Automaton a = findAutomaton(parser.getPTA(outerTransition).getContent());
			String prelocation = prestate.findLocation(a).getName();
			String postlocation = poststate.findLocation(a).getName();
			Transition t = findTransition(prelocation,postlocation,action,innerT);
			if (t != null) {
				transitions.add(t);
			}
		}
		return new OuterTransition(duration, action, transitions);
	}
	
	public static Transition findTransition(String preloc, String postloc, String action, List<Element> innerTransition) {
		List<List<Element>> update = parser.getUpdates(innerTransition);
		List<Element> guards = parser.getGuards(innerTransition);
		String pta = parser.getPTA(innerTransition).getContent();
		Automaton a = findAutomaton(pta);
		Location l = findLocation(a.getName(),preloc);
		if(l == null) {
			System.out.println("ABORTING findTransition DUE TO MISSING LOCATION");
			return null;
		}
		for(Transition t : l.getTransitions()) {
			if (t.transitionEquals(preloc, guards, action, update, postloc)) {
				return t;
			}
		}
		System.out.println("TRANSITION NOT FOUND FOR AUTOMATON " + a.getName() + ": " +preloc+ " " + action + " " + postloc);
		return null;
	}
	
}
