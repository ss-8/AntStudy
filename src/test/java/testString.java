import static org.junit.Assert.*;

import org.junit.Test;

public class testString {

	@Test
	public void test() {
		String aaa="bb";
		for(String b:aaa.split(",")){
			System.out.println(b);
		}
		
		String aa="jfs/t4705/15/1463547084/87004/7036afdf/58df287bNcd7139ea.jpg";
		System.out.println(aa.toLowerCase());
		
		String str=null;
		str=String.format("%s-%s-%s %s:%s:00", "2017","02","11","12","12");
		System.out.println(str);
		
		String s="aabbccdd    ";
		System.out.println(s.indexOf("ee"));
		
		StringBuilder sensitive = new StringBuilder();
		System.out.println(sensitive.length());
	}

}
