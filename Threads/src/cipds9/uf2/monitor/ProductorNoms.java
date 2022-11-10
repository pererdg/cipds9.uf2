package cipds9.uf2.monitor;

public class ProductorNoms implements Runnable {

	private MonitorNoms monitor;
	private String[] noms;
	
	public ProductorNoms(MonitorNoms monitor, String[] noms) {
		this.monitor = monitor;
		this.noms = noms;
	}
	
	@Override
	public void run() {
		for (String nom:noms) {
			try {
				monitor.posaNom(nom);
				//Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
