package ch06.ex_19_staticMethod;


/**
 * Ŭ���� �޼���� �ν��Ͻ� �޼���
 * 
 * Ŭ���� �޼��� : static �޼���
 * �ν��Ͻ� �޼��� : static x
 */
public class Driver {
		
	public static void main(String[] args) {
		// Ŭ���� �޼��� ȣ��
		System.out.println(MyMath.add(3, 5));
		System.out.println(MyMath.subtract(3, 5));
		System.out.println(MyMath.multiply(3, 5));
		System.out.println(MyMath.divide(3, 5));
		
		// �ν��Ͻ� �޼��� ȣ��
		MyMath mm = new MyMath();
		
		mm.a = 3;
		mm.b = 5;
		
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
	}
}
