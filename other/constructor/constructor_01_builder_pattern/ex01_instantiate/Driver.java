package other.constructor.constructor_01_builder_pattern.ex01_instantiate;

public class Driver {

	public static void main(String[] args) {
		// �� �����ڿ� ��� �ʵ� ����� �����ϸ� ��ü ������ ��� ���ڰ��� � �ʵ����� ��Ÿ������ �����
		// �̷��� ��Ȳ�� �������� �ſ� ������
		Student std1 = new Student(1, "ȫ�浿", null, 20);
		
		System.out.println(std1);
	}
}
