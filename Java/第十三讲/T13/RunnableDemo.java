package T13;
/*
 * Runnable接口实现线程
 * 优点：
 * 	1.可以自由的继承其他类，解决了java单继承的缺点
 * 	2.可以实现资源共享
 * 	3.减少创建新线程实例所需的可观的内存与CPU时间
 * */
public class RunnableDemo implements Runnable {

	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+",i="+i);
		}		
	}
	
	public static void main(String[] args) {
		
		RunnableDemo data = new RunnableDemo();
		Thread th1 = new Thread(data);
		Thread th2 = new Thread(data);
		Thread th3 = new Thread(data);
		Thread th4 = new Thread(data);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		
	}

}
