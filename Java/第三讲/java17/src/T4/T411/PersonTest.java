package T4.T411;

import T4.Person;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person(1001,"张三丰",20,"男");
		p.display();
		p.studid=1002;
//		p.studname="王老五";受保护的变量在不同包中的非子类是不能访问的
		p.setStudname("王老五");
//		p.sex="男";私有变量不能在类的外部访问
//		p.age = 18;
		p.setAge(18);
		p.display();
	}
}
