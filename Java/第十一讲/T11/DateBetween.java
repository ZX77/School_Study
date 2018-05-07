package T11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBetween {

	//3.	计算2009年1月1日距离今天有多少天，是星期几（30分钟）
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//系统当前时间
		Date d1 = null;
		Date d2 =null;
		try {
			//parse：把字符串解析为日期
			d1 = sdf.parse("2017-10-18");
			d2 = sdf.parse("2009-1-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//getTime返回的是时间的毫秒数，从1900-1-1 00:00:00开始计算的毫秒数
		long d = (d1.getTime()-d2.getTime())/(1000*3600*24);
		System.out.println("相差"+d+"天");
	}
}
