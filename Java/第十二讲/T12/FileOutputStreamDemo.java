package T12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	/*
	 * 文件输出流：FileOutputStream 1.write(int n); 2.write(byte[] b); 3.write(byte[]
	 * int off,int len); 4.flush(); 5.skip; 6.close();
	 */
	public static void main(String[] args) {
		String fileName = "d:\\test.txt";

		File f = new File(fileName);
		try {
			// 文件不存在就创建文件
			if (!f.exists()) {
				f.createNewFile();
			}
			//创建输出流
			FileOutputStream fos = new FileOutputStream(f);
			String str ="保存到文件的内容";
			fos.write(str.getBytes());
//			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
