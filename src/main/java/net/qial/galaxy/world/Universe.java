package net.qial.galaxy.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universe {
	private List<ObjLoc> systems;
	
	public Universe() {
		systems = new ArrayList<ObjLoc>();
	}
	
	public void generateSystems(int width, int height, int num) {
		Random r = new Random();
		for(int i = 0; i < num; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			
			Sys newSys = new Sys(x+","+y);
			systems.add(new ObjLoc(x,y,newSys));
		}
	}
	
	public List<ObjLoc> getSystems() {
		return systems;
	}
	
	public void setSystems(List<ObjLoc> systems) {
		this.systems = systems;
	}
}
