package npta;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utility.Utility;

public class Ex {
	private List<Variable> variables;
	private List<String> operators;
	private boolean isBoolean = false;
	
	public Ex(Variable v) {
		this.variables = new ArrayList<>();
		this.variables.add(v);
		this.operators = new ArrayList<>();
	}
	
	public Ex(List<Variable> vs, List<String> ops) {
		this.variables = vs;
		this.operators = ops;
	}
	
	public Ex(String s) {
		this.variables = new ArrayList<>();
		this.operators = new ArrayList<>();
		if (s == "") {
			return;
		} else {
			String[] parts = s.split(" ");
			for(String p : parts) {
				if (Utility.isArOperator(p)) {
					this.operators.add(p);
				} else {
					this.variables.add(new Variable(p));
				}
			}
		}
	}
	
	public Ex(String s, List<Parameter> params) {
		this.variables = new ArrayList<>();
		this.operators = new ArrayList<>();
		boolean added = false;
		if (s == "") {
			return;
		} else {
			String[] parts = s.split(" ");
			for(String p : parts) {
				added = false;
				if (Utility.isArOperator(p)) {
					this.operators.add(p);
				} else {
					for(Parameter param : params) {
						if (p.equals(param.getName())) {
							this.variables.add(param);
							added = true;
							break;
						}
					}
					if(!added)
						this.variables.add(new Variable(p));
				}
			}
		}
	}
	
	public Ex(boolean b) {
		this.variables = new ArrayList<>();
		variables.add(new Variable(b));
		this.operators = new ArrayList<>();
		this.isBoolean = true;
	}
	
	public List<Variable> getVariables() {
		return this.variables;
	}
	
	public void setBool(boolean b) {
		this.isBoolean = b;
	}
	
	public boolean getBool() {
		return this.isBoolean;
	}
	
	public List<String> getOperators(){
		return this.operators;
	}
	
	public String getVariable(int i) {
		Variable v = this.getVariables().get(i);
		String res;
		if (v instanceof Parameter) {
			if(((Parameter) v).isConst()) {
				res = ((Parameter) v).getConcValue();
			} else {
				res = v.getName();
			}
		} else {
			res = v.getName();
		}
		return res;
	}
	
	public String reverseToString() {
		if (this.isBoolean) {
			return this.variables.get(0).toString();
		}
		StringBuilder s = new StringBuilder();
		String var = "";
		String op = ""; 
		for(int i = this.variables.size()-1; i >= 0;i--) {
			var = this.getVariable(i);
			int j = i - 1;
			if(j == -1) {
				op = "";
			} else {
				op = Utility.mirrorOperator(this.operators.get(j));
			}
			s.append(var + " " + op + " ");
		}
		return s.toString().strip();
	}
	
	@Override 
	public boolean equals(Object e){
		return super.equals(e);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		if (this.isBoolean) {
			return this.getVariable(0);
		}
		StringBuilder s = new StringBuilder();
		String varName = "";
		String op = ""; 
		for(int i = 0; i < this.operators.size();i++) {
			varName = this.getVariable(i);
			op = this.operators.get(i);
			s.append(varName + " " + op + " ");
		}
		s.append(this.getVariable(this.variables.size()-1));
		return s.toString().strip();
	}
	
	public String toModelString() {
		if (this.isBoolean) {
			return this.getVariable(0);
		}
		StringBuilder s = new StringBuilder();
		String varName = "";
		String op = ""; 
		for(int i = 0; i < this.operators.size();i++) {
			varName = this.getVariables().get(i).getName();
			op = this.operators.get(i);
			s.append(varName + " " + op + " ");
		}
		s.append(this.getVariables().get(this.variables.size()-1).getName());
		return s.toString();
	}
	
	public String toSMTString() {
		if (this.isBoolean) {
			return this.variables.get(0).getName();
		}
		StringBuilder s = new StringBuilder();
		String var = "";
		String op = ""; 
		int j = operators.size()-1;
		for(int i = 0; i < this.variables.size();i++) {
			var = this.getVariable(i);
			if(i > j) {
				s.append(var);
			} else {
				op = this.operators.get(i) + " ";
				s.append("(" + op + var + " ");
			}
		}
		s.append(")".repeat(this.operators.size()));
		return s.toString();
	}

	public boolean containsClock(Clock c) {
		for(Variable v : this.variables) {
			if(v.getName().equals(c.getName()))
				return true;
		}
		return false;
	}

	

}
