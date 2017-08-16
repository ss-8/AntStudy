import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class testLog4j2 {
	private static Logger log=LogManager.getLogger(testLog4j2.class);
	@Test
	public void test() {
		log.info("Not yet implemented");
		log.error("ss");
	}

}
