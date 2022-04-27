package ch06.ex_22_varArgs;

/**
 * 가변인자와 오버로딩
 * - 형식 예제 : printf(String format, Object... args)
 * - 가변인자 부분에 배열도 들어갈 수 있음
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
	
	// 두 오버로딩 메서드가 구분이 되지 않음
//	public static String concatenate(String... args)
//	{
//		return concatenate("", args);
//	}
}
