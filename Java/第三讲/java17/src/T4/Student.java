package T4;

import T4.Person;

/*
 * extends继承
 * 父类，基类，超类的意义一样
 * 从父类，基类，超类派生出来的类就叫做子类
 * super:代表父类
 * 
 * 当子类初始化时，子类要先初始化父类，父类的构造函数先执行，子类的后执行
 * 
 * 
 * */
public class Student extends Person {

	
	public Student() {
		System.out.println("Student构造函数");
	}
	public Student(int studid,String studname,int age,String sex){
		this.age=age;
		this.studid = studid;
		this.studname = studname;
	}
	public static void main(String[] args) {
		Student s = new Student();
		s.display();
	}
}
