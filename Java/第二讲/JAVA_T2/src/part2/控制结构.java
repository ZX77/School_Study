package part2;

public class 控制结构 {
	public static void main(String[] args) {
		// 1、选择结构
		// if - else
		boolean bln;
		int a = 10, b = 20;
		bln = a > b;
		if (bln) {
			System.out.println("A>b");
		} else {
			System.out.println("A<b");
		}

		// switch case
		char c = 'a';
		switch (c) {
		case 'a':
			System.out.println("这是元音字母a");
			break;
		case 'e':
			System.out.println("这是元音字母e");
			break;
		case 'i':
			System.out.println("这是元音字母i");
			break;
		case 'o':
			System.out.println("这是元音字母o");
			break;
		case 'u':
			System.out.println("这是元音字母u");
			break;
		default:
			System.out.println("不是元音字母");
		}

		// 2、循环结构
		// while do-while for
		for (int i = 0; i < 10; i++) { // 循环变量可以直接在 for括号中定义
			System.out.println("i = " + i);
		}
		
		//3、break 跳出循环 不再执行  和 continue  跳出本次循环 继续下一次循环
	}
}
