import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class testDownloadByte {

	@Test
	public void test() {
		String urlStr="https://img20.360buyimg.com/vc/jfs/t3811/189/2614024324/302602/87060566/58636946N49a234f4.jpg";
		try {
			URL url = new URL(urlStr);    
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
			        //设置超时间为3秒  
			conn.setConnectTimeout(3*1000);  
			//防止屏蔽程序抓取而返回403错误  
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
			System.out.println(conn.getErrorStream());
			//得到输入流  
			InputStream inputStream = conn.getInputStream();    
			//获取自己数组  
			byte[] buffer = new byte[1024];    
			int len = 0;    
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while((len = inputStream.read(buffer)) != -1) {
			    bos.write(buffer, 0, len);    
			}
			bos.close();    
			byte[] getData = bos.toByteArray();
			System.out.println(getData.length);
			//转base64
			Base64 base64 = new Base64();
			String fileb64=base64.encodeAsString(getData);
			System.out.println(fileb64);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public void test1(){
		String urlStr="https://img14.360buyimg.com/n8/jfs/t1207/147/604748602/124635/2f027c4b/5535e1abN0a6b329a.jpg";
		System.out.println(urlStr.lastIndexOf("."));
	}
	
	public void rfile(){
		
	}

}
