package yapl.codegen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public enum CodeFunction{
	 yapl("yapl")
	,declareVariable("declareVar")
	
	
	,assign("assign")
	
	,constant("constant")
	,optrue("optrue")
	,opfalse("opfalse")
	,opId("opId")
	,opExprBlock("opExprBlock")
	,opIfThenElse("opIfThenElse")
	,opWhile("opWhile")
	
	,pop("pop")
	
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
	private String functionName;
	private CodeFunction(String name){
		this.functionName = name;
	}
	
	public String getFunctionName() {
		return functionName;
	}
	
	public Builder builder(){
		return new Builder();
	}
	
	public ST toST(STGroup group){
		return builder().build(group);
	}
	
	public ST type(Object value, STGroup group){
		return builder()
		.property(CodeProperty.type, value)
		.build(group);
	}
	
	public class Builder{
		private List<Property> properties = new ArrayList<Property>();
		
		/**
		 * @throws TemplateNotFoundException whenever the given STGroup does not contain the codefunction that it tries to execute 
		 * @param group
		 * @return
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
		
		public Builder property(CodeProperty property, Object binding){
			properties.add(new Property(property, binding));
			return this;
		}
		
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