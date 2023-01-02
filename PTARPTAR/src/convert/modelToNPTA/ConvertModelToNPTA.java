package convert.modelToNPTA;

import java.util.ArrayList;
import java.util.List;

import npta.*;
import parse.*;

/**
 * Class used to convert an IMITATOR-PTA file (.imi) to a NetworkPTA. This NetworkPTA is then used to 
 * construct the MaxSMT instance and synthesize the repaired IMITATOR-PTA-file. 
 * @author 49173
 *
 */
public class ConvertModelToNPTA {
	static Model_Parser parser = new Model_Parser();
	static List<Clock> clocks;
	static List<Parameter> parameters;
	static List<Variable> variables = new ArrayList<>();
	
	/**
	 * Converts an IMITATOR-PTA-file into a NetworkPTA. This NetworkPTA is then used to construct the MaxSMT instance
	 * and synthesize the repaired IMITATOR-PTA-file.
	 * @param fileName Name of the IMITATOR-PTA-file
	 * @return 
	 */
	public static NPTA createNPTA(String fileName) {
		Model_Lexer lex = new Model_Lexer(fileName);
		lex.findTokens();
		List<Element> model = lex.getTokens();
		// get variables for NPTA construction
		// get clocks
		clocks = createClocks(parser.getClocks(model));
		variables.addAll(clocks);
		// get parameters
		parameters = createParams(parser.getParameters(model));
		variables.addAll(parameters);
		// get automata
		List<Automaton> automata = buildAutomata(parser.getAutomata(model));
		// get initial locations
		List<Constraint> initLocs = createConstraints(parser.getInitLocations(model));
		// get initial constraints
		List<Constraint> initConstraints = createConstraints(parser.getInitConstraints(model));
		NPTA npta = new NPTA(automata, clocks, parameters, initLocs, initConstraints);
		return npta;
	}
	
	/**
	 * Creates a list of newly instantiated clocks based on a list of elements containing clock information.
	 * @param clock_elements
	 * @return
	 */
	public static List<Clock> createClocks(List<Element> clock_elements){
		List<Clock> clocks = new ArrayList<>();
		for(Element c : clock_elements) {
			clocks.add(new Clock(c.getContent()));
		}
		return clocks;
	}
	
	/**
	 * Creates a list of newly instantiated parameters based on a list of elements containing parameter information.
	 * @param clock_elements
	 * @return
	 */
	public static List<Parameter> createParams(List<Element> param_elements){
		List<Parameter> params = new ArrayList<>();
		for(Element c : param_elements) {
			params.add(new Parameter(c.getContent()));
		}
		return params;
	}
	
	/**
	 * Creates a list of newly instantiated automata based on a list of list of elements containing parameter information.
	 * @param automata_elements
	 * @return
	 */
	public static List<Automaton> buildAutomata(List<List<Element>> automata_elements) {
		List<Automaton> automata = new ArrayList<>();
		for(List<Element> automaton : automata_elements) {
			automata.add(buildAutomaton(automaton));
		}
		return automata;
	}
	
	/**
	 * Creates a new instance of an automaton based on a list of elements representing an automaton element
	 * @param automaton
	 * @return
	 */
	public static Automaton buildAutomaton(List<Element> automaton) {
		String name = parser.getAutomatonName(automaton);
		Automaton autom = new Automaton(name);
		autom.setActions(createActions(automaton));
		autom.setLocations(createLocations(automaton));
		return autom;
	}
	
	/**
	 * Creates a list of newly instantiated actions based on a list of elements representing an automaton element
	 * @param automaton 
	 * @return
	 */
	public static List<Action> createActions(List<Element> automaton){
		List<Element> action_Elements = parser.getActions(automaton);
		List<Action> actions = new ArrayList<>();
		for(Element e : action_Elements) {
			actions.add(new Action(e.getContent()));
		}
		return actions;
	}
	
	/**
	 * Creates a list of newly instantiated locations depending on list of elements representing an automaton
	 * @param automaton
	 * @return
	 */
	public static List<Location> createLocations(List<Element> automaton){
		List<List<Element>> location_Elements = parser.getLocations(automaton);
		List<Location> locations = new ArrayList<>();
		for(List<Element> location : location_Elements) {
			String name = location.get(0).getContent();
			List<Constraint> invariants = createConstraints(parser.getInvariants(location));
			List<Transition> transitions = createTransitions(location);
			locations.add(new Location(name,invariants,transitions));
		}
		return locations;
	}
	
	/**
	 * Creates a list of newly instantiated transitions based on a list of elements representing a location
	 * @param location
	 * @return
	 */
	public static List<Transition> createTransitions(List<Element> location){
		List<List<Element>> transition_Elements = parser.getTransitions(location);
		List<Transition> transitions = new ArrayList<>();
		String location_name = location.get(0).getContent();
		for(List<Element> transition : transition_Elements) {
			List<Constraint> guards = createConstraints(parser.getGuards(transition));
			List<Update> updates = createUpdates(parser.getUpdates(transition));
			String action = parser.getAction(transition).getContent();
			String postloc = parser.getPostLoc(transition).getContent();
			transitions.add(new Transition(location_name,action ,postloc,updates,guards));
		}
		return transitions;
	}
	
	/**
	 * Returns a list of newly created constraints based on the given list of list of elements.
	 * If a value contained in a constraint is a value, e.g. 235 or True, then a new value is created.
	 * Else one of the already created values is used, so clocks and parameters.
	 * @param elements
	 * @return
	 */
	public static List<Constraint> createConstraints(List<Element> elements){
		List<Constraint> constraints = new ArrayList<>();
		for(Element constraint : elements) {
			Constraint c;
			if (constraint.getType() == "KEY_VAR_BOOL_TRUE") {
				c = new Constraint(true);
			} else if (constraint.getType() == "KEY_VAR_BOOL_FALSE") {
				c = new Constraint(false);
			} else {
				c = new Constraint(constraint);
			}
			constraints.add(c);
		}
		return constraints;
	}
	
	/**
	 * Creates a list of newly instantiated updates based on a list of list of elements representing update rules
	 * @param update_elements
	 * @return
	 */
	public static List<Update> createUpdates(List<List<Element>> update_elements){
		List<Update> updates = new ArrayList<>();
		for(List<Element> update : update_elements) {
			String variable_name = update.get(0).getContent();
			String value = update.get(1).getContent();
			updates.add(new Update(variable_name,value));
		}
		return updates;
		
		
	}
	
	private static void printInfo() {
		for(Clock c : clocks) {
			c.printInfo(true);
		}
		for(Parameter p : parameters) {
			p.printInfo(false);
		}
		for(Variable v : variables) {
			v.printInfo();
		}
	}
}
