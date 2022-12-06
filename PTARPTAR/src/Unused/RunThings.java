package Unused;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Parsing.Element;
import Parsing.Model_Lexer;
import Parsing.Model_Parser;
import Parsing.Result_Lexer;

public class RunThings {

	public static void main(String[] args) {
		String res = "testEFExemplify1Pneg.res";
		String model = "testEFExemplify1Pneg.imi";
		Model_Lexer m_lex = new Model_Lexer(model);		
		m_lex.findTokens();
//		printElems(lex.getTokens());
		Model_Parser parser = new Model_Parser();
		List<Element> model_elems = m_lex.getTokens();
		
		List<Element> clocks = parser.getClocks(model_elems);
//		printElems(run);
//		List<List<Element>> states = new ArrayList<>();
//		states = parser.getStates(run);
//		printStructures(clocks);
		printElems(clocks);
//		List<List<Element>> transitions = new ArrayList<>();
//		transitions = parser.getOuterTransitions(run);
//		printStructures(transitions);
		
	}
	
	static void testRes(String filePath) {
		Result_Lexer r_lex = new Result_Lexer(filePath);
		r_lex.findTokens();
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