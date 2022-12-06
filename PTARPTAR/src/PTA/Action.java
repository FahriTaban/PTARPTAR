package PTA;

import java.util.List;

public class Action {
	private Automaton usedIn;
	private String name;
	private boolean isSynced;
	
	public Action(String name, boolean synced) {
		this.name = name;
		this.isSynced = synced;
	}
	
	public Action(Automaton automaton, String name) {
		this.name = name;
	}
	
	public Action(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isSynced() {
		return isSynced;
	}

	public Automaton getUsedIn() {
		return usedIn;
	}

	public void setUsedIn(Automaton usedIn) {
		this.usedIn = usedIn;
	}
}
