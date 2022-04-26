package ch06.ex_20_memberCall;

public class MemberCall {
	int iv = 10;		// 인스턴스 변수
	static int cv = 20;	// 클래스 변수
	
	int iv2 = cv;
//	static int cv2 = iv;	// 에러, 클래스변수는 인스턴수 변수를 사용할 수 없음
	static int cv2 = new MemberCall().iv;	// 객체를 생성후에 사용할 수 있음
	
	public static void staticMethod1()
	{
		System.out.println(cv);
//		System.out.println(iv);	// 에러, 클래스메서드에서 인스턴스 변수 사용불가
		MemberCall c= new MemberCall();
		System.out.println(c.iv);	// 객체를 생성한후에 사용 가능
	}
	
	public void instanceMethod1() 
	{
		System.out.println(cv);
		System.out.println(iv);	// 인스턴스 메서드에서는 인스턴스변수 사용가능
	}
	
	public static void staticMethod2()
	{
		staticMethod1();
//		instanceMethod1();	// 에러, 클래스메서드에서는 인스턴스 메서드 호출 불가능
		MemberCall c = new MemberCall();
		c.instanceMethod1(); // 객체를 생성한 후에 호출 가능함
	}
	
	public void instanceMethod2()
	{
		staticMethod1();	// 인스턴스 메서드는 클래스 메서드 호출 가능
		instanceMethod1();	// 인스턴스 메서드는 인스턴스 메서드 호출 가능
	}
	
}
