package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterHelper {
	private static File file;
	private static PrintWriter writer;

	public static boolean echo(String path, String word, String pattern) throws FileNotFoundException {
		boolean isWritten = false;
		try {

			file = new File(path + "\\" + word);
			System.out.println(file.getName());
			if (file.exists()) {
				writer = new PrintWriter(file);
				if (file.isFile() && file.canRead() && file.canWrite()) {
					writer.write(pattern);
					isWritten = true;
				} else {
					System.out.println("File cannot be accessed");
					isWritten = false;
				}
			} else {
				throw new FileNotFoundException();
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		return isWritten;
	}
}
