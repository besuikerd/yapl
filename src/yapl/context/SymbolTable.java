package yapl.context;

import java.util.*;
import java.util.stream.Collectors;

import yapl.context.ConstantExpression.ConstantType;
import yapl.context.IdEntry.EntryType;
import yapl.syntax.YAPLParser.DeclVarContext;

public class SymbolTable<Entry extends IdEntry> {

    private Map<String, Stack<Entry>> declarations;
    private Stack<Set<String>> scopedDeclarations;
    private int currentLevel;
    private int offset;

    /**
     * Constructor.
     * @ensures  this.currentLevel() == -1
     */
    public SymbolTable() {
        this.declarations = new HashMap<String, Stack<Entry>>();
        this.scopedDeclarations = new Stack<Set<String>>();
        this.currentLevel = -1;
        this.offset = 1;
    }

    /**
     * Opens a new scope.
     * @ensures this.currentLevel() == old.currentLevel()+1;
     */
    public void openScope()  {
        currentLevel++;
        scopedDeclarations.push(new HashSet<String>());
    }

    /**
     * Closes the current scope. All identifiers in
     * the current scope will be removed from the SymbolTable.
     * @requires old.currentLevel() > -1;
     * @ensures  this.currentLevel() == old.currentLevel()-1;
     * @return entries that are removed from the current scope
     */
    public Set<Entry> closeScope() {
        Set<String> toRemove = scopedDeclarations.pop();
        Set<Entry> removed = toRemove.stream().map((decl) -> {
            Stack<Entry> stack = declarations.get(decl);
            Entry entry = stack.pop();
            if(stack.isEmpty()){
                declarations.remove(decl);
            }
            return entry;
        }).collect(Collectors.toSet());
        currentLevel--;
        offset -= removed.stream().filter((entry) -> entry.getEntryType() == EntryType.VARIABLE).collect(Collectors.toSet()).size();

        return removed;
    }

    /** Returns the current scope level. */
    public int currentLevel() {
        return currentLevel;
    }

    /**
     * Enters an id together with an entry into this SymbolTable
     * using the current scope level. The entry's level is set to
     * currentLevel().
     * @requires id != null && id.length() > 0 && entry != null;
     * @ensures  this.retrieve(id).getLevel() == currentLevel();
     * @throws SymbolTableException when there is no valid
     *    current scope level, or when the id is already declared
     *    on the current level.
     */
    public void enter(String id, Entry entry)
            throws SymbolTableException {
    	if(currentLevel() < 0){
    		throw new InvalidScopeLevelException(currentLevel());
    	}
        Stack<Entry> stack = declarations.get(id);
        if(stack == null) {
            stack = new Stack<Entry>();
            declarations.put(id, stack);
        } else if(stack.peek().getLevel() == currentLevel()) {
            throw new DuplicateIdDefinitionException(id);
        }
        scopedDeclarations.peek().add(id);
        entry.setLevel(currentLevel());
        if(entry.getEntryType() == EntryType.VARIABLE || entry.getConstantExpression().getConstantType() == ConstantType.UNKNOWN_VALUE){
        	entry.setOffset(offset++);
        }
    	
        stack.push(entry);
    }

    /**
     * Get the Entry corresponding with id whose level is
     * the highest; in other words, that is defined last.
     * @return  Entry of this id on the highest level
     *          null if this SymbolTable does not contain id
     */
    public Entry retrieve(String id) {
        Stack<Entry> stack = declarations.get(id);
        Entry e = stack != null ? stack.peek() : null;
        if(e != null && !e.isUsed()){
        	e.setUsed(true);
        }
        return e;
    }
}
