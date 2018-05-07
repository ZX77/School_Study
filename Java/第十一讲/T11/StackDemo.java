package T11;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		/*
		 * 堆栈（stack):后进先出
		 * 
		 * */
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("容量："+stack.capacity());
		System.out.println("元素个数:"+stack.size());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		//出栈pop:返回结果，并且删除元素
		stack.remove(1);
		//判断堆栈是否为空
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}
}
