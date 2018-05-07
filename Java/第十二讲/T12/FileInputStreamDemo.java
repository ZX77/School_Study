package T12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * FileInputStream(文件输入流，读取文件内容)
 * 	1.read();
 * 	2.read(byte b[]);
 * 	3.read(byte b[],int off,int len);
 * 	4.skip(long l);
 * 	5.close();
 * 
 * */
public class FileInputStreamDemo {

	public static void main(String[] args) {
//		String fileName = "E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\T12 理论作业.txt";
//		String fileName = "E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\基础练习.txt";
		String fileName = "d:\\test.txt";
//		fileName="E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\L02 基本数据类型流程控制数组.doc";
		
		
		File f=new File(fileName);
		if(!f.exists()){
			System.out.println("文件不存在");
			return;
		}
		//定义文件输入流
		try {
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			//定义字节数组
			byte[] b = new byte[1024];
			//读取文件内容,如果返回值为-1，表示已经读到文件的结束
			//len表示读取的实际字节数
			int len = 0;
			String str = "";
			//获取文件长度
			long length = f.length();
			int total=0;
			while((len=bis.read(b, 0, b.length))!=-1){
				total = total+len;
			//把字节数组转换为字符串
				str += new String(b,0,len);
				System.out.println("已经读取"+(total*1.0/length*100)+"%");
			}
			System.out.println(str);
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
