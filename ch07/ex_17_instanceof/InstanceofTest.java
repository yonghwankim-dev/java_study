package ch07.ex_17_instanceof;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car) {
			System.out.println("This is a Car instance");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
		System.out.println(fe.getClass().getName());	// Ŭ���� �̸� ���
	}
}

class Car{
	
}
class FireEngine extends Car{
	
}
