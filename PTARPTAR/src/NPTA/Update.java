package NPTA;

import java.util.List;
import Parsing.*;

public class Update {
	private String variable;
	private String setToValue;
	
	public Update(String var, String val) {
		this.variable = var;
		this.setToValue = val;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getSetToValue() {
		return setToValue;
	}

	public void setSetToValue(String setToValue) {
		this.setToValue = setToValue;
	}
	
	public boolean updateEquals(List<Element> update) {
		int count = 0;
		for(Element u : update) {
			if(this.variable.equals(u.getContent()) || this.setToValue.equals(u.getContent())) {
				count++;
			}
		}
		return count == update.size();
}
	
	public void printInfo() {
		System.out.println("Update");
		System.out.println(this.variable + " := " + this.setToValue);
	}
}
