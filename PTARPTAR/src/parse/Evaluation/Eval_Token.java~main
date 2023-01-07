package parse.Evaluation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum Eval_Token {
	KEY_VALUATION("Valuation \\d+"),
	VALUE("[-+]?\\d+"),
	KEY_VAR_NAME("\\w+"),
	WHITESPACE("\\s+"),
	EQ("=");	

    private final Pattern pattern;

    Eval_Token(String regex) {
        pattern = Pattern.compile("^" + regex);
	
    }
    
    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);
        if (m.find()) {
        	int end = m.end();
            return end;
        }
        return -1;
    }
    
    public boolean isUseful() {
    	if (this.name() != "WHITESPACE" && this.name() != "EQ")
    		return true;
    	return false;
    }
}
