package Parsing;

import java.util.ArrayList;
import java.util.List;

public class Model_Parser extends Parser{

	public List<Element> getClocks(List<Element> model){
		return getVariableNames(model, "KEY_VAR", "KEY_VAR_DECL_CLOCKS");
	}
	
	public List<Element> getParameters(List<Element> model){
		return getVariableNames(model, "KEY_VAR_DECL_CLOCKS", "KEY_VAR_DECL_PARAMETERS");
	}
	
	public List<List<Element>> getInitLocations(List<Element> model){
		List<Element> initBlock = getSubList(model, "KEY_INIT", "BRACE_R");
		return getElemLists(initBlock, "KEY_LOCATION_ACCESS","COMMA",true);
	}
	
	public List<List<Element>> getInitConstraints(List<Element> model){
		List<Element> continuousBlock = getSubList(getSubList(model, "KEY_INIT", "BRACE_R"),"KEY_INIT_CONTINUOUS","SEMI");
		return getElemLists(continuousBlock, "AND", "AND", "SEMI");
	}
		
	public List<List<Element>> getAutomata(List<Element> model){
		return getElemLists(model, "KEY_AUTOMATON", "KEY_END");
	}
	
	public String getAutomatonName(List<Element> automaton) {
		return automaton.get(0).getContent();
	}
	
	public List<Element> getActions(List<Element> automaton){
		return getVariableNames(automaton, "KEY_ACTIONS", "SEMI");
	}
	
	public List<List<Element>> getLocations(List<Element> automaton){
		return getElemLists(automaton, "KEY_LOCATION", "KEY_LOCATION", "KEY_END");
	}
	
	public List<List<Element>> getInvariants(List<Element> location){
		return getElemLists(location, "KEY_INVARIANT", "KEY_LOCATION_WHEN", "KEY_END");
	}
	
	public List<List<Element>> getTransitions(List<Element> location){
		return getElemLists(location, "KEY_LOCATION_WHEN", "SEMI",true);
	}
	
	public List<List<Element>> getGuards(List<Element> transition){
		return getElemLists(transition, "KEY_LOCATION_WHEN", "KEY_ACTION", "AND");
	}
	
	public Element getAction(List<Element> transition) {
		return getVariableNames(transition, "KEY_ACTION", "KEY_LOCATION_GOTO").get(0);
	}
	
	public List<List<Element>> getUpdates(List<Element> transition){
		return getElemLists(transition, "BRACE_L", "COMMA", "BRACE_R");
	}
	
	public Element getPostLoc(List<Element> transition) {
		return getVariableNames(transition, "KEY_LOCATION_GOTO", "SEMI").get(0);
	}

	
}
