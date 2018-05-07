package T3;

public class Test {

	public static void main(String[] args) {
		//new 实例化
		Student st = new Student();
		Student st2 = new Student(1001);
		Student st1 = new Student(1001,"小小");
		Student st3 = new Student(1001,"小小","女",20,"宏图201701班");

		//st是对象（实例）
		st.studid=1001;
		st.studname="张三";
//		st.age = 19;
		st.sex="男";
		st.classname="1701班";
		
		System.out.println("st.studid="+st.studid+";st.studname="+st.studname+";st.sex="+st.sex);
		st.setStudid(1002);
		st.setStudname("王五");
		System.out.println("st.studid="+st.studid+";st.studname="+st.studname+";st.sex="+st.sex);
		System.out.println(st.max(11.5f, 33.8f));
		
		//st是对象（实例）
		st1.studid=1002;
		st1.studname="小丽";
//		st1.age = 18;
		st1.sex="女";
		st1.classname="1702班";
		
		Person p = new Person();
		
		
		
	}
}
