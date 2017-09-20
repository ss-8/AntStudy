import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testList {

	@Test
	public void test() {
		List<String> strList=new ArrayList<String>();
		strList.add("aaa");
		strList.add("aaa");
		strList.add("bbb");
		System.out.println(strList.size());
		for(String str:strList){
			System.out.println(str);
		}
		strList.clear();
		System.out.println(strList.size());
	}

}
