package ch07.ex_29_interfacePolymorphism5;

public class A {
	public void methodA() {
		I i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i.toString());
	}
}
