package T3;

public class B {
	//最小公倍数
	public int zxgbs(int a,int b){
		int c = a*b;
		A aa = new A();
		int t = aa.zdgys(a, b);
		System.out.println("最大公约数："+t);
		return c/t;
	}
}
