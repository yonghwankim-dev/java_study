package other.code_conventions;

public class Statements {
	public Statements() {
		/* �� �ٿ��� �ִ� �ϳ��� ��ɹ����� �����Ǿ�� ��*/
		int a = 1;
		a++;	// ���� ���
		a--;	// ���� ���
		a++; a--;	// ���� ���� ���
	}
	
	// return ������ ��ȯ ���� ��Ȯ�ϰ� ������ �ʴ� �� ��ȣ ����� ������
	public void returnMethod1() {
		// return someMethod1(arg1, arg2)	�������� ����
		return;
	}
	
	public int returnMethod2() {
		int[] arr = new int[4];
		return arr.length;
	}
	
	public int returnMethod3() {
		int[] arr = new int[4];
		return (arr.length == 4 ? arr.length : 4);	// ��Ȯ�ϹǷ� ������
	}
}
