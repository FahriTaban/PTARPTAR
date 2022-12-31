package Parsing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class UnitTestRP {

	public static void main(String[] args) {
		String result_name = "example.res";
		Result_Lexer r_lex = new Result_Lexer(result_name);		
		r_lex.findTokens();
		Result_Parser parser = new Result_Parser();
		List<Element> result = r_lex.getTokens();
//		testValidRun(parser, result);
		List<Element> run = parser.getValidRun(result);
//		testParameters(parser,run);
//		testStates(parser,run);
		List<List<Element>> states = parser.getStates(run);
		for(List<Element> state : states) {
//			testLocations(parser, state);
//			testDiscreteVariables(parser, state);
//			testContinuousVariables(parser,state);
		}
		List<List<Element>> ot = parser.getOuterTransitions(run);
		testTransitions(parser,run);
		for(List<Element> transition: ot) {
//			testDuration(parser, transition);
//			testAction(parser, transition);
			List<List<Element>> it = parser.getInnerTransitions(transition);
			testInnerTransitions(parser,transition);
			for(List<Element> i : it) {
				testPTA(parser,i);
				testGuard(parser,i);
				testUpdates(parser,i);
			}
		}
	}
	
	public static void testInnerTransitions(Result_Parser parser, List<Element> ot) {
		System.out.println("INNER TRANSITION");
		printStructures(parser.getInnerTransitions(ot));
	}
	
	public static void testPTA(Result_Parser parser, List<Element> it) {
		System.out.println("PTA");
		printElem(parser.getPTA(it));
	}
	
	public static void testGuard(Result_Parser parser, List<Element> it) {
		System.out.println("GUARD");
		printElems(parser.getGuards(it));
	}
	
	public static void testUpdates(Result_Parser parser, List<Element> it) {
		System.out.println("UPDATES");
		printStructures(parser.getUpdates(it));
	}
	
	public static void testValidRun(Result_Parser parser, List<Element> result) {
		System.out.println("VALID RUN OF RESULT");
		printElems(parser.getValidRun(result));
	}
	
	public static void testParameters(Result_Parser parser, List<Element> run) {
		System.out.println("SET OF PARAMETERS WITH SAME CONCRETE RUN");
		printElems(parser.getParameterConstraints(run));
	}
	
	public static List<List<Element>> testStates(Result_Parser parser, List<Element> run) {
		System.out.println("STATES OF THE RUN");
		List<List<Element>> automata = parser.getStates(run);
		printStructures(automata);
		return automata;
	}
	
	public static List<List<Element>> testLocations(Result_Parser parser, List<Element> state) {
		System.out.println("LOCATIONS OF STATE");
		List<List<Element>> locations = parser.getLocations(state);
		printStructures(locations);
		return locations;
	}
	
	public static List<List<Element>> testTransitions(Result_Parser parser, List<Element> run){
		System.out.println("TRANSITIONS OF RUN");
		List<List<Element>> transitions = parser.getOuterTransitions(run);
		printStructures(transitions);
		System.out.println("______________________________________________________");
		return transitions;
	}
	
	public static void testDuration(Result_Parser parser, List<Element> transition){
		System.out.println("DURATION OF TRANSITION");
		printElem(parser.getDuration(transition));
	}
	
	public static void testDiscreteVariables(Result_Parser parser, List<Element> state) {
		System.out.println("DISCRETE VARIABLES OF STATE");
		printStructures(parser.getVariables(state,true));
	}
	
	public static void testContinuousVariables(Result_Parser parser, List<Element> state) {
		System.out.println("CONTINUOUS VARIABLES OF STATE");
		printStructures(parser.getVariables(state,false));
	}
	
	public static void testAction(Result_Parser parser, List<Element> transition) {
		System.out.println("ACTION OF TRANSITION");
		printElem(parser.getAction(transition));
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

