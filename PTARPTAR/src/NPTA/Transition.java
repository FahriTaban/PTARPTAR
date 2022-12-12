package NPTA;

import java.util.List;
import org.javatuples.Pair;

import Parsing.Element;  

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
	
	public List<Update> getUpdateRule() {
		return updateRules;
	}
	
	public String getAction() {
		return this.action;
	}

	public void setUpdateRule(List<Update> updateRules) {
		this.updateRules = updateRules;
	}
	
	public void printInfo() {
		System.out.println("Transition");
		System.out.println("Prestate " + this.preloc);
		for(Constraint g : this.guards) {
			g.printInfo();
		}
		System.out.println("Action " + this.action);
		System.out.println("Update Rules:");
		for(Update u : this.updateRules) {
			u.printInfo();
		}
		System.out.println("Poststate " + this.postloc);
		
	}
	
	public String transitionToString() {
		StringBuilder guards = new StringBuilder();
		StringBuilder updates = new StringBuilder();
		for(Constraint g : this.guards) {
			guards.append("{" + g.constraintToString() + "},");
		}
		for(Update u : this.updateRules) {
			updates.append("{" + u.getVariable() + " := " + u.getSetToValue() + "},");
		}
		return preloc + "," + guards.toString() + action + "," + updates.toString() + postloc;
	}
	
	/**
	 * Checks if a transition is semantically equal to a set of arguments representing a transition
	 * @param preloc
	 * @param guards
	 * @param action
	 * @param updates
	 * @param postloc
	 * @return
	 */
	public boolean transitionEquals(String preloc, List<List<Element>> guards
			, String action, List<List<Element>> updates, String postloc) {
		boolean prel = false, a = false, ub = false,gb = false, postl = false;
		int countGuard = 0;
		int countUpdate = 0;
		if(this.preloc.equals(preloc)) {
			prel = true;
		}
		if(this.action.equals(action)) {
			a = true;
		}
		if(this.postloc.equals(postloc)) {
			postl = true;
		}
		for(List<Element> ge : guards) {
			for(Constraint g : this.guards) {
				if(g.constraintEquals(ge)) {
					countGuard++;
				}
			}
		}
		for(List<Element> upd : updates) {
			for(Update update : this.updateRules) {
				if(update.updateEquals(upd)) {
					countUpdate++;
				}
			}
		}
		gb = (countGuard == guards.size());
		ub = (countUpdate == updates.size());
		if (!(prel && a && postl && gb && ub)) {
		System.out.print(prel);
		System.out.print(gb);
		System.out.print(a);
		System.out.print(ub);
		System.out.print(postl);
		}
		return prel && a && postl && gb && ub;
	}
}
