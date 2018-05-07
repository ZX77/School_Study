package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputStreamDemo {

	public static void main(String[] args) {
		File f = new File("d:/test.bat");
		try{
			if(!f.exists()){
				System.out.println("文件不存在");
				return;
			}
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//保存对象到文件
			QQInfo info = (QQInfo)ois.readObject();
			ois.close();
			System.out.println(info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
