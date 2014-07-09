package yapl.context;

/**
 * Exception that is thrown in a {@link SymbolTable} when entering entries
 */
public abstract class SymbolTableException extends Exception {
    /** {@link #serialVersionUID} is required for Serializable */
    public static final long serialVersionUID = 24362462L;
    public SymbolTableException(String msg) { super(msg); }
}
