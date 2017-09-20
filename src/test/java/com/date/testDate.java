package com.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class testDate {

	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date(0L)));
		Calendar c = Calendar.getInstance();
		c.set(2099, 11, 31, 23, 59, 59);
		c.getTimeInMillis();
		System.out.println(sdf.format(new Date(c.getTimeInMillis())));
		System.out.println(new Date(c.getTimeInMillis()).getTime());
		System.out.println(sdf.format(new Date(4102415999079L)));

		// 取时间信息
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		System.out.println(c1.get(Calendar.YEAR));
		System.out.println(c1.get(Calendar.MONTH) + 1);
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));
		System.out.println(c1.get(Calendar.HOUR));
		System.out.println(c1.get(Calendar.MINUTE));
		System.out.println(c1.get(Calendar.SECOND));

		String d = "2017-12-12 12:23:45";
		try {
			System.out.println(sdf.parse(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void tt() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		StringBuilder dbname = new StringBuilder();
		dbname.append(cal.get(Calendar.YEAR));
		dbname.append(cal.get(Calendar.MONTH) + 1);
		dbname.append(cal.get(Calendar.DAY_OF_MONTH));
		dbname.append(cal.get(Calendar.HOUR_OF_DAY));
		dbname.append(cal.get(Calendar.MINUTE));
		System.out.println(dbname.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm00");
		String date = sdf.format(new Date());
		System.out.println(date);
	}

	@Test
	public void tt1() {
		String strdate="2017-07-25 16:03:42";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date pdate = new Date((new Date().getTime() + 300000));
		System.out.println(sdf.format(pdate));
		System.out.println(new Date().before(pdate));

	}
	
	@Test
	public void tt2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(sdf.format(new Date()));

	}
}
