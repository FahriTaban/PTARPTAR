package Parsing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class UnitTestMP {

	public static void main(String[] args) {
		String model_name = "testEFExemplify1Pneg.imi";
		Model_Lexer m_lex = new Model_Lexer(model_name);		
		m_lex.findTokens();
		Model_Parser parser = new Model_Parser();
		List<Element> model = m_lex.getTokens();
//		testClocks(parser,model);
//		testParameters(parser,model);
//		testAutomata(parser,model);
		testInitLocations(parser,model);
		testInitConstraints(parser,model);
		List<List<Element>> automata = parser.getAutomata(model);
		for(List<Element> automaton : automata) {
//		testActions(parser,automaton);
			List<List<Element>> locations = parser.getLocations(automaton);
//			testLocations(parser,automaton);
			for (List<Element> location : locations) {
//				testInvariants(parser,location);
				List<List<Element>> transitions = parser.getTransitions(location);
//				testTransitions(parser,location);
				for(List<Element> transition : transitions) {
//					testGuards(parser,transition);
//					testAction(parser,transition);
					testUpdates(parser,transition);
//					getPostLoc(parser,transition);	
			}
		}
		}
		
		
	}
	public static void testClocks(Model_Parser parser, List<Element> model) 
	{
		System.out.println("CLOCKS USED IN MODEL");
		printElems(parser.getClocks(model));
	}
	
	public static void testParameters(Model_Parser parser, List<Element> model) {
		System.out.println("PARAMETERS USED IN MODEL");
		printElems(parser.getParameters(model));
	}
	
	public static void testInitLocations(Model_Parser parser, List<Element> model) {
		System.out.println("INITAL LOCATIONS");
		printStructures(parser.getInitLocations(model));
	}
	
	public static void testInitConstraints(Model_Parser parser, List<Element> model) {
		System.out.println("INITAL CONSTRAINTS");
		printStructures(parser.getInitConstraints(model));
	}
	
	public static List<List<Element>> testAutomata(Model_Parser parser, List<Element> model) {
		System.out.println("AUTOMATA IN MODEL");
		List<List<Element>> automata = parser.getAutomata(model);
		printStructures(automata);
		return automata;
	}
	
	public static void testActions(Model_Parser parser, List<Element> automaton) {
		System.out.println("ACTIONS OF AUTOMATON " + automaton.get(0).getContent());
		printElems(parser.getActions(automaton));
	}
	
	public static List<List<Element>> testLocations(Model_Parser parser, List<Element> automaton) {
		System.out.println("LOCATIONS OF " + automaton.get(0).getContent());
		List<List<Element>> locations = parser.getLocations(automaton);
		printStructures(locations);
		return locations;
	}
	
	public static void testInvariants(Model_Parser parser, List<Element> location){
		System.out.println("INVARIANT OF LOCATION " + location.get(0).getContent());
		printStructures(parser.getInvariants(location));
	}
	
	public static List<List<Element>> testTransitions(Model_Parser parser, List<Element> location){
		System.out.println("TRANSITIONS OF LOCATION " + location.get(0).getContent());
		List<List<Element>> transitions = parser.getTransitions(location);
		printStructures(parser.getTransitions(location));
		System.out.println("______________________________________________________");
		return transitions;
	}
	
	public static void testGuards(Model_Parser parser, List<Element> transition){
		System.out.println("GUARDS OF TRANSITION");
		printStructures(parser.getGuards(transition));
	}
	
	public static void testAction(Model_Parser parser, List<Element> transition) {
		System.out.println("ACTION OF TRANSITION");
		printElem(parser.getAction(transition));
	}
	
	public static void testUpdates(Model_Parser parser, List<Element> transition){
		System.out.println("UPDATE OF TRANSITION");
		printStructures(parser.getUpdates(transition));
	}
	
	public static void getPostLoc(Model_Parser parser, List<Element> transition) {
		System.out.println("POSTLOC OF TRANSITION");
		printElem(parser.getPostLoc(transition));
	}
	
	
	static void printElem(Element elem) {
		elem.elemInfo();
	}
	
	static void printElems(List<Element> elems) {
		for (Element e : elems) {
			e.elemInfo();
		}
	}
	
	static void printStructures(List<List<Element>> structures) {
		for (List<Element> s : structures) {
			System.out.println("*".repeat(1000) + "\n NEW STRUCTURE \n " + "*".repeat(1000));
			for (Element e : s) {
				e.elemInfo();
			}
		}
	}

}
