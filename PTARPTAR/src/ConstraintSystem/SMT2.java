package ConstraintSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ConstraintSystem.Variation.*;
import ConstraintSystem.VariationVariable.VarType;
import NPTA.*;
import Run.*;
import Utility.Utility;

public class SMT2 {
	static List<Clock> clocks;
	static List<Parameter> parameters;
	static List<State> states;
	static List<List<Constraint>> invariants;
	static List<List<Constraint>> guards;
	static List<OuterTransition> transitions;
	static List<List<Update>> updates;
	static List<List<Clock>> resetClocks;
	static List<List<Clock>> nonResetClocks;
	static List<VariationVariable> varVars;
	static HashMap<Integer,State> urgentLocs;
	static int numberOfStates;
	static int numberOfTransitions;
	static List<String> ops = new ArrayList<>();
	static List<Constraint> initCons;
	static StringBuilder outerBlock = new StringBuilder();
	static StringBuilder soft = new StringBuilder();
	static StringBuilder forallBlock = new StringBuilder();
	static StringBuilder existsBlock = new StringBuilder();
	static StringBuilder tdtcs = new StringBuilder();
	
	public static String createSMT2Encoding(Run run, NetworkPTA npta, VarType vType, 
			List<VariationVariable> vvs, String filePath) {
		varVars = vvs;
		initProps(run,npta,vType);
		tdtcs(vType, tdtcs);
		appendVarBinding(existsBlock,false);
		appendVarBinding(forallBlock,true);
		existsBlock.append(tdtcs.toString());
		forallBlock.append(tdtcs.toString());
		appendEnd(existsBlock);
		appendEnd(forallBlock);
		prepareOuterBlock();
		Utility.writeToFile(filePath, outerBlock.toString());
		return outerBlock.toString();
	}
	
	public static void prepareSoftAssertions() {
		List<String> softs = new ArrayList<>();
		for(VariationVariable vv : varVars) {
			softs.add(vv.neutralEq());
		}
		soft.append("(assert-soft " + Utility.concatPretty("and", softs) + ")");
		
	}
	
	public static void prepareOuterBlock() {
		outerBlock.append(Utility.concatStrings(
				ToSMT2.declareParameters(parameters))+"\n");
		outerBlock.append(Utility.concatStrings(
				ToSMT2.declareVariationVariables(varVars))+"\n");
		String forall = forallBlock.toString();
		String inner = ToSMT2.formatSMT(existsBlock.toString(), "\n" + forall, "and");
		outerBlock.append(ToSMT2.par("assert " + inner) + "\n");
		prepareSoftAssertions();
		outerBlock.append(soft.toString()+"\n");
		outerBlock.append(ToSMT2.par("apply qe")+"\n");
		outerBlock.append(ToSMT2.par("check-sat")+"\n");
		outerBlock.append(ToSMT2.par("get-model")+"\n");
		}
	
	public static void appendVarBinding(StringBuilder s, boolean forall) {
		String type;
		if (forall) {
			type = "forall";
		} else {
			type = "exists";
		}
		s.append(Utility.concatPretty(
				type + " (", ToSMT2.declareBoundVariables(
						clocks, numberOfStates, numberOfTransitions))+"\n(and ");
	}
	
	public static void appendEnd(StringBuilder s) {
		s.append("))");
	}
	
	public static void initProps(Run run, NetworkPTA npta, VarType vType) {
		ops.addAll(List.of(">",">=","=","<=","<"));
		clocks = npta.getClocks();
		parameters = npta.getParameter();
		states = run.getStates();
		invariants = run.getInvariants();
		guards = run.getGuards();
		transitions = run.getTransitions();
		updates = run.getUpdates();
		resetClocks = run.getAllResetClocks(clocks);
		nonResetClocks = run.getAllNonResetClocks(clocks);
		urgentLocs = run.getUrgentLocations();
		varVars = new ArrayList<>();
		numberOfStates = states.size();
		numberOfTransitions = run.getTransitions().size();
		initCons = run.getInitialConstraints();
	}
	
	public static void tdtcs(VarType vType, StringBuilder forallBlock) {
		switch(vType) {
		case ClockBound:
			appendClauses(forallBlock,List.of(0,1,-1,4,5));
//			appendClauses(forallBlock,List.of(0,-1));
			break;
		case ClockReference:
			appendClauses(forallBlock,List.of(0,1,-2,4,5));
			break;
		case ClockReset:
			appendClauses(forallBlock,List.of(-3,2,3,4,5));
			break;
		case Operator:
			appendClauses(forallBlock,List.of(0,1,-4,4,5));
			break;
		case UrgentLocation:
			appendClauses(forallBlock,List.of(0,1,2,3,-5,5));
			break;
		case ParameterBound:
			appendClauses(forallBlock,List.of(0,1,2,3,4,-6));
			break;
		default:
			break;
			
		}
	}
	
	public static void appendClauses(StringBuilder s,List<Integer> args) {
		s.append(ToSMT2.timeAdvancement(numberOfTransitions)+"\n");
		for(int j = 0; j < args.size(); j++) {
			String app = "";
			if (j != args.size()-1) {
				app = "\n";
			}
			int i = args.get(j);
			switch(i) {
			case -6:
				s.append(ParameterBoundVariation.parameterBoundString(parameters, varVars));
				break;
			case -5:
				s.append(UrgentLocationVariation.urgentLocationString(states, varVars)+app);
				break;
			case -4:
				s.append(OperatorVariation.operatorVariation(
						transitions, states, clocks, varVars, ops)+app);
				break;
			case -3:
				s.append(ClockResetVariation.changeResetsString(
						transitions, clocks, varVars, true)+"\n");
				s.append(ClockResetVariation.changeResetsString(
						transitions, clocks, varVars, false)+app);
				break;
			case -2:
				s.append(ClockReferenceVariation.clockReferenceVariation(
						transitions, states, clocks, varVars)+app);
				break;
			case -1:
				s.append(ClockBoundVariation.clockBoundVariation(
						guards, invariants, clocks, varVars)+app);
				break;
			// append clock resets
			case 0:
				s.append(ToSMT2.clockResets(resetClocks)+app);
				break;
			// append sojourn time
			case 1:
				s.append(ToSMT2.sojournTime(nonResetClocks)+app);
				break;
			// append invariant bounds
			case 2:
				s.append(ToSMT2.getInvariantBounds(states, clocks)+app);
				break;
			// append transition bounds
			case 3:
				s.append(ToSMT2.getTransitionGuards(transitions, clocks)+app);
				break;
			// append urgent locations
			case 4:
				s.append(ToSMT2.urgentLocations(urgentLocs)+app);
				break;
			// append initial constraints on clocks and params
			case 5:
				s.append(ToSMT2.initializeInitConstraints(initCons, clocks)+app);
				break;
			default:
				break;
			}
		}
	}
	
}
