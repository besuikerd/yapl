package yapl.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * enum for different arguments that can be supplied to the {@link Tool}
 * @author Nicker
 *
 */
public enum ToolArgument{
	dot("dot", (args, ctx) -> {
		ctx.setDotFile(args[0]);
		ctx.setGenerateDot(true);
	}, "outfile")
	,outfile("o", (args, ctx) -> ctx.setOutfile(args[0]), "outfile")
	,textual("t", (args, ctx) -> ctx.setTextual(true))
	,assemble("a", (args, ctx) -> ctx.setAssemble(true))
	,run("r", (args, ctx) -> {ctx.setAssemble(true); ctx.setRun(true);})
	;
	

	public static final Map<String, ToolArgument> argumentMap;
	static{
		argumentMap = new HashMap<String, ToolArgument>();
		for(ToolArgument arg : values()) argumentMap.put(arg.getName(), arg);
	}
		
	private final String name;
	private final String[] args;
	private final ContextUpdater updater;
	private ToolArgument(String name, ContextUpdater updater, String... args){
		this.name = name;
		this.args = args;
		this.updater = updater;
	}
	
	/**
	 * getter for the name of the argument
	 * @return name of the argument
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * list of arguments the argument expects
	 * @return list of arguments the argument expects
	 */
	public String[] getArgs() {
		return args;
	}
	
	/**
	 * finds a ToolArgument by name if it exists
	 * @param name
	 * @return ToolArgument with the given name, or <code>null</code> if it does
	 * not.
	 */
	public static ToolArgument getByName(String name){
		return argumentMap.get(name);
	}
	
	/**
	 * applies the update function on the given context.
	 * @param ctx
	 * @param args
	 */
	public void update(ToolContext ctx, String... args){
		updater.update(args, ctx);
	}
	
	/**
	 * Update function that ToolArguments execute whenever the argument is given
	 * @author Nicker
	 *
	 */
	@FunctionalInterface
	protected interface ContextUpdater{
		/**
		 * updates the ToolContext
		 * @param args arguments this update function was given
		 * @param ctx context in which it was given
		 */
		public void update(String[] args, ToolContext ctx);
	}
}
