package ConstraintSystem.RepairComputation;

import java.util.ArrayList;
import java.util.List;

import ConstraintSystem.ToSMT2;
import NPTA.*;
import Run.State;
import Utility.Utility;;

public class VariationVariable {
	private VarType type;
	private String name;
	private String repairValue;
	private String neutralRepairValue = "0";
	private String operator;
	private String upper = null;
	private String lower = null;
	private Constraint constraint;
	private Transition transition;
	private Update update;
	private boolean setsReset;
	private State state;
	private Clock clock;
	private List<Clock> clocks = new ArrayList<>();
	private List<Update> updates = new ArrayList<>();
	
	public VariationVariable(String name, VarType type) {
		this.setName(name);
		this.type = type;
	}
	
	public VariationVariable(String name, VarType type, Constraint c) {
		this.setName(name);
		this.type = type;
		this.constraint = c;
	}
	
	public void repairConstraint() {
		this.constraint.backUp();
		this.repairNPTA();
	}
	
	public void setRepairValue(String val) {
		this.repairValue = val;
	}
	
	public boolean lowerIsNull() {
		return this.lower == null;
	}
	
	public void repairNPTA() {
		if (this.repairValue.equals(this.neutralRepairValue)) {
			return;
		}
		switch(this.type){
			case ClockBound:
				clockBound();
				return;
			case Operator:
				operator();
				return;
			case ClockReference:
				clockReference();
				return;
			case ClockReset:
				resetClocks();
				return;
			case UrgentLocation:
				urgentLocation();
				return;
			case ParameterBound:
				parameterBound();
				return;
			default:
				return;
		}
	}
	
	public void urgentLocation() {
		
	}
	
	public void clockBound() {
		List<String> split = Utility.splitString(repairValue, "[\\+\\-]");
		if (split.size() == 1) {
			Variable v = new Variable(split.get(0));
			this.constraint.getRhs().getVariables().add(v);
			this.constraint.getRhs().getOperators().add("+");
		} else {
			Variable v = new Variable(split.get(1));
			String operator = split.get(0);
			this.constraint.getRhs().getVariables().add(v);
			this.constraint.getRhs().getOperators().add(operator);
		}
	}
	
	public void operator() {
		String newOp;
		switch(Integer.valueOf(this.repairValue)) {
			case 0:
				newOp = ">";
				break;
			case 1:
				newOp = ">=";
				break;
			case 2:
				newOp = "=";
				break;
			case 3:
				newOp = "<=";
				break;
			case 4:
				newOp = "<";
				break;
			default:
				newOp = this.neutralRepairValue;
				break;
		}
		this.constraint.setOperator(newOp);
	}
	
	public void clockReference() {
		int index = Integer.valueOf(this.repairValue);
		this.constraint.getLhs().getVariables().clear();
		this.constraint.getLhs().getVariables().add(this.clocks.get(index));
	}
	
	public void resetClocks() {
		if(!this.setsReset) {
			this.transition.removeUpdate(this.update);
		} else {
			Update newUpdate = new Update(this.clock.getName(),"0");
			this.transition.addUpdate(newUpdate);
		}
	}
	
	public void parameterBound() {
		List<String> split = Utility.splitString(repairValue, "[\\+\\-]");
		if (split.size() == 1) {
			Variable v = new Variable(split.get(0));
			this.constraint.getRhs().getVariables().add(v);
			this.constraint.getRhs().getOperators().add("+");
		} else {
			Variable v = new Variable(split.get(1));
			String operator = split.get(0);
			this.constraint.getRhs().getVariables().add(v);
			this.constraint.getRhs().getOperators().add(operator);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock c) {
		this.clock = c;
	}
	
	public void setConstraint(Constraint c) {
		this.constraint = c;
	}
	
	public Constraint getConstraint() {
		return this.constraint;
	}

	public List<Clock> getClocks() {
		return clocks;
	}

	public void addClock(Clock clock) {
		this.clocks.add(clock);
	}
	
	
	public String getNeutralRepairValue() {
		return neutralRepairValue;
	}

	public void setNeutralRepairValue(String nrp) {
		switch(this.type){
		case ClockBound:
			this.neutralRepairValue = "0";
			return;
		case Operator:
			this.neutralRepairValue = nrp;
			return;
		case ClockReference:
			this.neutralRepairValue = nrp;
			return;
		case ClockReset:
			this.neutralRepairValue = "0";
			return;
		case UrgentLocation:
			this.neutralRepairValue = "0";
			return;
		case ParameterBound:
			this.neutralRepairValue = nrp;
			return;
		default:
			return;
	}
}

	public String neutralEq() {
		return ToSMT2.formatSMT(this.name, this.neutralRepairValue, "=");
	}

	public enum VarType{
		ClockBound, Operator, ClockReference, ClockReset, UrgentLocation, ParameterBound
	}

	public void printRepairInfo() {
		System.out.println("Variation variable "+this.name);
		System.out.println("Repair Value:" + this.repairValue + 
				"; Neutral Repair Value:" + this.neutralRepairValue);
	}

	public String getUpper() {
		return upper;
	}

	public void setUpper(String upper) {
		this.upper = upper;
	}

	public String getLower() {
		return lower;
	}

	public void setLower(String lower) {
		this.lower = lower;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	public boolean isReset() {
		return setsReset;
	}

	public void setReset(boolean isReset) {
		this.setsReset = isReset;
	}
}
