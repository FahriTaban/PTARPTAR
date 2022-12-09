package PTAToModel;
import Utility.*;

import java.util.List;

import PTA.*;

public class ConvertPTAToModel {
	
	
	/**
	 * Takes a NetworkPTA and a file path and creates a new text-file representing an IMI-file of an IMITATOR-PTA model.
	 * @param npta
	 * @param filePath
	 */
	public void nptaToModel(NetworkPTA npta, String filePath) {
		String model;
		String vars = declareVariables(npta.getClocks(),npta.getParameter());
		String automata = "";
		for(Automaton a : npta.getAutomata()) {
			automata += declareAutomaton(a) + "\n\n";
		}
		String initBlock = declareInit(npta.getInitial_Locations(), npta.getInitial_Constraints());
		model = vars + "\n\n" + automata + initBlock;
		String fp = Utility.createFile(filePath);
		Utility.writeToFile(fp, model);
	}
	
	/**
	 * Returns a string representing the initialization block at the bottom of the imi-file.
	 * @param initLocs
	 * @param initCons
	 * @return
	 */
	public String declareInit(List<Constraint> initLocs, List<Constraint> initCons) {
		String decl = "init := \\{\n\n";
		String initLoc = declareInitLocs(initLocs);
		String initCon = declareInitCons(initCons);
		decl += initLoc + "\n\n" + initCon + "\n\\}";
		return decl;
	}
	
	/**
	 * Returns a string representing the discrete part of the initialization block, where
	 * the initial locations are declared.
	 * @param locs
	 * @return
	 */
	public String declareInitLocs(List<Constraint> locs) {
		String decl = "discrete = \n";
		for(Constraint loc : locs) {
			decl += "loc\\[" + loc.getValue1().getName() + "\\] " + loc.getOperator() + " " + loc.getValue2() + ",\n";
		}
		decl += ";";
		return decl;
	}
	
	/**
	 * Returns a string representing the continuous part of the initialization block, where
	 * the constraints on parameters and clocks are declared.
	 * @param cons
	 * @return
	 */
	public String declareInitCons(List<Constraint> cons) {
		String decl = "continuous = \n";
		for(Constraint con : cons) {
			decl += "& " + con.getValue1().getName() + " " + con.getOperator() + " " + con.getValue2() + "\n";
		}
		decl += ";";
		return decl;
	}
	
	/**
	 * Returns a string representing the part of the imi-file, where the variables are declared.
	 * @param clocks
	 * @param parameters
	 * @return
	 */
	public String declareVariables(List<Clock> clocks, List<Parameter> parameters) {
		String decl = "var \n";
		for(Clock c : clocks) {
			decl += c.getName()+",";
		}
		decl += ": clock;\n";
		for(Parameter p : parameters) {
			decl += p.getName();
		}
		decl += ": parameter;";
		return decl;
	}
	
	/**
	 * Returns a string representing an automaton of a NetworkPTA
	 * @param a
	 * @return
	 */
	public String declareAutomaton(Automaton a) {
		String decl = "automaton " +a.getName() + "\n\n";
		// get actions
		decl += declareActions(a) + "\n\n";
		// get locations
		for(Location loc : a.getLocations()) {
			decl += declareLocation(loc) + "\n";
		}
		// declare end
		decl += "end";
		return decl;
	}
	
	/**
	 * Returns a string consisting of actions of an automaton
	 * @param a
	 * @return
	 */
	public String declareActions(Automaton a) {
		String decl = "synclabs: ";
		for(Action act : a.getActions()) {
			decl += act.getName() + ",";
		}
		decl = decl.substring(0, decl.length()-1) + ";";
		return decl;
	}
	
	/**
	 * Returns a string representing a location of an automaton
	 * @param loc
	 * @return
	 */
	public String declareLocation(Location loc) {
		String decl = "loc " + loc.getName() + ": invariant ";
		String invariant = declareConstraints(loc.getInvariants());
		String transitions = "";
		for(Transition t : loc.getTransitions()) {
			String transition = declareTransition(t);
			transitions += transition + "\n";
		}
		decl = decl + invariant + "\n" + transitions;
		return decl;
	}
	
	/**
	 * Returns a string representing a transition of an automaton
	 * @param t
	 * @return
	 */
	public String declareTransition(Transition t) {
		String decl = "when " + declareConstraints(t.getGuards()) + " sync " + t.getAction();
		String end;
		if (!t.getUpdateRule().isEmpty()) {
			end = " do " + declareUpdate(t) + " goto " + t.getPoststate() + ";";
		} else {
			end = " goto " + t.getPoststate() + ";";
		}
		return decl;
	}
	
	/**
	 * Returns a string representing a constraint on a variable, e.g. a clock or an inital location
	 * @param cons
	 * @return
	 */
	public String declareConstraints(List<Constraint> cons) {
		String decl = "";
		for(Constraint con : cons) {
			if (con.getValue2().getName() == "") {
				decl += con.getValue1().getName() + " & ";
			} else {
				decl += con.getValue1().getName() + " " + con.getOperator() + " " + con.getValue2().getName() + " & ";
			}
		}
		decl = decl.substring(0,decl.length()-2);
		return decl;
	}
	
	/**
	 * Returns a string representing the update rules of a transition
	 * @param t
	 * @return
	 */
	public String declareUpdate(Transition t) {
		String decl = "\\{";
		for(Update u : t.getUpdateRule()) {
			decl += u.getVariable() + " := " + u.getSetToValue()+",";
		}
		decl = decl.substring(0,decl.length()-1) + "\\}";
		return decl;
	}
	
}
