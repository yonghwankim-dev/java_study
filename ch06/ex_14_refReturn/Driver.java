package ch06.ex_14_refReturn;


/**
 * 참조형 반환타입
 * 반환타입이 참조형이라면 메서드가 객체의 주소를 반환한다는 것을 의미함
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
