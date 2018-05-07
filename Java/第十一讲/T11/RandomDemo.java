package T11;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		/*
		 * 数学类Math
		 * 
		 * */
		System.out.println("e="+Math.E);
		System.out.println("PI="+Math.PI);
		//ceil返回大于等于本数的整数
		System.out.println(Math.ceil(-3.0001));
		//以10为底数的对数函数
		System.out.println(Math.log10(100));
		//以e为底数的对数函数
		System.out.println(Math.log(Math.E*Math.E*Math.E));
		//四舍五入
		System.out.println(Math.round(3.59999999));
		//指数函数,2的3次方
		System.out.println(Math.pow(2, 3));
		//随机函数：返回0~1之间的任意数
		System.out.println(Math.random()*1000);
		Random rnd = new Random();
		//指定类型的随机数，5中类型的随机数：int,long,float,double,boolean 
		System.out.println(Math.abs(rnd.nextInt()));
		
	}
}
