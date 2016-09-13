package com.aaa.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.aaa.service.VideoService;

import net.iharder.Base64;

@Service
public class VideoServiceImpl implements VideoService {

	@Override
	public BufferedImage base64tojpeg(String base64) {
		// TODO Auto-generated method stub
		BufferedImage bi = null;
		try {
			byte[] imgByteArray = Base64.decode(base64.split(",")[1]);
			ByteArrayInputStream in = new ByteArrayInputStream(imgByteArray);
			bi = ImageIO.read(in);
			Graphics2D g2d = bi.createGraphics();
			Font myFont = new Font("宋体", Font.PLAIN, 12);
			g2d.setColor(Color.RED);
			g2d.setFont(myFont);
			g2d.drawString("渲染后", 5, 15);
			g2d.drawString("刘巍", 265, 40);
			g2d.drawString("male", 265, 60);
			g2d.drawString("13", 265, 80);
			g2d.drawRect(220, 30, 40, 50);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
	}

	@Override
	public String jpeg2base64(BufferedImage bi) {
		// TODO Auto-generated method stub
		String base64code = "";
		ByteArrayOutputStream outArray = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "jpeg", outArray);
			base64code = Base64.encodeBytes(outArray.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(base64code);
		return base64code;
	}

	@Override
	public String jpeg2file(BufferedImage bi, String path) {
		// TODO Auto-generated method stub
		File f = new File(path);
		if (!f.exists() || !f.isDirectory()) {
			f.mkdirs();
		}
		String fileName = UUID.randomUUID().toString() + ".jpg";
		try {
			ImageIO.write(bi, "jpeg", new File(path + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyThread mt=new MyThread(path+fileName);
		mt.start();
		return fileName;
	}

	public class MyThread extends Thread {
		private String filePath;

		public MyThread(String filePath) {
			super();
			this.filePath = filePath;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File f = new File(filePath);
			if (f.exists() && f.isFile()) {
				f.delete();
			}
		}
	}

}
