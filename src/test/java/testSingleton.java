import org.junit.Test;

import com.aaa.test.SingletonTest;

public class testSingleton {

	@Test
	public void test() {
		System.out.println(SingletonTest.instance);
		System.out.println(SingletonTest.instance1);
		SingletonTest.getInstance1();
		System.out.println(SingletonTest.instance1);
	}

}
