package T3;

/*
 *设计一个Student类，
  添加姓名(String)，年龄(int), 分数(float)等属性
  两个分别将string输入转换为int和float的方法
  一个输出学生信息的方法
  基本类型  包装类
  boolean Boolean
  char	  Character
  byte	  Byte
  short   Short
  int	  Integer
  float	  Float
  double  Double
 * */
public class Students {

	String name;
	int age;
	float score;
	
	public void setAge(String age){
		//把字符串转换为整形
		this.age = Integer.parseInt(age);
//		this.age = Integer.valueOf(age);
//		this.age = new Integer(age).intValue();
	}
	public void setScore(String score){
		this.score = Float.parseFloat(score);
//		this.score = Float.valueOf(score);
//		this.score = new Float(score).floatValue();
	}
	public void display(){
		System.out.println("姓名="+name+";年龄="+age+";成绩="+score);
	}
	public static void main(String[] args) {
		Students s = new Students();
		s.name = "张三";
		s.setAge("20");
		s.setScore("99.9");
		s.display();
		
		String str="true";
		boolean b = Boolean.parseBoolean(str);
		if(b){
			System.out.println("b="+b);
		}
	}
}
