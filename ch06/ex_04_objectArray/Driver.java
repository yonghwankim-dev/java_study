package ch06.ex_04_objectArray;

/**
 * ��ü �迭�� ������������ �ϳ��� ���� ���������迭
 * ������ ���ҿ� ���ؼ� ��ü�� �����Ͽ����� 
 */
public class Driver {

	public static void main(String[] args) {
		// ��ü �迭 ����
		TV[] tvArr = new TV[3];
		
		// ��ü �迭�� ������ ���ҿ� ��ü ����
		for(int i = 0; i < 3; i++)
		{
			tvArr[i] = new TV();
			tvArr[i].channel = i+10;
		}
		
		// ��ü �迭�� ������ ������ �޼��� ����
		for(int i = 0; i < 3; i++)
		{
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel = %d\n", i,tvArr[i].channel);
		}
		
	}

}
