import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class testDownloadList {

	@Test
	public void test() {
		String path = "E:\\mytemp\\imgurl.txt";
		File file = new File(path);
		String encoding = "GB2312";
		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt = null;
			Integer rowNum = 0;
			Integer cn = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				URL url = new URL("https://img14.360buyimg.com/n8/" + lineTxt.split(",")[0]);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 设置超时间为3秒
				conn.setConnectTimeout(3 * 1000);
				// 防止屏蔽程序抓取而返回403错误
				conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				InputStream is=conn.getErrorStream();
				if(is!=null){
					System.out.println(is);
				}
				// 得到输入流
				InputStream inputStream = conn.getInputStream();
				// 获取自己数组
				byte[] buffer = new byte[1024];
				int len = 0;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((len = inputStream.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				bos.close();
				byte[] getData = bos.toByteArray();
				System.out.println(getData.length);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
