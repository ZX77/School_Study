package T11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/*
 * 日期类：Date
 * 
 * */
public class DateDemo {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();//当前时间,单位毫秒
		System.out.println(start);
		//创建Date对象时，会获取系统的当前时间
		Date d = new Date();
		System.out.println(d);
		//转换为本地时间格式
		System.out.println(d.toLocaleString());
		System.out.println(d.getTime());
		//设置时间
//		d.setTime(1308205423086L);
		//设置年份
//		d.setYear(116);
		//计算机的时间是从1900-1-1 00:00:00开始计算
		System.out.println(d.toLocaleString());
		long end = System.currentTimeMillis();//当前时间,单位毫秒
		System.out.println("运行时间是："+(end-start) +"毫秒");
		//日期格式转换
		/*年：yyyy
		 * 月：MM
		 * 日：dd
		 * 小时：HH(24小时制），hh（12小时制）
		 * 分钟：mm
		 * 秒钟：ss
		 * 毫秒;mi
		 * 
		 * */
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dd = sdf.format(d);
		System.out.println(dd);
		//日历类:自动获取系统当前时间
		Calendar cal = Calendar.getInstance();
		System.out.println("今天是本月的第几天:"+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("本星期的第几天:"+cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("本月的第几周："+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		System.out.println("今天是本年的第几天："+cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("本月的第几周："+cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
	}
}
