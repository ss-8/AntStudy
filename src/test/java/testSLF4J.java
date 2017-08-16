import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testSLF4J {

	private static Logger log=LoggerFactory.getLogger(testSLF4J.class);
	

	@Test
	public void test() {
		log.info("log {1,2} info {}","aa");
		Boolean b=new Boolean("true");
		System.out.println(b);
		
		Map<String,String> mss=new HashMap<String,String>();
		mss.put("aa", "aa");
		System.out.println();
	}
}
