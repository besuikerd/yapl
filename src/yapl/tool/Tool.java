package yapl.tool;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import yapl.context.IdEntry;
import yapl.context.SymbolTable;
import yapl.context.YAPLChecker;
import yapl.reporter.ErrorReporter;
import yapl.syntax.YAPLLexer;
import yapl.syntax.YAPLParser;


public class Tool {
	public static void main(String[] args) {
		ToolContext ctx = new ToolContext();
		try{
			ArgumentParser parser = new ArgumentParser(args);
			ctx = parser.parse(ctx);
			Tool tool = new Tool(ctx);
			
			try{
				tool.run(parser.remainder());
			} catch(IOException e){
				System.err.println("error: " + e.getMessage());
			}
			
		} catch(ArgumentParseException e){
			System.err.println(e.getMessage());
			
		}
	}
	
	private ToolContext context;

	public Tool(ToolContext context) {
		this.context = context;
	}
	
	public void run(String[] args) throws IOException{
		if(args.length == 0){
			System.err.println("expected input file argument");
		} else{
			String input = args[0];
			YAPLLexer lexer = new YAPLLexer(new ANTLRFileStream(input));
			TokenStream stream = new CommonTokenStream(lexer);
			YAPLParser parser = new YAPLParser(stream);
			ParseTree tree = parser.yapl();
			ErrorReporter reporter = new ErrorReporter().withConsumer((x) -> System.out.println(x));
			
			if(context.isTextual()) System.out.println(tree.toStringTree(parser));
			
			tree.accept(new YAPLChecker(new SymbolTable<IdEntry>(), reporter));
		}
		
	}
}
