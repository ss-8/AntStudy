package com.aaa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.aaa.dao.UserDao;
import com.aaa.entity.User;

@Component
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	private static Logger log=Logger.getLogger(UserDaoImpl.class);
	@Autowired
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		Serializable s=null;
		s=this.getHibernateTemplate().save(user);
		return s.toString();
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		userList=this.getHibernateTemplate().loadAll(User.class);
		return userList;
	}
	
	@Override
	public List<User> getUserById(Integer id) {
		// TODO Auto-generated method stub
		List<User> user=new ArrayList<User>();
		String hql="from com.aaa.entity.User where id=:id";
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query<User> query=session.createQuery(hql,User.class);
		query.setParameter("id", id);
		return null;
	}

}
