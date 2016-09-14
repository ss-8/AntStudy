import static org.junit.Assert.*;

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

public class testReadTxt {

	@Test
	public void test() {
		File f=new File("E:\\temp\\黄图标注\\高危_主图_cv标注用\\sexy_gaowei_zhutu_full_pop.txt");
		String encoding = "utf-8";

		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(f), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			BufferedWriter writer_pop = new BufferedWriter(new FileWriter(new File("E:\\temp\\黄图标注\\高危_主图_cv标注用\\sexy_gaowei_zhutu_full_pop_0.txt")));
			String lineTxt = null;
			int rowNum = 0;
			int accordRow = 1;
			int pop=0;
			int self=0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				rowNum++;
				writer_pop.append(lineTxt+"\r\n");
				if(rowNum%160000==0){
					writer_pop.close();
					writer_pop=new BufferedWriter(new FileWriter(new File("E:\\temp\\黄图标注\\高危_主图_cv标注用\\sexy_gaowei_zhutu_full_pop_"+accordRow+".txt")));
					accordRow++;
				}
			}
			writer_pop.close();
			System.out.println(rowNum);
			System.out.println(pop);
			System.out.println(self);
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
