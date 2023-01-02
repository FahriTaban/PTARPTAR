package parse.Property;

import java.util.List;

import parse.Element;
import parse.Model_Lexer;
import parse.Model_Parser;
import utility.UnitTest;

public class UnitTestPP {

	public static void main(String[] args) {
		String prop_name = "testConvProp.imiprop";
		Prop_Lexer p_lex = new Prop_Lexer(prop_name);		
		p_lex.findTokens();
		Prop_Parser parser = new Prop_Parser();
		List<Element> prop = p_lex.getTokens();
		UnitTest.printStructures(parser.getLocations(prop));
			
		}
		
	public static void testClocks(Model_Parser parser, List<Element> model) 
	{
		System.out.println("CLOCKS USED IN MODEL");
	}

}
