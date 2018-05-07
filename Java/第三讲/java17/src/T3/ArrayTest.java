package T3;

public class ArrayTest {

	public static void main(String[] args) {
		String str="aa  bb     cc    ddd      ere ssd";
		//split把字符串分隔成数组
		//length求数组的长度
		//\\s+ --->至少出现一个空格
		String arr[] = str.split("\\s+", 0); //正则表达式
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
