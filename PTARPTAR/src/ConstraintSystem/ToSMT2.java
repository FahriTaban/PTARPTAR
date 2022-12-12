package ConstraintSystem;

import NPTA.*;

public class ToSMT2 {
		
	public static String assertion(Constraint c) {
		String cons = declareConstraint(c);
		return brackets("assert " + cons);
	}
	
	public static String declareConstraint(Constraint c) {
		return brackets(c.getOperator()+" "+c.getValue1().valueToString()+ " " + c.getValue2().valueToString());
		}
	
	public static String declareReal(Value v) {
		return brackets("declare-fun" + v.getName() + brackets("") + "Real");
	}
	
	public static String brackets(String s) {
		return "\\("+s+"\\)";
	}
	
}
