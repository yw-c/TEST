package sale;

public class Sale_tickets implements Runnable{
	//������Ʊ��
	private int tickets = 100;
	//��Ʊ��1�ſ�ʼ
	private int number = 1;
	public void run() {
		while(tickets > 0) {
			try {
				//���Ƴ�Ʊʱ�������
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//ͬ������飬��֤��ͬһʱ��ֻ��һ���߳̿���ִ���������
			synchronized(this) {
				if(tickets > 0) {
				System.out.println("��"+ number + "��Ʊ�ѱ�" + Thread.currentThread().getName() + "�۳�");
				//ʣ��Ʊ���ݼ���Ʊ�ŵ���
				tickets --;
				number ++;
			}
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("��ʼģ����Ʊ���̣�");
		Sale_tickets ticket = new Sale_tickets();
		Thread t1 = new Thread(ticket, "1�Ŵ���");
		Thread t2 = new Thread(ticket, "2�Ŵ���");
		Thread t3 = new Thread(ticket, "3�Ŵ���");
		t1.start();
		t2.start();
		t3.start();
	}
}
