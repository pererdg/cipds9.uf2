package cipds9.uf2;

public class RunnableExample implements Runnable {

	@Override
	public void run() {
		for (int n=1; n<6; n++) {
			System.out.println(Thread.currentThread().getName() + ":" + n);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableExample(), "Fil 1");
		Thread t2 = new Thread(new RunnableExample(), "Fil 2");
		Thread t3 = new Thread(new RunnableExample(), "Fil 3");
		
		System.out.println("Engegant fils");
		t1.start();
		t2.start();
		t3.start();

		System.out.println("Final main");
	}
}
