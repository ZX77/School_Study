package T12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/*
 * 所有的IO流章节讲的类库都是java.io包中的类
 *File(文件类):
 *	1.可以创建文件，文件夹；
 *	2.可以删除文件，文件夹；
 *	3.可以查看，修改文件，文件夹的属性
 *	4.不能读取，保存文件的内容
 *
 * */
public class FileDemo {

	public static void main(String[] args) {
//		File file = new File("E:\\工作资料\\一期课件\\Java (2008-12-8修改后)\\上机文挡 与 理论作业\\T01 理论作业.txt");
		File file = new File("d:\\work");
		//文件是否存在
		if(file.exists()){
			System.out.println("文件已经存在");
			
			System.out.println("文件的最后修改时间："+ new Date(file.lastModified()).toLocaleString());
			
			System.out.println("文件的大小："+file.length()+"字节");
			System.out.println("是否为文件："+file.isFile());
			System.out.println("是否为文件夹："+file.isDirectory());
			System.out.println("是否可读:"+file.canRead());
			System.out.println("是否可写:"+file.canWrite());
//			System.out.println("删除文件："+file.delete());
			System.out.println("绝对路径："+file.getAbsolutePath());
			System.out.println("文件名称："+file.getName());
			System.out.println("文件路径："+file.getParent());
			System.out.println("完整路径："+file.getPath());
			System.out.println("是否为隐藏文件："+file.isHidden());
			
			//读取文件夹中所有的文件
			if(file.isDirectory()){
				File[] fileList = file.listFiles();
				int len = fileList.length;
				for(int i=0;i<len;i++){
					System.out.println(fileList[i].getName()+",是否为文件："+fileList[i].isFile()+",是否为文件夹："+fileList[i].isDirectory());
	
				}
//				for (File file2 : fileList) {
//					System.out.println(file2.getName()+",是否为文件："+file2.isFile()+",是否为文件夹："+file2.isDirectory());
//				}
				
				//只取名称，返回的是字符串
				String [] filenameList = file.list();
				System.out.println("---------------------------------------");
				//显示当前文件夹下面的所有文件及文件夹
				for (String name : filenameList) {
					System.out.println(name);
				}

			}
		}else{
			try {
				//创建一个文件;
				file.createNewFile();
//				System.out.println("创建文件夹"+file.mkdir());
				System.out.println("文件创建成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
