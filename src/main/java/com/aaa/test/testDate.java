package com.aaa.test;

import java.util.Date;

import org.junit.Test;

public class testDate {

	@Test
	public void test() {
		System.out.println(new Date());
		System.out.println(new Date((new Date()).getTime()+300000));
	}

}
