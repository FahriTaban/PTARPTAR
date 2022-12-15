package ConstraintSystem;

import NPTA.*;
import java.util.*;

public class SMT2Clock {
	private Clock clock;
	private List<String> clones;
	private List<String> constraints;
	private List<String> updates;
	private List<String> variationVariables;
	
	public SMT2Clock(Clock c, List<String> aliases, List<String> constraints, List<String> varVariables) {
		this.clock = c;
		this.clones = List.copyOf(aliases);
		this.constraints = List.copyOf(constraints);
		this.variationVariables = List.copyOf(varVariables);
	}
	
	public SMT2Clock(Clock c, List<String> aliases){
		this.clock = c;
		this.clones = List.copyOf(aliases);
	}
	
	public List<String> getVariationVariables() {
		return variationVariables;
	}
	public void setVariationVariables(List<String> variationVariables) {
		this.variationVariables = List.copyOf(variationVariables);
	}
	public List<String> getClones() {
		return clones;
	}
	public void setClones(List<String> clones) {
		this.clones = List.copyOf(clones);
	}
	public Clock getClock() {
		return clock;
	}

	public List<String> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<String> constraints) {
		this.constraints = List.copyOf(constraints);
	}

	public List<String> getUpdates() {
		return updates;
	}

	public void setUpdates(List<String> updates) {
		this.updates = updates;
	}
	
	
	
}