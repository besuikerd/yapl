package yapl.tool;

public class ToolContext {
	boolean generateDot = false;
	boolean textual = false;
	String dotFile = "";
	String outfile = "obj.lang";

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

	public void setOutfile(String outfile) {
		this.outfile = outfile;
	}
	
	

	public boolean isTextual() {
		return textual;
	}

	public void setTextual(boolean textual) {
		this.textual = textual;
	}

	@Override
	public String toString() {
		return "ToolContext [generateDot=" + generateDot + ", dotFile="
				+ dotFile + ", outfile=" + outfile + "]";
	}
}
