package NPTA;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import ConstraintSystem.ToSMT2;
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
	private Constraint backup;
	private boolean isBoolean = false;
	
	public Constraint(Constraint c) {
		this.lhs = new Ex(c.getLhs().getVariables(),c.getLhs().getOperators());
		this.operator = c.operator;
		this.rhs = new Ex(c.getRhs().getVariables(),c.getRhs().getOperators());
		this.isBoolean = c.isBoolean;
	}
	
	public Constraint(Ex lhs, String op, Ex rhs) {
		this.lhs = lhs;
		this.operator = op;
		this.rhs = rhs;
	}
	
	public Constraint(Ex lhs, String op, Ex rhs, boolean b) {
		this.lhs = lhs;
		this.operator = op;
		this.rhs = rhs;
		this.isBoolean = b;
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
	
	public String toSMTString() {
		if (this.isBoolean) {
			return ToSMT2.formatSMT("0", "0", "=");
		} else {
		return ToSMT2.par(this.operator + " " + this.lhs.toSMTString() + " " + this.rhs.toSMTString());
		}
	}
	
	public String toSMTString(String id) {
		if (this.isBoolean) {
			return ToSMT2.formatSMT("0", "0", "=");
		} else {
		return ToSMT2.par(this.operator + " " + this.lhs.toSMTString()+id + " " + this.rhs.toSMTString());
		}
	}
	
	public void backUp() {
		Ex lhsc = this.copyEx(this.lhs);
		Ex rhsc = this.copyEx(this.rhs);
		String op = this.operator;
		boolean b = this.isBoolean;
		this.backup = new Constraint(lhsc,op,rhsc,b);
		}
	
	public Ex copyEx(Ex e) {
		List<Variable> vs = e.getVariables();
		List<String> ops = e.getOperators();
		List<Variable> vsc = new ArrayList<>();
		List<String> opsc = new ArrayList<>();
		for(Variable v : vs) {
			vsc.add(new Variable(v.getName()));
		}
		for(String op : ops) {
			opsc.add(op);
		}
		Ex c = new Ex(vsc,opsc);
		c.setBool(e.getBool());
		return new Ex(vsc,opsc);
	}
	
	public Ex getLhs() {
		return lhs;
	}
	
	public Ex getRhs() {
		return rhs;
	}
	
	public void setBoolean(boolean b) {
		this.isBoolean = b;
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
