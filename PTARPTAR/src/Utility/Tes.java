package Utility;
import Parsing.*;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Tes {

	public static void main(String[] args) {
		String filePath = "Model.imi";
		String filePath2 = "testEFExemplify1Pneg.res";
//		Model_Lexer lex = new Model_Lexer(filePath);
//		lex.findTokens();
//		for (Element e : lex.tokensFound()) {
//			e.elemInfo();
//		}
		Result_Lexer lex = new Result_Lexer(filePath2);
		lex.findTokens();
//		printElems(lex.getTokens());
		Result_Parser parser = new Result_Parser();
		List<Element> run = new ArrayList<>();
		run = parser.getValidRun(lex.getTokens());
//		printElems(run);
		List<List<Element>> states = new ArrayList<>();
//		states = parser.getStates(run);
		printStructures(states);
		List<List<Element>> transitions = new ArrayList<>();
		transitions = parser.getOuterTransitions(run);
		printStructures(transitions);
		
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
