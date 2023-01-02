package parse.Property;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Prop_Token {
	COMMENT("\\((?:[^)(]|\\((?:[^)(]|\\((?:[^)(]|\\([^)(]*\\))*\\))*\\))*\\)"),
	KEY_LOCATION_ACCESS("loc\\[\\w+\\]"),
	KEY_VAR_NAME("\\w+"),
	WHITESPACE("\\s+"),
	BRACE_L("\\{"),
	BRACE_R("\\}"),
	AND("AND"),
	LAND("&"),
	OR("OR"),
	LOR("\\|"),
	EQ("="),
	GEQ(">="),
	LEQ("<="),
	LT("<"),
	GT(">"),
	DEF(":="),
	VALUE("\\d+"),
	COLON(":"),
	SEMI(";"),
	COMMA(","),
	MINUS("-"),
	PLUS("\\+"),	
	MULT("\\*"),
	JUNK(".");
	

    private final Pattern pattern;

    Prop_Token(String regex) {
        pattern = Pattern.compile("^" + regex);
	
    }
    
    public boolean isUseful() {
    	if (this.name() != "COMMENT" && this.name() != "WHITESPACE" && this.name() != "JUNK")
    		return true;
    	return false;
    			
    }
    
    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);
        if (m.find()) {
        	int end = m.end();
            return end;
        }
        return -1;
    }
    
    public boolean isConstraint() {
    	return this.name() == "CONSTRAINT";
    }
}
