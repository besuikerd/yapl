package yapl.typing;

import java.util.HashMap;
import java.util.Map;

/**
 * class that represents a type of an expression.
 * @author Nicker
 *
 */
public class Type {
	/**
	 * Integer type
	 */
	public static final Type INT = new Type(TypeKind.INTEGER, "Integer");
	
	/**
	 * Boolean type
	 */
	public static final Type BOOLEAN = new Type(TypeKind.BOOLEAN, "Boolean");
	
	/**
	 * Character type
	 */
	public static final Type CHAR = new Type(TypeKind.CHAR, "Character");
	
	/**
	 * Error type when typechecking failed
	 */
	public static final Type ERROR = new Type(TypeKind.ERROR, "");
	
	/**
	 * Void (null) type
	 */
	public static final Type VOID = new Type(TypeKind.VOID, "");
	
	
	/**
	 * maps the spelling of types to their concrete type instance
	 */
	@SuppressWarnings("serial") //can be ignored since it is an anonymous type abstracted away by the Map interface
	public static final Map<String, Type> TYPEMAP = new HashMap<String, Type>(){{
		put(INT.getSpelling(), INT);
		put(BOOLEAN.getSpelling(), BOOLEAN);
		put(CHAR.getSpelling(), CHAR);
	}};
	
	/**
	 * kind of the type
	 */
	protected TypeKind kind;
	
	/**
	 * how the type is spelled
	 */
	protected String spelling;
	
	/**
	 * creates a new type with the given kind and spelling
	 * @param kind
	 * @param spelling
	 */
	public Type(TypeKind kind, String spelling) {
		this.kind = kind;
		this.spelling = spelling;
	}

	/**
	 * kind of the type
	 * @return
	 */
	public TypeKind getKind() {
		return kind;
	}
	
	/**
	 * spelling of this type
	 * @return
	 */
	public String getSpelling() {
		return spelling;
	}
	
	/**
	 * check if the kinds of this kind and another type kind matches
	 * @param other other type to match against
	 * @return whether the types kinds match or not
	 */
	public boolean matchesType(Type other){
		return getKind().equals(TypeKind.ERROR) || getKind().equals(other.getKind());
	}
	
	@Override
	public String toString() {
		return getKind().toString();
	}
}
