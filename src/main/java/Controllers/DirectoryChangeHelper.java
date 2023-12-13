package Controllers;

import java.io.File;
import java.io.FileNotFoundException;

public class DirectoryChangeHelper {
	private static File file;

	public static String cd(String path, String command, String display) throws FileNotFoundException {
		if (command.equalsIgnoreCase("d:\\") || command.equalsIgnoreCase("d:/")
				|| command.equalsIgnoreCase("e:/") || command.equalsIgnoreCase("f:/")) {
			display = command.substring(0, 2) + "\\";
			return display;
		}

		else if (command.contains("\\")) {
			String folder = command.substring(0, command.indexOf(':') + 1), innerfolder = "";
			String[] functionality = command.split("\\\\");
			for (int i = 1; i < functionality.length; i++) {
				for (int j = 0; j < functionality[i].length(); j++) {
					innerfolder += functionality[i].charAt(j);
				}
				folder += "\\" + innerfolder;
				innerfolder = "";
			}
			File folderPath = new File(folder);
			if (folderPath.exists()) {
				display = folderPath.getAbsolutePath();
			} else {
				display = path;
				throw new FileNotFoundException();
			}
		} else {
			file = new File(path);
			if (command.equals("../")) {
				display = file.getParent();
			} else if (command.equals("~") || command.equals("/")) {
				display = "C:\\Users\\" + System.getenv("USERNAME");
			} else {

				File checkFile = new File(path + "\\" + command);
				if (checkFile.exists()) {
					display = path + "\\" + command;
				} else {
					display = path;
					throw new FileNotFoundException();
				}

			}

		}
		return display;

	}
}
