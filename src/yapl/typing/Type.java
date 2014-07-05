package yapl.typing;

import java.util.HashMap;
import java.util.Map;


public class Type {
	
	public static final Type INT = new Type(TypeKind.INTEGER, "Integer");
	public static final Type BOOLEAN = new Type(TypeKind.BOOLEAN, "Boolean");
	public static final Type CHAR = new Type(TypeKind.CHAR, "Character");
	public static final Type ERROR = new Type(TypeKind.ERROR, "");
	public static final Type VOID = new Type(TypeKind.VOID, "");
	
	
	@SuppressWarnings("serial") //can be ignored since it is an anonymous type abstracted away by the Map interface
	public static final Map<String, Type> TYPEMAP = new HashMap<String, Type>(){{
		put(INT.getSpelling(), INT);
		put(BOOLEAN.getSpelling(), BOOLEAN);
		put(CHAR.getSpelling(), CHAR);
	}};
	
	protected TypeKind kind;
	protected String spelling;
	
	public Type(TypeKind kind, String spelling) {
		this.kind = kind;
		this.spelling = spelling;
	}

	public TypeKind getKind() {
		return kind;
	}
	
	public String getSpelling() {
		return spelling;
	}
	
	public boolean matchesType(Type other){
		return getKind().equals(TypeKind.ERROR) || getKind().equals(other.getKind());
	}
	
	@Override
	public String toString() {
		return getKind().toString();
	}
}
