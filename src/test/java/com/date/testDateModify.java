package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class testDateModify {

	@Test
	public void test() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1);
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		System.out.println(sdf.format(new Date(c.getTimeInMillis())));
	}
}
