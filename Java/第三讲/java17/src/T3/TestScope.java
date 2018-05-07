package T3;

//2.	定义TestScope类，并定义方法与局部变量，测试变量的作用范围（20分钟）
public class TestScope {

	
	int a=10;
	public void test(){
		int a;
		int b=30;
		a=20;
		
		System.out.println("a="+a);
		System.out.println("this.a="+this.a);
	}
	public void test2(){
		a=10;
	}
	public static void main(String[] args) {
		TestScope test = new TestScope();
		test.test();
		
	}
}
