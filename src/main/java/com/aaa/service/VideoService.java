package com.aaa.service;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Service;

public interface VideoService {
	public BufferedImage base64tojpeg(String base64);

	public String jpeg2base64(BufferedImage bi);
	
	public String jpeg2file(BufferedImage bi,String path);
}
