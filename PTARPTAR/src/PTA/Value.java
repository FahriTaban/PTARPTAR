package PTA;

/**
 * Parent class of Clock and Parameter
 * @author 49173
 *
 */
public class Value {
	private int valuation = 0;
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
}
