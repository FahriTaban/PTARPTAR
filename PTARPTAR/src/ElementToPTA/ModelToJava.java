package ElementToPTA;

import java.util.ArrayList;
import java.util.List;

import PTA.*;
import Parsing.*;

public class ModelToJava {
	static Model_Parser parser = new Model_Parser();
	
	public List<Automaton> buildAutomata(String fileName) {
		Model_Lexer lex = new Model_Lexer(fileName);
		List<Element> model = lex.getTokens();
		List<List<Element>> automata = parser.getAutomata(model);
	}
	
	public Automaton buildAutomaton(List<Element> automaton) {
		String name = parser.getAutomatonName(automaton);
		Automaton autom = new Automaton(name);
		autom.setActions(createActions(autom, automaton));
	}
	
	public List<Action> createActions(Automaton autom, List<Element> automaton){
		List<Element> action_Elements = parser.getActions(automaton);
		List<Action> actions = new ArrayList<>();
		for(Element e : action_Elements) {
			actions.add(new Action(autom, e.getContent()));
		}
		return actions;
	}
	
	public List<Location> createLocations(List<Element> automaton){
		List<List<Element>> location_Elements = parser.getLocations(automaton);
		List<Location> locations = new ArrayList<>();
		for(List<Element> location : location_Elements) {
			locations.add(new Location(location.get(0).getContent()));
		}
		
	}
	
	public List<Transition> createTransitions(List<Element> location){
		List<List<Element>> transitions = parser.getTransitions(location);
	}
	
	public List<Constraint> createInvariants(List<Element> location){
		List<List<Element>> invariants = parser.getInvariants(location);
	}
	
	public List<Constraint> createGuards(List<Element> transition){
		List<List<Element>> guard_Elements = parser.getGuards(transition);
		List<Constraint> guards = new ArrayList<>();
		for(List<Element> guard : guard_Elements) {
			
		}
	}
	
	public List<Update> createUpdates(List<Element> transition){
		List<List<Element>> updates = parser.getUpdates(transition);
	}
}
