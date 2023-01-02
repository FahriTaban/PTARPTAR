package parse;


public class Element {
	
	private final String type;
	private final String content;
	
	public Element(String t, String c) {
		type = t;
		content = c;
	}

	public String getContent() {
		return content;
	}

	public String getType() {
		return type;
	}
	
	public void elemInfo() {
		System.out.println("\n Element" + this.hashCode());
		System.out.println("Type: " + this.type);
		System.out.println(this.content);
	}
	
	public boolean isComparisonOperator() {
		return this.type == "LEQ" || this.type == "LT" 
				|| this.type == "EQ" || this.type == "GT" 
				|| this.type == "GEQ";
	}
	
	public boolean isValue() {
		return this.type == "VALUE" || this.type == "KEY_VAR_BOOL_TRUE" || this.type == "KEY_VAR_BOOL_FALSE"
				|| this.type == "DIVISION";
	}
	
	public boolean isBool() {
		return this.type == "KEY_VAR_BOOL_TRUE" || this.type == "KEY_VAR_BOOL_FALSE";
	}
}
