package yapl.context;

import org.stringtemplate.v4.ST;

public class ConstantExpression {

	private int value;
	private ConstantType constantType;
	
	public ConstantExpression(int value, ConstantType constantType) {
		this.value = value;
		this.constantType = constantType;
	}
	
	public int getValue() {
		return value;
	}
	
	public ConstantExpression newValue(int value){
		return new ConstantExpression(value, this.constantType);
	}

	public ConstantType getConstantType() {
		return constantType;
	}

	public enum ConstantType{
		KNOWN_VALUE,
		UNKNOWN_VALUE
		;
	}
}
