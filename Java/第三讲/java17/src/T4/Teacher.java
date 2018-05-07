package T4;

/*
 * 1、定义一个接口IPerson，封装一个方法： void print()//输出人员有关信息 （2分）
2、利用IPerson接口规范，定义一个类Teacher，表示某学校教师的最基本信息。 4个成员变量：工号num，
 姓名name， 工龄workAge, 职务job； 3个成员方法： Teacher ( String num, String name, int workAge, String job)； 
 Teacher( String num, double workAge)； 输出教师的工号和工龄：print(); (4分)
3、再定义一个类Director，表示教师中的主任。主任有专门的助理。 5个成员变量：工号num， 姓名name， 工龄workAge, 职务job , 助理名assistantName； 
2个成员方法： Director(String num, String name, int workAge, String job, String assistantName); 输出主任的工号和他的助理：print()； （5分）
4、定义一个主类Test,该类中利用Teacher类和Director类，输出每个教师的工号和工龄以及主任的助理名。 （4分）
教师数据：
工号 姓名 工龄 职务 助理 
0411 黄思曾 3  主任 罗琼 
0351 蔡木生 4 专业负责人 
0840 詹卫许 1 教师 
0302 黄玲玲 4 教师


 * 
 * */
public class Teacher implements IPerson{

	String num;
	String name;
	double workAge;
	String job;
	public Teacher (){
		
	}
	public Teacher ( String num, String name, double workAge, String job)
	{
		this.num = num;
		this.name = name;
		this.workAge = workAge;
		this.job = job;
	}
	public Teacher ( String num, double workAge)
	{
		this.num = num;
		this.workAge = workAge;
	}
	public void print() {
		System.out.println("工号："+this.num+",工龄："+this.workAge);
	}

}
