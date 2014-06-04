package yapl.tool;

import java.util.Arrays;
import java.util.Comparator;


public enum ToolArgument{
	dot("dot", (args, ctx) -> {
		ctx.setDotFile(args[0]);
		ctx.setGenerateDot(true);
	}, "outfile")
	,outfile("o", (args, ctx) -> ctx.setOutfile(args[0]), "outfile")
	,textual("t", (args, ctx) -> ctx.setTextual(true))
	;
	
	public static final ToolArgument[] sortedValues;
	static {
		ToolArgument[] copy = new ToolArgument[values().length];
		System.arraycopy(values(), 0, copy, 0, values().length);
		Arrays.sort(copy, new Comparator<ToolArgument>() {
			@Override
			public int compare(ToolArgument o1, ToolArgument o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		sortedValues = copy;
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
	
	public void update(ToolContext ctx, String... args){
		updater.update(args, ctx);
	}
	
	/**
	 * binary search the given ToolArgument by its name
	 * @param name name to search for
	 * @return ToolArgument with the given name or null if it does not exist.
	 */
	public static ToolArgument getByName(String name){
		int cur = sortedValues.length / 2;
		ToolArgument result = null;
		boolean found = false;
		while(!found){
			ToolArgument arg = sortedValues[cur];
			int compare = arg.getName().compareTo(name);
			if(cur > sortedValues.length){
				found = true;
			} else{
				if(cur == 0){
					found = true;
				}
				if(compare == 0){
					result = arg;
					found = true;
				} else if(compare > 0){
					cur = cur / 2;
				} else{
					cur = cur * 2;
				}
			}
			
		}
		return result;
	}
	
	@FunctionalInterface
	protected interface ContextUpdater{
		public void update(String[] args, ToolContext ctx);
	}
}
