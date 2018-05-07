package T11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse("2009-1-1");
			Date now = new Date();
			long day= (now.getTime() - d.getTime())/1000*60*60*24;
			System.out.println(day);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
