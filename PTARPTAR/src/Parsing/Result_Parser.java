package Parsing;
import Utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Result_Parser extends Parser{
	
	
	/**
	 * Returns a list of elements making up a valid run
	 * @param model List of elements to be parsed (make up a model file)
	 * @return List of Elements representing a valid run
	 */
	public List<Element> getValidRun(List<Element> model){
		List<Element> run = new ArrayList<>();
		boolean fetch = false;
		boolean valid = false;
		boolean runJsonFound = false;
		boolean runFound = false;
		int braceCount = 0;
		for (Element e : model) {
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
	 * @param run List of Elements representing a run
	 * @return List of Elements containing parameter constraints.
	 */
	public List<Element> getParameterConstraints(List<Element> run){
		List<Element> constraints = new ArrayList<>();
		boolean fetch = false;
		for (Element e : run) {
			if (e.getType() == "KEY_OTHER_VALUATIONS") {
				fetch = true;
			}
			if (e.getType() == "KEY_RUN_NATURE_VALID") {
				break;
			}
			if (fetch && (e.getType() == "KEY_VAR_NAME" || e.getType() == "VALUE" || e.isComparisonOperator())) {
				constraints.add(e);
			}
		}
		return constraints;
	}
	
	
	/**
	 * Returns a list of states of the run, which are a list of elements themselves.
	 * @param run List of Elements representing a run
	 * @return List of List of Elements, each sublist representing a state.
	 */
	public List<List<Element>> getStates(List<Element> run){
		List<List<Element>> states = new ArrayList<>();
		int fetch = 0;
		int braceCount = 0;
		boolean begin_brace = false;
		List<Element> state = new ArrayList<>();
		for (Element e : run) {
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
	
	/**
	 * Get locations of a state in a run from result file.
	 * @param state List of Elements representing a state
	 * @return List of list of Elements representing locations (made up of tuples <automaton_name,location_name>)
	 */
	public List<List<Element>> getLocations(List<Element> state) {
		List<Element> locations = getSubList(state, "KEY_LOCATION", "BRACE_R");
		return this.getVariableAndValue(locations, "KEY_VAR_NAME");
	}
	
	public Element getDuration(List<Element> transition) {
		Element duration = getValue(transition, "KEY_TRANSITION_DURATION", "VALUE");
		return duration;
	}
	
	
	/**
	 * Given a state (which is a list of elements), return all clock and parameter valuations.
	 * These states contain variable valuations
	 * @param state List of elements representing a state in the result file.
	 * @param discrete If true, return discrete variables (continuous else)
	 * @return Return List of list of Elements representing variable names and their valuation (discrete or continuous)
	 */
	public List<List<Element>> getVariables(List<Element> state, boolean discrete) {
		String begin;
		if (discrete) {
			begin = "KEY_VARS_DISCRETE";
		}
		else {
			begin = "KEY_VARS_CONTINUOUS";
		}
		List<Element> variables = getSubList(state, begin, "BRACE_R");
		return getVariableAndValue(variables, "KEY_VAR_NAME");
	}
	
	/**
	 * Given a valid run (as list of elements), return all outer transitions of that run.
	 * These outer transitions are list of elements with inner runs, guards, updates, etc.
	 * @param tokens List of elements representing run
	 * @return List of List of Elements representing outer transitions (only duration and action used)
	 */
	public List<List<Element>> getOuterTransitions(List<Element> run){
		return getElemLists(run, "KEY_TRANSITION", "KEY_STATE");
	}
	
	public List<List<Element>> getInnerTransitions(List<Element> outerTransitions){
		return getElemLists(outerTransitions, "KEY_TRANSITION" , "KEY_TRANSITION");
	}
	
	public Element getPTA(List<Element> innerTransition) {
		return getValue(innerTransition, "KEY_TRANSITION_PTA", "KEY_VAR_NAME");
	}
	
	public List<List<Element>> getGuards(List<Element> innerTransition){
		List<Element> sub = getSubList(innerTransition, "KEY_TRANSITION_GUARD", "COMMA");
		return getValOpVal(sub);
	}
	
	public List<List<Element>> getUpdates(List<Element> innerTransition){
		List<Element> sub = getSubList(innerTransition, "KEY_TRANSITION_UPDATES", "BRACE_R");
		return getVariableAndValue(sub, "KEY_VAR_NAME");
	}
	
	/**
	 * Return action name used in transition.
	 * @param transition List of elements
	 * @return Element representing action
	 */
	public Element getAction(List<Element> transition){
		return this.getValue(transition, "KEY_ACTION", "KEY_VAR_NAME");
	}
	


}
