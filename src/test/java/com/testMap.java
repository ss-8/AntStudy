package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class testMap {

	@Test
	public void test() {
		Map<String,String> m=new TreeMap<String,String>();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)-10);
		c.set(Calendar.SECOND,0);
		for(int i=1;i<=10;i++){
			m.put(sdf.format(new Date(c.getTimeInMillis()+i*60000)),"0");
		}
		m.put("2017-08-25 14:53:00", "ssss");
		for(String key:m.keySet()){
			System.out.println(key+"--"+m.get(key));
		}
	}

}
