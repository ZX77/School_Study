package T5.job;

/*
 * 3. "Manager"类继承"Employee"类，有一个final成员变量"vehicle" 
 * 
 * */
public class Manager extends Employee{

	final String  vehicle="经理";
	
	public Manager() {
			
		}
	public Manager(String name,int age,String sex,double salary,String empID) {
		super(name,age,sex,salary,empID);
	}
	@Override
	public String toString() {
		return vehicle+":姓名："+this.name+"，年龄："+this.age+",性别："+sex+",工号："+empID;
	}

}
