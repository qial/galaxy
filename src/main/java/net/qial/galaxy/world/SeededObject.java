package net.qial.galaxy.world;

public abstract class SeededObject {
	private String seed;
	private byte[] bytes;
	private int idx = 0;
	public SeededObject(String seed) {
		this.seed = seed;
	}
	public void init() {
		initSeedBytes();
		initValues();
	}
	protected abstract void initValues();
	protected void initSeedBytes() {
		bytes = SeedUtil.getBytes(seed);
	}
	protected int getNextValue() {
		int val = (int)bytes[idx];
		val += 128;
		idx++;
		return val;
	}
	protected int getNextValue(int mod) {
		return getNextValue()%mod;
	}
}
