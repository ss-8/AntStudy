package com.aaa.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilController {
	@RequestMapping("toopen/{dest}/")
	public String toopen(@PathVariable String dest, Model model) {
		String ss = "";
		Arrays.asList("aaa", "bbb", "ccc").forEach((e1) -> System.out.println(e1));
		model.addAttribute("message", "测试");
		return dest;
	}
}
