package com.aaa.controller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaa.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private Properties configs;
	@Resource
	private UserService userService;

	@RequestMapping("openPage/{dest}/")
	public String openPage(@PathVariable String dest) {

		String m = configs.getProperty("conf.TEMPORARY_STORE_DIR").toString();
		System.out.println(m);
		return dest;
	}

	@PostMapping(value = "Add/")
	public String addUser(@RequestParam String username, @RequestParam String password, Model model) {
		String id = "";
		id = userService.addUser(username, password);
		model.addAttribute("message", id);
		return "message";
	}

	@RequestMapping("List/{dest}/")
	public String userList(@PathVariable String dest, Model model) {
		model.addAttribute("userList", userService.getUserList());
		return dest;
	}
}
