package repair.repairComputation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.BoolSort;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Log;
import com.microsoft.z3.Model;
import com.microsoft.z3.Optimize;
import com.microsoft.z3.RealExpr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import utility.Utility;
import z3.JavaExample;

public class MaxSMT {
	private static int softViolations = 0;
	public static void repairValuesComputation(String smt2filePath, List<VariationVariable> vvs, String evalFilePath) {
		try
        {
            log();

            { // These examples need model generation turned on.
                HashMap<String, String> cfg = new HashMap<String, String>();
                cfg.put("model", "true");
                Context ctx = new Context(cfg);
                String qf = quantifierElimination(smt2filePath);
                System.out.println("STRING AFTER QE: \n"+qf);
                BoolExpr bexpr = ctx.mkAnd(ctx.parseSMTLIB2String(qf, null, null, null, null));
                List<Expr<BoolSort>[]> bexps = new ArrayList<>();
                List<Model> satModels = new ArrayList<>();
                List<IntExpr> iexps = new ArrayList<>();
                int sat = 1;
                int counter = 0;
                int newSize = 0;
                int oldSize = -1;
                int softVios = Integer.MAX_VALUE;
                while (sat == 1 && counter < 1000 && newSize != oldSize) {
                    Optimize opt = ctx.mkOptimize();
                    opt.Add(bexpr);
                    iexps = addSoftsInt(vvs,opt,ctx);
                    if (bexps.size() > 0 && bexps != null) {
						for(Expr<BoolSort>[] bexp : bexps) {
	                    	BoolExpr b = ctx.mkOr(bexp);
	                    	System.out.println(b.toString());
							opt.Add(b);
						}
                    }
					sat = opt.Check().toInt();
					if(sat == 1) {
						Model om = opt.getModel();
						Expr<BoolSort>[] x = helper(iexps,om,vvs,ctx);
						if (softViolations > softVios) {
							break;
						} else {
		                	softVios = softViolations;
							satModels.add(om);
							if(x.length > 0) {
								bexps.add(x);
							}
							counter++;
						}
					}
					oldSize = newSize;
					newSize = bexps.size();
					System.out.println(opt.toString());
                } 
                System.out.println("COUNTER: " + Integer.toString(counter) + "\n" +
                			"SATISFYING MODELS: " + Integer.toString(satModels.size()));
                saveSATModels(satModels,iexps, evalFilePath);
                ctx.close();
            }
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
	
	private static void saveSATModels(List<Model> satModels, List<IntExpr> exps, String evalFilePath) {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(Model m : satModels) {
			sb.append("Valuation " + Integer.toString(i++) + "\n");
			for(IntExpr re : exps) {
	        	String repairValue = m.eval(re, false).toString();
	        	String varName = re.toString();
	        	sb.append(varName + " = " + repairValue + "\n");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		Utility.writeToFile(evalFilePath, sb.toString().strip());
	}
	
	private static Expr<BoolSort>[] helper(List<IntExpr> rexps, Model om, List<VariationVariable> vvs, Context ctx) {
		if (vvs.get(0).lowerIsNull()) {
			return new BoolExpr[0];
		}
		int softVios = 0;
		Expr<IntSort> l,u,cnst;
		BoolExpr lExp,uExp,not;
		int size = rexps.size();
		Expr<BoolSort>[] bexps = new BoolExpr[size];
		int i = 0;
		for(IntExpr re : rexps) {
			VariationVariable vv = findVV(re.toString(),vvs);
			String lower = vv.getLower();
			String upper = vv.getUpper();
			String intValue = om.eval(re, false).toString().split("\\.")[0];
			if (!vv.getNeutralRepairValue().equals(intValue)) {
				softVios++;
			}
			System.out.println(intValue);
			cnst = ctx.mkInt(intValue);
			l = ctx.mkInt(lower);
			u = ctx.mkInt(upper);
			lExp = ctx.mkGe(re, l);
			uExp = ctx.mkLe(re, u);
			not = ctx.mkNot(ctx.mkEq(re, cnst));
			bexps[i] = ctx.mkAnd(lExp,uExp,not);
			i++;
		}
		for(Expr<BoolSort> b : bexps) {
			if (b == null) {
				System.out.println("*".repeat(1000));
			}
		}
		softViolations = softVios;
		return bexps;
	}
	
	
	
//	private static Expr<BoolSort>[] helper(Expr<BoolSort>[] be,List<RealExpr> rexps, Model om, List<VariationVariable> vvs, Context ctx) {
//		Expr<RealSort> cnst;
//		int size = be.length+rexps.size();
//		Expr<BoolSort>[] bexps = new BoolExpr[size];
//		int i = 0;
//		for(Expr<BoolSort> b : be) {
//			bexps[i] = b;
//			i++;
//		}
//		for(RealExpr re : rexps) {
//			cnst = om.eval(re, false);
//			if (ctx.mkEq(re, cnst) != null) {
//				bexps[i] = ctx.mkNot(ctx.mkEq(re, cnst));
//				i++;
//			}
//		}
//		for(Expr<BoolSort> b : bexps) {
//			if (b == null) {
//				System.out.println("*".repeat(1000));
//			}
//		}
//		return bexps;
//	}
	
	private static List<IntExpr> addSoftsInt(List<VariationVariable> vvs, Optimize opt, Context ctx){
		List<IntExpr> iexps = new ArrayList<>();
        for(VariationVariable vv : vvs) {
        	vv.printRepairInfo();
        	String vvn = vv.getName();
        	String nrv = vv.getNeutralRepairValue();
        	IntExpr expr = ctx.mkIntConst(vvn);
        	iexps.add(expr);
        	IntExpr constant = ctx.mkInt(nrv);
        	BoolExpr soft = ctx.mkEq(expr, constant);
            opt.AssertSoft(soft, 1, "default");
        }
        return iexps;
	}
	
	private static List<RealExpr> addSoftsReal(List<VariationVariable> vvs, Optimize opt, Context ctx){
		List<RealExpr> bexps = new ArrayList<>();
        for(VariationVariable vv : vvs) {
        	vv.printRepairInfo();
        	String vvn = vv.getName();
        	String nrv = vv.getNeutralRepairValue();
        	RealExpr expr = ctx.mkRealConst(vvn);
        	bexps.add(expr);
        	RealExpr constant = ctx.mkReal(nrv);
        	BoolExpr soft = ctx.mkEq(expr, constant);
            opt.AssertSoft(soft, 1, "default");
        }
        return bexps;
	}
	
	
	private static void log() {
		com.microsoft.z3.Global.ToggleWarningMessages(true);
        Log.open("test.log");

        System.out.print("Z3 Major Version: ");
        System.out.println(Version.getMajor());
        System.out.print("Z3 Full Version: ");
        System.out.println(Version.getString());
        System.out.print("Z3 Full Version String: ");
        System.out.println(Version.getFullVersion());
	}
	
	private static VariationVariable findVV(String name,List<VariationVariable> vvs) {
		for(VariationVariable vv : vvs) {
			if (vv.getName().equals(name)){
				System.out.println("Found object for variation variable " + name);
				return vv;
			}
		}
		System.out.println("Could not find object for variation variable " + name);
		return null;
	}
	
	public static String quantifierElimination(String filePath) {
		JavaExample p = new JavaExample();
		 try
	        {
	            { // These examples need model generation turned on.
	                HashMap<String, String> cfg = new HashMap<String, String>();
	                cfg.put("model", "true");
	                try (Context ctx = new Context(cfg)) {
	                	BoolExpr a = ctx.mkAnd(ctx.parseSMTLIB2File(filePath, null, null, null, null));
							                System.out.println(a.toString());
						Solver s = ctx.mkTactic("qe").getSolver();
						s.add(a);
						s.check();
						String res = s.toString();
						System.out.println(res);
						String res2 = "";
//						if(res.contains("exists") || res.contains("forall")) {
//							System.out.println("ENTER IF \n" + res);
//							BoolExpr b = ctx.mkAnd(ctx.parseSMTLIB2String(res, null, null, null, null));
//							System.out.println("NEW BOOL EXP \n" + b.toString());
//							Solver s2 = ctx.mkTactic("qe").getSolver();
//							System.out.println("LEAVE IF");
//							s2.add(b);
//							System.out.println(s2.toString());
//							res2 = s2.toString();
//							System.out.println("ARE BOTH RESULTS EQUAL: " + Boolean.toString(res.equals(res2)));
//							res = res2;
//						}
						return res;
	            }

//	            p.translationExample();

//	            Log.close();
//	            if (Log.isOpen())
//	                System.out.println("Log is still open!");
	        }} catch (Z3Exception ex)
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
		return null;
	}
}
        