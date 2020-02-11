package com.sp.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomUtil {
	//获得随机0-9之间的数字
	public static int getRandomNum() {
		Random random=new Random();
		int nextInt = random.nextInt(10);
		return nextInt;
	}
	
	//获得区间的随机数字
	public static int getRandomNum(int min,int max) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	
	//获得随机英文字符
	public static char getRandomChar() {
		Random random=new Random();
		//获得开始字符的ASCII码
		int startChar='a'+0;
		
		return 	(char) (random.nextInt(26)+startChar);

	}
	//获取4个随机验证码
	public static String getRandomCNumberString(int subs) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < subs; i++) {
			int nextInt=random.nextInt(36);
			if(nextInt>10) {
				sb.append(getRandomChar());
			}else {
				sb.append(getRandomNum());
			}
		}
		return sb.toString();
	}
	
	//获取一个随机中文字符串
	public static String getRandomChineseString() {
		Random random = new Random();
		//汉字高位字节最小值176
		//39 一级汉字 16-55区 55-16=39
		int highPos=176+Math.abs(random.nextInt(39));
		//常用汉字的低位字节最小值是161 
		int lowPos=161+Math.abs(random.nextInt(93));
		byte bytehigh = new Integer(highPos).byteValue();
		byte bytelow = new Integer(lowPos).byteValue();
		byte[] b=new byte[2];
		b[0]=bytehigh;
		b[1]=bytelow;
		String str=null;
		try {
			str=new String(b,"GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	//获取多个中文
	public static String getRandomChineseString(int subs) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < subs; i++) {
			sb.append(getRandomChineseString());
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int num = RandomUtil.getRandomNum(2, 4);
		String string = RandomUtil.getRandomCNumberString(4);
		String chineseString = RandomUtil.getRandomChineseString(500);
		System.out.println(chineseString);
		System.out.println(string);
		System.out.println(num);
	}
}
