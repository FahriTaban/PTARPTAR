package SSToNFA;

import java.util.*;


import Admissibility.NFA;
import Admissibility.Vertex;
import Parsing.Element;
import Parsing.Statespace.*;

public class ConvertSSToNFA {
	static Statespace_Parser parser = new Statespace_Parser();
	
	public static NFA createNFA(String filePath) {
		Statespace_Lexer lex = new Statespace_Lexer(filePath);
		lex.findTokens();
		List<Element> elems = lex.getTokens();
		List<List<Element>> transitions = parser.getTransitions(elems);
		HashSet<String> states = parser.getStates(transitions);
		HashSet<Vertex> vertices = createVertices(states);
		addTransitions(vertices,transitions);
		NFA nfa = new NFA(vertices);
		return nfa;
	}
	
	public static HashSet<Vertex> createVertices(HashSet<String> states){
		HashSet<Vertex> vertices = new HashSet<>();
		for(String name : states) {
			Vertex v = new Vertex(name);
			vertices.add(v);
		}
		return vertices;
	}
	
	public static void addTransitions(HashSet <Vertex> vs, List<List<Element>> transitions) {
		boolean first = true;
		for(List<Element> transition : transitions) {
			String pre = parser.getPrestate(transition);
			String action = parser.getAction(transition);
			String post = parser.getPoststate(transition);
			for(Vertex v : vs) {
				if(v.getName().equals(pre)){
					if(first) {
						v.setFirst(true);
						first = false;
					}
					Vertex postv = findVertex(post,vs);
					v.addTransition(action, postv);
					break;
				}
			}
		}
	}
	
	public static Vertex findVertex(String name, HashSet<Vertex> vs) {
		for(Vertex v : vs) {
			if (v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	
	
}
