package ch07.ex_02_relationship;

/**
 * Ŭ�������� ���� - ���԰���
 * - Ŭ�������� ���԰���� �� Ŭ������ ��������� �ٸ� Ŭ���� Ÿ���� ���������� �����ϴ� ���� �ǹ���
 * 
 */
public class DrawShape {
	public static void main(String[] args)
	{
		Point[] p = {
						new Point(100, 100),
						new Point(140, 50),
						new Point(200, 100)
					};
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);
		
		t.draw();
		c.draw();
	}
}

class Shape {
	String color = "block";
	public void draw() {
		System.out.printf("[color=%s]\n", color);
	}
}

class Point {
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

/**
 * ���� ������ ����
 * - ��(Circle)�� ��(Point)�� ������ �����Ƿ� Circle Ŭ������ ��������� Point Ŭ������
 * ��Ӻ����� ���� 
 * 
 */
class Circle extends Shape{
	Point center;	// ���� ������ǥ
	int r;			// ������
	
	public Circle() {
		this(new Point(0, 0), 100);
	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	public void draw() {
		System.out.printf("[center=(%d, %d), r=%d, color=%s\n", center.x, center.y, r, color);
	}
}

/**
 * �ﰢ���� �������� ����
 * - �ﰢ���� �����̹Ƿ� ���԰��谡 �ƴ϶� ��Ӱ������� �� �� ����
 */
class Triangle extends Shape{
	Point[] p = new Point[3];

	public Triangle(Point[] p) {
		this.p = p;
	}
	public void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]\n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}	
}