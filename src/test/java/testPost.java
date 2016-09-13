import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.junit.Test;

public class testPost {

	@Test
	public void test() {
		String base64code="";
		File file = new File("D:\\9base64.txt");
		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(file), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt="";
			while ((lineTxt = bufferedReader.readLine()) != null) {
				base64code=lineTxt;
				if(base64code.length()<5)
					return;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(base64code);
		String sTotalString;
		try {
			URL url = new URL("http://vision.jd.com/videort/searchWare.action");  
			URLConnection connection = url.openConnection();  
			connection.setDoOutput(true);  
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");  
			out.write("base64code="+base64code); // 向页面传递数据。post的关键所在！  
			out.flush();  
			out.close();  
			// 一旦发送成功，用以下方法就可以得到服务器的回应：  
			String sCurrentLine;  
			sCurrentLine = "";  
			sTotalString = "";  
			InputStream l_urlStream;  
			l_urlStream = connection.getInputStream();  
			// 传说中的三层包装阿！  
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(  
			        l_urlStream));  
			while ((sCurrentLine = l_reader.readLine()) != null) {  
			    sTotalString += sCurrentLine + "\r\n";  
  
			}
			System.out.println(sTotalString);  
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
