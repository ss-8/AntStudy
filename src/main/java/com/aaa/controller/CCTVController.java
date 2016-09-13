package com.aaa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cctv")
public class CCTVController {
	private static String pagePrefix="cctv/";
	private static final Logger logger = LogManager.getLogger(CCTVController.class);
	@RequestMapping("openPage/{dest}/")
	public String toCCTV(@PathVariable String dest, Model model) {
		model.addAttribute("message", "中央电视台");
		logger.info("来了来了");
		return pagePrefix+dest;
	}
}
