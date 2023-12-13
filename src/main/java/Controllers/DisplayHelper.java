package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DisplayHelper {
	private static File file;
	private static BufferedReader reader;
	private static List<String> filePaths;

	public static void ls(String path) {
		if (path == null) {
			System.out.println("No path specified");
		} else {
			file = new File(path);
			if (!file.exists()) {
				System.out.println("File not Found!!");
			}
			String[] files = file.list();
			for (String content : files) {
				System.out.println("\t-> " + content);
			}
		}
	}

	public static void cat(String filePath, String fileNames) throws FileNotFoundException, IOException {
		String path = filePath;
		String[] files = fileNames.split(" ");
		filePaths = Arrays.stream(files).toList();
		for (String name : filePaths) {
			file = new File(path + "\\" + name);
			if (file.exists()) {
				if (file.isFile()) {
					reader = new BufferedReader(new FileReader(file));
					String text;
					while ((text = reader.readLine()) != null) {
						System.out.println(text);
					}
				} else {
					throw new IOException("Given path is not a file, please give a proper file name");
				}
			} else {
				throw new FileNotFoundException();
			}
		}
	}
}
