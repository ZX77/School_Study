package part1;

public class 运算符 {
	public static void main(String[] args) {
		// 1、算术运算符 + - * / % ++ --
		// 字符串可以用+号拼接
		String a = "He";
		String b = "llo";
		System.out.println(a + b);

		// 整型除以整型 结果是整形
		System.out.println(3510 / 1000 * 1000);

		// 2、赋值运算符= += -= *= /= %=
		int i = 10, j = 0;
		j = i++;
		System.out.println("i的结果是 " + i + " j的结果是 " + j);

		// 3、比较运算符 == > < >= <= != instanceof
		boolean bln;
		bln = 1 > 2;
		System.out.println("结果是" + bln);

		// 类 对象
		运算符 s = new 运算符();
		System.out.println("结果是 " + (s instanceof 运算符));

		// 4、逻辑运算符
		// & 逻辑与 | 逻辑或 ^异或 !非 &&短路与 ||短路或
		// &和&&的区别:&在任何情况都会去判断两边的表达式
		int m = 10, n = 20;
		System.out.println("逻辑与  "+(m > n & m == 10));
		
		//异或 ^
		//1 ^ 0  1
		//0 ^ 1  1
		//1 ^ 1  0
		//0 ^ 0  0
		System.out.println("异或 "+(m > n ^ m != 10));
		
		//5、三目运算符
		int days=24,salary=0;
		salary = days==24?3000:2500;
		System.out.print("您本月的 月薪是 "+salary);

	}
}
