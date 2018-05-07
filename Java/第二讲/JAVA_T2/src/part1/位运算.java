package part1;

public class 位运算 {
	public static void main(String[] args) {
		//位运算
		int a=6;
		int b=2;
		int c=0;
		//1、 ~ 按位非 /取反   (先加1 再取反)
		//8    4    9     -5
		//-9   -5   -10   4
		c = ~a;
		System.out.println("C 的结果 是 "+c);
		
		//2、& 按位与  (上下为1 结果是1 其他为0)
		c = a & b;
		//110   a
		//011   b
		//010   c
		System.out.println("C 的结果 是 "+c);
		
		//3、|按位或  （上下有1 结果为1 其他为0）
		c = a | b;
		//110  a
		//010  b
		//110
		System.out.println("C 的结果 是 "+c);
		
		//4、^按位异或(上下不同为1 相同为0)
		c = a ^ b;
		//110  a
		//010  b
		//100
		System.out.println("C 的结果 是 "+c);
		
		//5、>> 右移  （将二进制数据向右移动 空位补0）
		//110  a
		//011
		c = a>>1;
		System.out.println("C 的结果 是 "+c);
		
		//6、<< 左移
		c = a << 2;
		//110
	//  11000 
		System.out.println("C 的结果 是 "+c);
	}
}
