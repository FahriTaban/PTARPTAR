package convert.modelToNPTA;

import java.util.List;

import convert.nptaToModel.ConvertNPTAToModel;
import npta.*;
import parse.Element;
import parse.model.Model_Lexer;
import parse.model.Model_Parser;

public class UnitTestModelToNPTA {
	public static void main(String[] args) {
		String model_name = "files/abc.imi";
		String new_model_name = "PM_JPMAM12_new.imi";
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
		for (Parameter p : npta.getParameter()){
			p.printInfo();
		}
		for(Constraint c : npta.getInitial_Constraints()) {
			System.out.println(c.toSMTString());
		}
		List<Element> initLocs = parser.getInitLocations(model);
		List<Element> initCons = parser.getInitConstraints(model);
//		npta.printInfo();
//		testClocks(clocks);
//		testParameter(parameter);
//		testAutomata(automata);
//		testInitLocs(initLocs);
//		testInitCons(initCons);
	}
	
	public static void testConstraints(List<Element> cons_e) {
		List<Constraint> cons = ConvertModelToNPTA.createConstraints(cons_e,false);
		for(Constraint c : cons) {
			List<Variable> vs = c.getRhs().getVariables();
			for (Variable v : vs) {
				System.out.println(v.getName());
				if (v instanceof Parameter) {
					System.out.println(v.getName() + " IS A PARAMETER");
				}
			}
//			c.printInfo();
//			System.out.println(c.toSMTString());
//			System.out.println(c.toSMTString("1"));
//			System.out.println(c.toSMTString("2", false));
//			System.out.println(c.toString());
//			System.out.println(c.getRhs().toSMTString());
//			System.out.println(c.getRhs().toString());
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
		List<Constraint> initLocs = ConvertModelToNPTA.createConstraints(locs,false);
		for(Constraint c : initLocs) {
			c.printInfo();
		}
	}
	
	public static void testInitCons(List<Element> cons) {
		List<Constraint> initCons = ConvertModelToNPTA.createConstraints(cons,false);
		for(Constraint c : initCons) {
			c.printInfo();
		}
	}
}
