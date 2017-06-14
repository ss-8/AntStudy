package com.aaa.runnable;

public class TestRunnable implements Runnable {
	private int id;
	
	public TestRunnable(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(id);
	}

}
