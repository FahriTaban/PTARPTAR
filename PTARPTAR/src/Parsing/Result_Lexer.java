package Parsing;
import Utility.Utility;
import java.util.ArrayList;
import java.util.List;

public class Result_Lexer {
	private StringBuilder input = new StringBuilder();
    private Result_Token token;
    private List<Element> tokens = new ArrayList<>();
    private String errorMessage = "";
    private boolean done = false;
    // to prevent wrong pattern matching (INIT_INFO and STATISTICS_INFO)
    private boolean info_done = false; 
    public Result_Lexer(String filePath) {
        input = Utility.readFile(filePath);
    }
    
    public void findTokens() {
    	String lex = "";
    	boolean foundToken = false;
    	for (Result_Token t : Result_Token.values()) {
    		if (info_done && t.name() == "INIT_INFO") {
    			continue;
    		}
    		int end = t.endOfMatch(input.toString());
    		
    		if (end != -1) {
    			if (t.name() == "INIT_INFO") {
    				info_done = true;
    			}
    			foundToken = true;
    			token = t;
    			lex = input.substring(0,end);
    			if(token.isUseful()) {
    				Element elem = new Element(token.name(),lex);
    				tokens.add(elem);
    			}
    			input.delete(0, end);
    		}
    	}
    	if (input.length()>0 && foundToken) {
    		findTokens();
    	}
    	else {
    		System.out.println("**************************\n Missing pattern: \n" + input);
    	}
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

