package yapl.reporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.antlr.v4.runtime.Token;

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
	public ErrorReporterTypeDelegate context(){
		return type(ErrorType.CONTEXT);
	}
	
	/**
	 * convenience method to create a TypeDelegate for semantic errors
	 * @return
	 * @see ErrorReporter#type(ErrorType)
	 */
	public ErrorReporterTypeDelegate semantic(){
		return type(ErrorType.SEMANTIC);
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
		public void severity(Token token, Severity severity, String message){
			addError(new CompilerError(message, severity, type, token.getLine(), token.getCharPositionInLine()));
		}
		
		/**
		 * add a warning message to the {@link ErrorReporter}
		 * @param message
		 * @see ErrorReporterTypeDelegate#severity(Severity, String)
		 */
		public void warning(Token token, String message){
			severity(token, Severity.WARNING, message);
		}
		
		public void warning(Token token, String format, Object... args){
			warning(token, String.format(format, args));
		}
		
		/**
		 * add an error message to the {@link ErrorReporter}
		 * @param message
		 * @see ErrorReporterTypeDelegate#severity(Severity, String)
		 */
		public void error(Token token, String message){
			severity(token, Severity.ERROR, message);
		}
		
		public void error(Token token, String format, Object... args){
			error(token, String.format(format, args));
		}
	} 
}
