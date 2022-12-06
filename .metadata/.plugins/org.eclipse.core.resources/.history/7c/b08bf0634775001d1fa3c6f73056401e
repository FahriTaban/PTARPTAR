package Parsing;
import Utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Result_Parser extends Parser{
	
	
	/**
	 * Returns a list of elements making up a valid run
	 * @param tokens List of elements to be parsed
	 * @return
	 */
	public List<Element> getValidRun(List<Element> tokens){
		List<Element> run = new ArrayList<>();
		boolean fetch = false;
		boolean valid = false;
		boolean runJsonFound = false;
		boolean runFound = false;
		int braceCount = 0;
		for (Element e : tokens) {
			// find new Run Nr declaring new Run
			if (e.getType() == "KEY_RUN_NR") {
				fetch = true;
			}
			// we only care about valid runs
			if (e.getType() == "KEY_RUN_NATURE_VALID") {
				valid = true;
			}
			// mark beginning of JSON string describing run
			if (e.getType() == "KEY_RUN") {
				runFound = true;
			}
			
			if (e.getType() == "BRACE_L") {
				if (braceCount == 0 && runFound) {
					runJsonFound = true;
				}
				braceCount++;
			}
			if (e.getType() == "BRACE_R") {
				braceCount--;
			}
			if (fetch) {
				run.add(e);
			}
			// if JSON string is fully parsed and the run is valid -> return; else empty list and start anew
			if (braceCount == 0) {
				if (runJsonFound) {
					if (valid) {
						return run;
					} else {
						run.removeAll(run);
						fetch = false;
						runJsonFound = false;
					}
				}
			}
		}
		return run;
	}
	
	
	/**
	 * Returns other parameter valuations with the same run (as a list of elements)
	 * @param tokens List of elements to be parsed
	 * @return
	 */
	public List<Element> getParameterConstraints(List<Element> tokens){
		List<Element> constraints = new ArrayList<>();
		boolean fetch = false;
		for (Element e : tokens) {
			if (e.getType() == "KEY_OTHER_VALUATIONS") {
				fetch = true;
			}
			if (e.getType() == "KEY_RUN_NATURE_VALID") {
				break;
			}
			if (fetch) {
				constraints.add(e);
			}
		}
		return constraints;
	}
	
	
	/**
	 * Returns a list of states of the run, which are a list of elements themselves.
	 * @param tokens
	 * @return
	 */
	public List<List<Element>> getStates(List<Element> tokens){
		List<List<Element>> states = new ArrayList<>();
		int fetch = 0;
		int braceCount = 0;
		boolean begin_brace = false;
		List<Element> state = new ArrayList<>();
		for (Element e : tokens) {
			if (fetch == 2) {
				state.add(e);
				if (e.getType() == "BRACE_L") {
					braceCount++;
					begin_brace = true;
				}
				if (e.getType() == "BRACE_R") {
					braceCount--;
				}
				if (braceCount == 0 && begin_brace) {
					fetch--;
					states.add(List.copyOf(state));
					state.clear();
					begin_brace = false;
				}
			}
			if (e.getType() == "KEY_STEPS") {
				fetch++;
			}
			if (e.getType() == "KEY_STATE") {
				fetch++;
			}
				
		}
		return states;
	}
	
	
	public List<List<Element>> getLocations(List<Element> state) {
		List<Element> locations = new ArrayList<>();
		for(Element e : state) {
			if (e.getType() == "BRACE_R") {
				break;
			}
			locations.add(e);
		}
		return this.getVariableAndValue(locations, "KEY_VAR_NAME", "KEY_VAR_NAME");
	}
	
	public Element getDuration(List<Element> transition) {
		return this.getValue(transition, "KEY_DURATION", "VALUE");
	}
	
	
	/**
	 * Given a state (which is a list of elements), return all clock and parameter valuations.
	 * These states contain variable valuations
	 * @param state
	 * @return
	 */
	public List<List<Element>> getVariables(List<Element> state) {
		List<List<Element>> variables = new ArrayList<>();
		boolean fetch = false;
		int fetched = 0;
		int complete = 0;
		int braceCount = 0;
		boolean braceClosed = false;
		List<Element> variable = new ArrayList<>();
		for (Element e : state) {
			if (fetch && e.getType() == "BRACE_L") {
				braceCount++;
				braceClosed = false;
			}
			if (fetch && e.getType() == "BRACE_R") {
				braceCount--;
				braceClosed = true;
				fetch = false;
			}
			if (e.getType() == "KEY_VARS") {
				fetch = true;
			}
			if (fetch && e.getType() == "KEY_VAR_NAME" && e.getContent() != "global_time") {
				variable.add(e);
				fetched++;
			}
			if (fetched == 2) {
				variables.add(List.copyOf(variable));
				variable.clear();
				fetched = 0;	
				}
			if (braceCount == 0 && braceClosed) {
				if (complete < 2) {
					complete++;
				}
				else {
					return variables;
				}
			}
		}
		return variables;
	}
	
	/**
	 * Given a valid run (as list of elements), return all outer transitions of that run.
	 * These outer transitions are list of elements with inner runs, guards, updates, etc.
	 * @param tokens
	 * @return
	 */
	public List<List<Element>> getOuterTransitions(List<Element> run){
		List<List<Element>> transitions = new ArrayList<>();
		int fetch = 0;
		boolean got_duration = false;
		boolean got_action = false;
		List<Element> transition = new ArrayList<>();
		for (Element e : run) {
			if (fetch == 2) {
				if (e.getType() == "KEY_TRANSITION_DURATION") {
					got_duration = true;
					}
				if (e.getType() == "KEY_ACTION") {
					got_action = true;
				}
				if ((got_duration && e.getType() == "VALUE") || (got_action && e.getType() == "KEY_VAR_NAME")) {
					transition.add(e);
				}
				if (e.getType() == "COMMA" && got_duration && got_action) {
					fetch--;
					transitions.add(List.copyOf(transition));
					transition.clear();
					got_duration = false;
					got_action = false;
				}
			}
			if (e.getType() == "KEY_STEPS") {
				fetch++;
			}
			if (e.getType() == "KEY_TRANSITION" && fetch < 2) {
				fetch++;
			}
				
		}
		return transitions;
	}
	


}
