package yapl.tool;

import java.util.Arrays;

/**
 * Parser for input arguments. All possible arguments are in the enum
 * {@link ToolArgument}. Most arguments modify the {@link ToolContext} the 
 * {@link Tool} is in and that context is used at runtime to make certain
 * decisions
 * @author Nicker
 *
 */
public class ArgumentParser {
	
	/**
	 * current argument count
	 */
	private int current;
	
	/**
	 * arguments given to be parsed
	 */
	private String[] args;
	
	public ArgumentParser(String[] args) {
		super();
		this.args = args;
		current = 0;
	}
	
	/**
	 * Attempts to parse the arguments to modify the given {@link ToolContext}
	 * @param ctx ToolContext to modify
	 * @return modified {@link ToolContext}
	 * @throws ArgumentParseException
	 */
	public ToolContext parse(ToolContext ctx) throws ArgumentParseException{
		ToolContext result = ctx;
		boolean finished = false;
		while(current < args.length && ! finished){
			String name = args[current];
			if(name.startsWith("-")){
				current++;
				name = name.substring(1);
				ToolArgument arg = ToolArgument.getByName(name);
				if(arg == null){
					throw new ArgumentParseException("option not found: " + name);
				} else{
					String[] sub = new String[arg.getArgs().length];
					if(sub.length > args.length - current){
						throw new ArgumentParseException(String.format("not enough arguments for %s, expected: %s", arg.getName(), Arrays.toString(arg.getArgs())));
					}
					for(int i = 0 ; i < sub.length ; i++){
						String argarg = args[current + i];
						if(argarg.startsWith("-")){
							throw new ArgumentParseException(String.format("not enough arguments for %s, expected: %s", arg.getName(), Arrays.toString(arg.getArgs())));
						}
						sub[i] = argarg;
					}
					System.arraycopy(args, current, sub, 0, sub.length);
					current += sub.length;
					arg.update(ctx, sub);
				}
			} else{
				finished = true;
			}
			
		}
		return result;
	}
	
	/**
	 * Remainder of arguments after parsing all arguments it could
	 * @return reaminder of arguments
	 */
	public String[] remainder(){
		String[] remainder = new String[args.length - current];
		System.arraycopy(args, current, remainder, 0, remainder.length);
		return remainder;
	}
}
