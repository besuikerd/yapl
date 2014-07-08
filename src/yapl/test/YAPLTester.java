package yapl.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import yapl.tool.ClassFunctionException;
import yapl.tool.ExecutionException;
import yapl.tool.MainRunner;

public class YAPLTester {
	
	private String location;
	private List<TestFile> testFiles;
	
	private OutputStream out;
	
	public YAPLTester(String location, List<TestFile> testFiles, OutputStream out) {
		this.location = location;
		this.testFiles = testFiles;
		this.out = out;
	}

	public YAPLTester(String location, List<TestFile> testFiles){
		this(location, testFiles, System.out);
	}
	
	public YAPLTester(String location) {
		this(location, new ArrayList<TestFile>());
	}
	
	public void addFile(TestFile file){
		testFiles.add(file);
	}
	
	
	
	public void run(){
		PrintStream out = new PrintStream(this.out);
		out.printf("starting %d tests\n...", testFiles.size());
		int errors = 0;
		MainRunner runner = MainRunner.getInstance();
		try {
			runner.addToClassPath(location);
		} catch (MalformedURLException e) {
			PrintStream oldOut = System.out;
			System.setOut(out);
			e.printStackTrace();
			System.setOut(oldOut);
		}
		for(TestFile file : testFiles){
			InputStream oldIn = System.in;
			PrintStream oldOut = System.out;
			ByteArrayOutputStream bOut = new ByteArrayOutputStream();
			try{
				System.setIn(new ByteArrayInputStream(file.getInput().getBytes()));
				System.setOut(new PrintStream(bOut));
				runner.tryMain(file.getProgramName());
				
				if(!bOut.toString().equals(file.getOutput())){
					out.println("error while testing " + file.getProgramName());
					out.println("expected output:");
					out.println("--------");
					out.print(file.getOutput());
					out.println("--------");
					out.println("got output:");
					out.println("--------");
					out.println(bOut.toString());
					out.println("--------");
				} else{
					out.printf("test %s succeeded\n", file.getProgramName());
				}
				
				
			} catch(ClassFunctionException e){
				out.println(e.getMessage());
			} catch(ExecutionException e){
				PrintStream oldOut2 = System.out;
				out.println("error during execution");
				out.println("====BEGIN STACKTRACE====");
				System.setOut(out);
				e.printStackTrace();
				System.setOut(oldOut2);
				out.println("====END   STACKTRACE====");
			} finally{
				System.setIn(oldIn);
				System.setOut(oldOut);
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		YAPLTester tester = new YAPLTester("..\\..\\..\\eclipse-vb\\Yapl\\out");
		tester.addFile(new TestFile("syntax_correct.test"));
		tester.run();
	}
}
