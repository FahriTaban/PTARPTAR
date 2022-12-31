package ConstraintSystem;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ConstraintSystem.RepairComputation.VariationVariable;
import ConstraintSystem.RepairComputation.VariationVariable.VarType;
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
		String testconvRes = "example.res";
		String testconvModel = "example.imi";
		Result_Lexer r_lex = new Result_Lexer(testconvRes);		
		r_lex.findTokens();
		List<Element> result = r_lex.getTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(testconvModel);
//		npta.printInfo();
		Run run = ConvertResToRun.createRun(testconvRes,npta);
		System.setOut(out);
		
		List<VariationVariable> vvs = new ArrayList<>();
//		testTDTCS(run,npta,VarType.ClockBound, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ClockReference, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ClockReset, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.Operator, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ParameterBound, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.UrgentLocation, "new_tdtcs.txt", vvs);
	}
	
	public static void testTDTCS(Run run, NetworkPTA npta, VarType vtype, String fp,
			List<VariationVariable> vvs) {
		System.out.println(SMT2Encoding.createSMT2Encoding(run, npta, vtype,vvs,fp));
	}
	
	public static void testDecl(List<Clock> clocks, List<Parameter> parameters, int numberOfTransitions, int numberOfStates) {
		List<String> clockDecl = ToSMT2.declareVariables(clocks,numberOfStates, false);
		List<String> paramDecl = ToSMT2.declareParameters(parameters);
		List<String> deltaDecl = ToSMT2.declareDelays(numberOfTransitions, false);
		printList(clockDecl);
		printList(paramDecl);
		printList(deltaDecl);
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
		String  transitionGuards = ToSMT2.getTransitionGuards(transitions,clocks);
		System.out.println(transitionGuards);
	}
}
