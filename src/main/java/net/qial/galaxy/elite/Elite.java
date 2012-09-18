package net.qial.galaxy.elite;

import java.util.Random;

public class Elite {
	public static final String[] COMMODITIES = {
		"Food","Textiles","Radioactives","Slaves","Liquor/Wines","Luxuries",
		"Narcotics","Computers","Machinery","Alloys","Firearms","Furs",
		"Minerals","Gold","Platinum","Gem-Stones","Alien Items"
	};
	
	public static final String[] GOVNAMES = {
		"Anarchy","Feudal","Multi-gov","Dictatorship","Communist",
		"Confederacy","Democracy","Corporate State"
	};
	
	public static final String[] ECONNAMES = {
		"Rich Ind","Average Ind","Poor Ind","Mainly Ind",
		"Mainly Agri","Rich Agri","Average Agri","Poor Agri"
	};
	
	public static final String PAIRS0 = "ABOUSEITILETSTONLONUTHNO";
	
	public static final String PAIRS = "..LEXEGEZACEBISOUSESARMAINDIREA.ERATENBERALAVETIEDORQUANTEISRION";
	
	public static final String[] UNITNAMES = {"t","kg","g"}; 
	
	private int lastrand;
	
	private Random rand;
	
	public int myrand() {
		return rand.nextInt();
	}
	
	public char randbyte() {
		return (char)rand.nextInt(256);
	}
	
	public void mysrand(int seed) {
		srand(seed);
		lastrand = seed-1;
	}
	
	class FastSeedType {
		int a,b,c,d;
		public FastSeedType(int a,int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	
	class SeedType {
		int w0,w1,w2;
		public SeedType(int a,b,c) {
			this.w0 = a;
			this.w1 = b;
			this.w2 = c;
		}
	}
	
	class Plansys {
		int x,y,economy,govtype,techlev,population,productivity,radius;
		String name;
		FastSeedType goatsoupseed;
	}
}
