import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testThreadStop {

	@Test
	public void test() {
		List<Thread> tList=new ArrayList<Thread>();
		for(int i=0;i>10;i++){
		Thread t=new Thread(new TS());
		t.start();
		tList.add(t);
		}
		for(Thread t:tList){
			if(t.getState()==Thread.State.TERMINATED){
				tList.remove(t);
				System.out.println("aa");
			}
				
		}
	}

	public class TS implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("aa");
		}
	}
}
