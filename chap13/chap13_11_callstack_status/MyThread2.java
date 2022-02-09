package chap13.chap13_11_callstack_status;

import java.util.Iterator;
import java.util.Map;

public class MyThread2 extends Thread{

	public MyThread2(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		Map map = getAllStackTraces();
		Iterator it = map.keySet().iterator();
		
		int x = 0;
		while(it.hasNext())
		{
			Object obj = it.next();
			Thread t = (Thread) obj;
			StackTraceElement[] ste = (StackTraceElement[]) map.get(obj);
			
			++x;
			System.out.printf("[%d] name : %s, group : %s, daemon : %s \n" ,
					x, t.getName(), t.getThreadGroup().getName(), t.isDaemon() ? "true" : "false");
			
			for(int i=0;i<ste.length;i++)
			{
				System.out.println(ste[i]);
			}
			System.out.println();
		}
	}

}
