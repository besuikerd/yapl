package yapl.codegen;

/**
 * CodeProperty is an enum that represents a property that can be bound to a 
 * {@link CodeFunction}. It is used in the {@link CodeFunction.Builder} class to
 * bind values to properties
 * @author Nicker
 *
 */
public enum CodeProperty {
	 statements("statements")
	,name("name")
	,type("type")
	,offset("offset")
	,num("num")
	,index("index")
	,expression("expression")
	,constant("constant")
	,function("function")
	,expressions_types("expressions_types")
	,popmaybe("popmaybe")
	,body("body")
	
	,conditional("conditional")
	,exprTrue("exprTrue")
	,exprFalse("exprFalse")
	
	
	,left("left")
	,right("right")
	
	,tuples("tuples")
	
	,labelto("lto")
	,labelto2("lto2")
	,labelgoto("lgoto")
	
	,labelgenerator("labelgen")
	
	;
	
	/**
	 * name of the property bound
	 */
	private String propertyName;
	private CodeProperty(String name){
		this.propertyName = name;
	}
	
	/**
	 * Getter for the name of this property
	 * @return the name of this property
	 */
	public String getPropertyName() {
		return propertyName;
	}
}
