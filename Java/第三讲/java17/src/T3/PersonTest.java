package T3;

public class PersonTest {

	/**
	 * @param args
	 */
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
