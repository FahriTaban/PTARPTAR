package Parsing.Statespace;

import java.util.List;

import Parsing.Element;
import resToRun.ConvertResToRun;

public class UnitTest_SP {
	public static void main(String[] args) {
		String ss_name = "testConv-statespace.states";
		Statespace_Lexer ss_lex = new Statespace_Lexer(ss_name);		
		ss_lex.findTokens();
		Statespace_Parser parser = new Statespace_Parser();
		List<Element> result = ss_lex.getTokens();
	}
}
