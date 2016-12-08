package com.aaa.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.aaa.service.ImageCheck;

public class ImageCheckImpl implements ImageCheck {

	@Override
	public int checkBackground(String imagePath) {
		Map<Integer, Integer> rv = new HashMap<Integer, Integer>();
		try {
			BufferedImage bi = ImageIO.read(new File(imagePath));
			//BufferedImage bi = ImageIO.read(new URL(imagePath));
			Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
			for (int y = 0; y < bi.getHeight(); y++) {
				for (int x = 0; x < bi.getWidth() - 10; x++) {
					// sumColor=
					int color = bi.getRGB(x, y);
					if (colorMap.get(color) != null) {
						int total = colorMap.get(color);
						colorMap.put(color, total + 1);
					} else {
						colorMap.put(color, 1);
					}
				}
			}
			rv.put(2, 0);// 缓存颜色最多的像素数
			colorMap.forEach((k, v) -> {
				if (v.intValue() > rv.get(2)) {
					rv.put(2, v.intValue());
					rv.put(1, k.intValue());// 存像素数最多的颜色
				}
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rv.get(1);
	}
}
