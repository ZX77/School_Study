package T3;

/*
 * （1）定义一个student类,其中包括用户名、姓名、性别、出生年月等属行以及
 * init()——初始化各属性、
 * display()——显示各属性、
 * modify()——修改姓名等方法。
 * 实现并测试这个类。
 * */
public class Stud {

	String username;
	String name;
	String sex;
	String birthday;
	public void init(String username,String name,String sex,String birthday){
		this.username = username;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
	public void display(){
		System.out.println("username="+username+";name="+name+";sex="+sex+";birthday="+birthday);
		
	}
	public void modify(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		Stud s = new Stud();
		s.init("admin", "学习", "男", "1990-8-8");
		s.display();
		s.modify("张三丰");
		s.display();
	}
}
