package T17;

import java.lang.reflect.Field;

public class Test {

	public double d;
	public static void main(String[] args) {
		try {
			Class clz = Class.forName("T17.Test");
			//获取变量d
			Field f = clz.getField("d");
			
			Test obj = new Test();
			//获取obj对象中d变量的值
			System.out.println("d="+f.get(obj));
			//修改obj对象中d变量的值
			f.set(obj, 888888.88);
			System.out.println("d="+f.get(obj));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
