package ch07.ex_11_staticImport;

import static java.lang.System.out;
import static java.lang.Math.*;

/**
 * static import문 선언
 * - static import 선언시 클래스 이름 생략가능
 * - 예를 들어 System.out -> out만으로 호출가능	
 */
public class StaticImportTest {
	public static void main(String[] args)
	{
		//System.out.println(Math.random());
		out.println(random());
		
		//System.out.println("Math.PI : " + Math.PI);
		out.println("Math.PI : " + PI);
	}
}
