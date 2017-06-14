import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

public class testFunction {

	@Test
	public void test() {
		List<String> strList=new ArrayList<String>();
		for(int i=0;i<10;i++){
			strList.add(i+"");
		}
		strList.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		
	}
}
