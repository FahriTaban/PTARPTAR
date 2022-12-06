package Parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum Model_Token {
	COMMENT("\\((?:[^)(]|\\((?:[^)(]|\\((?:[^)(]|\\([^)(]*\\))*\\))*\\))*\\)"),
	KEY_VAR("var"),
	KEY_VAR_DECL_CLOCKS("clock\\s*;"),
	KEY_VAR_DECL_PARAMETERS("parameter\\s*;"),
	KEY_VAR_BOOL("bool"),
	KEY_VAR_BOOL_TRUE("True"),
	KEY_VAR_BOOL_FALSE("False"),
	KEY_INIT("init"),
	KEY_INIT_DISCRETE("discrete"),
	KEY_INIT_CONTINUOUS("continuous"),
	KEY_END("end"),
	KEY_AUTOMATON("automaton"),
	KEY_ACTIONS("synclabs"),
	KEY_DO("do"),
	KEY_ACTION("sync"),
	KEY_LOCATION_ACCESS("loc\\[\\w+\\]"),
	KEY_LOCATION("loc"),
	KEY_LOCATION_GOTO("goto"),
	KEY_LOCATION_WHEN("when"),
	KEY_INVARIANT("invariant"),
	RES_KEY_STATE("state"),
	RES_KEY_LOCATION("location"),
	KEY_VAR_NAME("\\w+"),
	
//	KEY_INVARIANT_CONDITION(""),
	WHITESPACE("\\s+"),
	BRACE_L("\\{"),
	BRACE_R("\\}"),
	AND("&"),
	OR("\\|"),
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
	MULT("\\*");
	

    private final Pattern pattern;

    Model_Token(String regex) {
        pattern = Pattern.compile("^" + regex);
	
    }
    
    public boolean isUseful() {
    	if (this.name() != "COMMENT" && this.name() != "WHITESPACE")
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
}
