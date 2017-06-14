package com.aaa.test;

public class SingletonTest {
	public static String instance="aa";
	public static String instance1="aa";
	
	static {
		getInstance();
	}

	public static void getInstance() {
		instance = "ok";
	}

	public static void getInstance1() {
		instance1 = "ok1";
	}
}
