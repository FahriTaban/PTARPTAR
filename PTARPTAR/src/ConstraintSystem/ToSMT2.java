package ConstraintSystem;

import NPTA.*;

public class ToSMT2 {
		
	public static String assertion(Constraint c) {
		String cons = declareConstraint(c);
		return par("assert " + cons);
	}
	
	public static String declareConstraint(Constraint c) {
		return par(c.getOperator()+" "+c.getValue1().valueToString()+ " " + c.getValue2().valueToString());
		}
	
	public static String declareReal(Value v) {
		return par("declare-fun" + v.getName() + par("") + "Real");
	}
	
	public static String initValue(Value v) {
		return par("");
	}
	
	public static String par(String s) {
		return "\\("+s+"\\)";
	}
	
}
