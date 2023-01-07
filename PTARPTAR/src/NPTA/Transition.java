package npta;

import java.util.List;
import org.javatuples.Pair;

import parse.Element;  

/**
 * Transition from State to State
 * @author 49173
 *
 */
public class Transition {
	private String preloc;
	private List<Constraint> guards;
	private String action;
	private List<Update> updateRules;
	private String postloc;
	
	public Transition(String pre, String action, String post,List<Update> updateRules, List<Constraint> gs) {
		this.preloc = pre;
		this.action = action;
		this.postloc = post;
		this.guards = List.copyOf(gs);
		this.updateRules = updateRules;
		
	}

	public String getPrestate() {
		return preloc;
	}

	public String getPoststate() {
		if (postloc == null) {
			System.out.println("No poststate found");
		}
		return postloc;
	}

	public List<Constraint> getGuards() {
		return guards;
	}
	
	public List<Update> getUpdateRules() {
		return updateRules;
	}
	
	public Update getClockUpdate(Clock c) {
		for(Update u : this.updateRules) {
			if (u.updatesClock(c)) {
				return u;
			}
		}
		return null;
	}
	
	public void removeUpdate(Update u) {
		this.updateRules.remove(u);
	}
	
	public void addUpdate(Update u) {
		this.updateRules.add(u);
	}
	
	public String getAction() {
		return this.action;
	}

	public void setUpdateRule(List<Update> updateRules) {
		this.updateRules = updateRules;
	}
	
	public void printInfo() {
		System.out.println("Transition");
		StringBuilder trans = new StringBuilder();
		trans.append(this.preloc);
		for(Constraint g : this.guards) {
			trans.append("," + g.toModelString());
		}
		trans.append("---" + this.action + "---> " );
		for(Update u : this.updateRules) {
			trans.append(u.updateToString()+ ",");
		}
		trans.append(" " + this.postloc);
		System.out.println(trans.toString());
		
	}
	
	public String transitionToString() {
		StringBuilder guards = new StringBuilder();
		StringBuilder updates = new StringBuilder();
		for(Constraint g : this.guards) {
			guards.append("{" + g.toModelString() + "},");
		}
		for(Update u : this.updateRules) {
			updates.append("{" + u.getVariable() + " := " + u.getSetToValue() + "},");
		}
		return preloc + "," + guards.toString() + action + "," + updates.toString() + postloc;
	}
	
	/**
	 * Checks if a transition is semantically equal to a set of arguments representing a transition
	 * @param preloc
	 * @param guard_elems
	 * @param action
	 * @param update_elems
	 * @param postloc
	 * @return
	 */
	public boolean transitionEquals(String preloc, List<Element> guard_elems
			, String action, List<Element> update_elems, String postloc) {
		boolean prel = false, a = false, ub = false,gb = false, postl = false;
		int countGuard = 0;
		int countUpdate = 0;
		prel = this.preloc.equals(preloc);
		a = this.action.equals(action);
		postl = this.postloc.equals(postloc);
		for(Element guard_elem : guard_elems) {
			for(Constraint g : this.guards) {
				if(g.constraintEquals(guard_elem)) {
					countGuard++;
					break;
				}
			}
		}
		for(Element update_elem : update_elems) {
			for(Update update : this.updateRules) {
				if(update.updateEquals(update_elem)) {
					countUpdate++;
				}
			}
		}
		gb = countGuard == this.guards.size();
		ub = countUpdate == this.updateRules.size();
		if (!(prel && a && postl && gb && ub)) {
		System.out.println(this.transitionToString());
		}
		return prel && a && postl && gb && ub;
	}
}
