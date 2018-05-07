package T13;

public class T33 implements Runnable{

	/*
	 * 3.	同时启动两个线程，调用同一个类中的两个方法，分别打印出0—100和101到200之间的数字，
	 * 		且要求数字打印不能交互（30分钟）
	 * */
	int count=0;
	public synchronized void print100(){
		
		while(count<=100){
			System.out.println(Thread.currentThread().getName()+":count="+count);
			count++;
		}
	}
	public synchronized void print200(){
		
		while(count>100 && count<=200){
			System.out.println(Thread.currentThread().getName()+":count="+count);
			count++;
		}
	}
	
	
	public void run() {
		String name = Thread.currentThread().getName();
		if(name.equals("线程1")){
			print100();
		}else if(name.equals("线程2")){
			print200();
		}
		
	}

	public static void main(String[] args) {
		T33 t33 = new T33();
		Thread 线程1 = new Thread(t33,"线程1");
		Thread 线程2 = new Thread(t33,"线程2");
		线程1.start();
		线程2.start();
		
		
	}
	
}
