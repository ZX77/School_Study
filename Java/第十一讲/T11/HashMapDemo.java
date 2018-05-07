package T11;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

	/*
	 * Map接口：键值对
	 * 		1.键不允许重复
	 * 		2，key键
	 * 		3.value值
	 * 
	 * HashMap与HashTable的区别
	 * 	1.HashMap允许有一个键为null的值,Hashtable不允许有为空（null）的键
	 * 	2.HashMap不是线程同步的，性能更高，速度更快，Hashtable是线程同步的，速度更慢
	 * */
	public static void main(String[] args) {
//		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
//		HashMap map = new HashMap();
		
		Hashtable<Integer, Student> map = new Hashtable<Integer, Student>();
		
//		map.put(1111, "2222");错误，与指定的类型不一致
		Student s1 = new Student(1001,"张三","男",18);
		Student s2 = new Student(1002,"李四","男",20);
		Student s3 = new Student(1003,"王五","男",22);
		Student s4 = new Student(1004,"小丽","女",16);
		Student s5 = new Student(1005,"笑笑","女",17);
		Student s6 = new Student(1006,"丽丽","女",19);
		//put方法：新增(修改)元素
		map.put(s1.studid, s1);
		map.put(s2.studid, s2);
		map.put(s3.studid, s3);
		map.put(s4.studid, s4);
		map.put(s5.studid, s5);
		map.put(s6.studid, s6);
//		允许有null值
//		map.put(null, null);Hashtable报错，HashMap不会报错
		//get方法：获取元素
		Student s = map.get(1006);
		System.out.println(s);
		
		//删除元素remove
		map.remove(1006);
		//判断key是否存在
		if(map.containsKey(1006)){
			s = map.get(1006);
			System.out.println(s);
		}else{
			System.out.println("1006数据不存在");
		}
		
		//遍历所有元素
		
		//返回key的集合
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			//获取key
			Integer key = it.next();
			//获取key对应的值
			s = map.get(key);
			System.out.println("key="+key+"======value="+s);
		}
		
	}
}
