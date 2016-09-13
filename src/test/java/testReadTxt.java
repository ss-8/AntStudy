import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class testReadTxt {

	@Test
	public void test() {
		File f=new File("E:\\temp\\黄图标注\\高危_主图_cv标注用\\porn_gaowei_zhutu_full.txt");
		String encoding = "GB2312";

		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(f), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt = null;
			int rowNum = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				rowNum++;
			}
			System.out.println(rowNum);
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
