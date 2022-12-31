package ConstraintSystem.PropertyToConstraint;

import java.util.HashMap;
import java.util.List;

import Parsing.Element;
import Parsing.Property.Prop_Lexer;
import Parsing.Property.Prop_Parser;

public class PropToSMT2 {
	public static HashMap<String,String> parseProp(String filePath) {
		Prop_Lexer p_lex = new Prop_Lexer(filePath);		
		p_lex.findTokens();
		Prop_Parser parser = new Prop_Parser();
		List<Element> prop = p_lex.getTokens();
		parser.getLocations(prop);
	}
	
	public static HashMap<String,String> getPairs(List<List<Element>> locations){
		HashMap<String,String> locs = new HashMap<>();
		for(List<Element> location : locations) {
			String automaton = location.get(0).getContent();
			String loc = location.get(1).getContent();
			locs.put(automaton, loc);
		}
		return locs;
	}
}
