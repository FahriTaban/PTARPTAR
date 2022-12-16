package ConstraintSystem.RepairComputation;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;


import com.microsoft.z3.*;

import ConstraintSystem.TDTCS;
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
import resToRun.ConvertResToRun;

public class UnitTestSMT {

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
	
	}
	
	@SuppressWarnings("serial")
    class TestFailedException extends Exception
    {
        public TestFailedException()
        {
            super("Check FAILED");
        }
    };

	
	public static void parserExample1(Context ctx, String formula) throws TestFailedException
    {
        System.out.println("ParserExample1");
        Log.append("ParserExample1");
        
        BoolExpr f = ctx.parseSMTLIB2String(
                formula,
                null, null, null, null)[0];
        System.out.println("formula " + f);

        @SuppressWarnings("unused")
        Model m = check(ctx, f, Status.SATISFIABLE);
    }
	
	Model check(Context ctx, BoolExpr f, Status sat) throws TestFailedException
    {
        Solver s = ctx.mkSolver();
        s.add(f);
        if (s.check() != sat)
            throw new TestFailedException();
        if (sat == Status.SATISFIABLE)
            return s.getModel();
        else
            return null;
    }
	
	public void checkSyntax(Context ctx,String formula)
    {
        System.out.println("Checking syntax");

        try
        {
            ctx.parseSMTLIB2String(
                    /*
                     * the following string has a parsing error: missing
                     * parenthesis
                     */
                    formula,
                    null, null, null, null);
        } catch (Z3Exception e)
        {
            System.out.println("Z3 error: " + e);
        }
    }

}
