package Parsing.Evaluation;

import java.util.HashMap;
import java.util.List;

import Parsing.Element;
import Utility.UnitTest;

public class UnitTestEP extends UnitTest{

	public static void main(String[] args) {
		String eval_name = "savedModels.txt";
		Eval_Lexer lex = new Eval_Lexer(eval_name);		
		lex.findTokens();
		List<Element> elems = lex.getTokens();
		Eval_Parser parser = new Eval_Parser();
		HashMap<String,String> evals = parser.getParameterValuation(elems, 2);
		for(String e : evals.keySet()) {
			System.out.println("Variable: " + e + "\n Repair Value: " + evals.get(e) + "\n");
		}
	}

}
