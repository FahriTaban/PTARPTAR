package PTA;

/**
 * Parent class of Clock and Parameter
 * @author 49173
 *
 */
public class Value {
	private int valuation;
	private String name;
	
	public Value(int v, String n) {
		this.setValue(v);
		this.setName(n);
	}
	
	public Value(String n) {
		this.setName(n);
	}
	
	public Value(int v) {
		this.setValue(v);
		this.setName("Integer");
	}

	public boolean isConstant() {
		return this.name == null;
	}
	
	public int getValue() {
		return valuation;
	}

	public void setValue(int value) {
		this.valuation = value;
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
		System.out.println("Valuation =" + Integer.toString(this.valuation));
	}
	
	public void printInfo() {
		if (this.name != null) {
			System.out.println("Variable "+ " " + this.name);
		}
		System.out.println("Valuation =" + Integer.toString(this.valuation));
	}
}
