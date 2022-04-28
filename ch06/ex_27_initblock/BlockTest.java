package ch06.ex_27_initblock;

/**
 * 초기화 블럭
 * 클래스 초기화 블럭 : 클래스가 메모리에 로딩될때 단 한번만 수행
 * 인스턴스 초기화 블럭 : 객체가 생성될때마다 수행됨
 *
 */
public class BlockTest {
	static 
	{
		System.out.println("static { }");
	}
	
	{
		System.out.println("{ }");
	}
	
	public BlockTest() {
		System.out.println("생성자");
	}
	
	public static void main(String[] args)
	{
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();
		
		System.out.println("BlockTest bt2 = new BlockTest();");
		BlockTest bt2 = new BlockTest();
	}
}
