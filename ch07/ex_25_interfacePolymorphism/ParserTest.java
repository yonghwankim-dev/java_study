package ch07.ex_25_interfacePolymorphism;

public class ParserTest {

	public static void main(String[] args) {
		Parserable parser = ParserManager.getParser("XML");
		parser.parse("document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.xml");
	}

}
