package ch06.ex_13_callByRef4;

/**
 * call by value 예제
 */
public class Driver {

	/**
	 * 배열의 모든 요소를 출력 
	 * @param arr
	 */
	public static void printArr(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
	
	/**
	 * 배열의 모든 요소의 합을 구함
	 * @param arr
	 * @return 배열의 모든 요소의 합계
	 */
	public static int sumArr(int[] arr)
	{
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		return sum;
	}
	
	/**
	 * 배열을 오름차순으로 정렬
	 * @param arr
	 */
	public static void sortArr(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {50, 40, 30, 20, 10};
		
		printArr(arr);
		System.out.printf("sum = %d\n",sumArr(arr));
		sortArr(arr);
		printArr(arr);	
	}
}
