package convert.nptaToModel;

import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import npta.*;
import parse.Element;
import parse.Model_Lexer;
import parse.Model_Parser;

public class UnitTestNPTAToModel {
	static Model_Parser parser = new Model_Parser();
	static List<Element> model;
	
	public static void main(String[] args) {		
		String model_name = "example.imi";
		Model_Lexer m_lex = new Model_Lexer(model_name);
		m_lex.findTokens();
		model = m_lex.getTokens();
		NPTA npta = ConvertModelToNPTA.createNPTA(model_name);
		ConvertNPTAToModel.nptaToModel(npta, "example_model.imi");
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
		String test = ConvertNPTAToModel.declareInit(locs, cons);
		System.out.println("Initialization Block");
		System.out.println(test);
	}
	
	public static void testInitLocs(List<Constraint> cons) {
		String test = ConvertNPTAToModel.declareInitLocs(cons);
		System.out.println("Initial Locations");
		System.out.println(test);
	}
	
	public static void testInitCons(List<Constraint> cons) {
		String test = ConvertNPTAToModel.declareInitCons(cons);
		System.out.println("Initial Constraints");
		System.out.println(test);
	}
	
	public static void testVariables(List<Clock> clocks, List<Parameter> params) {
		String test = ConvertNPTAToModel.declareVariables(clocks, params);
		System.out.println("Variables");
		System.out.println(test);
	}
	
	public static void testAutomata(List<Automaton> automata) {
		String test;
		for(Automaton a : automata) {
			test = ConvertNPTAToModel.declareAutomaton(a);
			System.out.println("Automaton");
			System.out.println(test);
		}
	}
	
	public static void testActions(Automaton a) {
		String test;
		test = ConvertNPTAToModel.declareActions(a);
		System.out.println("Actions of automaton " + a.getName());
		System.out.println(test);
		
	}
	
	
	
	public static void testUpdates(List<Transition> trans) {
		String test;
		for(Transition t : trans) {
			test = ConvertNPTAToModel.declareUpdate(t);
			System.out.println("Transition");
			System.out.println(test);
		}
	}
	
	public static void testLocations(List<Location> locs) {
		String test;
		for(Location l : locs) {
			test = ConvertNPTAToModel.declareLocation(l);
			System.out.println("Location " + l.getName());
			System.out.println(test);
		}
	}
	
	public static void testTransitions(List<Transition> trans) {
		String test;
		for(Transition t : trans) {
			test = ConvertNPTAToModel.declareTransition(t);
			System.out.println("Transition");
			System.out.println(test);
		}
	}
	
	public static void testConstraints(List<Constraint> cons) {
		String test = ConvertNPTAToModel.declareConstraints(cons);
		System.out.println("Constraint");
		System.out.println(test);
	}
}
