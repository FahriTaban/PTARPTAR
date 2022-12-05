package PTA;

/**
 * Linear constraint on clock or parameter
 * @author 49173
 *
 */
public class Constraint {
	private final Value val;
	private final Operator operator;
	private final Value bound;
	
	public Constraint(Value v, Operator op, Value b) {
		this.val = v;
		this.operator = op;
		this.bound = b;
	}
	
	
	public Value getValue() {
		return val;
	}


	public Operator getOperator() {
		return operator;
	}
	
	public String opToString() {
		switch(this.operator) {
			case lt:
				return "<";
			case leq:
				return "<=";
			case gt:
				return ">";
			case geq:
				return ">=";
			default:
				return " ";
		}
	}


	enum Operator {
		lt,leq,gt,geq
	}
}
