package com.aaa.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.aaa.dao.TransactionalTest1Dao;
import com.aaa.entity.TransactionalTest1;

@Component
public class TransactionalTest1DaoImpl extends HibernateDaoSupport implements TransactionalTest1Dao {

	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String addTransactionalTest1(TransactionalTest1 transactionalTest1) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().save(transactionalTest1).toString();
	}

}
