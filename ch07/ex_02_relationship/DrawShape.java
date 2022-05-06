package ch07.ex_02_relationship;

/**
 * 클래스간의 관계 - 포함관계
 * - 클래스간의 포함관계란 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 의미함
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
 * 점과 원과의 관계
 * - 원(Circle)은 점(Point)을 가지고 있으므로 Circle 클래스의 멤버변수로 Point 클래스를
 * 멤머변수를 가짐 
 * 
 */
class Circle extends Shape{
	Point center;	// 원의 원점좌표
	int r;			// 반지름
	
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
 * 삼각형과 도형과의 관계
 * - 삼각형은 도형이므로 포함관계가 아니라 상속관계임을 알 수 있음
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