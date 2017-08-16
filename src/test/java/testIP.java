import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class testIP {

	@Test
	public void test() {
		InetAddress ia=null;
		try {
			ia=ia.getLocalHost();
			System.out.println(ia.getHostName());
			System.out.println(ia.getByName(ia.getHostName()).getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
