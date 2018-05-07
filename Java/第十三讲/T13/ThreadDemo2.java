package T13;

public class ThreadDemo2 extends Thread{

	@Override
	public void run() {
		//当前线程Thread.currentThread()
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+",i="+i);
			//设置休眠时间
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
