package T3;

/*
 * 静态（类）变量:包含有static关键字的变量，叫做静态变量
 * 静态（类）函数（方法）
 * 1.静态的方法只能访问静态变量，静态方法，不能直接访问成员变量与成员方法
 * 2.静态方法可以间接访问成员变量和成员方法，通过创建类的实例对象访问成员变量与成员方法；
 * 3.静态变量与静态方法一般是通过类的名称去访问
 * 4.静态成员是属于类的，不属于对象
 * 5.实例函数可以访问静态变量与静态函数;
 * 6.静态变量与静态方法是常驻内存，从程序开始运行到结束一直占用存储空间
 * 7.所有的实例对象访问的静态变量的值是一样的，静态变量实现数据的共享
 * */
public class T3_1 {

	String name;
	String sex;
	int age;
	//静态变量
	static int count;
	public T3_1(){
		//做计数器，统计通过该类创建的对象数量
		count++;
	}
	
	
	public static void main(String[] args) {
//		name="";报错
//		count=1;
//		test();报错
//		test1();
//		T3_1 t3 = new T3_1();
//		t3.age=20;
//		t3.name="张三";
//		t3.count=2;
//		T3_1.count=1;
		
		System.out.println("T3_1.count="+T3_1.count); //0
		T3_1 t1 = new T3_1();
		
		System.out.println("T3_1.count="+T3_1.count);//1
		System.out.println("t1.count="+t1.count);//1
		T3_1 t2 = new T3_1();
		System.out.println("T3_1.count="+T3_1.count);//2
		System.out.println("t2.count="+t2.count);//2
		T3_1 t3 = new T3_1();
		System.out.println("T3_1.count="+T3_1.count);//3
		System.out.println("t3.count="+t3.count);//3
		System.out.println("t1.count="+t1.count);//1
		System.out.println("t2.count="+t2.count);//2
		T3_1 t4 = new T3_1();
		System.out.println("T3_1.count="+T3_1.count);//4
		System.out.println("t4.count="+t4.count);//4
		System.out.println("t3.count="+t3.count);//4
		System.out.println("t1.count="+t1.count);//4
		System.out.println("t2.count="+t2.count);//4
		
	}
	
	//实例方法，属性对象
	public void test(){
		T3_1 t2= new T3_1();
		count=3;
		test1();
		System.out.println("test....");
	}
	//静态方法，属于类，共享，常驻内存
	public static void test1(){
		
		System.out.println("test1");
	}
}
