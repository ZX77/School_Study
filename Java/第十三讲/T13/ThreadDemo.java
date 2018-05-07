package T13;

/*
 * 线程的实现：
 * 	1.继承Thread类，重写run方法;
 * 	2.实现Runnable接口，实现run方法;
 * 线程的启动：
 * 	1.调用线程的start方法启动线程；
 * 	2.不能手动调用run方法启动线程
 * 
 * 注意：
 * 	1.线程启动了，不一定线程在运行
 * 	2.如果run方法运行结束，线程就结束了
 * 
 * */
public class ThreadDemo extends Thread{

	@Override
	public void run() {
		//当前线程Thread.currentThread()
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+",i="+i);
			//设置休眠时间
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadDemo thread1 = new ThreadDemo();
		//获取线程默认优先级
		System.out.println("priority="+thread1.getPriority());
		//给线程起名
		thread1.setName("ticket");
		ThreadDemo thread2 = new ThreadDemo();
		//线程的优先级,一共有10级，MAX_PRIORITY=10，MIN_PRIORITY=1,NORM_PRIORITY=5
		thread2.setPriority(Thread.MAX_PRIORITY);
		ThreadDemo thread3 = new ThreadDemo();
		ThreadDemo thread4 = new ThreadDemo();
		
		ThreadDemo2 thread5 = new ThreadDemo2();
		new ThreadDemo2().start();
		
		//启动线程
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		
	}
}

