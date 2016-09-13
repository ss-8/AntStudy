import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class testBAYI {

	@Test
	public void test() {
		String num = "1980106280";
		String[] nar = num.split("|");
		int s = 0;
		for (String a : nar) {
			s = s + Integer.parseInt(a);
		}
		System.out.println(s % 80);
		File file = new File("E:\\myfile\\81.txt");
		InputStreamReader read = null;
		if (file.exists() && file.isFile()) {
			try {
				read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = "";
				int c=0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					c++;
					if(c==s%80)
					System.out.println(lineTxt);
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
		}
	}

}
