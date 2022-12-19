package Parsing.Statespace;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Statespace_Token {
		KEY_TRANSITIONS_DESCRIPTION("DESCRIPTION OF THE TRANSITIONS"),
		KEY_VAR_NAME("\\w+"),
		KEY_VIA("via"),
		ARROW("\\->"),
		NEWLINE("\\n"),
		ELSE(".");

	    private final Pattern pattern;
	    
	    Statespace_Token(String regex) {
	        pattern = Pattern.compile("^" + regex);
		
	    }
	    
	    public boolean isUseful() {
	    	return this.name() != "ELSE";			
	    }
	    
	    int endOfMatch(String s) {
	        Matcher m = pattern.matcher(s);
	        if (m.find()) {
	        	int end = m.end();
	            return end;
	        }
	        return -1;
	    }
	}

