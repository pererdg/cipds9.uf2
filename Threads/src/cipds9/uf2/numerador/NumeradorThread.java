package cipds9.uf2.numerador;

public class NumeradorThread implements Runnable {

	private Numerador numerador;
	
	public NumeradorThread(Numerador numer) {
		this.numerador = numer;
	}
	
	@Override
	public void run() {
		for (int n=0; n<10; n++) numerador.getNumeroSeguent();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Numerador numerador = new Numerador();
		
		Thread t1 = new Thread(new NumeradorThread(numerador));
		Thread t2 = new Thread(new NumeradorThread(numerador));
		
		t1.start();
		t2.start();
	}
}
