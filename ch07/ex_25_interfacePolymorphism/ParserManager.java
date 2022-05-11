package ch07.ex_25_interfacePolymorphism;

public class ParserManager {
	// ����Ÿ���� Parserable �������̽�
	public static Parserable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		}
		else if(type.equals("HTML")) {
			return new HTMLParser();
		}
		return null;
	}
}
