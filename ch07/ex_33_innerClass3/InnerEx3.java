package ch07.ex_33_innerClass3;

/**
 * title : 내부 클래스에서 외부 클래스의 변수 참조 
 * 1. 인스턴스 클래스(InstanceInner)에서 외부 클래스(InnerEx3)의 변수(outerIv, outerCv) 참조
 * - outerIv : 참조가능
 * - outerCv : 참조가능
 * 
 * 2. static 클래스(StaticInner)에서 외부 클래스(InnerEx3)의 변수(outerIv, outerCv) 참조
 * - outerIv : 참조불가능 => static 멤버는 인스턴스 멤버에 접근할 수 없음
 * - outerCv : 참조가능
 * 
 * 3. 지역 클래스(LocalInner)에서 외부 클래스(InnerEx3)의 변수(outerIv, outerCv) 참조
 * - outerIv : 참조가능
 * - outerCv : 참조가능
 * - lv : 참조가능
 * - LV : 참조가능
 */
public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner{
		int iiv = outerIv;	// 외부 클래스(InnerEx3)의 private 멤버도 접근이 가능함
		int iiv2 = outerCv;
	}
	
	static class StaticInner{
		// static 클래스는 외부 클래스(InnerEx3)의 인스턴스 멤버(outerIv)에 접근할 수 없음
//		int siv = outerIv;
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;	// jdk 1.8부터 final 생략 가능
		
		class LocalInner{
			int liv = outerIv;
			int liv2 = outerCv;
			// 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근이 가능함
			int liv3 = lv;	// jdk 1.8부터 에러가 아님
			int liv4 = LV;
		}
	}
}
