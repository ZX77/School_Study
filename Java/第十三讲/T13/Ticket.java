package T13;

public class Ticket implements Runnable{

	int ticketCount=100;
	/*
	 * 同步机制：
	 * 	1.方法级的同步synchronized
	 * 	2.语句块的同步
	 * */
	public synchronized void test(){
		
	}
	
	public void test2(){
		
		synchronized (this) {
			
			
			
			
		}
		
		
	}

	public void run() {
		while(true){
			//同步机制，采用互斥锁是Object类型的变量
			synchronized (this) {
				if(ticketCount<=0){
					return;
				}
				System.out.println(Thread.currentThread().getName()+":ticketCount="+this.ticketCount);
				ticketCount--;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		Thread th1 = new Thread(t,"售票员1");
		Thread th2 = new Thread(t,"售票员2");
		Thread th3 = new Thread(t,"售票员3");
		Thread th4 = new Thread(t,"售票员4");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		/*
		 * th4.sleep(指定时间);
		th4.wait();必须调用notify或者notifyAll方法才恢复运行
		th4.notify();
		th4.notifyAll();
		*/
	}
}
