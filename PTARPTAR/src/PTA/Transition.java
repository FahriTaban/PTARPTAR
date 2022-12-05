package PTA;

import java.util.List;
import org.javatuples.Pair;  

/**
 * Transition from State to State
 * @author 49173
 *
 */
public class Transition {
	private Location prestate;
	private List<Constraint> guards;
	private Action action;
	private Update updateRule;
	private Location poststate;
	
	public Transition(Location pre, Location post,Update updateRule, List<Constraint> gs, Action a) {
		this.prestate = pre;
		this.poststate = post;
		this.guards = List.copyOf(gs);
		this.action = a;
		
	}

	public Location getPrestate() {
		return prestate;
	}

	public Location getPoststate() {
		return poststate;
	}

	public List<Constraint> getGuards() {
		return guards;
	}

	public Action getAction() {
		return action;
	}

	public Update getUpdateRule() {
		return updateRule;
	}

	public void setUpdateRule(Update updateRule) {
		this.updateRule = updateRule;
	}
}
