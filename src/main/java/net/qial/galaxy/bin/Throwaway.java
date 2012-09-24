package net.qial.galaxy.bin;

import net.qial.galaxy.world.*;

public class Throwaway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testworld();
	}
	
	public static void testworld() {
		String id = "0:10";
		StarSys sys = new StarSys(id);
		sys.init();
		System.out.println(sys);
		
	}

}
