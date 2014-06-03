package yapl.context;

public class IdEntry {
	private int level;

	public IdEntry(int level) {
		this.level = level;
	}
	
	public IdEntry() {
		this(-1);
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}
