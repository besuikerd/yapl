package yapl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

public class TestFile {
	private File file;
	private String input;
	private String output;
	private String programName;

	private static final String PROGRAM_NAME = "programfile";
	private static final String IN = "in";
	private static final String OUT = "out";

	public TestFile(File file) {
		this.file = file;
	}

	public TestFile(String path) {
		this(new File(path));
	}

	public String getProgramName() {
		return programName;
	}

	public String getOutput() {
		return output;
	}

	public String getInput() {
		return input;
	}

	public void read() throws IOException {
		Scanner scanner = new Scanner(new FileInputStream(file));
		if(previousLine == null){
			previousLine = scanner.nextLine();
		}
		while (scanner.hasNext()) {
			String nextBlockType = nextBlockType(scanner);
			if (nextBlockType != null) {
				switch (nextBlockType) {
				case PROGRAM_NAME:
					programName = previousLine;
					previousLine = scanner.nextLine();
					break;
				case IN:
					input = parseBlock(scanner);
					break;
				case OUT:
					output = parseBlock(scanner);
					break;
				default:
					throw new RuntimeException("unknown command: " + nextBlockType);
				}
			}
		}
	}

	private String previousLine;

	private String nextBlockType(Scanner in) {
		Matcher matcher = Pattern.compile("^\\s*(\\w+)\\s*:\\s*(\\w*)")
				.matcher(previousLine);
		String result = null;
		if (matcher.find()) {
			result = matcher.group(1);
			if (result.equals(PROGRAM_NAME)) {
				previousLine = matcher.group(2);
			}
		}
		return result;
	}

	private String parseBlock(Scanner scanner) {
		StringBuilder builder = new StringBuilder();
		previousLine = scanner.nextLine();
		while (!isBlockEnd() && scanner.hasNext()) {
			builder.append(previousLine);
			builder.append('\n');
			previousLine = scanner.nextLine();
		}
		return builder.toString();
	}

	private boolean isBlockEnd() {
		return Pattern.compile("^\\s*(programname|in|out)\\s*:")
				.matcher(previousLine).find();
	}

}
