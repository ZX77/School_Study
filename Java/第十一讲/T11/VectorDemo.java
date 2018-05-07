package T11;

import java.util.ArrayList;
import java.util.Vector;

public class VectorDemo {

	/*
	 * ArrayList:速度快，但是不安全
	 * Vector:线程安全，但是性能更差,速度更慢
	 * */
	public static void main(String[] args) {
		//初始容量为10，如果不足，每次增加一倍
//		Vector vector = new Vector();
//		Vector vector = new Vector(25);//初始25个元素的大小
		Vector vector = new Vector(25,5);//初始25个元素的大小,如果不足，每次增加5个元素
		System.out.println("容量："+vector.capacity());
		System.out.println("元素个数:"+vector.size());
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		System.out.println("容量："+vector.capacity());
		System.out.println("元素个数:"+vector.size());
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);
		System.out.println("容量："+vector.capacity());
		System.out.println("元素个数:"+vector.size());

	}
}
