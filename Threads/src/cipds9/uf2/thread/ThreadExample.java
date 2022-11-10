package cipds9.uf2.thread;

public class ThreadExample extends Thread {

	public ThreadExample(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int n=1; n<6; n++) {
			System.out.println(this.getName() + ":" + n);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread t1 = new ThreadExample("Fil 1");
		Thread t2 = new ThreadExample("Fil 2");
		Thread t3 = new ThreadExample("Fil 3");
		
		System.out.println("Engegant fils");
		
		t1.start();
		t2.start();
		t3.start();

		System.out.println("Fils engegats");
	}
}
