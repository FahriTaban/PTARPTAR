package npta;

import java.util.ArrayList;
import java.util.List;

import convert.modelToNPTA.ConvertModelToNPTA;
import parse.Element;
import parse.model.Model_Lexer;
import parse.model.Model_Parser;
import repair.tdtcs.ToSMT2;
import utility.UnitTest;
public class UnitTestNPTA extends UnitTest{

	public static void main(String[] args) {
		
//		Constraint c = new Constraint("x >= ABC * DEF");
//		c.printInfo();
//		c.backUp();
//		c.setOperator("<=");
//		c.printInfo();
//		c.restore();
//		c.printInfo();
//		System.out.println(ToSMT2.par(c.getRhs().toSMTString()));
		String model_name = "files/pacemaker_JPMAM12.imi";
		NPTA npta = ConvertModelToNPTA.createNPTA(model_name);
		System.out.println("+".repeat(50));
		for(Automaton a : npta.getAutomata()) {
			for(Location l : a.getLocations()) {
				for(Transition t : l.getTransitions()) {
					for(Constraint c : t.getGuards()) {
						System.out.println(c.replaceParametersToString(false));
						System.out.println(c.replaceParametersToString(true));
					}
				}
			}
		}
		for(Parameter p : npta.getParameter()) {
			p.printInfo();
		}
//		List<List<Element>> automata_elems = parser.getAutomata(model);
//		List<Automaton> automata = npta.getAutomata();
//		List<List<Element>> location_elems = null;
//		List<Location> locations = null;
//		List<Element> invariant_elems = null;
//		List<Constraint> invariants = null;
//		List<List<Element>> transition_elems = null;
//		List<Transition> transitions = null;
//		List<Element> guard_elems = null;
//		List<Constraint> guards = null;
//		List<List<Element>> update_elems = null;
//		List<Update> updates = null;
//		Element action_elem = null;
//		String action = null;
//		List<Element> automaton_elem = null;
//		Automaton automaton = null;
//		List<Element> location_elem = null;
//		Location location = null;
//		List<Element> transition_elem = null;
//		Transition transition = null;
//		Element invariant_elem = null;
//		Constraint invariant = null;
//		Element guard_elem = null;
//		Constraint guard = null;
//		List<Element> update_elem = null;
//		Update update = null;
//		
//		String preloc;
//		String postloc;
//		
//		int countAutom = automata.size();
//		int countLocs, countInvs, countTrans, countGuards, countUpdates;
//		
//		// AUTOMATA
//		for(int i = 0; i < countAutom;i++) {
//			automaton_elem = automata_elems.get(i);
//			automaton = automata.get(i);
//			location_elems = parser.getLocations(automaton_elem);
//			locations = automaton.getLocations();
//			countLocs = locations.size();
//			// LOCATIONS
//			for(int j = 0; j < countLocs; j++) {
//				location_elem = location_elems.get(j);
//				location = locations.get(j);
//				locations = automaton.getLocations();
//				preloc = location_elem.get(0).getContent();
//				transition_elems = parser.getTransitions(location_elem);
//				transitions = location.getTransitions();
//				countTrans = transitions.size();
//				// TRANSITIONS
//				for(int k = 0; k < countTrans;k++) {
//					transition_elem = transition_elems.get(k);
//					postloc = parser.getPostLoc(transition_elem).getContent();
//					transition = transitions.get(k);
//					action_elem = parser.getAction(transition_elem);
//					action = transition.getAction();
//					guard_elems = parser.getGuards(transition_elem);
//					guards = transition.getGuards();
//					update_elems = parser.getUpdates(transition_elem);
//					updates = transition.getUpdateRules();
//					countUpdates = updates.size();
//					testTransitionEquality(preloc,postloc,action_elem.getContent(),guard_elems,update_elems,transition);
//					countGuards = guards.size();
//					// GUARDS
//					for(int l = 0; l < countGuards; l++) {
//						guard_elem = guard_elems.get(l);
//						guard = guards.get(l);
//						testConstraintEquality(guard_elem,guard);
//					}
//					// UPDATES
//					for(int l = 0; l < countUpdates; l++) {
//						update_elem = update_elems.get(l);
//						update = updates.get(l);
//						testUpdateEquality(update_elem,update);
//					}
//				}
//				invariant_elems = parser.getInvariants(location_elem);
//				invariants = location.getInvariants();
//				countInvs = invariants.size();
//				// INVARIANTS
//				for(int k = 0; k < countInvs;k++) {
//					invariant_elem = invariant_elems.get(k);
//					invariant = invariants.get(k);
//					testConstraintEquality(invariant_elem,invariant);
//				}
//			}
//		}
		
	}
	
	/**
	 * Test equality for all given constraints
	 * @param econstraints
	 * @param jconstraints
	 */
	public static void testConstraintEquality(Element constraint_elem, Constraint constraint) {
		if(!constraint.constraintEquals(constraint_elem)) {
			System.out.println("NO MATCH EQUALITY: " + constraint.toString() + " AND " + constraint_elem.getContent());
			}
	}
	/**
	 * Check equality for all transitions of an automaton
	 * @param locations
	 * @param jtrans
	 * @param parser
	 */
	public static void testTransitionEquality(String preloc, String postloc, String action, List<Element> guard_elems,
			List<Element> update_elem, Transition transition) {
			if(!transition.transitionEquals(preloc, guard_elems, action, update_elem, postloc)) {
				System.out.println("NO MATCH TRANSITION: " + preloc+","+ elemsToString(guard_elems) + "," + action + "," + 
						elemsToString(update_elem) + "," + postloc + " AND \n" + transition.transitionToString());
			}
	}
		
		public static void testUpdateEquality(Element update_elem, Update update) {
			if(!update.updateEquals(update_elem)) {
			System.out.println("NO MATCH UPDATE: " + update.getVariable() + "," + update.getSetToValue() + 
					" AND " + update_elem.getContent());
			}
		}
	


}
