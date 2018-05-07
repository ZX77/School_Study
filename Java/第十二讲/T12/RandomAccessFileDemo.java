package T12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) {
		try {
			File file = new File("d:\\test.dat");
			//如果文件不存在，先创建
			if(!file.exists()){
				file.createNewFile();
			}
			//r：只读，rw可读可写
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			//指针移到文件的末尾
			raf.seek(raf.length());
			raf.writeBoolean(false);
			raf.writeInt(222);
			raf.writeDouble(1100.95);
			//文件指针移动到文件开始位置
			raf.seek(0);
			System.out.println(raf.readBoolean());
			System.out.println(raf.readInt());
			System.out.println(raf.readDouble());
			System.out.println(raf.readBoolean());
			System.out.println(raf.readInt());
			System.out.println(raf.readDouble());
			
			//在文件中指定的位置开始读取文件内容
			//pos:字节的起始位置，从0开始
//			raf.seek(1L);
//			System.out.println(raf.readInt());
			raf.seek(5);
			System.out.println(raf.readDouble());

			raf.close();
			
			//11111111 11111111111111111111111111111111 1111111111111111111111111111111111111111111111111111111111111111
			//11111111111111111111111111111111 1111111111111111111111111111111111111111111111111111111111111111 11111111
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
