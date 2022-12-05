package PTA;

import java.util.List;

public class Automaton {
	private final String name;
	private final List<Action> actions;
	private final List<Location> locations;
	
	public Automaton(String name, List<Action> actions, List<Location> locations) {
		this.name = name;
		this.actions = actions;
		this.locations = locations;
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
	
}
