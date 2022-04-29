package ch07.ex_02_relationship;

public class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0, 0);
	}
	public String getXY() {
		return "("+x+","+y+")";
	}
}
