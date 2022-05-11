package ch07.ex_25_interfacePolymorphism;

public class HTMLParser implements Parserable{

	@Override
	public void parse(String fileName) {
		// 구분 문석작업을 수행
		System.out.printf("%s - HTML parsing completed\n", fileName);
	}
}
