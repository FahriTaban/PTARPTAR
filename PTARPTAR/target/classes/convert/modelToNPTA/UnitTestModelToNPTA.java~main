package convert.modelToNPTA;

import java.util.List;

import convert.nptaToModel.ConvertNPTAToModel;
import npta.*;
import parse.Element;
import parse.Model_Lexer;
import parse.Model_Parser;

public class UnitTestModelToNPTA {
	public static void main(String[] args) {
		String model_name = "example.imi";
		String new_model_name = "example_model.txt";
		Model_Lexer m_lex = new Model_Lexer(model_name);		
		m_lex.findTokens();
		Model_Parser parser = new Model_Parser();
		List<Element> model = m_lex.getTokens();
		NPTA npta = ConvertModelToNPTA.createNPTA(model_name);
		npta.printInfo();
		ConvertNPTAToModel.nptaToModel(npta, new_model_name);
		List<Element> clocks = parser.getClocks(model);
		List<Element> parameter = parser.getParameters(model);
		List<List<Element>> automata = parser.getAutomata(model);
		for(List<Element> a : automata) {
//			testConstraints(parser.getConstraints(a));
		}
		List<Element> initLocs = parser.getInitLocations(model);
		List<Element> initCons = parser.getInitConstraints(model);
		npta.printInfo();
//		testClocks(clocks);
//		testParameter(parameter);
//		testAutomata(automata);
//		testInitLocs(initLocs);
//		testInitCons(initCons);
	}
	
	public static void testConstraints(List<Element> cons_e) {
		List<Constraint> cons = ConvertModelToNPTA.createConstraints(cons_e);
		for(Constraint c : cons) {
			c.printInfo();
		}
		
	}
	
	public static void testClocks(List<Element> clocks) {
		List<Clock> j_clocks = ConvertModelToNPTA.createClocks(clocks);
		for(Clock c : j_clocks) {
			c.printInfo(true);
		}
	}
	
	public static void testParameter(List<Element> params) {
		List<Parameter> j_params = ConvertModelToNPTA.createParams(params);
		for(Parameter p : j_params) {
			p.printInfo(false);
		}
	}
	
	public static void testAutomata(List<List<Element>> automata) {
		List<Automaton> j_automata = ConvertModelToNPTA.buildAutomata(automata);
		for(Automaton a : j_automata) {
			a.printInfo();
		}
	}
	
	public static void testInitLocs(List<Element> locs) {
		List<Constraint> initLocs = ConvertModelToNPTA.createConstraints(locs);
		for(Constraint c : initLocs) {
			c.printInfo();
		}
	}
	
	public static void testInitCons(List<Element> cons) {
		List<Constraint> initCons = ConvertModelToNPTA.createConstraints(cons);
		for(Constraint c : initCons) {
			c.printInfo();
		}
	}
}
