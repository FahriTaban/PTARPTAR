package parse.Property;

import java.util.ArrayList;
import java.util.List;

import parse.Element;
import utility.Utility;

public class Prop_Lexer {
	private StringBuilder input = new StringBuilder();
    private Prop_Token token;
    private List<Element> tokens = new ArrayList<>();
    private String errorMessage = "";
    private boolean done = false;
    
    public Prop_Lexer(String filePath) {
        input = Utility.readFile(filePath);
    }
    
    public void findTokens() {
    	String lex = "";
    	boolean foundToken = false;
    	for (Prop_Token t : Prop_Token.values()) {
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
    		System.out.println("**************************\n Missing pattern: \n" + input);
    	}
    }

	public Prop_Token currentToken() {
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
