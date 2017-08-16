package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

public class testFileMove {

	@Test
	public void test() {
		File file=new File("E:\\aaa\\ss.txt");
		try {
			FileOutputStream fileout =new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
