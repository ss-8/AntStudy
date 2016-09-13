package com.aaa.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testTransactionalTestService {

	@Test
	public void test() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		TransactionalTestService tts=cxt.getBean(TransactionalTestService.class);
		tts.addTransactionalTest();
	}

}
