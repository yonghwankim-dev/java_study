package other.code_conventions;

public class Declarations {
	int level;	// �ּ� ����� ���� ������ ���ٿ� �ϳ��� �ϴ� ���� ����
	int size;
	int a,b;	// �̷� ����� ������ ������� ����
	int c, d[];	// �̷� ����� �ٸ� ������ ���� ���ο� �߰��ϴ� ���� ���ؾ���
	
	public Declarations() {
		level = 1;
		size = 2;
		a = 3;
		b = 4;
		c = 5;
		d = new int[size];
	}
	
	public void method1() {
		int a = 1;	// ��������(���� ������ ����)�� ������ �̸��� �����ϹǷ� �̷� ���� ������ �����ؾ���
		int variable =2;
	}
}	
