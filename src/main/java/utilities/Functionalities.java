package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.FindException;
import java.util.Arrays;
import java.util.List;

import Controllers.DirectoryChangeHelper;
import Controllers.DisplayHelper;
import Controllers.FileOrFolderRemoverHelper;
import Controllers.FileOrFolderTransferClass;
import Controllers.GrepBuilderClass;
import Controllers.NewDirectoryBuilderClass;
import Controllers.NewFileBuilderClass;
import Controllers.WriterHelper;

/*This is a Functionalities Class. This class has all the methods used to validate as per the input given by the user. */
public class Functionalities {
	private static List<String> fileNames;
	private static String path;
	private static File file;

	public static void MakeDirectory(String filePath, String command) {
		try {
			NewDirectoryBuilderClass.mkdir(filePath, command);
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void createDirectory(String fileName) {
		path = path + "\\" + fileName;
		try {
			file = new File(path);
			Boolean bool = file.mkdir();
			if (bool && !file.exists()) {
				System.out.println("Directory created!");
			} else if (file.exists()) {
				System.out.println("Directory created!");
			} else {
				System.out.println("Error in creating directory!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String changeDirectory(String filePath, String command) {
		String display = "";
		if (command.length() == 0 || command.isBlank() || command.equals("")) {
			System.out.println("Path not specified");
		} else {
			try {
				path = filePath;
				display = DirectoryChangeHelper.cd(path, command, display);
			} catch (Exception e) {
				System.out.println(command + " no such file found!!");
				display = path;
			}

		}
		return display;
	}

	public static void listContentsOfCurrentDirectory(String display) {
		DisplayHelper.ls(display);
	}

	public static void createNewFile(String filePath, String command) {
		if (command.length() == 0 || command.isBlank() || command.equals("")) {
			throw new FindException("Path Not specified");
		}
		BufferedWriter writer = null;
		String[] newFiles = command.split(" ");
		fileNames = Arrays.stream(newFiles).toList();
		try {
			path = filePath;
			NewFileBuilderClass.touch(path, fileNames);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void removeFileOrDirectory(String filePath, String command) throws FileNotFoundException {
		if (command.length() == 0 || command.isBlank() || command.equals("") || command == null) {
			throw new FileNotFoundException("Path not specified");
		} else {
			try {

				path = filePath;
				if (command.contains(" ")) {
					String[] folders = command.split(" ");
					for (String word : folders) {
						FileOrFolderRemoverHelper.rm(path, word.stripTrailing());
					}

				} else {
					FileOrFolderRemoverHelper.rm(path, command.stripTrailing());
				}

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}

	}

	public static void displayContentsOfFile(String filePath, String command) {
		if (command.length() == 0 || command.isBlank() || command.equals("")) {
			System.out.println("Path not specified");
		} else {
			BufferedReader reader = null;
			try {

				DisplayHelper.cat(filePath, command);

			} catch (Exception e) {
				System.out.println(command + " File not found!!");
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static boolean writeToAPath(String filePath, String command) {
		boolean isWritten = false;
		if (command.length() == 0 || command.isBlank() || command.equals("")) {
			System.out.println("Path not specified");
			return isWritten;
		} else {
			PrintWriter writer = null;
			try {
				String text = command.substring(0, command.indexOf('>')).trim(),
						folderPath = command.substring(command.indexOf('>') + 2);
				path = filePath;
				if (folderPath.contains("\\") || folderPath.contains("/")) {
					String writePath = changeDirectory(filePath, folderPath);
					if (writePath == null) {
						throw new FileNotFoundException();
					} else {
						isWritten = WriterHelper.echo(path, "", text);
					}
				} else {
					isWritten = WriterHelper.echo(path, folderPath, text);
				}
			} catch (Exception e) {
				System.out.println("FILE DOES NOT EXIST!");
			} finally {
				if (writer != null) {
					writer.close();
				}
			}

		}
		return isWritten;
	}

	public static boolean copyFileOrFolder(String filePath, String source, String destination) {
		boolean isCopied = false;
		if (source == null || destination == null) {
			isCopied = false;
		} else {
			try {
				path = filePath;
				isCopied = FileOrFolderTransferClass.validateTransfer(path, source, destination, "copy");
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		return isCopied;
	}

	public static boolean moveFileOrFolder(String filePath, String source, String destination) {
		boolean isMoved = false;
		if (source == null || destination == null) {
			isMoved = false;
		} else {
			try {
				path = filePath;
				isMoved = FileOrFolderTransferClass.validateTransfer(path, source, destination, "move");

			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		return isMoved;

	}

	public static void grep(String filePath, String function, List<String> files) {
		if (files == null || files.size() == 0) {
			System.out.println("path not specified");
		} else {
			BufferedReader reader = null;
			path = filePath;
			try {
				String text = GrepBuilderClass.mergeAllText(files.get(1));
				switch (function.toLowerCase()) {
				case "-i":
				case "-c":
				case "-l":
				case "-n":
				case "-v":
					GrepBuilderClass.validatePatterns(filePath, function, text, files);
					break;
				default:
					System.out.println(
							"Please choose only those options that are mentioned in the doc, Sorry working on it now!!!");
				}
			} catch (Exception e) {
				System.out.println("FILE NOT FOUND!!");
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}
