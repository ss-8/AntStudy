import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class testReadLog {

	@Test
	public void test() {
		File file = new File("E:\\downloads\\nohup.out");
		String encoding = "UTF-8";
		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			// BufferedWriter writer = new BufferedWriter(new FileWriter(new
			// File("E:\\downloads\\aalog.txt")));
			String lineTxt = null;
			Integer row = 0;
			System.out.println("start");
			while ((lineTxt = bufferedReader.readLine()) != null) {
				row++;
				// if(row>228700000){
				// writer.append(lineTxt+"\r\n");
				// }
				if (lineTxt.indexOf("jpg") == -1 && lineTxt.indexOf("png") == -1) {
					System.out.println(row + " " + lineTxt);
				}
			}
			// writer.close();
			System.out.println(row);
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
