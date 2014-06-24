package yapl.tool;

import java.io.IOException;
import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import yapl.context.IdEntry;
import yapl.context.SymbolTable;
import yapl.context.YAPLChecker;
import yapl.context.YAPLTypeVisitor;
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
			ErrorReporter reporter = new ErrorReporter().withConsumer((x) -> System.err.println(x));
			YAPLParser parser = new YAPLParser(stream);
			
			parser.removeErrorListeners();
			parser.addErrorListener(new BaseErrorListener(){
				public void syntaxError(org.antlr.v4.runtime.Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
					reporter.syntax().error(line, charPositionInLine, msg);
				};
			});
			
			
			ParseTree tree = parser.yapl();
			
			
			
			
			if(context.isTextual()) System.out.println(tree.toStringTree(parser));
			
			tree.accept(new YAPLChecker(new SymbolTable<IdEntry>(), new YAPLTypeVisitor(reporter), reporter));
		}
		
	}
}
