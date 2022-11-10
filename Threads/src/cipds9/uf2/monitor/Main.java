package cipds9.uf2.monitor;

public class Main {

	public static void main(String[] args) {
		MonitorNoms monitor = new MonitorNoms();
		ConsumidorNoms consumidor = new ConsumidorNoms(monitor);
		String[] noms = {"joan", "pere", "manel", "pau", "fi"};
		ProductorNoms productor = new ProductorNoms(monitor, noms);
		
		Thread t1 = new Thread(consumidor, "Consumidor");
		Thread t2 = new Thread(productor, "Productor");
		
		t1.start();
		t2.start();
	}
}
