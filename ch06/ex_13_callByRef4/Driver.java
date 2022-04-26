package ch06.ex_13_callByRef4;

/**
 * call by value ����
 */
public class Driver {

	/**
	 * �迭�� ��� ��Ҹ� ��� 
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
	 * �迭�� ��� ����� ���� ����
	 * @param arr
	 * @return �迭�� ��� ����� �հ�
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
	 * �迭�� ������������ ����
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
