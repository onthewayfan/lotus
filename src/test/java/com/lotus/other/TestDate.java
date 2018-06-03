package com.lotus.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		String str = "yyyy-MM-dd HH:mm:ss";
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		System.out.println(date+","+new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
		System.out.println(simpleDateFormat.format(date));
		try {
			System.out.println(simpleDateFormat.parse(LocalDate.now().toString()+" "+LocalTime.now()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
