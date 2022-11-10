package cipds9.uf2.banc2;

public class OperacioBancaria2 implements Runnable {

	Banc2 banc;
	float diners;
	
	public OperacioBancaria2(Banc2 banc, float diners) {
		this.diners = diners;
		this.banc = banc;
	}
	
	@Override
	public void run() {
		if (diners < 0) {
			banc.treureDiners(-diners);
		} else {
			banc.posarDiners(diners);
		}
	}

	public static void main(String[] args) {
		Banc2 banc = new Banc2(1000);
		
		float[] operacions = {100, -200, -300, 200, 500, -100, -400, 500};
		
		for (float op: operacions) {
			new Thread(new OperacioBancaria2(banc, op)).start();
		}
	}
}
