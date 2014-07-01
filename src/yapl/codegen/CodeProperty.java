package yapl.codegen;

public enum CodeProperty {
	 statements("statements")
	,name("name")
	,type("type")
	,num("num")
	,index("index")
	,expression("expression")
	
	,left("left")
	,right("right")
	
	,labelto("lto")
	,labelto2("lto2")
	,labelgoto("lgoto")
	;
	
	private String propertyName;
	private CodeProperty(String name){
		this.propertyName = name;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
}
