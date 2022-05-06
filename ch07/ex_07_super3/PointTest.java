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
		// 생성자 첫줄에 super() 생성자 호출을 하지 않으면 컴파일러가 자동으로 삽입함
		// super() 호출시 부모 클래스 생성자 Point()를 호출함
		// 부모 클래스에 공백 생성자가 아닌 다른 생성자를 정의시 컴파일러 에러가 발생함
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getLocation() {
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
	
}


