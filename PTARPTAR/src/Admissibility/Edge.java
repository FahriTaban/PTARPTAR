package Admissibility;

import java.util.HashMap;

public class Edge{
	private String action;
	private Vertex post;
	
	public Edge(String action, Vertex post) {
		this.action = action;
		this.post = post;
	}

	public Vertex getPost() {
		return post;
	}

	public void setPost(Vertex post) {
		this.post = post;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}