package yapl.typing;

public class Type {
	
	public static final Type INT = new Type(TypeKind.INTEGER);
	public static final Type BOOLEAN = new Type(TypeKind.BOOLEAN);
	public static final Type ERROR = new Type(TypeKind.ERROR);
	public static final Type VOID = new Type(TypeKind.VOID);
	
	protected TypeKind kind;
	
	public Type(TypeKind kind) {
		this.kind = kind;
	}

	public TypeKind getKind() {
		return kind;
	}
	
	public boolean matchesType(Type other){
		return other.getKind().equals(TypeKind.ERROR) || getKind().equals(other.getKind());
	}
	
	@Override
	public String toString() {
		return getKind().toString();
	}
}
