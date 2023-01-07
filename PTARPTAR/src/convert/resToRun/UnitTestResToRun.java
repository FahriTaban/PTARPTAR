package convert.resToRun;

import java.util.HashSet;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.nptaToModel.ConvertNPTAToModel;
import npta.*;
import parse.Element;
import parse.result.Result_Lexer;
import parse.result.Result_Parser;
import run.*;
import utility.UnitTest;

public class UnitTestResToRun extends UnitTest{
	private static Result_Parser parser = new Result_Parser();

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String result_name = "files/example.res";
		String testconvRes = "files/fisch93.res";
		String testconvModel = "files/fisch93.imi";
		Result_Lexer r_lex = new Result_Lexer(testconvRes);		
//		r_lex.findTokens();
//		List<Element> result = r_lex.getTokens();
		NPTA npta = ConvertModelToNPTA.createNPTA(testconvModel);

//		npta.printInfo();
		Run run = ConvertResToRun.createRun(testconvRes,npta);
		HashSet<Integer> h = new HashSet<>();
		int nr = 0;
		for(List<Constraint> c : run.getValidInvariants()) {
			for(Constraint cc : c) {
//				h.add(cc.hashCode());
//				System.out.println(cc.toSMTString());
			}
//			nr += c.size();
		}
		for(int i = 0; i < run.getAllValidNonResetClocks().size(); i++) {
			List<Clock> nrcs = run.getAllValidNonResetClocks().get(i);
			List<Clock> rcs = run.getAllValidResetClocks().get(i);
			System.out.println("NONRESET CLOCKs");
			for(Clock c : nrcs) {
				c.printInfo();
			}
			System.out.println("RESET CLOCK");
			for(Clock c : rcs) {
				c.printInfo();
			}
		
	}
//			nr += c.size();
//		System.out.println("Number of unique constraints : " +Integer.toString(h.size()) + "\n Number of invariants in run : " + Integer.toString(nr));
//		for(List<Update> ups : run.getValidUpdates()) {
//			for(Update u : ups) {
//				u.printInfo();
//			}
//		}
		for(Update up : npta.getUpdates()) {
			
		}
		HashSet<Constraint> hset = new HashSet<>();
//		for(State s :  run.getValidStates()){
//			System.out.println("STATE :" + s.getId());
//			for(StateLocation sl : s.getStateLocations()) {
//				System.out.println("AUTOMATON :" + sl.getAutomaton().getName());
//				System.out.println("LOCATION :" + sl.getLocation().getName());
//				for(Constraint c : sl.getLocation().getInvariants()) {
//					
//					if(hset.contains(c)) {
//						System.out.println("CONSTRAINT ALREADY CONTAINED IN HSET");
//					}
//					hset.add(c);
//					c.printInfo();
//					
//				}
//			}
//		}
//		ConvertResToRun.setNPTA(npta);
//		NPTA npta_conv = ConvertResToRun.getNPTA();
//		ConvertNPTAToModel.nptaToModel(npta, "files/PM_conversion.imi");
//		ConvertNPTAToModel.nptaToModel(npta, "testConversion_ORIGIN.txt");
//		List<List<Element>> outerTs = parser.getOuterTransitions(parser.getValidRun(result));
//		for(Automaton a : npta.getAutomata()) {
//			for(Location l : a.getLocations()) {
//			testFindLocation(a.getName(),l.getName());
//			for(Transition t : l.getTransitions()) {
//				t.printInfo();
//				for(List<Element> outerT : outerTs) {
//					List<List<Element>> innerTs = parser.getInnerTransitions(outerT);
//					for(List<Element> innerT : innerTs) {
//						testFindTransition(t.getPrestate(),t.getPoststate(),t.getAction(),innerT);						
//					}
//				}
//			}
//			}
//		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}
	
	public static void testFindAutomaton(String name) {
		System.out.println("INPUT AUTOMATON NAME: "+ name);
		String found = ConvertResToRun.findAutomaton(name).getName();
		System.out.println("OUTPUT AUTOMATON NAME: "+ found);
	}
	
	public static void testFindLocation(Automaton automaton, String location) {
		System.out.println("INPUT AUTOMATON NAME: "+ automaton + " AND INPUT LOCATION NAME: "+ location);
		String location_name = ConvertResToRun.findLocation(automaton, location).getName();
		System.out.println("OUTPUT LOCATION NAME: "+ location_name);
	}

	public static void testFindTransition(String preloc, String postloc, String action, List<Element> innerTransition) {
		String guards = elemsToString(parser.getGuards(innerTransition));
		String updates = elemsToString(parser.getUpdates(innerTransition));
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
