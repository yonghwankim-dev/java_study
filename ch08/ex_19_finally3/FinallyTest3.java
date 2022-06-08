package ch08.ex_19_finally3;

/**
 * title : finally ���� ���� �帧
 * - try-catch-finally �������� ���ܰ� �߻����� �ʰ� try ������ �κ��� return ���� ȣ���Ͽ�
 * ȣ���ߴ� �޼���� ���ư����� �Ҷ� ���ư������� finally ���� ���� �����մϴ�.
 * - try ���� �������� return���� �������� �����帧
 * try->return�� ȣ��->finally �� ���� -> return�� ����
 */
public class FinallyTest3 {

	public static void main(String[] args) {
		method1();
		System.out.println("main �޼��尡 ����Ǿ����ϴ�.");
	}
	static void method1() {
		try {
			System.out.println("method1()�� ȣ��Ǿ����ϴ�.");
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("method1()�� finally ���� ����Ǿ����ϴ�.");
		}
	}
}
