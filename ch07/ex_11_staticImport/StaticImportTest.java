package ch07.ex_11_staticImport;

import static java.lang.System.out;
import static java.lang.Math.*;

/**
 * static import�� ����
 * - static import ����� Ŭ���� �̸� ��������
 * - ���� ��� System.out -> out������ ȣ�Ⱑ��	
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
