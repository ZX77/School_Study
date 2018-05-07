package T4;

/*
 * 静态内部类：
 * 	1.如果内部类含有静态变量或者静态方法，那么内部类必须定义成静态内部类
 * 	2.静态内部类不能访问外部类实例变量，实例方法
 * 	3.静态内部类可以像普通类一样使用,可以直接实例化
 * */
public class Outer2 {

	String name;
	static int count;
	
	public void test(){
		
	}
	static class Inner{
		
		static String sex; 
		public void display(){
//			name=""; 错误
			System.out.println("count="+count);
//			test();错误
		}
	}
	public static void main(String[] args) {
		Inner inner = new Inner();
	}
}
