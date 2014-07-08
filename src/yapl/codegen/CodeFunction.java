package yapl.codegen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/**
 * CodeFunction is an enum that represent the different code functions that are executed by the {@link YAPLJVMCodeGenerator}  
 * @author Nicker
 *
 */
public enum CodeFunction{
	 yapl("yapl")
	,declareVariable("declareVar")
	
	
	,assign("assign")
	
	,constant("constant")
	,optrue("optrue")
	,opfalse("opfalse")
	,opId("opId")
	,opExprBlock("opExprBlock")
	,opIfThen("opIfThen")
	,opIfThenElse("opIfThenElse")
	,opWhile("opWhile")
	
	,pop("pop")
	,dup("dup")
	,store("store")
	,print("print")
	,printMultiple("printMultiple")
	
	,read("read")
	,readMultiple("readMultiple")
	
	,add("add")
	,sub("sub")
	,mult("mult")
	,div("div")
	,mod("mod")
	,and("and")
	,or("or")
	,gt("gt")
	,gte("gte")
	,lt("lt")
	,lte("lte")
	,eq("eq")
	,neq("neq")
	,negate("negate")
	,not("not")
	;
	 
	 /**
	  * the StringTemplate name this codefunction is bound to
	  */
	private String functionName;
	
	/**
	 * 
	 * @param name the StringTemplate name this codefunction is bound to
	 */
	private CodeFunction(String name){
		this.functionName = name;
	}
	
	
	/**
	 * getter for the StringTemplate name this codefunction is bound to
	 * @return the StringTemplate name this codefunction is bound to
	 */
	public String getFunctionName() {
		return functionName;
	}
	
	/**
	 * Creates a builder 
	 * @return
	 */
	public Builder builder(){
		return new Builder();
	}
	
	/**
	 * Builds an ST directly without binding any variables
	 * @param group {@link STGroup} to find Code Functions in
	 * @return
	 */
	public ST toST(STGroup group){
		return builder().build(group);
	}
	
	/**
	 * Builds an ST directly by binding the {@link CodeProperty#type} property
	 * @param value {@link CodeProperty#type} value
	 * @param group STGroup to find Code Functions in
	 * @return
	 */
	public ST type(Object value, STGroup group){
		return builder()
		.property(CodeProperty.type, value)
		.build(group);
	}
	
	/**
	 * Builder class that can create StringTemplates for the given code functions. Allows the binding of properties to the codefunction before creating a StringTemplate.
	 * Builder pattern: http://en.wikipedia.org/wiki/Builder_pattern
	 * @author Nicker
	 *
	 */
	public class Builder{
		private List<Property> properties = new ArrayList<Property>();
		
		/**
		 * @throws TemplateNotFoundException whenever the given STGroup does not contain the codefunction that it tries to execute 
		 * @param group {@link STGroup} to find Code Functions in
		 * @return The {@link ST} built with this {@link CodeFunction}
		 */
		public ST build(STGroup group){
			ST st = group.getInstanceOf(getFunctionName());
			if(st != null){
				properties.forEach((property) -> st.add(property.property.getPropertyName(), property.binding));
			} else{
				throw new TemplateNotFoundException(getFunctionName(), properties.stream().map((prop) -> prop.property.getPropertyName()).collect(Collectors.toList()));
			}
			return st;
		}
		
		/**
		 * Adds a property to this Builder for a CodeFunction
		 * @param property Property to bind
		 * @param binding value of the binding
		 * @return
		 */
		public Builder property(CodeProperty property, Object binding){
			properties.add(new Property(property, binding));
			return this;
		}
		
		/**
		 * Model class for a Codeproperty
		 * @author Nicker
		 *
		 */
		private class Property{
			public Property(CodeProperty property, Object binding){
				this.property = property;
				this.binding = binding;
			}
			
			CodeProperty property;
			Object binding;
		}
	}
}