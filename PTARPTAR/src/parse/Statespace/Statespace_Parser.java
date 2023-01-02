package parse.Statespace;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import parse.Element;
import parse.Parser;

public class Statespace_Parser extends Parser{
	
	public List<List<Element>> getTransitions(List<Element> elems){
		List<List<Element>> transitions = new ArrayList<>();
		List<Element> transition = new ArrayList<>();
		for(Element e : elems) {
			transition.add(e);
			if(transition.size() == 5) {
				transitions.add(List.copyOf(transition));
				transition.clear();
			}
		}
		return transitions;
	}
	
	public HashSet<String> getStates(List<List<Element>> transitions){
		HashSet<String> states = new HashSet<>();
		for(List<Element> transition : transitions) {
			states.add(getPrestate(transition));
			states.add(getPoststate(transition));
		}
		return states;
	}
	
	public String getPrestate(List<Element> transition) {
		return transition.get(0).getContent();
	}
	
	public String getPoststate(List<Element> transition) {
		return transition.get(2).getContent();
	}
	
	public String getAction(List<Element> transition) {
		return transition.get(4).getContent();
	}


}
