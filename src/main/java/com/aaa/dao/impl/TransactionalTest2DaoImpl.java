package com.aaa.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.aaa.dao.TransactionalTest2Dao;
import com.aaa.entity.TransactionalTest2;

@Component
public class TransactionalTest2DaoImpl extends HibernateDaoSupport implements TransactionalTest2Dao {

	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String addTransactionalTest2(TransactionalTest2 transactionalTest2) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().save(transactionalTest2).toString();

	}

}
