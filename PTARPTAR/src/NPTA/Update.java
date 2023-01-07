package npta;

import java.util.List;

import parse.*;

public class Update {
	private String variable;
	private String setToValue;
	
	public Update(String var, String val) {
		this.variable = var.strip();
		this.setToValue = val.strip();
	}
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable.strip();
	}

	public String getSetToValue() {
		return setToValue.strip();
	}

	public void setSetToValue(String setToValue) {
		this.setToValue = setToValue.strip();
	}
	
	public boolean updateEquals(Element update) {
		return this.variable.equals(update.getContent());
	}
	
	public void printInfo() {
		System.out.println("Update");
		System.out.println(this.variable + " := " + this.setToValue);
	}
	
	public String updateToString() {
		return "{"+this.variable + " := " + this.setToValue+"}";
	}
	
	public boolean updatesClock(Clock c){
		return this.variable.equals(c.getName());
	}
}
