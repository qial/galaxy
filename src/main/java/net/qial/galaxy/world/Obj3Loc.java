package net.qial.galaxy.world;

public class Obj3Loc {
	private SeededObject obj;
	private int x;
	private int y;
	private int z;
	public Obj3Loc(int x, int y, int z, SeededObject obj) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int get(Dim d) {
		if(d == Dim.X) {
			return x;
		}
		else if(d == Dim.Y) {
			return y;
		}
		else if(d == Dim.Z) {
			return z;
		}
		return 0;
	}
}
