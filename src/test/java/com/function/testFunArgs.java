package com.function;

import org.junit.Test;
/**
 * 可变参数
 * @author aaa
 *
 */
public class testFunArgs {

	@Test
	public void test() {
		moreArgument("aaa","bbb","ccc");
	}
	
	public void moreArgument(String... strings){
		for(String str:strings){
			System.out.println(str);
		}
	}

}
