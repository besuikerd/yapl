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
	
	,left("left")
	,right("right")
	
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
