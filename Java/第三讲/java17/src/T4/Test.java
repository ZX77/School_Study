package T4;

public class Test {

	public static void main(String[] args) {
//		教师数据：
//		工号 姓名 工龄 职务 助理 
//		0411 黄思曾 3  主任 罗琼 
		
//		0351 蔡木生 4 专业负责人 
//		0840 詹卫许 1 教师 
//		0302 黄玲玲 4 教师
		
		
		Director director = new Director("0411","黄思曾",3,"主任","罗琼");
		director.print();
		Teacher t1 = new Teacher("0351","蔡木生",4,"专业负责人");
		Teacher t2 = new Teacher("0840","詹卫许",1,"教师");
		Teacher t3 = new Teacher("0302","黄玲玲",4,"教师");
		t1.print();
		t2.print();
		t3.print();
		
	}
}
