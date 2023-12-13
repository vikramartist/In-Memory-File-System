package Controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewFileBuilderClass {
	private static BufferedWriter writer = null;

	public static void touch(String path, List<String> fileNames) throws IOException,Exception {
		if(path==null) {
			throw new Exception("Path is not specified");
		}
		for (int i = 0; i < fileNames.size(); i++) {
			writer = new BufferedWriter(new FileWriter(path + "\\" + fileNames.get(i)));
			writer.write("<--- Write your code or text here --->");
			writer.close();
			System.out.println("File created successfully");
		}
	}
}
