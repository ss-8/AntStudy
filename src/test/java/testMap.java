import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

public class testMap {

	public void test() {
		Map m = new HashMap();
		m.put(1, "aaa");
		m.put(2, "bbb");
		m.put(3, "ccc");
		m.put(3, "sss");
		System.out.println(m.get(4));
	}

	@Test
	public void test1() {
		Long s=System.currentTimeMillis();
		Map<String, Integer> m = new HashMap<String, Integer>();
		Random r = new Random();
		for (int i = 0; i < 500000; i++) {
			String key = UUID.randomUUID().toString().substring(0, 1);
			Integer v = m.get(key);
			if (v != null) {
				v++;
				m.put(key, v);
			} else {
				m.put(key, 1);
			}
		}
		Integer a=0;
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
			a=a+entry.getValue();
		}
		System.out.println(a);
		System.out.println(System.currentTimeMillis()-s);
	}

}
