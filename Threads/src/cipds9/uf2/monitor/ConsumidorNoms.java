package cipds9.uf2.monitor;

public class ConsumidorNoms implements Runnable {

	private MonitorNoms monitor;
	
	public ConsumidorNoms(MonitorNoms monitor) {
		this.monitor = monitor;
	}
	@Override
	public void run() {
		String nom;
		while (true) {
			try {
				nom = monitor.treuNom();
				System.out.println("Hola " + nom);
				if (nom.equalsIgnoreCase("fi")) break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
