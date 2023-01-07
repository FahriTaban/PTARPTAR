package npta;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parse.*;
import repair.tdtcs.ToSMT2;
import utility.Utility;
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
	private boolean doNotModify = false;
	
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
	
	public Constraint(String con) {
		List<String> strings = Utility.splitString(con,"[><=]+");
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
	
	public Constraint(Element con, List<Parameter> params) {
		List<String> strings = Utility.splitString(con.getContent(),"[><=]+");
		if (strings.size() == 1) {
			this.lhs = new Ex(strings.get(0));
			this.operator = "";
			this.rhs = new Ex("");
			this.isBoolean = true;
		} else {
		this.lhs = new Ex(strings.get(0), params);
		this.operator = strings.get(1);
		this.rhs = new Ex(strings.get(2), params);
		}
	}
	
	
	public int getHighestBound() {
		int hb = 0;
		int nb = 0;
		Pattern p = Pattern.compile("\\d+");
		for(Variable v : this.rhs.getVariables()) {
			Matcher m = p.matcher(v.getName());
			if(m.matches()) {
				nb = Integer.valueOf(v.getName());
			}
			if(nb > hb) {
				hb = nb;
			}
		}
		return hb;
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
	
	public String toSMTString(String id, boolean negateOp) {
		String op = this.operator;
		if (this.isBoolean) {
			return ToSMT2.formatSMT("0", "0", "=");
		} else {
			if(negateOp) {
				op = Utility.negateOperator(op);
			}
		return ToSMT2.par(op + " " + this.lhs.toSMTString()+id + " " + this.rhs.toSMTString());
		}
	}
	
	public void backUp() {
		Ex lhsc = this.copyEx(this.lhs);
		Ex rhsc = this.copyEx(this.rhs);
		String op = this.operator;
		boolean b = this.isBoolean;
		this.backup = new Constraint(lhsc,op,rhsc,b);
		}
	
	public void restore() {
		this.lhs = this.backup.getLhs();
		this.rhs = this.backup.getRhs();
		this.operator = this.backup.getOperator();
		this.isBoolean = this.backup.isBoolean();
	}
	
	public Ex copyEx(Ex e) {
		List<Variable> vs = e.getVariables();
		List<String> ops = e.getOperators();
		List<Variable> vsc = new ArrayList<>();
		List<String> opsc = new ArrayList<>();
		for(Variable v : vs) {
			if (v instanceof Parameter) {
				if (((Parameter) v).isConst()) {
					vsc.add(new Parameter(v.getName(), ((Parameter) v).getConcValue()));
				} else {
					vsc.add(new Parameter(v.getName()));
				}
			} else {
				vsc.add(new Clock(v.getName()));
			}
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
	
	public boolean isBoolean() {
		return this.isBoolean;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String op) {
		this.operator = op;
	}
	
	public void printInfo() {
		System.out.println("Constraint");
		System.out.println(this.toModelString());
		System.out.println(this.toString());
	}
	
	@Override
	public boolean equals(Object c) {
		return super.equals(c);
	}
	
    @Override
    public int hashCode() {
    	return super.hashCode();
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
	
	public String toModelString() {
		String le1 = "";
		String le2 = "";
		String op = "";
		if (this.isBoolean) {
			le1 = this.lhs.getVariables().get(0).getName();
			return le1;
		} else {
			le1 = this.lhs.toModelString();
			le2 = this.rhs.toModelString();
			op = this.operator;
		}
		return le1 + " " + op + " " + le2;
	}
	
	public String reversedToString(boolean replace) {
		String le1 = "";
		String le2 = "";
		String op = "";
		if (this.isBoolean) {
			le1 = this.lhs.getVariables().get(0).getName();
			return le1;
		} else {
			if(replace) {
				le1 = this.rhs.toString();
				le2 = this.lhs.toString();
			} else {
				le1 = this.rhs.toModelString();
				le2 = this.lhs.toModelString();
			}
			
			op = Utility.mirrorOperator(this.operator);
		}
		return le1 + " " + op + " " + le2;
	}
	
	public boolean constraintEquals(Element con_elem) {
		String constraint = con_elem.getContent();
		boolean res = checkEquality(constraint, this.toString());
		if(!res) {
			res = checkEquality(constraint, this.reversedToString(false));
		}
		if(!res) {
			res = checkEquality(constraint, this.reversedToString(true));
		}
		if(!res) {
			String replaced = this.replaceParametersToString(false);
			res = checkEquality(constraint, replaced);
			if(!res) {
				replaced = this.replaceParametersToString(true);
				res = checkEquality(constraint, replaced);
			}
		}
		if(!res) {
			res = this.solveForClockToString(constraint);
		}
		return res;
		
	}
	
	public List<Variable> getVariables(){
		List<Variable> vs = new ArrayList<>();
		vs.addAll(this.lhs.getVariables());
		vs.addAll(this.rhs.getVariables());
		return vs;
	}
	
	public boolean solveForClockToString(String con) {
		String toString = this.toModelString();
		for(String s : con.split(" ")) {
			if(!toString.contains(s)) {
				if((Utility.isArOperator(s) && !toString.contains(Utility.negateOperator(s))) ||
						Utility.isCompOperator(s)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String replaceParametersToString(boolean reversed) {
		if (this.isBoolean) {
			return this.lhs.getVariable(0);
		} else if (!reversed){
			return this.lhs.toModelString() + " " + operator + " " + this.rhs.toModelString();
		} else {
			return this.rhs.reverseToString() + " " + Utility.mirrorOperator(operator) + " " +lhs.reverseToString();
		}
	}
	
	
	private boolean checkEquality(String con_elem, String con) {
		return con_elem.equals(con);
	}
	
	public boolean constrainsClock(Clock c){
		if (this.isBoolean) {
			return false;
		}
		return this.lhs.containsClock(c);
	}

	public boolean isDoNotModify() {
		return doNotModify;
	}

	public void setDoNotModify(boolean doNotModify) {
		this.doNotModify = doNotModify;
	}
	
}
