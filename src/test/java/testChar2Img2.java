import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.junit.Test;

public class testChar2Img2 {

	@Test
	public void test() throws IOException {
		String imgPath = "D:\\myfile\\Work\\javamaven3\\MagicEye\\imgFile\\11.jpg";
		String filePath = "D:\\myfile\\Work\\javamaven3\\MagicEye\\imgFile\\aa\\";
		File file = new File(filePath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		FileInputStream fis = null;
		ImageInputStream iis = null;
		try {
			// 背景图大图
			fis = new FileInputStream(imgPath);
			String suffix = imgPath.substring(imgPath.lastIndexOf(".") + 1);
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(suffix);
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = null;
			rect = new Rectangle(0, 0, reader.getWidth(reader.getMinIndex()), reader.getHeight(reader.getMinIndex()));
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			// 要输出的字符
			String chars = "一二三";
			String[] charArr = chars.split("|");
			Integer fileNum = 0;
			for (String str : charArr) {
				// 将文字输出至图片缓存
				int font_size = 160;
				BufferedImage bi2 = new BufferedImage(font_size * 3, font_size * 3, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi2.createGraphics();
				g2.setBackground(Color.WHITE);
				g2.clearRect(0, 0, font_size * 3, font_size * 3);
				Font font = new Font("华文行楷", Font.BOLD, font_size);
				g2.setColor(Color.BLACK);
				g2.setFont(font);
				g2.drawString(str, 0, font_size);
				// 查看文字像素大小
				int h1 = 0;
				int h2 = 0;
				int w1 = 0;
				int w2 = 0;
				int char_height = 0;
				int char_width = 0;
				// width
				for (int x = 0; x < bi2.getWidth(); x++) {
					for (int y = 0; y < bi2.getHeight(); y++) {
						if (bi2.getRGB(x, y) != -1) {
							w1 = x;
							break;
						}
					}
					if (w1 != 0)
						break;
				}
				for (int x = bi2.getWidth() - 1; x > 0; x--) {
					for (int y = bi2.getHeight() - 1; y > 0; y--) {
						if (bi2.getRGB(x, y) != -1) {
							w2 = x;
							break;
						}
					}
					if (w2 != 0)
						break;
				}
				// hight
				for (int y = 0; y < bi2.getHeight(); y++) {
					for (int x = 0; x < bi2.getWidth(); x++) {
						if (bi2.getRGB(x, y) != -1) {
							h1 = y;
							break;
						}
					}
					if (h1 != 0)
						break;
				}
				for (int y = bi2.getHeight() - 1; y > 0; y--) {
					for (int x = bi2.getWidth() - 1; x > 0; x--) {
						if (bi2.getRGB(x, y) != -1) {
							h2 = y;
							break;
						}
					}
					if (h2 != 0)
						break;
				}
				char_height = h2 - h1;
				char_width = w2 - w1;
				// 随机按文字像素大小读取背景
				int space = 10;// 边界留白
				Random r = new Random();
				int random_height = r.nextInt((bi.getHeight() - (bi.getHeight() % char_height + space)) / (char_height + space));
				int random_width = r.nextInt((bi.getWidth() - (bi.getWidth() % char_width + space)) / (char_width + space));
				BufferedImage bi1 = new BufferedImage(char_width + space, char_height + space, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = bi1.createGraphics();
				g.setBackground(Color.WHITE);
				g.clearRect(0, 0, char_width + space, char_height + space);
				for (int y = random_height * (char_height + space); y < char_height + space + random_height * (char_height + space); y++) {
					for (int x = random_width * (char_width + space); x < char_width + space + random_width * (char_width + space); x++) {
						Color c = new Color(bi.getRGB(x, y));
						g.setColor(c);
						g.drawRect(x - random_width * (char_width + space), y - random_height * (char_height + space), 0, 0);
					}
				}

				// 将文字输出到背景上
				Integer[] rgb = new Integer[3];
				int addrgb = 180;
				for (int y = h1; y <= h2; y++) {
					for (int x = w1; x <= w2; x++) {
						if (bi2.getRGB(x, y) != -1) {
							rgb = convertARGBToRGB(bi1.getRGB(x - w1, y - h1));
							if (rgb[0] + addrgb > 255) {
								rgb[0] = 255;
							} else {
								rgb[0] = rgb[0] + addrgb;
							}
							if (rgb[1] + addrgb > 255) {
								rgb[1] = 255;
							} else {
								rgb[1] = rgb[1] + addrgb;
							}
							if (rgb[2] + addrgb > 255) {
								rgb[2] = 255;
							} else {
								rgb[2] = rgb[2] + addrgb;
							}
							Color c = new Color(rgb[0], rgb[1], rgb[2], 255);
							g.setColor(c);
							g.drawRect(x - w1 + space / 2, y - h1 + space / 2, 0, 0);
						}
					}
				}
				System.out.println(h1 + "," + h2 + "," + w1 + "," + w2);
				ImageIO.write(bi1, "png", new File(filePath + fileNum + ".png"));
				fileNum++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Integer[] convertARGBToRGB(int ARGB) {
		Integer[] rgb = new Integer[3];
		rgb[0] = (ARGB & 0xff0000) >> 16;
		rgb[1] = (ARGB & 0xff00) >> 8;
		rgb[2] = (ARGB & 0xff);
		return rgb;

	}
}
