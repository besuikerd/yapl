package yapl.typing;

public class DynamicType extends Type{

	public DynamicType(String spelling) {
		super(TypeKind.DYNAMIC, spelling);
	}
	
	@Override
	public boolean matchesType(Type other) {
		return other.getKind().equals(TypeKind.ERROR) || other.getKind().equals(TypeKind.DYNAMIC) && other.spelling.equals(spelling);
	}
	
	@Override
	public String toString() {
		return spelling;
	}
}
