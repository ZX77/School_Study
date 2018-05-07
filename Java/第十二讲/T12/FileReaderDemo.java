package T12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderDemo {

	/*
	 * 字符流：Reader,Writer
	 * 1.FileReader
	 * 2.BufferedReader
	 * */
	public static void main(String[] args) {
		String fileName = "E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\T12 理论作业.txt";
//		String fileName = "E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\基础练习.txt";
//		String fileName = "d:\\test.txt";
//		fileName="E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\L02 基本数据类型流程控制数组.doc";
		

		File file = new File(fileName);
		try{
			if(!file.exists()){
				System.out.println("文件不存在");
				return;
			}
			//文件字符流
			FileReader fr = new FileReader(file);
			//缓存流
			BufferedReader br = new BufferedReader(fr);
			char c[] = new char[1024];
//			int n=fr.read(c, 0, c.length);
//			String str = new String(c,0,n);
			String str = null;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
