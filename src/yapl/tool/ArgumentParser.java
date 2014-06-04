package yapl.tool;

import java.util.Arrays;

public class ArgumentParser {
	private int current;
	private String[] args;
	
	public ArgumentParser(String[] args) {
		super();
		this.args = args;
		current = 0;
	}
	
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
	
	public String[] remainder(){
		String[] remainder = new String[args.length - current];
		System.arraycopy(args, current, remainder, 0, remainder.length);
		return remainder;
	}
}
