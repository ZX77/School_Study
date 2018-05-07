package T11;

public class Student {

	int studid;
	String name;
	String sex;
	int age;

	public Student(int studid,String name,String sex,int age) {
		this.studid = studid;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public Student() {
		
	}

	@Override
	public String toString() {
		
		return "学号："+this.studid+",姓名："+this.name+",性别："+this.sex+",年龄："+this.age;
	}
	
}
