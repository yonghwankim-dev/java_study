package ch06.ex_22_varArgs;

public class Driver {
	public static void main(String[] args)
	{
		String[] strArr = {"100", "200", "300"};
		
		System.out.println(VarArgs.concatenate("", "100", "200", "300"));
		System.out.println(VarArgs.concatenate("-", strArr));
		System.out.println(VarArgs.concatenate(",", new String[] {"1", "2", "3"}));
		System.out.println("[" + VarArgs.concatenate(",", new String[0]) + "]");
		System.out.println("[" + VarArgs.concatenate(",") + "]");
	}
}
