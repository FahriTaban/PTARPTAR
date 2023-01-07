package parse.model;

import java.util.ArrayList;
import java.util.List;

import parse.Element;
import utility.Utility;

public class Model_Lexer {
	private StringBuilder input = new StringBuilder();
    private Model_Token token;
    private List<Element> tokens = new ArrayList<>();
    private String errorMessage = "";
    private boolean done = false;
    
    public Model_Lexer(String filePath) {
        input = new StringBuilder(Utility.readFile(filePath));
    }
    
    public void findTokens() {
    	String lex = "";
    	boolean foundToken = false;
    	for (Model_Token t : Model_Token.values()) {
    		int end = t.endOfMatch(input.toString());
    		
    		if (end != -1) {
    			foundToken = true;
    			token = t;
    			lex = input.substring(0,end);
    			if(token.isUseful()) {
    				if (token.name() == "KEY_LOCATION_ACCESS") {
    					lex = lex.substring(4, lex.length()-1);
    				}
    				if (token.name() == "CONSTRAINT") {
    					lex = lex.replaceAll("\\s+"," ");
    				}
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
    		System.out.println(input);
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

	public Model_Token currentToken() {
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

