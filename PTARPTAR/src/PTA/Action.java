package PTA;

import java.util.List;

public class Action {
	private final String name;
	private final boolean isSynced;
	
	public Action(String name, boolean synced) {
		this.name = name;
		this.isSynced = synced;
	}
	public String getName() {
		return name;
	}
	
	public boolean isSynced() {
		return isSynced;
	}
}
