package com.aaa.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import com.aaa.dao.UserDao;
import com.aaa.entity.User;
import com.aaa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger log=Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;

	@Override
	public String addUser(String username, String password) {
		String id = "";
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setCreateDate(new Date());
		id = userDao.addUser(user);
		log.info("addid:"+id);
		return id;
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
