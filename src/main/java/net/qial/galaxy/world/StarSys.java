package net.qial.galaxy.world;

public class StarSys {
	private String id;
	private byte[] hash;
	
	private String commodities;
	private String government;
	private String economy;
	
	private int initIdx = 0;
	
	public StarSys(String id) {
		this.id = id;
	}
	
	public void init() {

		this.hash = SeedUtil.getSeedFor(id);
		
	}
	
	private int getNext() {
		return 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SysId:'").append(id).append("', ").append(hash);
		//sb.append("\n\t");
		return sb.toString();
	}
}
