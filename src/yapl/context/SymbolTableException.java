package yapl.context;

/**
 * Created by langstra on 30-4-14.
 */
public class SymbolTableException extends Exception {
    /** {@link #serialVersionUID} is required for Serializable */
    public static final long serialVersionUID = 24362462L;
    public SymbolTableException(String msg) { super(msg); }
}
