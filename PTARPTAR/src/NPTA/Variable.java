package NPTA;

/**
 * Parent class of Clock and Parameter
 * @author 49173
 *
 */
public class Variable {
	private String name;
	
	public Variable(String n) {
		this.setName(n);
	}
	
	public Variable(int i) {
		this.setName(Integer.toString(i));
	}
	
	public Variable(boolean b) {
		if (b) {
			this.setName("True");
		} else {
			this.setName("False");	
		}
	}

	public boolean isConstant() {
		return this.name.matches("\\w+");
	}
	
	public boolean variableEquals(String s) {
		return (this.name.equals(s));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo(boolean isClock) {
		String type;
		if (isClock) {
			type = "Clock";
		} else {
			type = "Parameter";
		}
		if (this.name != null) {
			System.out.println(type + " " + this.name);
		}
	}
	
	
	public void printInfo() {
		if (this.name != null) {
			System.out.println("Variable "+ " " + this.name);
		}
	}
}
