package yapl.tool;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.ErrorBuffer;

import yapl.codegen.TemplateNotFoundException;
import yapl.codegen.YAPLJVMCodeGenerator;
import yapl.context.IdEntry;
import yapl.context.SymbolTable;
import yapl.context.YAPLChecker;
import yapl.context.YAPLTypeVisitor;
import yapl.reporter.ErrorReporter;
import yapl.reporter.ErrorType;
import yapl.reporter.Severity;
import yapl.syntax.YAPLLexer;
import yapl.syntax.YAPLParser;

/**
 * Main class for the compiler that calls all the components of the compiler:
 * Syntax checking
 * Context checking
 * Code Generation 
 * Assembling
 * Executing
 * 
 * The main function takes input arguments this is the usage:
 * 
 * [optionals] input_file
 * 
 * input_file is the yapl file to compile
 * 
 * where [optionals] is any or multiple of the following:
 * -o outfile 	-> output file to write the jvm bytecode to
 * -d dotfile	-> generate dotfile (not implemented yet)
 * -a 			-> assmeble the program
 * -r	 		-> run the program after assembling
 * -t			-> prints a textual representation of the AST
 * 
 * @author Nicker
 *
 */
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
	
	/**
	 * context this tool is run in
	 */
	private ToolContext context;

	public Tool(ToolContext context) {
		this.context = context;
	}
	
	/**
	 * run the tool
	 * @param args
	 * @throws IOException
	 */
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
			
			

			if(reporter.getErrorCount(ErrorType.SYNTAX, Severity.ERROR) == 0){ //no syntax errors
				System.out.println("Syntactic analysis successful");
				tree.accept(new YAPLChecker(new SymbolTable<IdEntry>(), new YAPLTypeVisitor(reporter), reporter));
				if(reporter.getErrorCount(ErrorType.CONTEXT, Severity.ERROR) == 0){ //no contextual errors
					System.out.println("Contextual analysis successful");
					
					ST jvm = null;
					try{
						jvm = tree.accept(new YAPLJVMCodeGenerator(new STGroupFile("st/jvm.stg", '$', '$'), context));
					} catch(TemplateNotFoundException e){
						reporter.codegen().error(0, 0, e.getMessage());
					}
					if(jvm != null){
						boolean assemblyWrittenSuccessfully = false;
						File outFile = new File(context.getOutfile() + ".j");
						try{
							ErrorBuffer errorBuffer = new ErrorBuffer();
							if(!outFile.getParentFile().exists()){
								outFile.getParentFile().mkdir();
							}
							jvm.write(outFile, errorBuffer);
							if(!errorBuffer.errors.isEmpty()){
								errorBuffer.errors.forEach((error) -> reporter.codegen().error(0, 0, error.toString()));
							} else{
								assemblyWrittenSuccessfully = true;
							}
						} catch(IOException e){
							reporter.codegen().error(0, 0, e.getMessage());
						}
						if(assemblyWrittenSuccessfully){
							System.out.println("successfully wrote jasmin assembly file to " + outFile.getAbsolutePath());
							if(context.isAssemble()){
								JasminHelper jasmin = new JasminHelper();
								boolean successfullyAssembled = false;
								String classFile = context.getOutfile() + ".class"; 
								try{
									successfullyAssembled = jasmin.assembleToFile(outFile.getAbsolutePath(), classFile);;
								} catch(IOException e){
									System.err.println(String.format("could not assemble %s: %s", outFile.getAbsolutePath(), e.getMessage()));
								}
								if(successfullyAssembled){
									System.out.println("successfully wrote class file to " + classFile);
									if(context.isRun()){
										MainRunner runner = MainRunner.getInstance();
										runner.addToClassPath(new File(classFile).getParentFile().getAbsolutePath());
										
										try {
											System.out.println(String.format("running main %s...", context.getOutfileWithoutPath()));
											runner.tryMain(context.getOutfileWithoutPath());
										} catch (ExecutionException e1) {
											System.err.println("Error during invocation of main function");
											System.err.println("==========START STACKTRACE=========");
											e1.printStackTrace();
											System.err.println("==========STOP STACKTRACE==========");
										} catch (ClassFunctionException e1) {
											System.err.println("Could not execute main function: " + e1.getMessage());
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
