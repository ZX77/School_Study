package T3;

/*类的定义：
 * 修饰符	class	类名
 * 修饰符：public(公有)，默认，private(私有)
 * 类名：符合标识符的命名规则，类名用大写字母开头，变量名用小写字母开头，常量全部用大写字母
 * 类中的成员：
 * 		1.成员变量（属性）
 * 			1.1公有变量public 
 * 			1.2受保护的变量protected
 * 			1.3默认变量，
 * 			1.4私有变量
 * 			1.5静态变量（类变量）static
 * 		2.成员函数（方法，行为）
 * 			1.1公有public 
 * 			1.2受保护protected
 * 			1.3默认，
 * 			1.4私有
 * 			1.5静态（类方法）static
 * 		3.构造函数
 * 			1.构造函数与类名同名
 * 			2.构造函数无返回值，也不能写void关键字
 * 			3.构造函数是类中第一个运行的函数，一般用于做初始化操作
 * 			4.如果类中没有定义构造函数,系统会自动添加一个默认构造函数,
 * 			   但是如果类中定义了构造函数，就不会再添加默认构造函数
 * 			5.构造函数可以重载
 * 			6.系统实例化对象时调用构造方法（new)
 * 
 * 重载：在同一个类中，函数名称相同，但是参数的个数或者类型不一致
 * 
 * 
 * */

public class Student {

	//公有变量
	public int studid;//学号
	public String classname;//班级
	//受保护的变量
	protected String studname;//姓名
	//默认变量
	String sex;//性别
	//私有变量
	private int age;//年龄
	//静态变量
	public static int count;
	
	//默认构造函数
	public Student(){
		
	}
	//1个参数的构造方法
	public Student(int studid){
		this.studid = studid;
	}
	//2个参数的构造方法
	public Student(int studid,String studname){
		this.studid = studid;
		this.studname = studname;
	}
	//5个参数的构造方法
	public Student(int studid,String studname,String sex,int age,String classname){
		this.studid = studid;
		this.studname = studname;
		this.sex = sex;
		this.age = age;
		this.classname = classname;
		System.out.println("studid="+this.studid);
		System.out.println("studname="+this.studname);
		System.out.println("sex="+this.sex);
		System.out.println("age="+this.age);
		System.out.println("classname="+this.classname);
		
	}
	//公有方法
	//void 无返回值函数
	/*
	 * this代表当前对象,当前对象的所有成员都可以通过this关键字访问,静态除外
	 * 当成员变量与局部变量同名时，必须用this关键字进行区别成员变量与局部变量，
	 * 如果不存在同名的情况，this关键字可以省略
	*/
	public void setStudid(int studid){
		
		System.out.println("this.studid="+this.studid+";studid="+studid);
		//把函数局部变量studid的值赋值给类的成员变量
		this.studid = studid;
//		studid=studid;错误，废代码
		System.out.println("this.studid="+this.studid+";studid="+studid);
		
		
	}
	void setStudname(String name){
//		this.studname = name;
		studname = name;
	}
	//求2个数的最大值函数
	//重载：在同一个类中，函数名称相同，但是参数的个数或者类型不一致
	public int max(int a,int b){
		
		return a>b?a:b;
	}
	public float max(float a,float b){
		
		return a>b?a:b;
	}
	public double max(double x,double y){
		
		return x>y?x:y;
	}
	public int max(int a,int b,int c){
		int t = a>b?a:b;
		
		return t>c?t:c;
	}
	
	
}
