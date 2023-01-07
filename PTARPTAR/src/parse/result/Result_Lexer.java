package parse.result;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import parse.Element;
import utility.Utility;

public class Result_Lexer {
	private StringBuilder input;
    private Result_Token token;
    private int runNr;
    private List<Element> tokens = new ArrayList<>();
    private String errorMessage = "";
    private boolean done = false;
    // to prevent wrong pattern matching (INIT_INFO and STATISTICS_INFO)
    private boolean info_done = false; 
    public Result_Lexer(String filePath) {
        input = new StringBuilder(Utility.readFile(filePath));
    }
    
    public void findTokens() {
    	boolean foundToken = true;
    	while (foundToken) {
    		foundToken = findTokensHelper();
    	}
    }
    
    public boolean findTokensHelper() {
    	boolean foundToken = false;
    	String lex = "";
    	for (Result_Token t : Result_Token.values()) {
    		if (info_done && t.name().equals("INIT_INFO")) {
    			continue;
    		}
    		int end = t.endOfMatch(input.toString());
    		
    		if (end != -1) {
    			if (t.name().equals("INIT_INFO")) {
    				info_done = true;
    			}
    			foundToken = true;
    			token = t;
    			lex = input.substring(0,end);
    			if(t.name().equals("KEY_RUN_NR")) {
    				runNr++;
    				System.out.println(runNr);
    				if(runNr == 2) {
    					return false;
    				}
    			}
    			if(token.isUseful()) {
    				Element elem = new Element(token.name(),lex);
    				tokens.add(elem);
    			}
    			input.delete(0, end);
//    			System.out.println(lex);
    		}
    	}
    	return foundToken;
    }
    
//    public boolean isStringFaulty(String s) {
//    	if (s.contains("\\(")) {
//    		if(!s.contains("\\)")) {
//    			return true;
//    		}
//    	}
//    	else if (s.contains("\\)")) {
//    		if(!s.contains("\\(")) {
//    			return true;
//    		}
//    	}
//    	return false;
//    }

	public Result_Token currentToken() {
        return token;
    }

    public List<Element> getTokens() {
        return tokens;
    }

    public boolean isSuccessful() {
        return errorMessage.isEmpty();
    }

    public String errorMessage() {
        return errorMessage;
    }

    public boolean isDone() {
        return done;
    }
	}

