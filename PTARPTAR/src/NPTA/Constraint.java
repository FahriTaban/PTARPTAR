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
	private Ex lhs;
	private String operator;
	private Ex rhs;
	private boolean isBoolean = false;
	
	public Constraint(Ex v, String op, Ex b) {
		this.lhs = v;
		this.operator = op;
		this.rhs = b;
	}
	
	public Constraint(boolean bool) {
		this.lhs = new Ex(bool);
		this.operator = "";
		this.rhs = new Ex(bool);
		this.isBoolean = true;
	}
	
	public Constraint(Element con) {
		List<String> strings = Utility.splitString(con.getContent(),"[><=]+");
		if (strings.size() == 1) {
			this.lhs = new Ex(strings.get(0));
			this.operator = "";
			this.rhs = new Ex("");
			this.isBoolean = true;
		} else {
		this.lhs = new Ex(strings.get(0));
		this.operator = strings.get(1);
		this.rhs = new Ex(strings.get(2));
		}
	}
	
	public Ex getLhs() {
		return lhs;
	}
	
	public Ex getRhs() {
		return rhs;
	}


	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String op) {
		this.operator = op;
	}
	
	public void printInfo() {
		System.out.println("Constraint");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		String le1 = "";
		String le2 = "";
		String op = "";
		if (this.isBoolean) {
			le1 = this.lhs.getVariable(0);
			return le1;
		} else {
			le1 = this.lhs.toString();
			le2 = this.rhs.toString();
			op = this.operator;
		}
		return le1 + " " + op + " " + le2;
	}
	
	public String reversedToString() {
		String le1 = "";
		String le2 = "";
		String op = "";
		if (this.isBoolean) {
			le1 = this.lhs.getVariables().get(0).getName();
			return le1;
		} else {
			le1 = this.rhs.toString();
			le2 = this.lhs.toString();
			op = Utility.negateOperator(this.operator);
		}
		return le1 + " " + op + " " + le2;
	}
	
	public boolean constraintEquals(Element constraint) {
		boolean res = checkEquality(constraint, this.toString());
		if(!res) {
			res = checkEquality(constraint, this.reversedToString());
		}
		if(!res) {
			System.out.println(this.toString() + " NOT EQUAL TO " + constraint.getContent());
		}
		return res;
		
	}
	
	private boolean checkEquality(Element con_elem, String con) {
		return con_elem.getContent().equals(con);
	}
	
	public boolean constrainsClock(Clock c){
		if (this.isBoolean) {
			return false;
		}
		return this.lhs.toString().contains(c.getName()) || this.rhs.toString().contains(c.getName());
	}
	
}
