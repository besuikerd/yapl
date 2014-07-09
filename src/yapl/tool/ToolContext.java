package yapl.tool;

/**
 * Context the compiler {@link Tool} is being run in. This defines certain
 * settings that are applied
 * @author Nicker
 *
 */
public class ToolContext {
	
	/**
	 * should the tool generate a dot file? (not implemented yet)
	 */
	boolean generateDot = false;
	
	/**
	 * output a textual representation to the std out?
	 */
	boolean textual = false;
	
	/**
	 * should the compiled program be run after compiling?
	 */
	boolean run = false;
	
	/**
	 * should the compiled program be assembled?
	 */
	boolean assemble = false;
	
	/**
	 * dotfile to write to (not implemented yet)
	 */
	String dotFile = "";
	
	/**
	 * outfile to write the bytecode to
	 */
	String outfile = "main";

	/**
	 * getter for generate dot option
	 * @return
	 */
	public boolean isGenerateDot() {
		return generateDot;
	}

	/**
	 * setter for generate dot option
	 * @param generateDot
	 */
	public void setGenerateDot(boolean generateDot) {
		this.generateDot = generateDot;
	}

	/**
	 * getter for the dotfile to generate to 
	 * @return
	 */
	public String getDotFile() {
		return dotFile;
	}

	/**
	 * setter for the dotfile to generate to
	 * @param dotFile
	 */
	public void setDotFile(String dotFile) {
		this.dotFile = dotFile;
	}

	/**
	 * getter for the outfile to write the jvm bytecode to
	 * @return
	 */
	public String getOutfile() {
		return outfile;
	}
	
	/**
	 * retrieves only the name of the file to write the jvm bytecode to,
	 * without the preceding path
	 * @return
	 */
	public String getOutfileWithoutPath(){
		return getOutfile().replaceAll("[\\.a-zA-Z0-9\\s\\-_]+[/\\\\]", "");
	}

	/**
	 * setter for the outfile to write the jvm bytecode to
	 * @param outfile
	 */
	public void setOutfile(String outfile) {
		this.outfile = outfile;
	}

	/**
	 * getter for if textual AST should be printed out
	 * @return
	 */
	public boolean isTextual() {
		return textual;
	}

	/**
	 * setter for if textual AST should be printed out
	 * @param textual
	 */
	public void setTextual(boolean textual) {
		this.textual = textual;
	}

	/**
	 * getter for if compiled class should be run
	 * @return
	 */
	public boolean isRun() {
		return run;
	}

	/**
	 * setter for if compiled class should be run
	 * @param run
	 */
	public void setRun(boolean run) {
		this.run = run;
	}

	/**
	 * getter for if class should be assembled
	 * @return
	 */
	public boolean isAssemble() {
		return assemble;
	}

	/**
	 * setter for if class should be assembled
	 * @param assemble
	 */
	public void setAssemble(boolean assemble) {
		this.assemble = assemble;
	}

	@Override
	public String toString() {
		return "ToolContext [generateDot=" + generateDot + ", dotFile="
				+ dotFile + ", outfile=" + outfile + "]";
	}
}
