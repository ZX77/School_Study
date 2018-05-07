package T16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {

	/*
	 * 本章所有内容都是使用java.net包中的类
	 * URL获取网络资料
	 * 
	 * */
	public static void main(String[] args) {
		
		try {
			//获取地址
//			URL url = new URL("http://www.sms98.cn/");
			URL url = new URL("http://www.sms98.cn/images/LOGO2.gif");
//			URL url = new URL("http://www.qq.com/");
			
			//连接到url指定的地址
			URLConnection conn = url.openConnection();
			//读取地址的内容
			InputStream is = conn.getInputStream();
			
			BufferedInputStream bis = new BufferedInputStream(is);
			
			
			//保存图片
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\logo.gif"));
			//读取输入流的内容
			byte b[] = new byte[4096];
			int len=0;
			//-1表示读到文件的末尾
			while((len=bis.read(b, 0, b.length))!=-1){
				String str = new String(b,len);
				bos.write(b, 0, len);
//				str = new String(str.getBytes("iso-8859-1"),"utf-8");
//				str = new String(str.getBytes("iso-8859-1"),"gbk");
//				System.out.println(str);
				System.out.println("下载成功");
			}
			bos.flush();
			bos.close();
			bis.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
