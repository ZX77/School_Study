package T12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderDemo1 {

	/*
	 * 7.	实现从文件中一次读出一个字符的操作
	 * */
	public static void main(String[] args) {
		String fileName = "d:\\test.txt";
		

		File file = new File(fileName);
		try{
			if(!file.exists()){
				System.out.println("文件不存在");
				return;
			}
			//文件字符流
			FileReader fr = new FileReader(file);
			int c;
			//缓存流
			while((c=fr.read())!=-1){
				System.out.print((char)c);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
