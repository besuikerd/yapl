package yapl.codegen;

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
	
	private String propertyName;
	private CodeProperty(String name){
		this.propertyName = name;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
}
