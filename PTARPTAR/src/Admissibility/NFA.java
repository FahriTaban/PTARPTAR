package Admissibility;

import java.util.HashSet;

public class NFA {
	private HashSet<Vertex> vertices;
	private HashSet<String> words = new HashSet<>();
	private HashSet<Vertex> visited = new HashSet<>();
	
	public NFA(HashSet<Vertex> vertices) {
		this.setVertices(vertices);
	}
	
	public void genLanguage() {
		words.clear();
		visited.clear();
		Vertex v = findFirst();
		DFS(v,"");
	}
	
	public void DFS(Vertex v, String word) {
		words.add(word);
		if (visited.contains(v)) {
			return;
		}
		visited.add(v);
		for(String action : v.getTransitions().keySet()) {
			word += ":" + action;
			Vertex post = v.getTransitions().get(action);
			DFS(post,word);
		}
	}

	public HashSet<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(HashSet<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public Vertex findFirst() {
		for(Vertex v : this.vertices) {
			if (v.isFirst()) {
				return v;
			}
		}
		return null;
	}
	
}