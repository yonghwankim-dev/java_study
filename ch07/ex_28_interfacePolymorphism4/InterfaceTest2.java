package ch07.ex_28_interfacePolymorphism4;

public class InterfaceTest2 {
	public static void main(String[] args) {
		A a = new A();
		a.autoplay(new B()); // void autoplay(I i) ȣ��
		a.autoplay(new C()); // void autoplay(I i) ȣ��
		
	}
}
