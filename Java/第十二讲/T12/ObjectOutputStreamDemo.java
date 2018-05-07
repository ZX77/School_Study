package T12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	/*
	 * 对象流ObjectOutputStream
	 * */
	public static void main(String[] args) {
		
		File f = new File("d:/test.bat");
		try{
			if(!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//创建QQInfo对象
			QQInfo info = new QQInfo(1001,"张三","1234");
			//保存对象到文件
			oos.writeObject(info);
			oos.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
