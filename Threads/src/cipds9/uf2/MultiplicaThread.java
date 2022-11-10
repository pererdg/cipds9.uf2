package cipds9.uf2;

public class MultiplicaThread implements Runnable {

	private int num;
	
	public MultiplicaThread(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	@Override
	public void run() {
		num *= num;
	}

	public static void main(String[] args) throws Exception {
		MultiplicaThread m1 = new MultiplicaThread(2);
		MultiplicaThread m2 = new MultiplicaThread(3);
		MultiplicaThread m3 = new MultiplicaThread(4);
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println(m1.getNum() + " " + m2.getNum() + " " + m3.getNum() +
				" = " + (m1.getNum() + m2.getNum() + m3.getNum()));
	}

}
