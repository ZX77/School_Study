package T12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class InputAndSort {

	/*
	 * 3.	编一段代码，实现在控制台输入一组数字后，排序后在控制台输出，直到输入"END"为止（20分钟）
	 * */
	public static void main(String[] args) {
		//保存从键盘输入的整形值
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		//字节流与字符流的转换类
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		System.out.println("请按行输入数据:");
		try {
			while((line=br.readLine())!=null){
				if(line.equals("end") || line.equals("END")){
					break;//终止输入
				}else{
					inputList.add(Integer.parseInt(line));
				}
			}
			//把inputList变量的值转换为数组
			
			Object a[]=inputList.toArray();
			//排序
			Arrays.sort(a);
			System.out.println("排序结果：");
			for (Object object : a) {
				System.out.println(object);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
