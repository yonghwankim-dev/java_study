package other.constructor.constructor_01_builder_pattern.ex03_javabean_pattern;

public class Driver {

	public static void main(String[] args) {
		
		// �ڹٺ� ����
		// ��ü�� �����ϰ� ���� setter �޼��带 ���ؼ� ������
		// �������� ������ ���� �ʱ� ������ �����ڸ� ���� ������ �ʿ䰡 ����
		// ������ �ѹ��� ������ ȣ��� ������ ���� ������ �ϰ����� ���� �� ����
		// �׸��� ������ �ʴ� immutable�� ��ü�� ������ �� ����
		Student std1 = new Student();
		
		std1.setStdno(1);
		std1.setName("ȫ�浿");
		std1.setDept("��ǻ�Ͱ��а�");
		std1.setAge(20);
		
		System.out.println(std1);

	}
}
