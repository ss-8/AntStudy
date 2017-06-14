package com.aaa.test;

public class Caller {
	private CallInterface callInterface;

	public void doCall(String msg) {
		System.out.println(callInterface.callback(msg));
	}

	public void setCallInterface(CallInterface callInterface) {
		this.callInterface = callInterface;
	}
}
