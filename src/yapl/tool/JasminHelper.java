package yapl.tool;

import jas.jasError;
import jasmin.ClassFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Helper class for the Jasmin assembler that allows saving assembled files to
 * a given location
 * @author Nicker
 *
 */
public class JasminHelper {
	
	/**
	 * attempts to assemble a jvm assembly file and write it to a file
	 * @param in input jvm assembly file
	 * @param out ouput file to write the jvm bytecode to
	 * @return whether assembly succeeded or not
	 * @throws IOException whenever an IO exception occurs while reading/writing
	 */
	public boolean assembleToFile(String in, String out) throws IOException {
		ClassFile classFile = new ClassFile();
		File inFile = new File(in);
		File outFile = new File(out);
		boolean success = false;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
			try{
				classFile.readJasmin(reader, inFile.getName(), false);
			}finally{
				reader.close();
			}

			// if we got some errors, don't output a file - just return.
			if (classFile.errorCount() > 0) {
				System.err.println(in + ": Found " + classFile.errorCount()
						+ " errors");
			} else {
				OutputStream os = new FileOutputStream(out);
				try {
					outFile = new File(out).getAbsoluteFile();
					if (!outFile.getParentFile().exists()) {
						outFile.getParentFile().mkdirs();
					}
					classFile.write(os);
				} finally {
					os.close();
				}
				success = true;
			}
		} catch (jasError e) {
			System.out.println("JAS Error: " + e.getMessage());

			if (classFile.errorCount() > 0) {
				System.err.println(in + ": Found " + classFile.errorCount()
						+ " errors");
			}
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println("Jasmin generated an error: " + e);
		}
		return success;
	}
}
