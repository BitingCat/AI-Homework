package wen.maze;

public class MazePoint {
	private int x;
	//co-ordinate x
	private int y;
	//co-ordinate y
	private int z;
	//right of way the x,y
	private int g;
	//on the distance of the begining point
	private int h;
	private int f;
	private int zz;
	public MazePoint() {}
	public MazePoint(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	public int getZ() {
		return z;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	public int getG() {
		return g;
	}
	
	public void setH(int h) {
		this.h= h;
	}
	public int getH() {
		return h;
	}
	
	public void setF(int f) {
		this.f = f;
	}
	public int getF() {
		return f;
	}
	
	public void setZZ(int zz) {
		this.zz = zz;
	}
	public int getZZ() {
		return zz;
	}
}
