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
		testClocks(parser,model);
		testParameters(parser,model);
		testAutomata(parser,model);
		testActions(parser,model);
		testLocations(parser,model);
		testTransitions(parser,model);
		testGuards(parser,model);
		testAction(parser,model);
		testUpdates(parser,model);
		getPostLoc(parser,model);
		
		
	}
	public static void testClocks(Model_Parser parser, List<Element> model) 
	{
		printElems(parser.getClocks(model));
		System.out.println("______________________________________________________");
	}
	
	public static void testParameters(Model_Parser parser, List<Element> model) {
		printElems(parser.getParameters(model));
		System.out.println("______________________________________________________");
	}
	
	public static void testAutomata(Model_Parser parser, List<Element> model) {
		printStructures(parser.getAutomata(model));
		System.out.println("______________________________________________________");
	}
	
	public static void testActions(Model_Parser parser, List<Element> automaton) {
		printElems(parser.getActions(automaton));
		System.out.println("______________________________________________________");
	}
	
	public static void testLocations(Model_Parser parser, List<Element> automaton) {
		printStructures(parser.getAutomata(automaton));
		System.out.println("______________________________________________________");
	}
	
	public static void testTransitions(Model_Parser parser, List<Element> location){
		printStructures(parser.getTransitions(location));
		System.out.println("______________________________________________________");
	}
	
	public static void testGuards(Model_Parser parser, List<Element> transition){
		printStructures(parser.getGuards(transition));
		System.out.println("______________________________________________________");
	}
	
	public static void testAction(Model_Parser parser, List<Element> transition) {
		printElem(parser.getAction(transition));
		System.out.println("______________________________________________________");
	}
	
	public static void testUpdates(Model_Parser parser, List<Element> transition){
		printStructures(parser.getUpdates(transition));
		System.out.println("______________________________________________________");
	}
	
	public static void getPostLoc(Model_Parser parser, List<Element> transition) {
		printElem(parser.getPostLoc(transition));
		System.out.println("______________________________________________________");
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
