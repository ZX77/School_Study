package T11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class T11 {

	/*
	 * 集合框架:所有的集合接口，类库都在java.util包中
	 * 	1.Collection接口
	 * 		1.set接口:不允许重复
	 * 			1.HashSet;
	 * 			2.TreeSet
	 * 		2.list接口:允许重复
	 * 			ArrayList,LinkedList;
	 * 2.Map接口
	 * 		1.HashMap
	 * 		2.TreeMap
	 * 3.Itertor接口
	 * 		1.hasNext方法
	 * 		2.next方法
	 * 		3.remove方法
	 * */
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		
		coll.add(1);
		coll.add(2);
		coll.add(3);
		coll.add(4);
		coll.add(5);
		coll.add(6);
		coll.add(7);
		//删除元素
		coll.remove(7);
		//查看
		Iterator it = coll.iterator();
		//hasNext判断集合中是否存在元素
		while(it.hasNext()){
			Object obj = it.next();//next获取当前元素
			System.out.println(obj);
			
		}
		
	}
}
