package ConstraintSystem.RepairComputation;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;


import com.microsoft.z3.*;

import ConstraintSystem.SMT2Encoding;
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
import resToRun.ConvertResToRun;

public class UnitTestSMT {

	public static void main(String[] args) {
		PrintStream out = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
		String resFile = "example.res";
		String modelFile = "example.imi";
		Result_Lexer r_lex = new Result_Lexer(resFile);		
		r_lex.findTokens();
		NetworkPTA npta = ConvertModelToNPTA.buildNetworkPTA(modelFile);
		npta.printInfo();
		Run run = ConvertResToRun.createRun(resFile,npta);
		System.setOut(out);
		String smt2filePath= "UnitTestMaxSMT.txt";
		List<VariationVariable> vvs = new ArrayList<>();
		SMT2Encoding.createSMT2Encoding(run, npta, VarType.Operator, vvs, smt2filePath);
//		for(VariationVariable vv : vvs) {
//			vv.printRepairInfo();
//		}
//		System.out.println(MaxSMT.quantifierElimination(smt2filePath));
		MaxSMT.repairValuesComputation(smt2filePath, vvs);
	}
	
	@SuppressWarnings("serial")
    class TestFailedException extends Exception
    {
        public TestFailedException()
        {
            super("Check FAILED");
        }
    };

	
	public void parserExample1(Context ctx, String formula) throws TestFailedException
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
