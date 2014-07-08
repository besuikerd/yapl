package yapl.context;

/**
 * Model class for a constant expression. This class is used to determine wheter
 * a constant expression has an expression that can be determined at compile
 * time
 * @author Nicker
 *
 */
public class ConstantExpression {

	/**
	 * constant value, if any;
	 */
	private int value;
	
	/**
	 * type of the constant. Determines if the expression is known at compile
	 * time
	 */
	private ConstantType constantType;
	
	/**
	 * creates a new ConstantExpression with the given value and type
	 * @param value constant value of the expression
	 * @param constantType type of the constant
	 */
	public ConstantExpression(int value, ConstantType constantType) {
		this.value = value;
		this.constantType = constantType;
	}
	
	/**
	 * retrieves the value of the constant, if any
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * creates a new ConstantExpression with the same {@link ConstantType} that
	 * contains the given value
	 * @param value value for the new ConstantExpression
	 * @return
	 */
	public ConstantExpression newValue(int value){
		return new ConstantExpression(value, this.constantType);
	}

	/**
	 * getter for the {@link ConstantType} of this ConstantExpression
	 * @return
	 */
	public ConstantType getConstantType() {
		return constantType;
	}

	/**
	 * Determines what type a ConstantExpression is.
	 * @author Nicker
	 *
	 */
	public enum ConstantType{
		/**
		 * A known value is known at compile time and does not have to be
		 * calculated at runtime
		 */
		KNOWN_VALUE,
		
		/**
		 * An unknown value means that the expression contains parts that are
		 * not known at compile time, so it needs to calculate the constant at
		 * runtime.
		 */
		UNKNOWN_VALUE
		;
	}
}
