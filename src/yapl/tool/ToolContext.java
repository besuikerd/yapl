package yapl.tool;

public class ToolContext {
	boolean generateDot = false;
	boolean textual = false;
	boolean run = false;
	boolean assemble = false;
	String dotFile = "";
	String outfile = "main";

	public boolean isGenerateDot() {
		return generateDot;
	}

	public void setGenerateDot(boolean generateDot) {
		this.generateDot = generateDot;
	}

	public String getDotFile() {
		return dotFile;
	}

	public void setDotFile(String dotFile) {
		this.dotFile = dotFile;
	}

	public String getOutfile() {
		return outfile;
	}
	
	public String getOutfileWithoutPath(){
		return getOutfile().replaceAll("[\\.a-zA-Z0-9\\s\\-_]+[/\\\\]", "");
	}

	public void setOutfile(String outfile) {
		this.outfile = outfile;
	}

	public boolean isTextual() {
		return textual;
	}

	public void setTextual(boolean textual) {
		this.textual = textual;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public boolean isAssemble() {
		return assemble;
	}

	public void setAssemble(boolean assemble) {
		this.assemble = assemble;
	}

	@Override
	public String toString() {
		return "ToolContext [generateDot=" + generateDot + ", dotFile="
				+ dotFile + ", outfile=" + outfile + "]";
	}
}
