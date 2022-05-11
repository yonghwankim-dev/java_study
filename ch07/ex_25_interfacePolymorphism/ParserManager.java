package ch07.ex_25_interfacePolymorphism;

public class ParserManager {
	// 리턴타입이 Parserable 인터페이스
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
