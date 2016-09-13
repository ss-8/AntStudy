import static org.junit.Assert.*;

import org.junit.Test;

public class testStringBuffer {

	@Test
	public void test() {
		StringBuffer sb=new StringBuffer();
		sb.append("abcdef");
		System.out.println(sb);
		sb.setLength(0);
		System.out.println(sb.toString());
		sb.append("123456");
		System.out.println(sb.toString());
	}

}
