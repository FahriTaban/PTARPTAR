package PTAToModel;

import java.util.List;

import ModelToPTA.ConvertModelToPTA;
import PTA.*;
import Parsing.Element;
import Parsing.Model_Lexer;
import Parsing.Model_Parser;

public class UnitTestPTAToModel {
	static Model_Parser parser = new Model_Parser();
	static List<Element> model;
	
	public static void main(String[] args) {		
		String model_name = "testEFExemplify1Pneg.imi";
		Model_Lexer m_lex = new Model_Lexer(model_name);
		m_lex.findTokens();
		model = m_lex.getTokens();
		NetworkPTA npta = ConvertModelToPTA.buildNetworkPTA(model_name);
		ConvertPTAToModel.nptaToModel(npta, "test");
//		testVariables(npta.getClocks(),npta.getParameter());
//		testInitLocs(npta.getInitial_Locations());
//		testInitCons(npta.getInitial_Constraints());
//		testInit(npta.getInitial_Locations(), npta.getInitial_Constraints());
//		testAutomata(npta.getAutomata());
		for(Automaton a : npta.getAutomata()) {
//			testActions(a);
//			testLocations(a.getLocations());
			for(Location l : a.getLocations()) {
//				testConstraints(l.getInvariants());
//				testUpdates(l.getTransitions());
//				testTransitions(l.getTransitions());
				for(Transition t : l.getTransitions()) {
//					testConstraints(t.getGuards());
				}
			}
		}
	}
	
	public static void testInit(List<Constraint> locs, List<Constraint> cons) {
		String test = ConvertPTAToModel.declareInit(locs, cons);
		System.out.println("Initialization Block");
		System.out.println(test);
	}
	
	public static void testInitLocs(List<Constraint> cons) {
		String test = ConvertPTAToModel.declareInitLocs(cons);
		System.out.println("Initial Locations");
		System.out.println(test);
	}
	
	public static void testInitCons(List<Constraint> cons) {
		String test = ConvertPTAToModel.declareInitCons(cons);
		System.out.println("Initial Constraints");
		System.out.println(test);
	}
	
	public static void testVariables(List<Clock> clocks, List<Parameter> params) {
		String test = ConvertPTAToModel.declareVariables(clocks, params);
		System.out.println("Variables");
		System.out.println(test);
	}
	
	public static void testAutomata(List<Automaton> automata) {
		String test;
		for(Automaton a : automata) {
			test = ConvertPTAToModel.declareAutomaton(a);
			System.out.println("Automaton");
			System.out.println(test);
		}
	}
	
	public static void testActions(Automaton a) {
		String test;
		test = ConvertPTAToModel.declareActions(a);
		System.out.println("Actions of automaton " + a.getName());
		System.out.println(test);
		
	}
	
	
	
	public static void testUpdates(List<Transition> trans) {
		String test;
		for(Transition t : trans) {
			test = ConvertPTAToModel.declareUpdate(t);
			System.out.println("Transition");
			System.out.println(test);
		}
	}
	
	public static void testLocations(List<Location> locs) {
		String test;
		for(Location l : locs) {
			test = ConvertPTAToModel.declareLocation(l);
			System.out.println("Location " + l.getName());
			System.out.println(test);
		}
	}
	
	public static void testTransitions(List<Transition> trans) {
		String test;
		for(Transition t : trans) {
			test = ConvertPTAToModel.declareTransition(t);
			System.out.println("Transition");
			System.out.println(test);
		}
	}
	
	public static void testConstraints(List<Constraint> cons) {
		String test = ConvertPTAToModel.declareConstraints(cons);
		System.out.println("Constraint");
		System.out.println(test);
	}
}
