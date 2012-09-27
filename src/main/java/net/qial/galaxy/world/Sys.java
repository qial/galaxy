package net.qial.galaxy.world;

import net.qial.galaxy.elite.Elite;
import net.qial.galaxy.engine.SeededObject;

public class Sys extends SeededObject {
	private String commodities;
	private String government;
	private String economy;
	private String name;
	
	public Sys(String seed) {
		super(seed);
		init();
	}

	@Override
	protected void initValues() {
		commodities = Elite.COMMODITIES[getNextValue(Elite.COMMODITIES.length)];
		government = Elite.GOVNAMES[getNextValue(Elite.GOVNAMES.length)];
		economy = Elite.ECONNAMES[getNextValue(Elite.ECONNAMES.length)];
		
		// simple name making thing
		int p1 = getNextValue(Elite.PAIRS.length()/2);
		int p2 = getNextValue(Elite.PAIRS.length()/2);
		int p3 = getNextValue(Elite.PAIRS.length()/2);
		StringBuilder sb = new StringBuilder();
		sb.append(Elite.PAIRS.substring(p1,p1+2));
		sb.append(Elite.PAIRS.substring(p2,p2+2));
		sb.append(Elite.PAIRS.substring(p3,p3+2));
		name = sb.toString().replace('.', ' ');
	}
	
	public String toString() {
		return name+", "+government+", "+economy+", "+commodities;
	}
}
