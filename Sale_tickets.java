package sale;

public class Sale_tickets implements Runnable{
	//定义总票数
	private int tickets = 100;
	//出票从1号开始
	private int number = 1;
	public void run() {
		while(tickets > 0) {
			try {
				//控制出票时间间隔随机
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//同步代码块，保证在同一时刻只有一个线程可以执行下列语句
			synchronized(this) {
				if(tickets > 0) {
				System.out.println("第"+ number + "号票已被" + Thread.currentThread().getName() + "售出");
				//剩余票数递减，票号递增
				tickets --;
				number ++;
			}
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("开始模拟售票过程：");
		Sale_tickets ticket = new Sale_tickets();
		Thread t1 = new Thread(ticket, "1号窗口");
		Thread t2 = new Thread(ticket, "2号窗口");
		Thread t3 = new Thread(ticket, "3号窗口");
		t1.start();
		t2.start();
		t3.start();
	}
}
