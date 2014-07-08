package yapl.codegen;

/**
 * Generator for unique labels. Labels are generated as with a prefix and starts
 * with a certain offset. Labels are generated as numbers with a radix of 36.
 * @author Nicker
 *
 */
public class LabelGenerator {
	
	/**
	 * current offset to generate a label with
	 */
	private int offset;
	
	/**
	 * Buffers the current label
	 */
	private StringBuilder builder;
	
	/**
	 * label prefix for this generator
	 */
	private String prefix;
	
	/**
	 * Creates a LabelGenerator that starts at the given offset and generates
	 * labels with the given prefix
	 * @param offset offset to start generating at
	 * @param prefix prefix in front of the label
	 */
	public LabelGenerator(int offset, String prefix) {
		this.offset = offset;
		builder = new StringBuilder(prefix + offset);
		this.prefix = prefix;
	}
	
	/**
	 * generates a label and increments the offset
	 * @return the generates label
	 */
	public String generate(){
		increment();
		return builder.toString();
	}
	
	/**
	 * increments the generator and updates the buffer to reflect the new label
	 */
	private void increment(){
		String intString = Integer.toString(offset, 36);
		builder.replace(prefix.length(), prefix.length() + intString.length(), intString);
		offset++;
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
}
