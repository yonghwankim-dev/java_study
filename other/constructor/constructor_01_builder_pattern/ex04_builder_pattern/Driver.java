package other.constructor.constructor_01_builder_pattern.ex04_builder_pattern;

public class Driver {

	public static void main(String[] args) {
		// builder ����
		// ������ ������ ���ϰ� �ڹٺ� ������ ������ ������ ����
		// ���ο� ��ü�� �ʿ��� ������ ���� �����ϱ� ���� �ʼ� ���� ������ �����Ͽ�
		// builder ��ü�� ���� �� ���� ��ü�� ���ǵ� �޼��带 ȣ���ؼ� ��ü�� ������
		Student std1 = new Student.Builder(1)
									.name("ȫ�浿")
									.dept("��ǻ�Ͱ��а�")
									.age(20)
									.build();
		
		System.out.println(std1);
							
	}

}
