import org.junit.Test;

import com.aaa.service.impl.ImageCheckImpl;

public class testImageCheck {

	@Test
	public void test() {
		String path="D:\\Develop\\file_face\\aaa.jpg";
		//path="http://img13.360buyimg.com/n8/jfs/t2677/20/3562494987/137842/1f2c53ed/5791e352N914a0643.jpg";
		ImageCheckImpl ici=new ImageCheckImpl();
		long s=System.currentTimeMillis();
		int irgb=ici.checkBackground(path);
		Integer[] rgb=convertARGBToRGB(irgb);
		System.out.println(System.currentTimeMillis()-s);
		for(int i=0;i<rgb.length;i++)
			System.out.println(rgb[i]);
	}

	final Integer[] convertARGBToRGB(int ARGB) {
		Integer[] rgb = new Integer[3];
		rgb[0] = (ARGB & 0xff0000) >> 16;
		rgb[1] = (ARGB & 0xff00) >> 8;
		rgb[2] = (ARGB & 0xff);
		return rgb;
	}
}
