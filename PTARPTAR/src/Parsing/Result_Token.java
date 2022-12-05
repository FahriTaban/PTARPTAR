package Parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Result_Token {
	COMMENT("\\((?:[^)(]|\\((?:[^)(]|\\((?:[^)(]|\\([^)(]*\\))*\\))*\\))*\\)"),
	INIT_INFO("(?s)\\-{2,}.*?\\-{2,}"),
	STATISTICS_INFO("(?s)\\-{2,}.*\\-{2,}"),
	KEY_BEGIN_RESULT("BEGIN RESULT"),
	KEY_END_RESULT("END RESULT"),
	KEY_RUN_NATURE("Run nature"),
	KEY_RUN_NATURE_VALID("valid run"),
	KEY_RUN_NATURE_INVALID("impossible run"),
	KEY_RUN_NR("Run\\s*.\\d"),
	KEY_RUN("Run"),
	KEY_OTHER_VALUATIONS("Other valuations with equivalent \\(discrete\\) run"),
	KEY_PARAM_VALUATION("[vV]aluation"),
	
	KEY_STEPS("steps"),
	KEY_STATE("state"),
	KEY_LOCATION("location"),
	KEY_VARS("[a-z]+_variables"),
	KEY_FLOWS("flows"),
	KEY_TRANSITION_TRANSITIONS("transitions"),
	KEY_TRANSITION("transition"),
	KEY_TRANSITION_NATURE("nature"),
	KEY_TRANSITION_DURATION("duration"),
	KEY_ACTION("action"),
	KEY_TRANSITION_PTA("PTA"),
	KEY_TRANSITION_GUARD("guard"),
	KEY_TRANSITION_UPDATES("updates"),
	
	KEY_VAR_BOOL_TRUE("True"),
	KEY_VAR_BOOL_FALSE("False"),
	VALUE("\\d+"),
	KEY_VAR_NAME("\\w+"),
	
//	KEY_INVARIANT_CONDITION(""),
	IDK("\""),
	WHITESPACE("\\s+"),
	BRACE_L("\\{"),
	BRACE_R("\\}"),	
	BRACKET_L("\\["),
	BRACKET_R("\\]"),
	AND("&"),
	OR("\\|"),
	EQ("="),
	GEQ(">="),
	LEQ("<="),
	LT("<"),
	GT(">"),
	DEF(":="),
	COLON(":"),
	SEMI(";"),
	COMMA(","),
	MINUS("\\-"),
	PLUS("\\+"),	
	MULT("\\*");
	

    private final Pattern pattern;
    
    Result_Token(String regex) {
        pattern = Pattern.compile("^" + regex);
	
    }
    
    public boolean isUseful() {
    	if (this.name() != "COMMENT" && this.name() != "WHITESPACE" && this.name() != "INIT_INFO" && this.name() != "WHITESPACE" && this.name() != "IDK")
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
