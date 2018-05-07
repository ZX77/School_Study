package T4;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person(1001,"张三丰",20,"男");
		p.display();
		p.studid=1002;
		p.studname="王老五";
//		p.sex="男";私有变量不能在类的外部访问
		p.setSex("女");
		p.age = 18;
		p.display();
	}
}
