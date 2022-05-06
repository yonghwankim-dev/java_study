package ch07.ex_08_super4;

public class PointTest {
	public static void main(String[] args)
	{
		Point3D p3 = new Point3D();
		System.out.printf("p3.x = %d\n", p3.x);
		System.out.printf("p3.y = %d\n", p3.y);
		System.out.printf("p3.z	= %d\n", p3.z);
	}
}

class Point{
	int x = 10;
	int y = 20;
	
	public Point(int x, int y) {
		// super()�� ���������� �����Ϸ��� ���� �ڵ� ���Ե�. Object Ŭ������ ���� ������ ȣ��
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point{
	
	int z = 30;
	
	public Point3D() {
		this(100, 200, 300);
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
}


