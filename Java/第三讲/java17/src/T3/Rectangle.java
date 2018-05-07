package T3;

import java.util.Scanner;
public class Rectangle {

	int width;
	int height;
	
	public int area(){
		
		return width*height;
	}
	public int zhouchang(){
		return (width+height)*2;
	}
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入长和宽：");
		rect.width=input.nextInt();
		rect.height=input.nextInt();
		System.out.println("面积="+rect.area());
		System.out.println("周长="+rect.zhouchang());
		
	}
	
}
