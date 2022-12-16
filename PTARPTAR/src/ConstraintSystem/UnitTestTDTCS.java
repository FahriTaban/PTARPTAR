package ConstraintSystem;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import ModelToPTA.ConvertModelToNPTA;
import NPTA.Clock;
import NPTA.Constraint;
import NPTA.NetworkPTA;
import NPTA.Parameter;
import NPTA.Update;
import Parsing.Element;
import Parsing.Result_Lexer;
import Run.OuterTransition;
import Run.Run;
import Run.State;
import Utility.UnitTest;
import resToRun.ConvertResToRun;

public class UnitTestTDTCS extends UnitTest{
	public static void main(String[] args) {
		PrintStream out = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
		String testconvRes = "testConv.res";
		String testconvModel = "testConv.imi";
		Result_Lexer r_lex = new Result_Lexer(testconvRes);		
		r_lex.findTokens();
		List<Element> result = r_lex.getTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(testconvModel);
//		npta.printInfo();
		Run run = ConvertResToRun.createRun(testconvRes,npta);
		System.setOut(out);
		
		List<Clock> clocks = npta.getClocks();
		List<Constraint> initCons = run.getInitialConstraints();
		List<Parameter> parameters = npta.getParameter();
		List<State> states = run.getStates();
		List<List<Constraint>> invariants = run.getInvariants();
		List<List<Constraint>> guards = run.getGuards();
		List<OuterTransition> transitions = run.getTransitions();
		List<List<Update>> updates = run.getUpdates();
		List<List<Clock>> resetClocks = TDTCS.getAllResetClocks(updates,clocks);
		List<List<Clock>> nonResetClocks = TDTCS.getAllNonResetClocks(resetClocks,clocks);
		int numberOfStates = states.size();
		int numberOfTransitions = run.getTransitions().size();
	
		testDecl(clocks,parameters,numberOfTransitions,numberOfStates);
		testInit(initCons,clocks);
		testTimeAdvancement(numberOfTransitions);
		testClockResets(resetClocks);
		testSojTime(nonResetClocks);
		testLocInvariants(states,clocks);
		testTransGuards(transitions,clocks);
	}
	
	public static void testDecl(List<Clock> clocks, List<Parameter> parameters, int numberOfTransitions, int numberOfStates) {
		String clockDecl = ToSMT2.declareClocks(clocks,numberOfStates);
		String paramDecl = ToSMT2.declareParameters(parameters);
		String deltaDecl = ToSMT2.declareDelays(numberOfTransitions);
		System.out.println(clockDecl);
		System.out.println(paramDecl);
		System.out.println(deltaDecl);
	}
	
	public static void testInit(List<Constraint> cons, List<Clock> clocks) {
		String initCons = ToSMT2.initializeInitConstraints(cons, clocks);
		System.out.println(initCons);
	}
	
	public static void testTimeAdvancement(int numberOfTransitions) {
		String timeAdvancement = ToSMT2.timeAdvancement(numberOfTransitions);
		System.out.println(timeAdvancement);
	}
	
	public static void testClockResets(List<List<Clock>> resetClocks) {
		String clockResets = ToSMT2.clockResets(resetClocks);
		System.out.println(clockResets);
	}
	
	public static void testSojTime(List<List<Clock>> nonResetClocks) {
		String sojournTime = ToSMT2.sojournTime(nonResetClocks);
		System.out.println(sojournTime);
	}
	
	public static void testLocInvariants(List<State> states,List<Clock> clocks) {
		String locationInvariants = ToSMT2.getInvariantBounds(states,clocks);		
		System.out.println(locationInvariants);		
	}
	
	public static void testTransGuards(List<OuterTransition> transitions, List<Clock> clocks) {
		String transitionGuards = ToSMT2.getTransitionGuards(transitions,clocks);
		System.out.println(transitionGuards);
	}
}
