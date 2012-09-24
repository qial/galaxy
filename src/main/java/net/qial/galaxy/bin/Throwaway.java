package net.qial.galaxy.bin;


import net.qial.galaxy.world.*;


public class Throwaway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testworld();
		buildworld();
		//testseeds();
	}
	
	public static void testworld() {
		String id = "0:10";
		StarSys sys = new StarSys(id);
		sys.init();
		System.out.println(sys);
	}
	
	public static void buildworld() {
		String seed = "world12345";
		Sys sys = new Sys(seed);
		System.out.println(sys);
	}
	
	public static void testseeds() {

		int min = 1000000;
		int max = -1000000;
		
		for(int i = 0; i < 1000; i++) {
			String seed = ""+i;
			int[] arr = SeedUtil.getSeeds(seed);
			for(int k = 0; k < arr.length; k++) {
				if(arr[k] > max) max = (int)arr[k];
				if(arr[k] < min) min = (int)arr[k];
			}
		}
		System.out.println("min: "+min+" max: "+max);
	}

}
