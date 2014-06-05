package yapl.typing;

public class DynamicType extends Type{
	private String spelling;

	public DynamicType(String spelling) {
		super(TypeKind.DYNAMIC);
		this.spelling = spelling;
	}

	@Override
	public TypeKind getKind() {
		return TypeKind.DYNAMIC;
	}
	
	@Override
	public boolean matchesType(Type other) {
		return other.getKind().equals(TypeKind.ERROR) || other.getKind().equals(TypeKind.DYNAMIC) && ((DynamicType) other).spelling.equals(spelling);
	}
	
	@Override
	public String toString() {
		return spelling;
	}
}
