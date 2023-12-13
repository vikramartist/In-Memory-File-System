package Controllers;

import java.io.File;
import java.io.FileNotFoundException;

public class FileOrFolderRemoverHelper {

	private static File file;

	public static void rm(String path, String word) throws FileNotFoundException {
		file = new File(path + "\\" + word);
		if (file.exists()) {
			if (file.isFile()) {
				if(file.delete()) {
					System.out.println(word+" deleted");
				}
			} 
			if (file.isDirectory()) {
				deleteDirectory(file);
				if (file.delete()) {
					System.out.println(word + " deleted");
				}
			}
		} else {
			throw new FileNotFoundException();
		}
	}

	private static void deleteDirectory(File fileToDelete) {
		for (File subfile : fileToDelete.listFiles()) {
			if (subfile.isDirectory()) {
				deleteDirectory(subfile);
			}
			subfile.delete();
		}

	}
}
