package com.extend;

import java.io.File;

import org.junit.Test;

public class testFileInfo {

	@Test
	public void test() {
//		File f=new File("D:\\aaa.jpg");
//		System.out.println(f.lastModified());
		
//		String sku=" 3452352345 ";
//		System.out.println(sku.trim().matches("[0-9]*"));
		String file="aaa.flv";
		System.out.println(file.substring(file.indexOf(".")+1));
	}

}
