package T5.job;
/*2. 从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构
造方法除外），并扩展 salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。
同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法，
并提供一个final sing()方法。 

 * */
public class Employee extends Role{

	double salary;
	static String empID;
	public Employee() {
		
	}
	public Employee(String name,int age,String sex,double salary,String empID) {
		super(name,age,sex);
		this.salary = salary;
		this.empID = empID;
	}
	@Override
	public String toString() {
		return "员工：姓名："+this.name+"，年龄："+this.age+",性别："+sex+",工号："+empID;

	}
	
	
	@Override
	public void play() {
		System.out.println(this.name+"喜欢玩游戏!");
	}
	public final void sing(){
		System.out.println(this.name+"喜欢唱歌!");
	}

}
