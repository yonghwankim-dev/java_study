package ch07.ex_14_singleton;

final class Singleton{
	private static Singleton s = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(s == null)
		{
			return new Singleton();
		}
		return s;
	}
}

public class SingletonTest {
	public static void main(String[] args)
	{
//		Singleton s = new Singleton();	// error, 공백생성자의 접근제어자가 private
		Singleton s = Singleton.getInstance();
	}
}
