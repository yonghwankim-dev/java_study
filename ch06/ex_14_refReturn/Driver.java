package ch06.ex_14_refReturn;


/**
 * ������ ��ȯŸ��
 * ��ȯŸ���� �������̶�� �޼��尡 ��ü�� �ּҸ� ��ȯ�Ѵٴ� ���� �ǹ���
 */
public class Driver {

	public static Data copy(Data d)
	{
		Data tmp = new Data();
		tmp.x = d.x;
		return tmp;
	}
	
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		
		Data d2 = copy(d);
		System.out.printf("d.x = %d\n",d.x);
		System.out.printf("d2.x = %d\n",d2.x);
	}
}
