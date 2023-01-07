package parse.result;
import java.util.ArrayList;
import java.util.List;

import parse.Element;
import parse.Parser;
import utility.Utility;

public class Result_Parser extends Parser{
	
	
	/**
	 * Returns a list of elements making up a valid run
	 * @param model List of elements to be parsed (make up a model file)
	 * @return List of Elements representing a valid run
	 */
	public List<Element> getValidRun(List<Element> model){
		List<Element> run = this.getSubList(model, "KEY_RUN_NATURE_VALID", "KEY_RUN_NR");
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
			if (fetch && e.getType() == "CONSTRAINT") {
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
		List<Element> state = new ArrayList<>();
		boolean fetch = false;
		for(Element e: run) {
			if(e.getType().equals("KEY_STATE") && !fetch) {
				fetch = true;
			} 
			if (e.getType().equals("KEY_TRANSITION") && fetch) {
				fetch = false;
				states.add(List.copyOf(state));
				state.clear();
			} 
			else if (fetch) {
				state.add(e);
			}
		}
		if(!state.isEmpty()) {
			states.add(List.copyOf(state));
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
	 * Given a state (which is a list of elements), return all clock   parameter valuations.
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
	
	public List<Element> getGuards(List<Element> innerTransition){
		List<Element> sub = getSubList(innerTransition, "KEY_TRANSITION_GUARD", "COMMA");
		return getConstraints(sub);
	}
	
	public List<Element> getUpdates(List<Element> innerTransition){
		List<Element> sub = getSubList(innerTransition, "KEY_TRANSITION_UPDATES", "BRACE_R");
		List<Element> ups = new ArrayList<>();
		for(Element e : sub) {
			if (e.getType().equals("KEY_VAR_NAME")) {
				ups.add(e);
			}
		}
		return ups;
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
