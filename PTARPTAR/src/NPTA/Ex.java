package NPTA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utility.Utility;

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
				System.out.println(p);
				if (Utility.isArOperator(p)) {
					this.operators.add(p);
				} else {
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
	
	public List<String> getOperators(){
		return this.operators;
	}
	
	public String getVariable(int i) {
		return this.getVariables().get(i).getName();
	}
	
	public String reverseToString() {
		if (this.isBoolean) {
			return this.variables.get(0).toString();
		}
		StringBuilder s = new StringBuilder();
		String var = "";
		String op = ""; 
		for(int i = this.operators.size()-1; i >= 0;i--) {
			var = this.variables.get(i).getName();
			int j = i - 1;
			if(j == -1) {
				op = "";
			} else {
				op = " " + Utility.negateOperator(this.operators.get(i));
			}
			s.append(var + op + " ");
		}
		return s.toString();
	}
	
	@Override
	public String toString() {
		if (this.isBoolean) {
			return this.variables.get(0).toString();
		}
		StringBuilder s = new StringBuilder();
		String var = "";
		String op = ""; 
		for(int i = 0; i < this.operators.size();i++) {
			var = this.variables.get(i).getName();
			op = this.operators.get(i);
			s.append(var + " " + op + " ");
		}
		s.append(this.getVariable(this.variables.size()-1));
		return s.toString();
	}
	
	public String toSMTString() {
		if (this.isBoolean) {
			return this.variables.get(0).toString();
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

	

}
