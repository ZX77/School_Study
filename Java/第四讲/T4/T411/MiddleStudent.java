package T4.T411;

public class MiddleStudent extends Student{

	String teacherName;
	public MiddleStudent() {
		
	}
	public MiddleStudent(int studid,String studname,int age,String sex,String classname,String teacherName) {
//		super(studid,studname,age,sex,classname);
		//构造函数用this关键字可以调用本类的其他构造函数
		this(studid,studname,age,sex,classname);
		
		this.teacherName = teacherName;
	}
	public MiddleStudent(int studid,String studname,int age,String sex,String classname) {
		super(studid,studname,age,sex,classname);
	}
	/*
	 * 重写：函数同名，
	 * */
	@Override
	public void display() {
		//先调用父类的函数
		super.display();
		//再打印自己特有的东西
		System.out.println("teachername="+teacherName);
	}
	public static void main(String[] args) {
		MiddleStudent s = new MiddleStudent(1003,"啧啧啧",16,"女","1701班","赖老师");
		s.display();
	}
}
