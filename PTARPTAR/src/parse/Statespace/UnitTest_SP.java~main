package parse.Statespace;

import java.util.List;

import convert.resToRun.ConvertResToRun;
import parse.Element;
import utility.UnitTest;

public class UnitTest_SP extends UnitTest{
	private static Statespace_Parser parser = new Statespace_Parser();

	public static void main(String[] args) {
		String ss_name = "example_model-statespace.states";
		Statespace_Lexer ss_lex = new Statespace_Lexer(ss_name);		
		ss_lex.findTokens();
		List<Element> result = ss_lex.getTokens();
		List<List<Element>> ts = testTransitions(result);
		testStates(ts);
		
	}
	
	public static List<List<Element>> testTransitions(List<Element> elems) {
		UnitTest.printStructures(parser.getTransitions(elems));
		return parser.getTransitions(elems);
	}
	
	public static void testStates(List<List<Element>> transitions) {
		for(String s : parser.getStates(transitions)) {
			System.out.println(s);
		}
	}
}
