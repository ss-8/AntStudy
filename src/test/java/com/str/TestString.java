package com.str;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestString {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String aa="aaaaAAA式样";
		System.out.println(aa.toLowerCase());
		System.out.println(aa);
		
		String bb=new String("Duplicate entry '0006fa4e-b967-4f77-ae39-ab9edbd9586e' for key 'PRIMARY'");
		System.out.println(bb.indexOf("Duplicate"));
	}

}
