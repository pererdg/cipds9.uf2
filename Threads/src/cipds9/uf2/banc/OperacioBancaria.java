package cipds9.uf2.banc;

public class OperacioBancaria implements Runnable {

	Banc banc;
	float diners;
	
	public OperacioBancaria(Banc banc, float diners) {
		this.diners = diners;
		this.banc = banc;
	}
	
	public void posarDiners(float diners) {
		synchronized(banc) {
			float s1 = banc.getSaldo();
			float s2 = s1+diners;
			System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "+" + diners + "=" + s2);
			banc.setSaldo(s2);
		}
	}
	
	public void treureDiners(float diners) {
		synchronized(banc) {
			float s1 = banc.getSaldo();
			float s2 = s1-diners;
			System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "-" + diners + "=" + s2);
			banc.setSaldo(s2);
		}
	}	
	
	@Override
	public void run() {
		if (diners < 0) {
			treureDiners(-diners);
		} else {
			posarDiners(diners);
		}
	}

	public static void main(String[] args) {
		Banc banc = new Banc(1000);
		
		float[] operacions = {100, -200, -300, 200, 500, -100, -400, 500};
		
		for (float op: operacions) {
			new Thread(new OperacioBancaria(banc, op)).start();
		}
	}
}
