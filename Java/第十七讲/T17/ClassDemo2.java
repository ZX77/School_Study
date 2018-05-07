package T17;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo2 {

	public static void main(String[] args) {
		try {
			Class clz = Class.forName("java.lang.String");
			
			//获取所有成员变量
//			Field fields[] = clz.getDeclaredFields();
			//获取公有的成员变量
			Field fields[] = clz.getFields();
			
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			//获取所有的成员方法
//			Method methods[] = clz.getDeclaredMethods();
			//获取公有的方法
			Method methods[] = clz.getMethods();
			for (Method method : methods) {
				System.out.print(method.getName()+"(");
				//获取方法的参数
				Class [] params = method.getParameterTypes();
				for (Class class1 : params) {
					System.out.print(class1.getName()+",");
				}
				System.out.println(")");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
