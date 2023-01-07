package repair.repairComputation;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;


import com.microsoft.z3.*;

import convert.modelToNPTA.ConvertModelToNPTA;
import convert.resToRun.ConvertResToRun;
import npta.Clock;
import npta.Constraint;
import npta.NPTA;
import npta.Parameter;
import npta.Update;
import parse.Element;
import parse.Result_Lexer;
import repair.repairComputation.VariationVariable.VarType;
import repair.tdtcs.SMT2Encoding;
import run.OuterTransition;
import run.Run;
import run.State;

public class UnitTestSMT {

	public static void main(String[] args) {
		PrintStream out = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
		String resFile = "example_model.res";
		String modelFile = "example_model.imi";
		Result_Lexer r_lex = new Result_Lexer(resFile);		
		r_lex.findTokens();
		NPTA npta = ConvertModelToNPTA.createNPTA(modelFile);
		npta.printInfo();
		Run run = ConvertResToRun.createRun(resFile,npta);
		System.setOut(out);
		String smt2filePath= "UnitTestMaxSMT.txt";
		List<VariationVariable> vvs = new ArrayList<>();
		SMT2Encoding.createSMT2Encoding(run, npta, VarType.Operator, vvs, smt2filePath);
//		for(VariationVariable vv : vvs) {
//			vv.printRepairInfo();
//		}
		System.out.println(containsQuantifier(MaxSMT.quantifierElimination(smt2filePath)));
//		MaxSMT.repairValuesComputation(smt2filePath, vvs);
	}
	
	@SuppressWarnings("serial")
    class TestFailedException extends Exception
    {
        public TestFailedException()
        {
            super("Check FAILED");
        }
    };

    public static boolean containsQuantifier(String s) {
    	return s.contains("exists") || s.contains("forall");
    }
	
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
