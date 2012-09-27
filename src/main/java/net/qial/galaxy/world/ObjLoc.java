package net.qial.galaxy.world;

import net.qial.galaxy.engine.Dim;
import net.qial.galaxy.engine.SeededObject;

public class ObjLoc {
	private SeededObject obj;
	private int x;
	private int y;
	public ObjLoc(int x, int y, SeededObject obj) {
		this.x = x;
		this.y = y;
		this.obj = obj;
	}
	public SeededObject getObj() {
		return obj;
	}
	public void setObj(SeededObject obj) {
		this.obj = obj;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int get(Dim d) {
		if(d == Dim.X) {
			return x;
		}
		else if(d == Dim.Y) {
			return y;
		}
		return 0;
	}
}
