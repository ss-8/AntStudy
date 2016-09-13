package com.aaa.service;

import java.util.List;

import com.aaa.entity.User;

public interface UserService {
	public String addUser(String username, String password);

	public List<User> getUserList();
}
