package repair.variation;

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
import parse.Result_Lexer;
import repair.repairComputation.VariationVariable;
import repair.tdtcs.SMT2Encoding;
import run.OuterTransition;
import run.Run;
import run.State;
import utility.UnitTest;

public class UnitTestVariation extends UnitTest{

	public static void main(String[] args) {
		PrintStream out = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
		String testconvRes = "testConv.res";
		String testconvModel = "testConv.imi";
		Result_Lexer r_lex = new Result_Lexer(testconvRes);		
		r_lex.findTokens();
		List<Element> result = r_lex.getTokens();
		NPTA npta = ConvertModelToNPTA.createNPTA(testconvModel);
//		npta.printInfo();
		Run run = ConvertResToRun.createRun(testconvRes,npta);
		System.setOut(out);
		
		List<Clock> clocks = npta.getClocks();
		List<Constraint> initCons = run.getInitialConstraints();
		List<Parameter> parameters = npta.getParameter();
		List<State> states = run.getStates();
		List<List<Constraint>> invariants = run.getInvariants();
		List<List<Constraint>> guards = run.getGuards();
		List<OuterTransition> ots = run.getTransitions();
		List<List<Update>> updates = run.getUpdates();
		List<List<Clock>> resetClocks = run.getAllResetClocks(clocks);
		List<List<Clock>> nonResetClocks = run.getAllNonResetClocks(clocks);
		List<VariationVariable> vvs = new ArrayList<>();
		List<String> ops = new ArrayList<>();
		ops.addAll(List.of(">",">=","=","<=","<"));
		testCBV(guards,invariants,clocks,vvs);
		testCRefV(ots,states,clocks,vvs);
		testCResV(ots,clocks,vvs);
		testOV(ots,states,clocks,vvs,ops);
		testPB(parameters,vvs);
		testULocV(states,vvs);
		testCBVGuardBounds(guards,clocks, vvs);
		testCBVInvariantBounds(invariants,clocks,vvs);
		testCBVPositivity(vvs);
		System.out.println(ClockBoundVariation.clockBoundVariation(guards, invariants, clocks, vvs));
		testOVInvariantBounds(states,clocks,vvs,ops);
		testOVGuardBounds(ots,clocks,vvs,ops);
		testCRVGuardBounds(ots,clocks, vvs);
		testCRVInvariantBounds(states,clocks,vvs);
		testRCVGuardBoundsTrue(ots, clocks, vvs);
		testRCVGuardBoundsFalse(ots, clocks, vvs);
		testULV(states,vvs);
		testParameterBound(parameters,vvs);
	}

	public static void testCBV(List<List<Constraint>> guards,List<List<Constraint>> invs, List<Clock> cs, 
			List<VariationVariable> vvs) {
		System.out.println(ClockBoundVariation.clockBoundVariation(guards, invs, cs, vvs));
	}
	
	public static void testCRefV(List<OuterTransition> ots,List<State> states, List<Clock> cs, 
			List<VariationVariable> vvs) {
		System.out.println(ClockReferenceVariation.clockReferenceVariation(ots, states, cs, vvs));
	}
	
	public static void testCResV(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs) {
		System.out.println(ClockResetVariation.changeResetsString(ots, clocks, vvs, false));
		System.out.println(ClockResetVariation.changeResetsString(ots, clocks, vvs, true));
	}
	
	public static void testOV(List<OuterTransition> ots, List<State> states, List<Clock> clocks, 
			List<VariationVariable> vvs, List<String> ops) {
		System.out.println(OperatorVariation.operatorVariation(ots, states, clocks, vvs, ops));
	}
	
	public static void testPB(List<Parameter> params, List<VariationVariable> vvs) {
		System.out.println(ParameterBoundVariation.parameterBoundString(params, vvs));
	}
	
	public static void testULocV(List<State> states, List<VariationVariable> vvs) {
		System.out.println(UrgentLocationVariation.urgentLocationString(states, vvs));
	}
	
	public static void testCBVGuardBounds(List<List<Constraint>> guards, List<Clock> cs, 
			List<VariationVariable> vvs) {
		List<String> s = ClockBoundVariation.getGuardBounds(guards, cs, vvs);
		printList(s);
	}
	
	public static void testCBVInvariantBounds(List<List<Constraint>> invs, List<Clock> cs, 
			List<VariationVariable> vvs) {
		List<String> s = ClockBoundVariation.getInvariantBounds(invs, cs, vvs);
		printList(s);
	}
	
	public static void testCBVPositivity(List<VariationVariable> vvs) {
		List<String> s = ClockBoundVariation.getPositivityConstraints(vvs);
		printList(s);
	}
	
	public static void testOVInvariantBounds(List<State> states, List<Clock> clocks, 
			List<VariationVariable> vvs, List<String> ops){
		printListList(OperatorVariation.getInvariantBounds(states, clocks, vvs, ops));
	}
	
	public static void testOVGuardBounds(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs, List<String> ops){
		printListList(OperatorVariation.getGuardBounds(ots, clocks, vvs, ops));
	}
	
	public static void testCRVGuardBounds(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs) {
		printListList(ClockReferenceVariation.getGuardBounds(ots, clocks, vvs));
	}
	
	public static void testCRVInvariantBounds(List<State> states, List<Clock> clocks, 
			List<VariationVariable> vvs){
		printListList(ClockReferenceVariation.getInvariantBounds(states, clocks, vvs));
	}
	
	public static void testRCVGuardBoundsTrue(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs) {
		printList(ClockResetVariation.changeResets(ots, clocks, vvs,true));
	}
	
	public static void testRCVGuardBoundsFalse(List<OuterTransition> ots, List<Clock> clocks, 
			List<VariationVariable> vvs) {
		printList(ClockResetVariation.changeResets(ots, clocks, vvs,false));
	}
	
	public static void testULV(List<State> states, List<VariationVariable> vvs) {
		printList(UrgentLocationVariation.urgentLocation(states, vvs));
	}
	
	public static void testParameterBound(List<Parameter> params, List<VariationVariable> vvs) {
		printList(ParameterBoundVariation.parameterBound(params, vvs));
	}
}
