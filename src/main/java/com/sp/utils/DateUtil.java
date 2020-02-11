package com.sp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//根据生日计算年龄
	public static int getAgeByBirthday(Date birthday) {
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		//生日赋给日历控件
		calendar.setTime(birthday);
		int biryear = calendar.get(Calendar.YEAR);
		int birmonth = calendar.get(Calendar.MONTH);
		int birday = calendar.get(Calendar.DAY_OF_MONTH);
		int age=year-biryear;
		if(month>birmonth) {
			age++;
		}
		if(month==birmonth&&day>birday) {
			age++;
		}
		return age;
	}
	
	//方法的重载 计算年龄
	public static int getAgeByBirthday(String birthday) {
		Date birDate=null;
		try {
			birDate = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAgeByBirthday(birDate);
	}
	
	//计算俩个日期相差天数
	public static int getDayNum(Date date1,Date date2) {
		//一天多少毫秒
		Long time=(long) (24*60*60*1000);
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		
		if(time1>time2) {
			return (int) ((time1-time2)/time);
		}else {
			return (int) ((time2-time1)/time);
		}
	}
	
	//方法的重载 获得俩者相差天数
	public static int getDayNum(String date1,String date2) {
		try {
			return getDayNum(sdf.parse(date1), sdf.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) throws ParseException {
		int age = DateUtil.getAgeByBirthday("2000-01-02");
		System.out.println(age);
		int num = DateUtil.getDayNum("2000-01-02", "2000-01-03");
		System.out.println(num);
	}
}
