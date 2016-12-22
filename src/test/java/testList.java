import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testList {

	@Test
	public void test() {
		List<String> strList=new ArrayList<String>();
		for(int i=0;i<10;i++){
			strList.add("aa"+i);
		}
		for(String s:strList){
			System.out.println(s);
		}
		strList.clear();
		System.out.println(strList.size());
	}

}
