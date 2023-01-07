package npta;

public class Parameter extends Variable {
	private String concValue = "";
	private boolean isConst = false;
	
	public Parameter(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	public Parameter(String name, String concValue) {
		super(name);
		this.setConcValue(concValue);
		this.isConst = true;
		// TODO Auto-generated constructor stub
	}

	public String getConcValue() {
		return concValue;
	}

	public void setConcValue(String concValue) {
		this.concValue = concValue;
	}
	public boolean isConst() {
		return isConst;
	}
	
	public void printParam() {
		if(!isConst)
			System.out.println("Parameter: " + this.getName() + " is a constant: " + Boolean.toString(isConst));
		else
			System.out.println("Parameter: " + this.getName() + " = " + this.getConcValue());

	}
	
	

}
