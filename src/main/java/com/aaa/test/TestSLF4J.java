package com.aaa.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSLF4J {
	private static Logger log=LoggerFactory.getLogger(TestSLF4J.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("Not yet implemented");
		System.out.println("logger impl:"+log.getClass().getName());  
	}
}
