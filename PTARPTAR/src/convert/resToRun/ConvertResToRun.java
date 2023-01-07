package convert.resToRun;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import npta.*;
import parse.*;
import parse.result.Result_Lexer;
import parse.result.Result_Parser;
import run.*;
import utility.Utility;

public class ConvertResToRun {
	private static List<String> warnings = new ArrayList<>();
	private static Result_Parser parser = new Result_Parser();
	private static NPTA npta;
	private static HashMap<String,Automaton> automata = new HashMap<>();
	
	public static Run createRun(String fileName, NPTA n) {
		npta = n;
		for(Automaton a : npta.getAutomata()) {
			automata.put(a.getName(), a);
		}
		Result_Lexer r_lex = new Result_Lexer(fileName);		
		r_lex.findTokens();
		List<Element> run = parser.getValidRun(r_lex.getTokens());
		List<State> states = createStates(parser.getStates(run));
		List<OuterTransition> transitions = createOuterTransitions(states, parser.getOuterTransitions(run));
		List<Constraint> initialConstraints = npta.getInitial_Constraints();
		for(String s : warnings) {
			System.out.println(s);
		}
		return new Run(initialConstraints,states,transitions,npta);
	}
	
	public static NPTA getNPTA() {
		return npta;
	}
	
	public static void setNPTA(NPTA n) {
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
			Automaton a = findAutomaton(automaton);
			stateLs.add(new StateLocation(a,findLocation(a,location)));
		}
		return stateLs;
	}
	
	public static Automaton findAutomaton(String name) {
		Automaton a = automata.get(name);
		if(a != null) {
			return a;
		}
		System.out.println("AUTOMATON " + name +" NOT FOUND");
		return null;
	}
	
	public static Location findLocation(Automaton automaton, String location) {
			for(Location l : automaton.getLocations()) {
				if(l.getName().equals(location)) {
					return l;
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
		String action = parser.getAction(outerTransition).getContent();
		for(List<Element> innerT : parser.getInnerTransitions(outerTransition)) {
			Automaton a = findAutomaton(parser.getPTA(innerT).getContent());
			String prelocation = prestate.findLocation(a).getName();
			String postlocation = poststate.findLocation(a).getName();
			Transition t = findTransition(prelocation,postlocation,action,innerT);
			if (t != null) {
				transitions.add(t);
			}
			else 
				System.out.println("RE".repeat(20));
		}
		return new OuterTransition(action, transitions);
	}
	
	public static Transition findTransition(String preloc, String postloc, String action, List<Element> innerTransition) {
		List<Element> update = parser.getUpdates(innerTransition);
		List<Element> guards = parser.getGuards(innerTransition);
		String pta = parser.getPTA(innerTransition).getContent();
		Automaton a = findAutomaton(pta);
		Location l = findLocation(a,preloc);
		if(l == null) {
			return null;
		}
		for(Transition t : l.getTransitions()) {
			if (t.transitionEquals(preloc, guards, action, update, postloc)) {
				return t;
			}
		}
//		System.out.println(a.toString());
		String warning = "TRANSITION NOT FOUND FOR AUTOMATON \n" + a.getName() + ": " +preloc+ " "
				+ Utility.elemToString(innerTransition) + " " + postloc;
		warnings.add(warning);
//		System.out.println("TRANSITION NOT FOUND FOR AUTOMATON \n" + a.getName() + ": " +preloc+ " "
//				+ Utility.elemToString(innerTransition) + " " + postloc);
		return null;
	}
	
}
