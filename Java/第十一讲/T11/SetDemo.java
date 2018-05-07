package T11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		//不确保有序，性能和效率更高
		HashSet hashset = new HashSet();
		hashset.add(1);
		hashset.add(2);
		hashset.add(3);
		hashset.add(4);
		hashset.add(5);
		Iterator it = hashset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
//--------------------------
		//有序
		TreeSet treeset = new TreeSet();
		treeset.add(1);
		treeset.add(3);
		treeset.add(22);
		treeset.add(9);
		treeset.add(5);
		it = treeset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}
