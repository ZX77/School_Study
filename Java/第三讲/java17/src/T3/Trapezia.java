package T3;

import java.util.Scanner;
public class Trapezia {

	int up;
	int down;
	int height;
	
	public Trapezia(){};
	public Trapezia(int up,int down,int height){
		this.up = up;
		this.down = down;
		this.height = height;
	}
	
	public int area(){
		
		return (up+down)*height/2;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Trapezia tr = new Trapezia();
		System.out.println("请输入上低，下底，高：");
		tr.up = input.nextInt();
		tr.down = input.nextInt();
		tr.height = input.nextInt();
		System.out.println("面积="+tr.area());
		System.out.println("请重新输入高");
		tr.height = input.nextInt();
		System.out.println("面积="+tr.area());
		
		Trapezia tr1 = new Trapezia(10,20,30);
		System.out.println("面积="+tr1.area());
	}
}
