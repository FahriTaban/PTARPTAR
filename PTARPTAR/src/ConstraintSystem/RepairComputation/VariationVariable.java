package ConstraintSystem.RepairComputation;

import java.util.List;

import NPTA.*;
import Run.State;
import Utility.Utility;;

public class VariationVariable {
	private VarType type;
	private String name;
	private String repairValue;
	private String operator;
	private Constraint constraint;
	private Update update;
	private State state;
	private Clock clock;
	private List<Update> updates;
	
	enum VarType{
		ClockBound, Operator, ClockReference, ResetClock, UrgentLocation, ParameterBound
	}
	
	public VariationVariable(String name, VarType type) {
		this.setName(name);
		this.type = type;
	}
	
	public void setRepairValue(String val) {
		this.repairValue = val;
	}
	
	public void interpretRepairValue() {
		switch(this.type){
			case ClockBound:
				clockBound();
			case Operator:
				operator();
			case ClockReference:
				clockReference();
			case ResetClock:
				resetClocks();
			case UrgentLocation:
				return;
			case ParameterBound:
				parameterBound();
			default:
				return;
		}
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
			case 1:
				newOp = ">=";
			case 2:
				newOp = "=";
			case 3:
				newOp = "<=";
			case 4:
				newOp = "<";
			default:
				newOp = "";
		}
		this.constraint.setOperator(newOp);
	}
	
	public void clockReference() {
		this.constraint.getLhs().getVariables().clear();
		this.constraint.getLhs().getVariables().add(this.clock);
	}
	
	public void resetClocks() {
		Update newUpdate = new Update(this.clock.getName(),"0");
		this.updates.add(newUpdate);
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
	
	
	
}
