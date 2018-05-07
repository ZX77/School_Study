package T11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	/*
	 * Properties类：读取配置文件
	 * 应用场合：用于应用程序的配置文件,配置文件中不允许出现中文
	 * */
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			//载入文件
//			prop.load(new FileInputStream("prop/test.properties"));
//			//读取参数
//			prop.put("aaaa", "11111");
//			prop.save(new FileOutputStream("prop/test.properties"), "aaaaaa");
			
			prop.load(new FileInputStream("prop/test.properties"));
			String url = prop.getProperty("db.url");
			String driver = prop.getProperty("db.driver");
			String aaaa = prop.getProperty("aaaa");
			
			System.out.println("url="+url);
			System.out.println("driver="+driver);
			System.out.println("aaaa="+aaaa);
			
			//如果读取参数失败，就给参数赋值默认值
//			prop.getProperty(key, defaultValue);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
