package ht.servlet.upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//对上传的文件进行重命名
public class RenamePolicy implements FileRenamePolicy {

	public File rename(File file) {
      String body = "";  
      String ext = "";  
      //获取系统当前时间
      Date date = new Date();  
      //MM代表月,mm代表分,HH代表24小时制,hh代表12小时制
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
     
      //14842908.55999.jpg
      int pot = file.getName().lastIndexOf(".");//取得文件名和后缀分割点  
      if (pot != -1) {//说明后缀存在  
//          body = date.getTime() + "";//采用时间的形式命名  
          //文件名
    	  body = sdf.format(date);
          //扩展名
    	  ext = file.getName().substring(pot);//截取后缀名  
      } else {  
          body = (new Date()).getTime() + "";  
          ext = "";  
      }  
      Random rand = new Random();
      int rnd = Math.abs(rand.nextInt(9000))+1000;//1000~9999
      //新的文件名称
      String newName = body +rnd + ext;  
      file = new File(file.getParent(), newName);//对文件进行重命名  
      return file;
	}
	public static void main(String[] args) {
		Date d = new Date();
//		System.out.println(d);
//		System.out.println(d.toLocaleString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String sdate = sdf.format(d);
		System.out.println(sdate);
	}

}
