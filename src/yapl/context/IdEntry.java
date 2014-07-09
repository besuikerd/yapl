package yapl.context;

import yapl.syntax.YAPLParser.DeclarationContext;
import yapl.typing.Type;

/**
 * IdEntry contains information about a variable that is being filled during
 * context checking and is being used for the code generator to be able to use
 * this information during code generation.
 * @author Nicker
 *
 */
public class IdEntry {
	/**
	 * spelling of the variable
	 */
	private String spelling;
	
	/**
	 * context where this variable was declared in
	 */
	private DeclarationContext ctx;
	
	/**
	 * scope level of the variable
	 */
	private int level;
	
	/**
	 * flag that determines wheter this variable was used later in the program
	 */
	private boolean used;
	
	/**
	 * {@link Type} of the variable
	 */
	private Type type;
	
	/**
	 * offset where this variable is stored to and loaded from
	 */
	private int offset;
	
	/**
	 * Type of this entry: either variable or constant
	 */
	private EntryType entryType;
	
	/**
	 * ConstantExpression, only contains a reference if the entryType is 
	 * {@link EntryType.CONSTANT}
	 */
	private ConstantExpression constantExpression;

	/**
	 * Constructs a new IdEntry
	 * @param spelling spelling of the variable
	 * @param ctx contexts this variable was declared in
	 * @param level scope level of the declaration
	 * @param type {@link Type} of the variable
	 * @param entryType {@link EntryType} of the variable
	 */
	public IdEntry(String spelling, DeclarationContext ctx, int level, Type type, EntryType entryType){
		this.spelling = spelling;
		this.ctx = ctx;
		this.level = level;
		this.type = type;
		this.used = false;
		this.entryType = entryType;
	}
	
	public IdEntry(String spelling, DeclarationContext ctx, Type type, EntryType entryType){
		this(spelling, ctx, -1, type, entryType);
	}
	
	/**
	 * getter for the scope level
	 * @return scope level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * setter for the scope level
	 * @param level scope level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * setter for the variable offset
	 * @param offset variable offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	/**
	 * getter for the variable offset 
	 * @return the variable offset
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * getter for the DeclarationContext
	 * @return the {@link DeclarationContext} this variable was declared in
	 */
	public DeclarationContext getDeclarationContext() {
		return ctx;
	}
	
	/**
	 * flag whether or not this variable is used
	 * @return is this variable used?
	 */
	public boolean isUsed() {
		return used;
	}
	
	/**
	 * getter for the spelling of the variable
	 * @return the spelling of the variable
	 */
	public String getSpelling() {
		return spelling;
	}
	
	/**
	 * getter for the {@link Type} of the variable
	 * @return the type of the variable
	 */
	public Type getType() {
		return type;
	}
	
	
	/**
	 * getter for the {@link EntryType} of the variable
	 * @return the EntryType of the variable
	 */
	public EntryType getEntryType() {
		return entryType;
	}
	
	/**
	 * setter for the used flag
	 * @param used is this variable used?
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	/**
	 * getter for the {@link ConstantExpression} of this variable
	 * @return the ConstantExpression
	 */
	public ConstantExpression getConstantExpression() {
		return constantExpression;
	}
	
	/**
	 * setter for the {@link ConstantExpression} of this variable
	 * @param constantExpression the ConstantExpression
	 */
	public void setConstantExpression(ConstantExpression constantExpression) {
		this.constantExpression = constantExpression;
	}
	
	/**
	 * Defines what kind of {@link IdEntry} this is: a variable or a constant
	 * @author Nicker
	 *
	 */
	public enum EntryType{
		/**
		 * a variable IdEntry
		 */
		VARIABLE,
		
		/**
		 * a constant IdEntry
		 */
		CONSTANT;
	}
}
