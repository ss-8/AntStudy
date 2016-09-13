package com.aaa.dao;

import java.util.List;

import com.aaa.entity.User;

public interface UserDao {
	public String addUser(User user);

	public List<User> getUserList();
}
