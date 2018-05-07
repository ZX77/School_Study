package T4.T411;

import sun.security.jca.GetInstance.Instance;
import T4.Person;

/*
 * extends继承
 * 父类，基类，超类的意义一样
 * 从父类，基类，超类派生出来的类就叫做子类
 * super:代表父类
 * 继承：
 * 		1.父类中私有成员不能继承，
 * 		2.不同包中默认成员也不能继承
 * 		3.公有的，受保护的都可以继承
 * 		4.父类的构造函数不能被继承;
 * 		5.单重多层（子类只允许有一个父类）
 * 
 * 当子类初始化时，子类要先初始化父类，父类的构造函数先执行，子类的后执行
 * 子类的构造函数调用父类的构造函数时，必须是子类构造函数中的第一条语句
 * 当创建子类的实例时，如果子类中没有指明调用父类构造函数，子类会自动调用父类的默认构造函数;
 * 如果父类没有默认的构造函数，子类必须指明调用父类的构造函数
 * 
 * 重写（覆盖）
 * 1.子类中的函数与父类中继承的函数同名；
 * 2.参数的个数与类型必须一致；
 * 3.返回值相同
 * 4.子类函数的访问权限必须大于或者等于父类的权限
 * 5.只有在继承的子类中才有重写
 * 
 * 多态：
 * 		1.重载(静态编联)
 * 		2.重写(动态编联)
 * */
public class Student extends Person {

	
	String classname;
	public Student() {
//		super(1001,"未知",22,"男");
		System.out.println("Student构造函数");
	}
	public Student(int studid,String studname,int age,String sex,String classname){
		//调用父类的构造函数
		super(studid,studname,age,sex);
		this.classname=classname;
	}
	//重写(覆盖)
	@Override
	public void display() {
		//调用父类的display函数
//		super.display();
		System.out.println("studid="+studid+",studname="+studname+",sex="+this.getSex()+",age="+this.getAge()+",classname="+classname);
	}
	//重载overroad
	public void display(String str) {
		//调用父类的display函数
//		super.display();
		System.out.println("studid="+studid+",studname="+studname+",sex="+this.getSex()+",age="+this.getAge()+",classname="+classname);
	}

	public void display(Person p){
		p.display();
	}
	public static void main(String[] args) {
		Student s = new Student(1003,"啧啧啧",16,"女","1701班");
		s.display();
		Person p = new Person();
		p.display();
		/*
		 * 子类可以自动转换为父类
		 * 父类转换为子类必须强制转换
		 * */
		Person p2 = new Student();//调用student类的display方法
		p2.display(s);
		p2.display(p2);
		Object  obj = new Student();//子类可以自动转换为父类
		Student s2=null;
		//判断对象的类型
		if (obj instanceof Student) {
			s2 = (Student)obj;
			
		}
		MiddleStudent s3=null;
		if (obj instanceof MiddleStudent) {
			s3 = (MiddleStudent)obj;
			
		}
		//强制转换:要强制转换的对象确实是这种类型
//		Student s2 = (Student)obj;
		s2.display();
		
	}
}
