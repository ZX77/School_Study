package T3;

/*
 * 基本数据类型的比较（==）
 * 对象的比较（equals）
 * 1.8种基本的数据类型进行比较用==,比较变量的值是否相等
 * 2.引用类型也可以用==比较，比较的是对象的地址
 * 3.如果比较对象的内容，就必须使用equals函数
 * 
 * 
 * 所有类的父类都是Object类
 * */
public class T3_2 {

	int count;
	static int aaa;
	public static void main(String[] args) {
//		char c = '中';
//		int i = c;
		T3_2 t1 = new T3_2();
		t1.count = 1;
		T3_2 t2 = new T3_2();
		t2.count=2;
		//引用，t2,t3代表同一个对象,t3就是t2的别名
		T3_2 t3 = t2;
		t3.count=3;
		System.out.println("t1.count="+t1.count);//1
		System.out.println("t2.count="+t2.count);//3
		System.out.println("t3.count="+t3.count);//3
		if(t1==t2){
			System.out.println("t1==t2");
		}else{
			System.out.println("t1!=t2");
		}
		if(t2==t3){
			System.out.println("t2==t3");
		}else{
			System.out.println("t2!=t3");
		}
		if(t1.equals(t2)){
			System.out.println("内容相同");
			
		}else{
			System.out.println("内容不一致");
		}
		//Object类是所以类的父类，java中定义的所有类都继承Object类的公有函数
	}
	//重写
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "aaaaaaaaaaaaaaa";
	}
	//重写
	@Override
	public boolean equals(Object obj) {
		T3_2 tt=(T3_2)obj;
		
		if(this.count==tt.count){
			return true;
		}else{
			return false;
		}
	}
}
