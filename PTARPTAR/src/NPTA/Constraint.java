package NPTA;

import java.util.List;
import Parsing.*;
/**
 * Linear constraint on clock or parameter
 * @author 49173
 *
 */
public class Constraint {
	private Value val1;
	private String operator;
	private Value val2;
	
	public Constraint(Value v, String op, Value b) {
		this.val1 = v;
		this.operator = op;
		this.val2 = b;
	}
	
	public Constraint(String bool) {
		this.val1 = new Value(bool);
		this.operator = "";
		this.val2 = new Value("");
	}
	
	
	public Value getValue1() {
		return val1;
	}
	
	public Value getValue2() {
		return val2;
	}


	public String getOperator() {
		return operator;
	}
	
	public void printInfo() {
		System.out.println("Constraint");
		String va1;
		String va2;
		if(this.val1.getName() != null) {
			va1 = val1.getName();
		} else {
			va1 = Integer.toString(val1.getValue());
		}
		if(this.val2.getName() != null) {
			va2 = val2.getName();
		} else {
			va2 = Integer.toString(val2.getValue());
		}
		System.out.println(va1 + " " + this.operator + " " + va2);
	}
	
	public String constraintToString() {
		System.out.println("Constraint");
		String va1;
		String va2;
		if(this.val1.getName() != null) {
			va1 = val1.getName();
		} else {
			va1 = Integer.toString(val1.getValue());
		}
		if(this.val2.getName() != null) {
			va2 = val2.getName();
		} else {
			va2 = Integer.toString(val2.getValue());
		}
		return va1 + " " + this.operator + " " + va2;
	}
	
	public boolean constraintEquals(List<Element> elems) {
		int count = 0;
		for(Element g : elems) {
			if (this.val1.valueEquals(g.getContent()) || this.getOperator().equals(g.getContent()) 
					|| this.val2.valueEquals(g.getContent())) {
				count++;
			}
		}
		return (count == 3 || (count == 1 && elems.size() == 1) );
		
	}
	
}
