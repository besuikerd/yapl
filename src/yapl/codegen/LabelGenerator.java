package yapl.codegen;

public class LabelGenerator {
	private int offset;
	private StringBuilder builder;
	private String prefix;
	
	public LabelGenerator(int offset, String prefix) {
		this.offset = offset;
		builder = new StringBuilder(prefix + offset);
		this.prefix = prefix;
	}
	
	public String generate(){
		increment();
		return builder.toString();
	}
	
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
