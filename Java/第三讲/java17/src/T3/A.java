package T3;

/*
 * 6.	编写两个类：A和B 。 
 * 类A创建的对象可以计算两个正整数的最大公约数，
 * 类B创建的对象可以计算两个正整数的最小公倍数。
 * */
public class A {

	//最大公约数
	public int zdgys(int a,int b){
		int c = a<b?a:b;
		for(int i=c;i>0;i--){
			if(a%i==0 && b%i==0){
				c =i;
				break;
			}
		}
		return c;
	}
}
