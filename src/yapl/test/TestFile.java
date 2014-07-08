package yapl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFile {
	private File file;
	private String input;
	private String output;
	private String programName;
	
	private static final String PROGRAM_NAME = "programname";
	private static final String IN = "in";
	private static final String OUT = "out";
	
	public TestFile(File file) {
		this.file = file;
	}
	
	public TestFile(String path){
		this(new File(path));
	}
	
	public void read() throws IOException{
		Scanner scanner = new Scanner(new FileInputStream(programName));
		boolean read = false;
		
		String nextBlockType = nextBlockType(scanner);
		if(nextBlockType != null){
			switch(nextBlockType){
			
			case PROGRAM_NAME:
				
				break;
			case IN:
				input = parseBlock(scanner);
				break;
			case OUT:
				output = parseBlock(scanner);
				break;
			}
		}
		
		
	}
	
	private String previousLine;
	
	private String nextBlockType(Scanner in){
		previousLine = in.nextLine();
		Matcher matcher = Pattern.compile("^\\s*(\\w+)\\s*:").matcher(previousLine);
		String result = null;
		if(matcher.find()){
			result = matcher.group();
		}
		return result;
	}
	
	private boolean parseProgramName(Scanner scanner){
		boolean success = false;
		Matcher programNameMatcher= Pattern.compile("^\\s*programname\\s*:\\s*(\\w+)").matcher(scanner.nextLine());
		if(programNameMatcher.find()){
			this.programName = programNameMatcher.group();
			success = true;
		}
		return success;
	}
	
	private String parseBlock(Scanner scanner){
		StringBuilder builder = new StringBuilder();
		while(!isBlockEnd() && scanner.hasNext()){
			builder.append(previousLine);
			previousLine = scanner.nextLine();
		}
		return builder.toString();
	}
	
	
	
	private boolean isBlockEnd(){
		return Pattern.compile("^\\s*(programname|in|out)\\s*:)").matcher(previousLine).find();
	}
}
