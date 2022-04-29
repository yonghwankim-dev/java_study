package ch07.ex_04_singleInheritance;

public class Driver {
	public static void main(String[] args)
	{
		TVCR tvcr = new TVCR();
		
		tvcr.play();
		tvcr.stop();
		tvcr.rew();
		tvcr.ff();
		
	}
}
