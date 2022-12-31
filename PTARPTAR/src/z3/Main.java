package z3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.microsoft.z3.ApplyResult;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Goal;
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
	                Context ctx = new Context(cfg);
//	                BoolExpr a = ctx.mkAnd(ctx.parseSMTLIB2File("new_tdtcs.txt", null, null, null, null));
//	                //	                System.out.println(a.toString());
//	                Goal g = ctx.mkGoal(false, false, false);
//	                g.add(a);
//	                Solver s = ctx.mkTactic("qe").getSolver();
//	                s.add(a);
//	                s.check();
//	              	System.out.println(s.toString());
	                p.parserExample1(ctx);
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
