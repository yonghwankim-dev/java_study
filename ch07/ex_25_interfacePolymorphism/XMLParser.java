package ch07.ex_25_interfacePolymorphism;

public class XMLParser implements Parserable{

	@Override
	public void parse(String fileName) {
		// ���� �����۾��� ����
		System.out.printf("%s - XML parsing completed\n", fileName);
	}
}
