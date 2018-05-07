package T5.job;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CCircle {

	private double radius;
	public static final double PI=3.14;
	public CCircle() {
		radius=10;
	}
	public CCircle(double radius) {
		this.radius=radius;
	}
	public void setRadius(double r){
		this.radius = r;
	}
	public double getRadius(){
		return this.radius;
	}
	public double getArea() throws MyException{
		
		double s=0;
		if(this.radius<=0){
			throw new MyException(radius);
		}else{
			s = PI*radius*radius;
		}
		return s;
	}
	public double area(){
		
		double s=0;
		if(this.radius<=0){
			System.out.println("半径必须大于0");
		}else{
			s = PI*radius*radius;
		}
		return s;
	}
	public static void main(String[] args){
		CCircle circle = new CCircle(10);
		double s=0;
		try {
			s = circle.getArea();
			System.out.println("圆的面积是："+s);
			s=circle.area();
			System.out.println("圆的面积是："+s);
			Scanner input = new Scanner(System.in);
			System.out.println("请输入半径：");
			circle.setRadius(input.nextDouble());
			s=circle.getArea();
			System.out.println("圆的面积是："+s);
		}catch(InputMismatchException e){
			System.out.println("只能输入0~9之间的数字字符");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}
}
