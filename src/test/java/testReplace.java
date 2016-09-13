import static org.junit.Assert.*;

import org.junit.Test;

public class testReplace {

	@Test
	public void test() {
		String url="http://img10.360buyimg.local/imgzone/jfs/t1216/162/214133081/92767/cdb64d58/550cd637N41a5bf5c.jpg";
		url=url.replaceFirst(".local", ".com");
		System.out.println(url);
	}

}
