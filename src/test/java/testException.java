import org.junit.Test;

import com.aaa.exception.AntException;
import com.aaa.service.impl.TestException;

public class testException {

	@Test
	public void test() {
		TestException te=new TestException();
		try {
			te.testE();
		} catch (AntException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
