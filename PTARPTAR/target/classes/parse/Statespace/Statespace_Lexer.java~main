package parse.Statespace;
import java.util.ArrayList;
import java.util.List;

import parse.Element;
import utility.Utility;
public class Statespace_Lexer {

	private StringBuilder input = new StringBuilder();
	    private Statespace_Token token;
	    private List<Element> tokens = new ArrayList<>();
	    private String errorMessage = "";
	    private boolean done = false;
	    private boolean begin = false; 
	    public Statespace_Lexer(String filePath) {
	        input = Utility.readFile(filePath);
	    }
	    
	    public void findTokens() {
	    	String lex = "";
	    	boolean foundToken = false;
	    	for (Statespace_Token t : Statespace_Token.values()) {
	    		int end = t.endOfMatch(input.toString());
	    		
	    		if (end != -1) {
	    			if (t.name() == "KEY_TRANSITIONS_DESCRIPTION") {
	    				begin = true;
	    			}
	    			foundToken = true;
	    			token = t;
	    			lex = input.substring(0,end);
	    			if(begin && token.isUseful()) {
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
	    
//	    public boolean isStringFaulty(String s) {
//	    	if (s.contains("\\(")) {
//	    		if(!s.contains("\\)")) {
//	    			return true;
//	    		}
//	    	}
//	    	else if (s.contains("\\)")) {
//	    		if(!s.contains("\\(")) {
//	    			return true;
//	    		}
//	    	}
//	    	return false;
//	    }

		public Statespace_Token currentToken() {
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

