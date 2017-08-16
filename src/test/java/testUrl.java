import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.junit.Test;

public class testUrl {

	@Test
	public void test() throws MalformedURLException {
		URL url=new URL("http://img10.360buyimg.local/imgzone/jfs/t6445/229/1920864380/189890/bf10dd7a/595a68f3N918c8c10.jpg");
		System.out.println(url.getPath());
		System.out.println(url.getAuthority());
		System.out.println(new Random().nextInt());
	}
}
