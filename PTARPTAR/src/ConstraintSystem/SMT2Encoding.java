package ConstraintSystem;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import ConstraintSystem.RepairComputation.VariationVariable;
import ConstraintSystem.RepairComputation.VariationVariable.VarType;
import ConstraintSystem.Variation.*;
import NPTA.*;
import Run.*;
import Utility.Utility;

public class SMT2Encoding {
	static List<Clock> clocks;
	static List<Parameter> parameters;
	static List<State> states;
	static List<List<Constraint>> invariants;
	static List<List<Constraint>> guards;
	static List<OuterTransition> transitions;
	static List<List<Update>> updates;
	static List<List<Clock>> resetClocks;
	static List<List<Clock>> nonResetClocks;
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
	static String temp = "";
	
	public static String createSMT2Encoding(Run run, NetworkPTA npta, VarType vType, 
			List<VariationVariable> vvs, String filePath) {
		initProps(run,npta);
		tdtcs(vType,tdtcs,vvs);
		prepareExistsBlock();
		prepareForallBlock(run);
		prepareOuterBlock(vvs);
		String res = outerBlock.toString();
		Utility.writeToFile(filePath, res);
		return res;
	}
	
	public static void prepareExistsBlock() {
		String vb = getVarBindings();
		String t = ToSMT2.concatWith("and", tdtcs.toString());
		existsBlock.append(ToSMT2.concatWith("exists", vb+ " " +t));
	}
	
	public static void prepareForallBlock(Run run){
		String vb = getVarBindings();
		String t = ToSMT2.concatWith("and", tdtcs.toString());
		String impR = getImplicationR(run);
		String imp = ToSMT2.concatWith("=>", t+ " " + ToSMT2.concatWith("not", impR));
		forallBlock.append(ToSMT2.concatWith("forall", vb+ "\n\t" +imp));
	}
	
	public static String getImplicationR(Run run) {
		String id = Integer.toString(run.getTransitions().size()-1);
		List<Constraint> cons = run.getPropertyConstraints();
		StringBuilder sb = new StringBuilder();
		for(Constraint c : cons) {
			sb.append(c.toSMTString(id)+"\n\t");
		}
		return sb.toString().strip();
	}
	
	public static void prepareSoftAssertions(List<VariationVariable> varVars) {
		List<String> softs = new ArrayList<>();
		for(VariationVariable vv : varVars) {
			softs.add(vv.neutralEq());
		}
		soft.append("(assert-soft " + Utility.concatPretty("and", softs) + ")");
		
	}
	
	public static void prepareOuterBlock(List<VariationVariable> varVars) {
//		outerBlock.append(Utility.concatStrings(
//				ToSMT2.declareParameters(parameters))+"\n");
		outerBlock.append(Utility.concatStrings(
				ToSMT2.declareVariationVariables(varVars))+"\n");
		String forall = forallBlock.toString();
		String inner = ToSMT2.formatSMT(existsBlock.toString(), "\n" + forall, "and");
		outerBlock.append(ToSMT2.concatWith("assert",inner) + "\n");
//		if (!temp.equals("")) {
//			outerBlock.append(ToSMT2.concatWith("assert",temp)+ "\n");
//		}
//		prepareSoftAssertions();
//		outerBlock.append(soft.toString()+"\n");
//		outerBlock.append(ToSMT2.par("apply qe")+"\n");
//		outerBlock.append(ToSMT2.par("check-sat")+"\n");
//		outerBlock.append(ToSMT2.par("get-model")+"\n");
		}
	
	public static String getVarBindings() {
		return ToSMT2.par(Utility.concatStrings(ToSMT2.declareBoundVariables(
						clocks, parameters, numberOfStates, numberOfTransitions)));
	}
	
	public static void appendEnd(StringBuilder s) {
		s.append("))");
	}
	
	public static void initProps(Run run, NetworkPTA npta) {
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
		numberOfStates = states.size();
		numberOfTransitions = run.getTransitions().size();
		initCons = run.getInitialConstraints();
	}
	
	public static void tdtcs(VarType vType, StringBuilder st,List<VariationVariable> varVars) {
		List<Integer> sequence;
		String lower = "",upper = "";
		switch(vType) {
		case ClockBound:
			sequence = List.of(0,1,-1,4,5);
//			appendClauses(forallBlock,List.of(0,-1));
			break;
		case ClockReference:
			sequence = List.of(0,1,-2,4,5);
			lower = "0";
			upper = Integer.toString(clocks.size());
			break;
		case ClockReset:
			sequence = List.of(-3,2,3,4,5);
			lower = "0";
			upper = "1";
			break;
		case Operator:
			sequence = List.of(0,1,-4,4,5);
			lower = "0";
			upper = "4";
			break;
		case UrgentLocation:
			sequence = List.of(0,1,2,3,-5,5);
			lower = "0";
			upper = "1";
			break;
		case ParameterBound:
			sequence = List.of(0,1,2,3,4,-6);
			break;
		default:
			sequence = List.of();
			break;
		}
		appendClauses(st, sequence, varVars);
		if (!lower.equals("")) {
			for(VariationVariable vv : varVars) {
				vv.setLower(lower);
				vv.setUpper(upper);
			}
		}
	}
	
	public static void appendClauses(StringBuilder s,List<Integer> args,List<VariationVariable> varVars) {
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
