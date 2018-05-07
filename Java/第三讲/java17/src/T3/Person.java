package T3;

public class Person {

	public int studid;
	public String studname;
	public int age;
	
	//赋值函数
	public void setStudid(int studid){
		this.studid = studid;
	}
	//取值函数
	public int getStudid(){
		return this.studid;
	}
	//同一个类中，函数名称相同，参数个数或者类型不一致
	public int max(int a,int b){
		return a>b?a:b;
	}
	public int max(int x,int y,int z){
		int c = x>y?x:y;
		return c>z?c:z;
	}
	public float max(float a,float b){
		return a>b?a:b;
	}
	public double max(double a,double b){
		return a>b?a:b;
	}
	public Person(int studid) {
		this.studid = studid;
	}
	public Person(){}
	public Person(int studid,String studname,int age){
		this.studid = studid;
		this.studname = studname;
		this.age = age;
	}
	public static void main(String[] args) {
		//new实例化，其实就是分配内存空间
		Person p = new Person(1001);
		Person p1 = new Person();
		Person p2 = new Person(1003,"小丽",18);
//		p.setStudid(1001);
		p.studname="张三";
		p1.setStudid(1002);
		System.out.println(p.getStudid());
		System.out.println("p.studname="+p.studname);
		int studid  = p1.getStudid();
		System.out.println(studid);
		System.out.println("p1.studname="+p1.studname);
		System.out.println("p2.studid="+p2.getStudid());
		
		
		int a=10;
		
		int b=20;
		int d=30;
		int c = p.max(a, b);
		float f1=10.5f,f2=9.8f;
		float f3=p.max(f1, f2);
		System.out.println("c="+c);
		System.out.println("f3="+f3);
//		c = p.max(a, b, f1);
//		System.out.println("c="+c);
		
	}
}
