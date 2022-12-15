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
			List<String> parts = Utility.splitString(s, " ");
			for(String p : parts) {
				if (Utility.isArOperator(s)) {
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
	
	public String reverseToString(){
		StringBuilder s = new StringBuilder();
		String var = "";
		String op = ""; 
		for(int i = this.operators.size()-1; i >= 0 ;i--) {
			var = this.variables.get(i).getName();
			op = this.operators.get(i);
			op = Utility.negateOperator(op);
			s.append(var + " " + op + " ");
		}
		s.append(this.variables.get(0));
		return s.toString();
	}
	

}
