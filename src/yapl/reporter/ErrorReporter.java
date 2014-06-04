package yapl.reporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ErrorReporter {
	private List<CompilerError> errors;
	private Set<Consumer<CompilerError>> consumers;
	
	public ErrorReporter(){
		this.errors = new ArrayList<CompilerError>();
		this.consumers = new HashSet<Consumer<CompilerError>>();
	}
	
	public int getErrorCount(){
		return errors.size();
	}
	
	public void addError(CompilerError error){
		errors.add(error);
		consumers.forEach((consumer) -> consumer.accept(error));
	}
	
	public ErrorReporter withConsumer(Consumer<CompilerError> consumer){
		consumers.add(consumer);
		return this;
	}
	
	public ErrorReporter withoutConsumer(Consumer<CompilerError> consumer){
		consumers.remove(consumer);
		return this;
	}
	
	public ErrorReporterTypeDelegate type(ErrorType type){
		return new ErrorReporterTypeDelegate(type);
	}
	
	public ErrorReporterTypeDelegate syntax(){
		return type(ErrorType.SYNTAX);
	}
	
	public ErrorReporterTypeDelegate context(){
		return type(ErrorType.CONTEXT);
	}
	
	public ErrorReporterTypeDelegate semantic(){
		return type(ErrorType.SEMANTIC);
	}
	
	public Stream<CompilerError> stream(){
		return errors.stream();
	}
	
	public class ErrorReporterTypeDelegate{
		private ErrorType type;
		private ErrorReporterTypeDelegate(ErrorType type) {
			this.type = type;
		}
		
		public void severity(Severity severity, String message){
			addError(new CompilerError(message, severity, type));
		}
		
		public void warning(String message){
			severity(Severity.WARNING, message);
		}
		
		public void error(String message){
			severity(Severity.ERROR, message);
		}
	} 
}
