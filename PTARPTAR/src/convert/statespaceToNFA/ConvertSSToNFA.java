package convert.statespaceToNFA;

import java.util.*;

import admissibility.NFA;
import admissibility.Vertex;
import parse.Element;
import parse.Statespace.*;

public class ConvertSSToNFA {
	static Statespace_Parser parser = new Statespace_Parser();
	static HashMap<String,String> action_aliases = new HashMap<>();
	
	public static NFA createNFA(String filePath) {
		Statespace_Lexer lex = new Statespace_Lexer(filePath);
		lex.findTokens();
		List<Element> elems = lex.getTokens();
		List<List<Element>> transitions = parser.getTransitions(elems);
		if(action_aliases.isEmpty()) {
			System.out.println("Creating action aliases");
			createActionAliases(transitions);
		}
		HashSet<String> states = parser.getStates(transitions);
		HashSet<Vertex> vertices = createVertices(states);
		addTransitions(vertices,transitions);
		NFA nfa = new NFA(vertices);
		return nfa;
	}
	
	public static String renameTrace(List<String> trace) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < trace.size(); i++) {
			String alias = action_aliases.get(trace.get(i));
			sb.append(alias);
		}
		return sb.toString();
	}
	
	public static void createActionAliases(List<List<Element>> transitions) {
		int i = 0;
		for(List<Element> transition : transitions) {
			String t = parser.getAction(transition);
			String alias = "a"+Integer.toString(i);
			if(!action_aliases.containsKey(t)) {
				action_aliases.put(t, alias);
				i++;
			}
		}
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
			String action = action_aliases.get(parser.getAction(transition));
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