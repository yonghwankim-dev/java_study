package ch07.ex_25_interfacePolymorphism;

public class HTMLParser implements Parserable{

	@Override
	public void parse(String fileName) {
		// ���� �����۾��� ����
		System.out.printf("%s - HTML parsing completed\n", fileName);
	}
}
