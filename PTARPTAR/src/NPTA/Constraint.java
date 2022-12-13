package NPTA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Parsing.*;
import Utility.Utility;
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
		boolean res = checkEquality(elems);
		if(!res && elems.size() > 1) {
			List<Element> reversed = reverseList(elems);
			res = checkEquality(reversed);
		}
		if(!res) {
			System.out.println(this.constraintToString() + " NOT EQUAL TO " + Utility.elemToString(elems));
		}
		return res;
		
	}
	
	private List<Element> reverseList(List<Element> elems){
		List<Element> reversed = new ArrayList<>();
		for(int i = elems.size()-1;i >= 0;i--) {
			Element e = elems.get(i);
			if(e.isComparisonOperator()) {
				Element f = new Element("",negateOperator(e.getContent()));
				reversed.add(f);
			} else {
			reversed.add(elems.get(i));
			}
		}
		return reversed;
	}
	
	private boolean checkEquality(List<Element> elems) {
		int count = 0;
		for(int i = 0; i < elems.size(); i++) {
			Element g = elems.get(i);
			String gc = g.getContent();
			if (this.val1.valueEquals(gc) || this.getOperator().equals(gc) 
					|| this.val2.valueEquals(gc)) {
				count++;
			}
		}
		return count == elems.size() && elems.size() > 0;
	}
	
	private String negateOperator(String operator) {
		switch(operator) {
			case "=":
				return "!=";
			case ">=":
				return "<=";
			case "<=":
				return ">=";
			case ">":
				return "<";
			case "<":
				return ">";
			default:
				return operator;
		}
	}
	
}
