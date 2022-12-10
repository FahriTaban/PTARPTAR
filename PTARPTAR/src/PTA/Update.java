package PTA;

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
	
	public void printInfo() {
		System.out.println("Update");
		System.out.println(this.variable + " := " + this.setToValue);
	}
}
