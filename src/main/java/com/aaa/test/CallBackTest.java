package com.aaa.test;

public class CallBackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caller caller = new Caller();
		caller.setCallInterface(new CallInterface(){

			@Override
			public String callback(String msg) {
				// TODO Auto-generated method stub
				return msg+" world";
			}
			
		});
		caller.doCall("hello");
	}

}
