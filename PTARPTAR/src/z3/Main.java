package z3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Log;
import com.microsoft.z3.Model;
import com.microsoft.z3.Optimize;
import com.microsoft.z3.RatNum;
import com.microsoft.z3.RealExpr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import z3.JavaExample.TestFailedException;

public class Main {

	public static void main(String[] args) {
		JavaExample p = new JavaExample();
		 try
	        {
	            com.microsoft.z3.Global.ToggleWarningMessages(true);
	            Log.open("test.log");

	            System.out.print("Z3 Major Version: ");
	            System.out.println(Version.getMajor());
	            System.out.print("Z3 Full Version: ");
	            System.out.println(Version.getString());
	            System.out.print("Z3 Full Version String: ");
	            System.out.println(Version.getFullVersion());

	            { // These examples need model generation turned on.
	                HashMap<String, String> cfg = new HashMap<String, String>();
	                cfg.put("model", "true");
	                cfg.put("unsat_core", "true");
	                Context ctx = new Context(cfg);
	                BoolExpr a = ctx.mkAnd(ctx.parseSMTLIB2File("TDTCS.txt", null, null, null, null));
	                Solver s = ctx.mkSolver();      
	                Optimize o = ctx.mkOptimize();
	                List<String> softs = new ArrayList<>();
	                String string = "(and (= bvg0 0)\r\n"
	                		+ "	(= bvg1 0)\r\n"
	                		+ "	(= bvg2 0)\r\n"
	                		+ "	(= bvi0 0)\r\n"
	                		+ "	(= bvi1 0)\r\n"
	                		+ "	(= bvi2 0)\r\n"
	                		+ "	(= bvi3 0)\r\n"
	                		+ "	(= bvi4 0)\r\n"
	                		+ "	(= bvi5 0)\r\n"
	                		+ "	(= bvi6 0))";
	                RealExpr bvg2 = ctx.mkRealConst("bvg2");
	                RealExpr bvg1 = ctx.mkRealConst("bvg1");
	                RealExpr bvi3 = ctx.mkRealConst("bvi3");
	                RealExpr consta = ctx.mkReal("5");
	                BoolExpr soft = ctx.mkGt(bvg1, bvg2);
	                BoolExpr soft2 = ctx.mkGt(bvg2, bvg1);
	                BoolExpr soft3 = ctx.mkGt(bvi3, bvg1);
	                BoolExpr soft4 = ctx.mkGt(bvg1, bvi3);
	                BoolExpr soft5 = ctx.mkEq(bvi3, consta);
	                BoolExpr soft6 = ctx.mkEq(bvg1, consta);
	                BoolExpr soft7 = ctx.mkEq(bvg2, consta);
	                
//	                BoolExpr b = ctx.mkAnd(ctx.parseSMTLIB2String(string, null, null, null, null));
	                o.Assert(soft);
	                o.Assert(soft4);
	                o.AssertSoft(soft2, 1, "default");
	                o.AssertSoft(soft3, 1, "default");
	                o.AssertSoft(soft5, 1, "default");
	                o.AssertSoft(soft6, 1, "default");
	                o.AssertSoft(soft7, 1, "default");
//	                s.add(a);
	                o.Add(a);
	                System.out.println(o.Check());
	                	
//	                s.check();
//					Model m = s.getModel();
					Model om = o.getModel();
//	                System.out.println(m.toString());
	                System.out.println(om.eval(bvg1, true));
//	                var m = s.getModel();
//	                p.basicTests(ctx);
//	                p.check(ctx, a, null);
//	                p.simpleExample();
//	                p.parserExample1(ctx);
//	                p.smt2FileTest("TDTCS.txt");
//	                p.parserExample2(ctx);
//	                p.parserExample5(ctx);
//	                p.quantifierExample1(ctx);
	                // core dumps: p.floatingPointExample2(ctx);
	                ctx.close();
	            }

//	            p.translationExample();

//	            Log.close();
//	            if (Log.isOpen())
//	                System.out.println("Log is still open!");
	        } catch (Z3Exception ex)
	        {
	            System.out.println("Z3 Managed Exception: " + ex.getMessage());
	            System.out.println("Stack trace: ");
	            ex.printStackTrace(System.out);
	        } catch (Exception ex)
	        {
	            System.out.println("Unknown Exception: " + ex.getMessage());
	            System.out.println("Stack trace: ");
	            ex.printStackTrace(System.out);
	        }
	    }
	
	
	
	public static void pr(String str) {
		System.out.println(str);
	}
	public static void pr(int str) {
		System.out.println(Integer.toString(str));
	}

}
