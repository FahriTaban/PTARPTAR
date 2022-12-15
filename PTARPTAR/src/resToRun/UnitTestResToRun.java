package resToRun;

import java.util.List;


import ModelToPTA.ConvertModelToNPTA;
import NPTA.*;
import NPTA.NetworkPTA;
import Parsing.Element;
import Parsing.Result_Lexer;
import Parsing.Result_Parser;
import Run.*;
import Utility.UnitTest;
import NPTAToModel.ConvertPTAToModel;

public class UnitTestResToRun extends UnitTest{
	private static Result_Parser parser = new Result_Parser();

	public static void main(String[] args) {
		String result_name = "testEFExemplify1Pneg.res";
		String testconvRes = "testConv.res";
		String testconvModel = "testConv.imi";
		Result_Lexer r_lex = new Result_Lexer(testconvRes);		
		r_lex.findTokens();
		List<Element> result = r_lex.getTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(testconvModel);
//		npta.printInfo();
		Run run = ConvertResToRun.createRun(result_name,npta);
		ConvertResToRun.setNPTA(npta);
		NetworkPTA npta_conv = ConvertResToRun.getNPTA();
		ConvertPTAToModel.nptaToModel(npta_conv, "testConversion_COPY.txt");
		ConvertPTAToModel.nptaToModel(npta, "testConversion_ORIGIN.txt");
		List<List<Element>> outerTs = parser.getOuterTransitions(parser.getValidRun(result));
		for(Automaton a : npta.getAutomata()) {
			for(Location l : a.getLocations()) {
//			testFindLocation(a.getName(),l.getName());
			for(Transition t : l.getTransitions()) {
//				t.printInfo();
				for(List<Element> outerT : outerTs) {
					List<List<Element>> innerTs = parser.getInnerTransitions(outerT);
					for(List<Element> innerT : innerTs) {
//						testFindTransition(t.getPrestate(),t.getPoststate(),t.getAction(),innerT);						
					}
				}
			}
			}
		}
		
	}
	
	public static void testFindAutomaton(String name) {
		System.out.println("INPUT AUTOMATON NAME: "+ name);
		String found = ConvertResToRun.findAutomaton(name).getName();
		System.out.println("OUTPUT AUTOMATON NAME: "+ found);
	}
	
	public static void testFindLocation(String automaton, String location) {
		System.out.println("INPUT AUTOMATON NAME: "+ automaton + " AND INPUT LOCATION NAME: "+ location);
		String location_name = ConvertResToRun.findLocation(automaton, location).getName();
		System.out.println("OUTPUT LOCATION NAME: "+ location_name);
	}

	public static void testFindTransition(String preloc, String postloc, String action, List<Element> innerTransition) {
		String guards = elemsToString(parser.getGuards(innerTransition));
		String updates = elemssToString(parser.getUpdates(innerTransition));
		System.out.println("INPUT PARAMETER");
		System.out.println(preloc + " , " + guards + " , " + action + " , " + updates + " , " + postloc);
		System.out.println("INPUT TRANSITION");
		Result_Parser parser = new Result_Parser();
		System.out.println(resultTransitionElemToString(innerTransition,parser));
		Transition trans = ConvertResToRun.findTransition(preloc,postloc,action,innerTransition);
		if(trans == null) {
			return;
		}
		System.out.println("\n*************************************************************************************");
		trans.printInfo();
	}
}
