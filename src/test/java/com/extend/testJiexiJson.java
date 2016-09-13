package com.extend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class testJiexiJson {

	@Test
	public void test() {
		File file = new File("E:\\downloads\\aa.txt");
		String encoding = "UTF-8";
		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt = null;
			Integer row = 0;
			StringBuffer sb=new StringBuffer();
			while ((lineTxt = bufferedReader.readLine()) != null) {
				sb.append(lineTxt);
			}
			JSONObject jsonObject=new JSONObject(sb.toString());
			JSONArray jsonArray=new JSONArray(jsonObject.get("wareCollection").toString());
			JSONArray newJsonArray=new JSONArray();
			for(Object j:jsonArray){
				JSONObject jo=(JSONObject)j;
				System.out.println(jo.get("sku")+" "+URLDecoder.decode(jo.get("wareName").toString(),"GBK"));
				row++;
				newJsonArray.put(jo);
				if(row==4){
					break;
				}
			}
			System.out.println(newJsonArray.length());
			System.out.println(newJsonArray.toString());
			System.out.println("rownum:"+row);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		String json="[{\"id\":\"1\",\"msg\":\"jfs/t3169/99/239346600/15107/d27c3cb9/57ac4a11N1720e0c8.jpg\"}]";
		JSONArray jsonArray=new JSONArray(json);
		if(jsonArray.length()>0){
			JSONObject jo=(JSONObject)jsonArray.get(0);
			System.out.println(jo.get("msg"));
		}
	}
	@Test
	public void test2(){
		String name="%BA%E3%D4%B4%CF%E9%B7%AD%C1%EC%B6%CC%D0%E4T%D0%F4%C4%D0%20%C9%CC%CE%F1%D0%DD%CF%D0t%D0%F4%202016%CF%C4%BC%BE%D0%C2%BF%EE%C4%D0%CA%BF%C3%DEpolo%C9%C0%20%C6%AF%B0%D7%20190";
		try {
			System.out.println(URLDecoder.decode(name,"GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
