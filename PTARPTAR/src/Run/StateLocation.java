package Run;

import NPTA.Automaton;
import NPTA.Location;

public class StateLocation {
	private Automaton automaton;
	private Location location;
	
	public StateLocation(Automaton a, Location l) {
		this.setAutomaton(a);
		this.setLocation(l);
	}

	public Automaton getAutomaton() {
		return automaton;
	}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void printInfo() {
		System.out.println("STATE-LOCATION");
		this.automaton.printInfo();
		this.location.printInfo();
	}
}
