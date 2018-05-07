package part2;

import java.util.Scanner;

public class 输入函数 {
	public static void main(String[] args) {

		System.out.print("请输入一个数:");
		
		//得到键盘输入的对象
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt(); // 输入一个整形
		
		System.out.print("请再输入一个数:");
		
		int b = scan.nextInt();
		
		System.out.print("结果是 "+(a+b));
		
		System.out.print("请输入一句话:");
		
		
		//连续输入字符串 需要使用另一个scanner对象
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//输入字符串 
		System.out.print("您输入的话是 :"+str);
	}
}
