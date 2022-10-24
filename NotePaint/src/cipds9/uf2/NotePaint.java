package cipds9.uf2;

public class NotePaint {

	public static void main(String[] args) throws Exception {
		
		ProcessBuilder builder = new ProcessBuilder("notepad.exe");
		Process proNote = builder.start();
		
		builder = new ProcessBuilder("mspaint.exe");
		Process proPaint = builder.start();
				
		while (proNote.isAlive() && proPaint.isAlive()) {
			System.out.println("Processos vius");
			Thread.sleep(1000);
		}
		
		proNote.destroyForcibly();
		proPaint.destroyForcibly();
	}
}
