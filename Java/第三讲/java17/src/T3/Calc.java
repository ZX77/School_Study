package T3;

//3.	根据给出的程序的实现意图，写出一个通用的方法，
//并对该方法进行重载，根据传递参数的不同调用不同的方法（30分钟）
/*
 * 4.	修改3中的程序代码，要求定义个方法getArea，求出三角形的面积，并实现方法的重载（20分钟）
 * */
public class Calc {

	public int add(int a,int b){
		System.out.println("调用int方法");
		return a+b;
	}
	public float add(float a,float b){
		System.out.println("调用float方法");
		return a+b;
	}
	public double add(double a,double b){
		System.out.println("调用double方法");
		return a+b;
	}
	public long add(long a,long b){
		System.out.println("调用long方法");
		return a+b;
	}
	public double getArea(int a,int b,int c){
		
		double p = (a+b+c)/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
		return area;
		
	}
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println(calc.add(1, 2));
		System.out.println(calc.add(1.5f, 2.3f));
		System.out.println(calc.add(8.88, 9.99));
//		calc.add(3, 4,5);错误
		System.out.println("三角形的面积="+calc.getArea(30, 40, 15));
		
	}
}
