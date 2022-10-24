package cipds9.uf2;

import java.io.File;

public class DirectoryCleanerService {

		final static String DIR = "c:\\dirclean";
		final static int TEMPS = 10000;
		
		public static void main(String[] args) throws Exception {
			File dir = new File(DIR);
			while (true) {
				clearDirectory(dir);
				Thread.sleep(TEMPS);
			}
		}
		
		private static void clearDirectory(File dir) {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File f: files) {
					if (f.isDirectory()) {
						clearDirectory(f);
					}
					f.delete();
				}
			}	
		}		
}