package PTA;

import java.util.List;
import org.javatuples.Pair;  

/**
 * Transition from State to State
 * @author 49173
 *
 */
public class Transition {
	private String prestate;
	private List<Constraint> guards;
	private String action;
	private List<Update> updateRules;
	private String poststate;
	
	public Transition(String pre, String action, String post,List<Update> updateRules, List<Constraint> gs) {
		this.prestate = pre;
		this.action = action;
		this.poststate = post;
		this.guards = List.copyOf(gs);
		this.updateRules = updateRules;
		
	}

	public String getPrestate() {
		return prestate;
	}

	public String getPoststate() {
		return poststate;
	}

	public List<Constraint> getGuards() {
		return guards;
	}
	
	public List<Update> getUpdateRule() {
		return updateRules;
	}
	
	public String getAction() {
		return this.action;
	}

	public void setUpdateRule(List<Update> updateRules) {
		this.updateRules = updateRules;
	}
}
