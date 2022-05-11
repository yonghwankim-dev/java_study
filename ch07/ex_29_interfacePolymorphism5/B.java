package ch07.ex_29_interfacePolymorphism5;

public class B implements I{

	@Override
	public void methodB() {
		System.out.println("methodB in B class");
	}

	@Override
	public String toString() {
		return "class B";
	}

	
}
