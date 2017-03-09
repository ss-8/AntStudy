import static org.junit.Assert.*;

import org.junit.Test;

public class testCpu {

	@Test
	public void test() {
		//System.out.println(Runtime.getRuntime().availableProcessors());
		long s=System.currentTimeMillis();
		System.out.println(Math.sqrt(20));
		System.out.println(System.currentTimeMillis()-s);
	}

}
