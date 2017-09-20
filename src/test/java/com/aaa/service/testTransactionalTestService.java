package com.aaa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springtest.xml")
public class testTransactionalTestService {
	@Autowired
	private TransactionalTestService tts;

	@Test
	public void test() {
		tts.addTransactionalTest();
	}

}
