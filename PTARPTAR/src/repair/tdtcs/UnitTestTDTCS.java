package repair.tdtcs;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.resToRun.ConvertResToRun;
import npta.Clock;
import npta.Constraint;
import npta.NPTA;
import npta.Parameter;
import npta.Update;
import parse.Element;
import parse.result.Result_Lexer;
import repair.repairComputation.VariationVariable;
import repair.repairComputation.VariationVariable.VarType;
import run.OuterTransition;
import run.Run;
import run.State;
import utility.UnitTest;
import utility.Utility;

public class UnitTestTDTCS extends UnitTest{
	
	
	public static void main(String[] args) {
		String testconvRes = "files/pacemaker_JPMAM12.res";
		String testconvModel = "files/pacemaker_JPMAM12.imi";
		NPTA npta = ConvertModelToNPTA.createNPTA(testconvModel);
//		npta.printInfo();
		Run run = ConvertResToRun.createRun(testconvRes,npta);
//		String tdtcs = Utility.readFile("new_tdtcs.txt");
//		String removed = SMT2Encoding.replaceVariables(tdtcs);
//		System.out.println(removed);
		List<VariationVariable> vvs = new ArrayList<>();
		testTDTCS(run,VarType.ClockBound, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ClockReference, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ClockReset, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.Operator, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.ParameterBound, "new_tdtcs.txt", vvs);
//		testTDTCS(run,npta,VarType.UrgentLocation, "new_tdtcs.txt", vvs);
	}
	
	public static void testTDTCS(Run run, VarType vtype, String fp,
			List<VariationVariable> vvs) {
		System.out.println(SMT2Encoding.createSMT2Encoding(run, vtype,vvs,fp));
	}
	
	public static void testDecl(List<Clock> clocks, List<Parameter> parameters, int numberOfTransitions, int numberOfStates) {
		List<String> clockDecl = ToSMT2.declareVariables(clocks,numberOfStates, false);
		List<String> paramDecl = ToSMT2.declareParameters(parameters);
		List<String> deltaDecl = ToSMT2.declareDelays(numberOfTransitions, false);
		printList(clockDecl);
		printList(paramDecl);
		printList(deltaDecl);
	}
	
	public static void testInit(List<Constraint> cons, List<Clock> clocks,VarType vType, List<Parameter> params) {
		String initCons = ToSMT2.initializeInitConstraints(cons, clocks, vType, params);
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
