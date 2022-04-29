package ch07.ex_02_relationship;

public class Circle extends Shape{
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
