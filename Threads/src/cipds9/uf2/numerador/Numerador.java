package cipds9.uf2.numerador;

public class Numerador {
	private int numero=0;
		
	public synchronized int getNumeroSeguent() {
		numero++;
		System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + numero);
		return numero;
	}
}
