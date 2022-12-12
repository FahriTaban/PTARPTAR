package resToRun;

import java.util.List;

import ModelToPTA.ConvertModelToNPTA;
import NPTA.NetworkPTA;
import Parsing.Element;
import Parsing.Result_Lexer;
import Parsing.Result_Parser;

public class UnitTestResToRun {
	public static void main(String[] args) {
		String result_name = "testEFExemplify1Pneg.res";
		Result_Lexer r_lex = new Result_Lexer(result_name);		
		r_lex.findTokens();
		Result_Parser parser = new Result_Parser();
		List<Element> result = r_lex.getTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(result_name);
	}
	
	

}
