package T4;

public class Circle {

	/*
	 * final
	 * 1.有final关键字的变量叫做常量，他的值不能修改;
	 * 2.有final关键字的函数，不能被重写
	 * 3.有final关键字的类，不能被继承;
	 * */
	double radius;
	//定义常量,常量一般用大写字母，常量的值不能修改
	public static final double PI=3.14;
	public Circle() {
		
//		PI=3.1415926;常量的值不能修改
	}
	public final double getArea(){
		
		return PI*radius*radius;
	}
}
