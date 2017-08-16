import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class testDateFormat {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
	}

}
