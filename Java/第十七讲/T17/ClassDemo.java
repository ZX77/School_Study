package T17;

import java.lang.reflect.Constructor;

public class ClassDemo {

	public static void main(String[] args) {
		String str = new String();
		str="abc";
		//1.获取一个存在的实例
		Class clz=str.getClass();
		//2.通过Class的静态方法forName动态创建一个实例
		
//		new ChatDemo();
		try {
			//调用默认构造方法
			Object obj = Class.forName("T16.ChatDemo").newInstance();
			Class clazz = obj.getClass();
			//获取公有的构造方法
			Constructor []arg = clazz.getConstructors();
			for(int i=0;i<arg.length;i++){
				Constructor c = arg[i];
				System.out.println(c.getName());
			}
			System.out.println("---------------------------");
			//获取所有的构造方法，包括私有的构造方法
			arg = clazz.getDeclaredConstructors();
			for(int i=0;i<arg.length;i++){
				Constructor c = arg[i];
				System.out.print(c.getName()+"(");
				
				Class[] parms = c.getParameterTypes();
				for (Class class1 : parms) {
					System.out.print(class1.getName()+",");
				}
				System.out.println(")");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
