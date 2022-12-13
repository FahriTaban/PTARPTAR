package SMT;

import java.io.File;
import java.util.HashMap;

import com.microsoft.z3.Context;
import com.microsoft.z3.Log;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import SMT.JavaExample.TestFailedException;

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
	        
	                p.simpleExample();
	                p.parserExample1(ctx);
	                p.parserExample2(ctx);
	                p.parserExample5(ctx);
	                // core dumps: p.floatingPointExample2(ctx);
	            }

	            p.translationExample();

	            Log.close();
	            if (Log.isOpen())
	                System.out.println("Log is still open!");
	        } catch (Z3Exception ex)
	        {
	            System.out.println("Z3 Managed Exception: " + ex.getMessage());
	            System.out.println("Stack trace: ");
	            ex.printStackTrace(System.out);
	        } catch (TestFailedException ex)
	        {
	            System.out.println("TEST CASE FAILED: " + ex.getMessage());
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
