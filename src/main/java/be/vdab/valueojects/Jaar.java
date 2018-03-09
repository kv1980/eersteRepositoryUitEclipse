package be.vdab.valueojects;

public class Jaar {
	private final int jaar;

	public Jaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean isSchrikkeljaar() {
		return jaar % 800000 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
	}
}
