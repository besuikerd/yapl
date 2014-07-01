package yapl.tool;

import java.util.HashMap;
import java.util.Map;


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
	public String getName() {
		return name;
	}
	public String[] getArgs() {
		return args;
	}
	
	public static ToolArgument getByName(String name){
		return argumentMap.get(name);
	}
	
	public void update(ToolContext ctx, String... args){
		updater.update(args, ctx);
	}
	
	
	@FunctionalInterface
	protected interface ContextUpdater{
		public void update(String[] args, ToolContext ctx);
	}
}
