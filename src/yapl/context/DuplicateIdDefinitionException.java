package yapl.context;

/**
 * Exception that is thrown whenever a {@link SymbolTable} entry is entered but
 * is already defined at the current scope level
 * @author Nicker
 *
 */
public class DuplicateIdDefinitionException extends SymbolTableException{
	
	private static final long serialVersionUID = -4075567480997896713L;
	private String id;

	public DuplicateIdDefinitionException(String id) {
		super(String.format("variable %s is already declared", id));
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
