package ch06.ex_22_varArgs;

/**
 * �������ڿ� �����ε�
 * - ���� ���� : printf(String format, Object... args)
 * - �������� �κп� �迭�� �� �� ����
 *
 */
public class VarArgs {
	public static String concatenate(String dlim, String... args) {
		String result = "";
		
		for(String str : args)
		{
			result += str;
		}
		
		return result;
	}
	
	// �� �����ε� �޼��尡 ������ ���� ����
//	public static String concatenate(String... args)
//	{
//		return concatenate("", args);
//	}
}
