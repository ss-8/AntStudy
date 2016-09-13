package com.aaa.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.TransactionalTest1Dao;
import com.aaa.dao.TransactionalTest2Dao;
import com.aaa.entity.TransactionalTest1;
import com.aaa.entity.TransactionalTest2;
import com.aaa.service.TransactionalTestService;

@Service
@Transactional
public class TransactionalTestServiceImpl implements TransactionalTestService {
	private static final Logger log=LogManager.getLogger(TransactionalTestServiceImpl.class);
	
	@Resource
	private TransactionalTest1Dao transactionalTest1Dao;
	@Resource
	private TransactionalTest2Dao transactionalTest2Dao;

	@Override
	public void addTransactionalTest() {
		// TODO Auto-generated method stub
		transactionalTest2Dao.addTransactionalTest2(new TransactionalTest2("aaaa111"));
		transactionalTest1Dao.addTransactionalTest1(new TransactionalTest1("aaaaaaa"));
		try {
			throw new Exception("错啦错啦");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaa");
	}
}
