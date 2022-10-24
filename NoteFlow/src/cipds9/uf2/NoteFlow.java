package cipds9.uf2;

import java.util.ArrayList;
import java.util.Random;

public class NoteFlow {

	public static void main(String[] args) throws Exception {
		
		// Declarar variables
		ArrayList<ProcessHandle> notList = new ArrayList<ProcessHandle>();
		Random rand = new Random();
		final int MAX_RAND = 3;
		
		// Bucle de programa
		while (true) {

			// Carregar llista de processos notepad
			notList.clear();
			ProcessHandle.allProcesses().forEach(process -> {
	        	 if (process.info().toString().toLowerCase().contains("notepad")) notList.add(process);
	         });
			
			// Si més de 5 notepad acabar
			if (notList.size() > 5) break;
			
			// Si nombre parell engegar mes processos
			if (notList.size() % 2 == 0) {
				int numP = rand.nextInt(MAX_RAND);
				for (int n=0; n<numP; n++)
					(new ProcessBuilder("notepad.exe")).start();
			
			// Si nombre és senar aturar tots els notepad
			} else destroyNotepads(notList);
		
			// Esperem 1 segons
			Thread.sleep(1000);
		}
		
		// Tancar tots els notepad
		destroyNotepads(notList);
	}
	
	private static void destroyNotepads(ArrayList<ProcessHandle> list) {
		list.forEach(process -> process.destroyForcibly());
	}
}
