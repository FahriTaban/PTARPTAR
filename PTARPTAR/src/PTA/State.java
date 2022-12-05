package PTA;

import java.util.List;

/**
 * Representing a state in a network PTA
 * @author 49173
 *
 */
public class State {
	private final List<Clock> clocks;
	private final List<Location> locations;
	private int duration;
	private boolean urgent;
	
	public State(List<Clock> clockList, List<Location> locs, boolean urg) {
		this.clocks = List.copyOf(clockList);
		this.locations  = List.copyOf(locs);
		this.urgent = urg;
	}

	public List<Clock> getClocks() {
		return clocks;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isUrgent() {
		return urgent;
	}

}
