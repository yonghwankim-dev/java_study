package ch07.ex_07_super3;

public class PointTest {
	public static void main(String[] args)
	{
		Point3D p3 = new Point3D(1, 2, 3);
	}
}

class Point{
	int x, y;

	public Point() {
	
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}

class Point3D extends Point{
	
	int z;

	public Point3D(int x, int y, int z) {
		// ������ ù�ٿ� super() ������ ȣ���� ���� ������ �����Ϸ��� �ڵ����� ������
		// super() ȣ��� �θ� Ŭ���� ������ Point()�� ȣ����
		// �θ� Ŭ������ ���� �����ڰ� �ƴ� �ٸ� �����ڸ� ���ǽ� �����Ϸ� ������ �߻���
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getLocation() {
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
	
}


