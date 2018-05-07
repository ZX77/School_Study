package T5;

/*
 * Throwabble
 * 	1.Error错误：
 * 	2.Exception异常
 * 		1.运行时异常：空指针异常，数组越界异常
 * 		2.普通异常（非运行时异常）,需要应用程序处理
 * 	语法：
 * 	try{
 * 		可能出现异常的代码块
 * }catch(Exception1 e){
 * 		如果出现异常，该部分语句才会执行,否则永远不执行
 * 		捕获异常的catch语句必须要按照异常类的层次，子类放在前面，父类放在后面
 * }catch(Exception2 e){
 * 		允许出现多个catch语句，最少一个
 * 
 * }
 * 
 * 
 * finally{
 * 		不管有没有出现异常，该部分代码都会执行，
 * 		所以这部分的代码一般做一些垃圾回收的工作，清理内存
 * 		这一部分不是必须的
 * }
 * 
 * 
 * */
public class ExceptionDemo1 {

	public static void main(String[] args) {
		int a=10;
		int b=2;
		int c = 0;
		try{
			c = a/b;
			System.out.println("c="+c);
			Cat cat =new Cat();
			cat.display();
			return;//运行完finally块的语句后才会返回，终止函数的运行
			//捕获异常的catch语句必须要按照异常类的层次，子类放在前面，父类放在后面
		}catch(ArithmeticException e){//捕获异常
			//处理异常,显示错误的详细信息
//			e.printStackTrace();
			//显示简单的错误信息
//			System.out.println(e.getMessage());
			System.out.println("分母不能为0");
		}catch (NullPointerException e) {
			System.out.println("请先实例化对象再使用");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//不是必须的，可以省略
			System.out.println("有没有异常都会运行");
		}
		
	}
}
