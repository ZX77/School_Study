package T4;

/*权限
 * 1.private成员只能在本类的内部访问;
 * 2.默认成员只能在同一个包中的不同类以及类本身访问；不同包中的类是不能访问
 * 3.受保护的成员可以被同一个包中的所有类及不同包中的子类访问
 * 4.公有成员任何包中的类都可以访问；
 * 封装：将成员变量定义成私有的，再提供一个或者多个公有的方法，
 * 	     以便对成员进行访问getXXX与修改setXXX
 * 
 * */
public class Person {

	//公有的
	public int studid;
	//受保护的
	protected String studname;
	//默认的，友好的
	int age;
	//私有的
	private String sex;
	
	
	public void setStudname(String studname){
		this.studname = studname;
	}
	//定义公有方法
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	
	public Person() {
		System.out.println("Person构造函数");
	}
	public Person(int studid,String studname,int age,String sex){
		this.age=age;
		this.sex = sex;
		this.studid=studid;
		this.studname =studname; 
	}
	public void display(){
		System.out.println("studid="+studid+",studname="+studname+",sex="+sex+",age="+age);
		
	}
	public void display(Person p){
		p.display();
	}
	public static void main(String[] args) {
		Person p = new Person(1001,"张三丰",20,"男");
		p.display();
		p.studid=1002;
		p.studname="王老五";
		p.sex="男";
		p.age = 18;
		p.display();
	}
}
