package part1;

public class 变量 {
	public static void main(String[] args){
		//单行注释
		/*
		 * 多行注释
		 */
		//println 带换行的输出
		//1、byte 整型 -128 - 127 (1字节)
		byte b=127;
		System.out.println(b+100);
		
		//2、整型 (4字节)
		int a=2000,cb=0;
		System.out.println(a+cb);
		
		//3、char字符 (2字节)
		char c='a';
		
		//4、String 字符串
		String s="这是java专有的字符串";
		
		System.out.println("您输出的字符串内容是:"+s);
		
		//5、boolean 布尔型 (存放逻辑值 true/false)
		boolean bln=true;
		System.out.println(bln);
		
		
		//自动数据类型转换 (精度小的数据类型赋值给精度大的数据类型)
		int i=0;
		byte b1=10;
		i=b1;
		
		//强制数据类型转换
		b1 =(byte) i;
		
		
		//当字符类型跟整型计算时 字符会转换成ASCII码进行计算
		System.out.println('a'+1);
		
		//字符串
		System.out.println("这是字符串"+1);	
		System.out.println('a'+1+"");
		
		
	}
}
