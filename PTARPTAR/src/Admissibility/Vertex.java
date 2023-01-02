package admissibility;

import java.util.*;

public class Vertex {
	private String name;
	private HashMap<String,Vertex> transitions = new HashMap<>();
	private boolean first = false;
	
	public Vertex(String name){
		this.setName(name);
	}
	
	public List<Vertex> findNeighbors(){
		List<Vertex> neighbors = new ArrayList<>();
		for(String action : transitions.keySet()) {
			neighbors.add(transitions.get(action));
		}
		return neighbors;
	}
	
	public void printInfo() {
		for(String action : transitions.keySet()) {
			String poststate = transitions.get(action).getName();
			System.out.println(this.name + "---- " + action + " ----> " + poststate);
		}
	}
	
	public Vertex traverseEdge(String action) {
		return transitions.get(action);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String,Vertex> getTransitions() {
		return transitions;
	}

	public void addTransition(String s, Vertex v) {
		this.transitions.put(s, v);
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

}

