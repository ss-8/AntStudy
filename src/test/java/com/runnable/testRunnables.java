package com.runnable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.aaa.runnable.TestRunnable;

public class testRunnables {
	private static Logger logger=LogManager.getLogger(testRunnables.class);

	@Test
	public void test() {
		System.out.println("bbb");
		new Thread(){
			public void run(){
				logger.info("aaa");
			}
		}.start();
		System.out.println("ccc");
		new Thread(new TestRunnable(11)).start();
	}

}
