package com.sp.utils;

public class StringUtil {
	//判断是不是数字
	public static boolean isNumber(String str) {
		String reg_str="^(([0-9])|([1-9]\\d+))(\\.\\d+)?$";
		boolean matches = str.matches(reg_str);
		return matches;
	}
	
	//判断字符串是否有值
	public static boolean isNotEmpty(String str) {
		if(str!=null&&!str.equals("")) {
			if(str.trim().length()==0) {
				return false;
			}
			return true;
		}
		return false;
	}
	//验证手机号码
	public static boolean isPhone(String str) {
		String reg_str="^1[3-9]\\d{9}$";
		boolean matches = str.matches(reg_str);
		return matches;
	}
	
	//验证邮箱
	public static boolean isEmail(String str) {
		String reg_str="^\\w+@\\w+\\.(com|cn|net|com\\.cn)$";
		boolean matches = str.matches(reg_str);
		return matches;
	}
	public static void main(String[] args) {
		boolean number = StringUtil.isEmail("884171361@qq.com");
		System.out.println(number);
	}
}
