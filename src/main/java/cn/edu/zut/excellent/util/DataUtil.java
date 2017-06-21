package cn.edu.zut.excellent.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DataUtil {
	
	/**
	 * 从开始时间 获取当前第几周
	 * 不考虑是否是周一问题，只考虑7天为一周
	 * @param date
	 * @return
	 */
	public static int week(Date date){
		long today = new Date().getTime()/1000;
		long yestday = date.getTime()/1000;
//		System.out.println(today);
//		System.out.println(yestday);
		long time = today - yestday;
//		time /= 1000;
//		System.out.println(time);
//		System.out.println(time);
		long miao = 86400;
		int day = (int) (time/miao);
//		System.out.println(day);
		int week = day/7 + 4;
		if (day < 0 || week < 4 || week > 18) {
			return 0;
		}
		return week;
	}
	
	/**
	 * 目前只考虑  三月  四月 
	 * 不符合三月份或四月份 返回 0.
	 * @return
	 */
	public static int yue(){
		Calendar calendar = Calendar.getInstance();  
		int month = calendar.get(Calendar.MONTH) + 1;
		if (month != 4 && month != 3 && month != 5 && month != 6) {
			return 0;
		}
		return month;
	}
//	/**
//	 * 通过对二进制数的解析，获得该教师下面的学生哪些周报、月报没有交。
//	 * @return
//	 */
//	public static String Notsubmitted (long a){
//		int[] codeValue = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
//
//		Scanner sc = new Scanner(System.in);
//		String ss = "";
//		int n = 0;
//		long na;
//		if (a < 0) {
//			a = -a;
//			n = 1;
//		}
//		for (int i = 0; i < 1000; i++) {
//			na = 1 << i;
//			if (a < na) {
//				break;
//			}
//			if ((a & na) != 0) {
//				if (n == 0) {
//					ss += (i + 3) + "周       ";
//				}
//				if (n == 1) {
//                    ss+=(i+3)+"月      ";
//				}
//			}
//		}
//		return ss;
//		
//	}

	/**
	 * 通过对二进制数的解析，获得该教师下面的学生哪些周报、月报没有交。
	 * @return
	 */
	public static String Notsubmitted (long a){
		int[] codeValue = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };

		Scanner sc = new Scanner(System.in);
		String ss = "";
		int n = 0,m=17;//周报不会超过20周
		long na;
		if (a < 0) {
			a = -a;
			n = 1;
			if(a<2048){
				m=5;//月报不会超过8月
			}
		}
		
		for (int i = 0; i < m; i++) {
			na = 1 << i;
			if (a < na) {
				break;
			}
			if ((a & na) != 0) {
				if (n == 0) {
					ss += (i + 3) + "周       ";
				}
				if (n == 1) {
                    ss+=(i+3)+"月      ";
				}
			}
		}
		return ss;
		
	}
	
	public static void main(String[] args) {
//		System.out.println(week(new Date()));
//		System.out.println(yue());
//		Date date =new Date();
//		System.out.println(date);
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-03-01");
//			System.out.println(week(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
		
		
	}
	
}
