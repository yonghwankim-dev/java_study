package ch08.ex_14_exception14;


/**
 * title : ���� �߻� ó�� ��� (�ڱ⸦ ȣ���� �޼���� �����Ͽ� ���� ó��)
 * - �޼��忡 ���ܸ� �����ϰ� ���ܰ� �߻��ϸ� �ڱ⸦ ȣ���� �޼���� ���ܸ� ������
 * - ���޹��� �Ǵٸ� �޼���� ����ó���� �� �� �ְ� �߻� ��ǵ� �� �� ����
 */
public class ExceptionEx14 {
	public static void main(String[] args){
		
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main�޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	static void method1() throws Exception{
		throw new Exception();
	}
	
	
}
