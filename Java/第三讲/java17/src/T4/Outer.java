package T4;

/*
 * 普通内部类：在一个类的内部定义的类叫做内部类
 * 	1.内部类可以访问外部类的成员变量和成员方法；但是外部类不能访问内部类的成员；
 * 	2.内部类不能直接实例化，只能通过外部类的对象创建内部类的对象
 * 	3.内部类的名称：外部类的名称+$符号+内部类的名称.class(Outer$Inner.class)
 * 	4.普通的内部类不能定义静态成员；
 * 静态内部类:
 * 
 * */
public class Outer {

	private int count;
	public void display(){
		count=2;
	}
	//内部类
	public class Inner{
		int a;
		public Inner(){
			//内部类可以访问外部类的变量
			count =1;
			
		}
		public void display(){
			//内部类可以访问外部类的函数
			System.out.println(count);
			display();
		}
	}
	public class Inner1{
		
	}
	public class Inner2{
		
	}
	public class Inner3{
		public class Inner33{
			
		}
	}
	public static void main(String[] args) {
		//创建外部类
		Outer out = new Outer();
		//创建内部类
		Outer.Inner in = out.new Inner();
	}
}
