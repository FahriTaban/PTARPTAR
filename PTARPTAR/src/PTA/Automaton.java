package PTA;

import java.util.List;

public class Automaton {
	private String name;
	private List<Action> actions;
	private List<Location> locations;
	
	public Automaton(String name, List<Action> actions, List<Location> locations) {
		this.name = name;
		this.actions = actions;
		this.locations = locations;
	}
	
	public Automaton(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Action> getActions() {
		return actions;
	}

	public List<Location> getLocations() {
		return locations;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
