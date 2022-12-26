package ConstraintSystem;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import ConstraintSystem.VariationVariable.VarType;
import ModelToPTA.ConvertModelToNPTA;
import NPTA.NetworkPTA;
import Parsing.Element;
import Parsing.Result_Lexer;
import Run.Run;
import resToRun.ConvertResToRun;

public class MaxSMT {
	public static String constructMaxSMTstring(VarType v_type) {
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
		String tdtcs = SMT2.createSMT2Encoding(run, npta, v_type);
		
	}
}
