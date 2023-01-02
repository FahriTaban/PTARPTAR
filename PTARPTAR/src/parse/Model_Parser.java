package parse;

import java.util.ArrayList;
import java.util.List;

public class Model_Parser extends Parser{

	public List<Element> getClocks(List<Element> model){
		return getVariableNames(model, "KEY_VAR", "KEY_VAR_DECL_CLOCKS");
	}
	
	public List<Element> getParameters(List<Element> model){
		return getVariableNames(model, "KEY_VAR_DECL_CLOCKS", "KEY_VAR_DECL_PARAMETERS");
	}
	
	public List<Element> getInitLocations(List<Element> model){
		List<Element> initBlock = getSubList(model, "KEY_INIT", "BRACE_R");
		List<List<Element>> split = getElemLists(initBlock, "KEY_LOCATION_ACCESS","COMMA",true);
		List<Element> merged = new ArrayList<>();
		for(List<Element> pieces : split) {
			StringBuilder content = new StringBuilder();
			for(Element p : pieces) {
				content.append(p.getContent() + " ");
			}
			String c = content.toString().strip();
			merged.add(new Element("CONSTRAINT", c));
		}
		return merged;
	}
	
	public List<Element> getInitConstraints(List<Element> model){
		List<Element> continuousBlock = getSubList(getSubList(model, "KEY_INIT", "BRACE_R"),"KEY_INIT_CONTINUOUS","SEMI");
		return getConstraints(continuousBlock);
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
	
	public List<Element> getInvariants(List<Element> location){
		List<Element> sublist = getSubList(location, "KEY_INVARIANT", "KEY_LOCATION_WHEN", "KEY_END");
		return getConstraints(sublist);
	}
	
	public List<List<Element>> getTransitions(List<Element> location){
		return getElemLists(location, "KEY_LOCATION_WHEN", "SEMI",true);
	}
	
	public List<Element> getGuards(List<Element> transition){
		List<Element> sublist = getSubList(transition, "KEY_LOCATION_WHEN", "KEY_ACTION", "AND");
		return getConstraints(sublist);
	}
	
	public Element getAction(List<Element> transition) {
		return getVariableNames(transition, "KEY_ACTION", "KEY_LOCATION_GOTO").get(0);
	}
	
	public List<List<Element>> getUpdates(List<Element> transition){
		List<List<Element>> elems = getElemLists(transition, "BRACE_L", "COMMA", "BRACE_R");
		List<List<Element>> ret = new ArrayList<>();
		for(List<Element> es : elems) {
			List<Element> ret_part = new ArrayList<>();
			for(Element e : es) {
				if (!(e.getType() == "DEF")) {
					ret_part.add(e);
				}
			}
			ret.add(ret_part);
		}
		return ret;
	}
	
	public Element getPostLoc(List<Element> transition) {
		return getVariableNames(transition, "KEY_LOCATION_GOTO", "SEMI").get(0);
	}

	
}
