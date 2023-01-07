package run;

import npta.Automaton;
import npta.Location;

public class StateLocation {
	private Automaton automaton;
	private Location location;
	
	public StateLocation(Automaton a, Location l) {
		this.setAutomaton(a);
		this.setLocation(l);
		try {
		if(l == null || a == null) {
			throw new Exception("AUTOMATON IS NULL: " + Boolean.toString(a==null)+
					"; LOCATION IS NULL: " + Boolean.toString(l == null));
		}}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
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
