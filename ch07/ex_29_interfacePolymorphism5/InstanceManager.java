package ch07.ex_29_interfacePolymorphism5;

public class InstanceManager {
	public static I getInstance() {
		return new B();
	}
}
