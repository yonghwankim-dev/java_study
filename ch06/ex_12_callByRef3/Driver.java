package ch06.ex_12_callByRef3;

/**
 * 반환값이 없는 callbyref 방법
 * 참조형 매개변수를 활용하면 반환값이 없어도 return문을 사용하지 않아도
 * 같은 결과를 얻을 수 있음
 */
public class Driver {
	
	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static void add(int a, int b, int[] result)
	{
		result[0] = a + b;
	}
	
	public static void main(String[] args) {
		Driver r = new Driver();
		
		int result = r.add(3, 5);
		System.out.printf("r.add(3,5) = %d\n", result);
		
		int[] result2 = {0};
		r.add(3, 5, result2);
		System.out.printf("r.add(3,5,result) = %d\n", result2[0]);
		
			
	}
}
