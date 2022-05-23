package ch07.ex_34_innerClass4;

/**
 * title : 다른 클래스에서 내부 클래스 생성 및 접근
 * 1. 외부 클래스(Outer)가 아닌 다른 클래스(InnerEx4)에서 내부 클래스(InstanceInner)를
 * 생성하고 내부 클래스의 멤버에 접근하는 경우는 발생해서는 안됨 
 *
 */
class Outer{
	class InstanceInner{
		int iv = 100;
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod() {
		class LocalInner{
			int iv = 400;
		}
	}
}

public class InnerEx4 {
	public static void main(String[] args) {
		// 인스턴스 클래스(InstanceInner)의 인스턴스를 생성하려면
		// 외부 클래스(Outer)의 인스턴스를 먼저 생성해야함
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		
		// static 내부 클래스(StaticInner)의 인스턴스는 외부 클래스(Outer)를 먼저 생성하지 않아도됨
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv : " + si.iv);
	}
}
