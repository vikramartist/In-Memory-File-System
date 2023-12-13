package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import utilities.Functionalities;

public class FileOrFolderTransferClass {
	private static File testFile1, testFile2;

	public static boolean validateTransfer(String path, String source, String destination, String property)
			throws IOException {
		boolean isValidated = false;
		if (source.contains("/") || source.contains("\\") || destination.contains("\\") || destination.contains("/")) {
			testFile1 = new File(Functionalities.changeDirectory(path, source));
			testFile2 = new File(Functionalities.changeDirectory(path, destination));
			if (testFile1.exists() && testFile2.exists()) {
				isValidated = helper(testFile1, testFile2, property, isValidated);

			} else {
				throw new FileNotFoundException("File does not exist");
			}
		} else {

			testFile1 = new File(path + "\\" + source.trim());
			testFile2 = new File(path + "\\" + destination.trim());
			if (testFile1.exists() && testFile2.exists()) {
				isValidated = helper(testFile1, testFile2, "copy", isValidated);
			} else {
				throw new FileNotFoundException("File does not exist");
			}
		}

		return isValidated;

	}

	private static boolean helper(File sourceFile, File destinationFile, String property, boolean isMoved)
			throws IOException {
		if (property.equals("move")) {
			if (testFile1.isFile() && testFile2.isFile()) {
				FileUtils.moveFile(testFile1, testFile2);
				isMoved = true;
			}
			if (testFile1.isFile() && testFile2.isDirectory()) {
				FileUtils.moveToDirectory(testFile1, testFile2, true);
				isMoved = true;
			}

			if (testFile1.isDirectory() && testFile2.isDirectory()) {
				FileUtils.moveDirectoryToDirectory(testFile1, testFile2, true);
				isMoved = true;
			}
		} else if (property.equals("copy")) {
			if (testFile1.isFile() && testFile2.isFile()) {
				FileUtils.copyFile(testFile1, testFile2);
				isMoved = true;
			}
			if (testFile1.isFile() && testFile2.isDirectory()) {
				FileUtils.copyToDirectory(testFile1, testFile2);
				isMoved = true;
			}

			if (testFile1.isDirectory() && testFile2.isDirectory()) {
				FileUtils.copyDirectoryToDirectory(testFile1, testFile2);
				isMoved = true;
			}
		}
		return isMoved;

	}
}
