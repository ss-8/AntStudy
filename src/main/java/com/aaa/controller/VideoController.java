package com.aaa.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaa.service.VideoService;

@Controller
public class VideoController {
	private static String pagePrefix = "video/";

	@Resource
	private VideoService videoService;

	@RequestMapping(value = "openVideo/{dest}/")
	public String openVideo(@PathVariable String dest) {
		return pagePrefix + dest;
	}

	@RequestMapping(value = "renderPic/", method = RequestMethod.POST)
	public void renderPic(@RequestParam String base64code, PrintWriter printWriter, HttpServletRequest request) {
		System.out.println(request.getServletContext().getRealPath(File.separator));
		BufferedImage bi = videoService.base64tojpeg(base64code);
		String base64encode = videoService.jpeg2base64(bi);
		String path = request.getServletContext().getRealPath(File.separator) + File.separator + "videoimage" + File.separator;
		String imagePath = videoService.jpeg2file(bi, path);
		System.out.println(imagePath);
		// printWriter.write(base64encode);//使用base64编码显示
		printWriter.write("videoimage/" + imagePath);
	}
}
