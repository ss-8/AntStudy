import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class testMap {

	@Test
	public void test() {
		Map m=new HashMap();
		m.put(1, "aaa");
		m.put(2, "bbb");
		m.put(3, "ccc");
		m.put(3, "sss");
		System.out.println(m.get(4));
	}

}
