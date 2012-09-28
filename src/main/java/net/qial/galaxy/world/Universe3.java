package net.qial.galaxy.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universe3 {
	private List<Obj3Loc> systems;
	
	public Universe3() {
		systems = new ArrayList<Obj3Loc>();
	}
	
	public void generateSystems(int cube, int num) {
		Random r = new Random();
		for(int i = 0; i < num; i++) {
			int x = r.nextInt(cube);
			int y = r.nextInt(cube/2);
			int z = r.nextInt(cube/4);
			
			Sys newSys = new Sys(x+","+y+","+z);
			systems.add(new Obj3Loc(x,y,z,newSys));
		}
	}
	
	public List<Obj3Loc> getSystems() {
		return systems;
	}
	
	public void setSystems(List<Obj3Loc> systems) {
		this.systems = systems;
	}
}
