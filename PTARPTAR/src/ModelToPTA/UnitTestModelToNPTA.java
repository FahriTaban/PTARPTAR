package ModelToPTA;

import java.util.List;

import NPTA.*;
import NPTAToModel.ConvertPTAToModel;
import Parsing.Element;
import Parsing.Model_Lexer;
import Parsing.Model_Parser;

public class UnitTestModelToNPTA {
	public static void main(String[] args) {
		String model_name = "testEFExemplify1Pneg.imi";
		String new_model_name = "test";
		Model_Lexer m_lex = new Model_Lexer(model_name);		
		m_lex.findTokens();
		Model_Parser parser = new Model_Parser();
		List<Element> model = m_lex.getTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(model_name);
		npta.printInfo();
		ConvertPTAToModel.nptaToModel(npta, new_model_name);
		List<Element> clocks = parser.getClocks(model);
		List<Element> parameter = parser.getParameters(model);
		List<List<Element>> automata = parser.getAutomata(model);
		List<List<Element>> initLocs = parser.getInitLocations(model);
		List<List<Element>> initCons = parser.getInitConstraints(model);
//		testClocks(clocks);
//		testParameter(parameter);
//		testAutomata(automata);
//		testInitLocs(initLocs);
//		testInitCons(initCons);
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
			p.printInfo(true);
		}
	}
	
	public static void testAutomata(List<List<Element>> automata) {
		List<Automaton> j_automata = ConvertModelToNPTA.buildAutomata(automata);
		for(Automaton a : j_automata) {
			a.printInfo();
		}
	}
	
	public static void testInitLocs(List<List<Element>> locs) {
		List<Constraint> initLocs = ConvertModelToNPTA.createConstraints(locs);
		for(Constraint c : initLocs) {
			c.printInfo();
		}
	}
	
	public static void testInitCons(List<List<Element>> cons) {
		List<Constraint> initCons = ConvertModelToNPTA.createConstraints(cons);
		for(Constraint c : initCons) {
			c.printInfo();
		}
	}
}
