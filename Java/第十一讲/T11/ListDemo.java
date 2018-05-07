package T11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDemo {

	public static void main(String[] args) {
		//List接口：允许重复项的有序集合
//		List list = new ArrayList();
		/*
		 * 集合对象可以存放任意类型的数据，默认情况自动转换为Object类型，
		 * 但是也可以指定类型，如果指定类型以后，取出来的元素就不需求强制转换，
		 * 自动还原会指定的类型
		 * 
		 * */
		List<Student> list = new ArrayList<Student>();
//		LinkedList<Student> list = new LinkedList<Student>();
//		Vector<Student> list = new Vector<Student>();
		Student s1 = new Student(1001,"张三","男",18);
		Student s2 = new Student(1002,"李四","男",20);
		Student s3 = new Student(1003,"王五","男",22);
		Student s4 = new Student(1004,"小丽","女",16);
		Student s5 = new Student(1005,"笑笑","女",17);
		Student s6 = new Student(1006,"丽丽","女",19);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		//第一种遍历方式
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
//			Student s = (Student)it.next();
			Student s = it.next();
			
			System.out.println(s);
			System.out.println("学生姓名："+s.name);
		}
		System.out.println("====================================");
		
		s2.name="李小龙";
		//修改元素的值
		list.set(1, s2);
		//删除指定位置的元素
		list.remove(1);
		//第二种遍历方式
		//size方法：获取集合中的元素个数
		for(int i=0;i<list.size();i++){
			//get方法:获取指定位置的元素
			System.out.println(list.get(i));
			
		}
		//集合转换为数组
//		Object objs[] = list.toArray();
	}
}
