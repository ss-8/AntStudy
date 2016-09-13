import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class testImgDownload {

	@Test
	public void test() {
		String urlStr = "http://img10.360buyimg.com/imgzone/jfs/t2818/235/189965654/383957/f726894f/570778bcN26d9adbf.jpg";
		int len = 0;
		byte[] bs = new byte[1024];
		try {
			for (int i = 0; i < 100; i++) {
				long firstTime = System.currentTimeMillis();
				URL url = new URL(urlStr);
				URLConnection con = url.openConnection();
				InputStream is = con.getInputStream();
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				while ((len = is.read(bs)) != -1) {
					output.write(bs, 0, len);
				}
				byte[] b = output.toByteArray();
				System.out.println(b.length + "  " + i + "  " + (System.currentTimeMillis() - firstTime));
				output.close();
				is.close();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if (e.getClass().equals(FileNotFoundException.class))
				System.out.println("文件不存在");
			e.printStackTrace();
		}

	}

}
