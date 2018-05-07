package T12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileWriterDemo {

	public static void main(String[] args) {
		String fileName = "d:\\test.txt";

		File f = new File(fileName);
		try {
			// 文件不存在就创建文件
			if (!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("是的冯绍峰是范德萨范德萨范德萨范德萨范德萨");
			bw.flush();
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
