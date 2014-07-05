package yapl.reporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.omg.CORBA.RepositoryIdHelper;

import yapl.context.IdEntry;
import yapl.syntax.YAPLParser.ExpressionContext;
import yapl.typing.Type;

/**
 * This class keeps a record of errors that are reported.
 * @author Nicker
 *
 */
public class ErrorReporter {
	private List<CompilerError> errors;
	private Set<Consumer<CompilerError>> consumers;
	
	public ErrorReporter(){
		this.errors = new ArrayList<CompilerError>();
		this.consumers = new HashSet<Consumer<CompilerError>>();
	}
	
	/**
	 * returns the amount of errors that are reported
	 * @return the amount of errors reported
	 */
	public int getErrorCount(){
		return errors.size();
	}
	
	public int getErrorCount(ErrorType type, Severity severity){
		return (int) stream().filter((error) -> error.getType() == type && error.getSeverity().compareTo(severity) >= 0).count();
	}
	
	/**
	 * add an error to this ErrorReporter. If there are any {@link Consumer}s bound to this {@code ErrorReporter}, these will be triggered.
	 * @param error
	 */
	public void addError(CompilerError error){
		errors.add(error);
		consumers.forEach((consumer) -> consumer.accept(error));
	}
	
	/**
	 * adds a {@link Consumer} to this {@code ErrorReporter}. A consumer will be triggered when a {@link CompilerError} is added.
	 * @param consumer
	 * @return reference to {@code this}, to allow method chaining
	 */
	public ErrorReporter withConsumer(Consumer<CompilerError> consumer){
		consumers.add(consumer);
		return this;
	}
	
	
	/**
	 * removes a {@link Consumer} from this ErrorReporter
	 * @param consumer
	 * @return reference to {@code this}, to allow method chaining
	 */
	public ErrorReporter withoutConsumer(Consumer<CompilerError> consumer){
		consumers.remove(consumer);
		return this;
	}
	
	/**
	 * creates a TypeDelegate of the given type to report an error. This method is a convenience method to generate {@link CompilerError}s.
	 * It is used like this:
	 * <pre>
	 * type({@link ErrorType#SYNTAX}).error("an error occurred");
	 * </pre>
	 * @param type delegate type 
	 * @return
	 */
	public ErrorReporterTypeDelegate type(ErrorType type){
		return new ErrorReporterTypeDelegate(type);
	}
	
	/**
	 * convenience method to create a TypeDelegate for syntax errors
	 * @return
	 * @see ErrorReporter#type(ErrorType)
	 */
	public ErrorReporterTypeDelegate syntax(){
		return type(ErrorType.SYNTAX);
	}
	
	
	/**
	 * convenience method to create a TypeDelegate for contextual errors
	 * @return
	 * @see ErrorReporter#type(ErrorType)
	 */
	public ErrorReporterContextTypeDelegate context(){
		return new ErrorReporterContextTypeDelegate();
	}
	
	/**
	 * convenience method to create a TypeDelegate for semantic errors
	 * @return
	 * @see ErrorReporter#type(ErrorType)
	 */
	public ErrorReporterTypeDelegate codegen(){
		return type(ErrorType.CODEGEN);
	}
	
	/**
	 * returns all created errors as a stream. Can be used to further process the error messages
	 * @return all created errors as a stream
	 */
	public Stream<CompilerError> stream(){
		return errors.stream();
	}
	
	/**
	 * Delegator class that allows reporting errors of certain {@link Severity}. The error type is already given for a delegate.
	 * @author Nicker
	 *
	 */
	public class ErrorReporterTypeDelegate{
		
		/**
		 * errortype this delegate can report
		 */
		private ErrorType type;
		private ErrorReporterTypeDelegate(ErrorType type) {
			this.type = type;
		}
		
		/**
		 * add an error to the {@link ErrorReporter} of the given {@link Severity}.
		 * @param severity Severity of the error
		 * @param message error message
		 */
		public void severity(int line, int charPos, Severity severity, String message){
			addError(new CompilerError(message, severity, type, line, charPos));
		}
		
		/**
		 * add a warning message to the {@link ErrorReporter}
		 * @param message
		 * @see ErrorReporterTypeDelegate#severity(Severity, String)
		 */
		public void warning(Token token, String message){
			warning(token.getLine(), token.getCharPositionInLine(), message);
		}
		
		public void warning(Token token, String format, Object... args){
			warning(token, String.format(format, args));
		}
		
		public void warning(int line, int charPos, String format, Object... args){
			warning(line, charPos, String.format(format, args));
		}
		
		public void warning(int line, int charPos, String message){
			severity(line, charPos, Severity.WARNING, message);
		}
		
		public void warning(ParserRuleContext ctx, String message){
			warning(ctx.start, message);
		}
		
		public void warning(ParserRuleContext ctx, String format, Object... args){
			warning(ctx.start, format, args);
		}
		
		/**
		 * add an error message to the {@link ErrorReporter}
		 * @param message
		 * @see ErrorReporterTypeDelegate#severity(Severity, String)
		 */
		public void error(Token token, String message){
			error(token.getLine(), token.getCharPositionInLine(), message);
		}
		
		public void error(Token token, String format, Object... args){
			error(token, String.format(format, args));
		}
		
		public void error(int line, int charPos, String format, Object... args){
			error(line, charPos, String.format(format, args));
		}
		
		public void error(int line, int charPos, String message){
			severity(line, charPos, Severity.ERROR, message);
		}
		
		public void error(ParserRuleContext ctx, String message){
			error(ctx.start, message);
		}
		
		public void error(ParserRuleContext ctx, String format, Object... args){
			error(ctx.start, format, args);
		}
	}
	
	public class ErrorReporterContextTypeDelegate extends ErrorReporterTypeDelegate{
		public ErrorReporterContextTypeDelegate(){
			super(ErrorType.CONTEXT);
		}
		
		public void warnUnusedVariable(IdEntry entry){
			warning(entry.getDeclarationContext().start, "variable %s is not used", entry.getSpelling());
		}
		
		public void errorBinaryOpType(ParserRuleContext ctx, Object op, Type t1, Type t2){
			error(ctx.start, "cannot apply (%s), expected type: %s, got: %s", op, t1, t2);
		}
		
		public void errorLHSNotIdentifier(ParserRuleContext ctx){
			error(ctx, "Left hand side of assign expression must be an identifier");
		}
		
		public void errorNotIdentifierExpression(ExpressionContext ctx){
			error(ctx, "Expression '%s' is not an identifier", ctx.getText().substring(0, Math.min(ctx.getText().length(), 100)));
		}
		
		public void errorInvalidAssignmentType(ParserRuleContext ctx, Type t1, Type t2){
			error(ctx, "invalid assignment type, expected type: %s, got: %s", t1, t2);
		}
		
		
	}
}
