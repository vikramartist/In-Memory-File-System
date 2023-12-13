package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import utilities.Functionalities;

/*This is an In Memory file system built using java and its Io Classes
This is the Main Class in which Scanner class has been used to receive the user's input,
An infinite loop is created until the user selects exit to get out of the loop and stop the application.
The Initial path is taken to be the user's eclipse workspace path
Example in my case: [User.dir]\\eclipse-workspace\\[Project-name]
		
This version 1.0
*/
public class App {

	public static void main(String[] args) {

		Scanner s1 = new Scanner(System.in);
		String option = "", display = System.getProperty("user.dir");
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			System.out.println("\t\t\t\t\t\t\t<-----Welcome to the In-Memory File System----->");

			while (!option.equalsIgnoreCase("exit")) {
				System.out.print(display + "> ");
				option = s1.nextLine();

				/* Create a new Directory */
				if (option.startsWith("mkdir")) {
					if (option.length() == 5) {
						Functionalities.MakeDirectory(display, "");
					} else {
						String command = option.substring(option.indexOf(' ') + 1);
						Functionalities.MakeDirectory(display, command);
					}

				}

				/* Change directory */
				if (option.startsWith("cd")) {
					String command = option.substring(option.indexOf(' ') + 1);
					if (!display.equals("C:\\")) {
						display = Functionalities.changeDirectory(display, command.trim());
					} else {
						System.out.println("Access Denied!");
					}

				}

				/* List the contents of a current directoru */
				if (option.startsWith("ls")) {
					Functionalities.listContentsOfCurrentDirectory(display);
				}

				/* create a new file */
				if (option.startsWith("touch")) {
					if (option.length() == 5) {
						Functionalities.createNewFile(display, "");
					} else {
						String command = option.substring(option.indexOf(' ') + 1);
						Functionalities.createNewFile(display, command);
					}

				}

				/* Read the contents of a given file*/
				if (option.startsWith("cat")) {
					String command = option.substring(option.indexOf(' ') + 1);
					Functionalities.displayContentsOfFile(display, command.trim());
				}

				/*Remove the files or folder*/
				if (option.startsWith("rm")) {
					String command = option.substring(option.indexOf(' ') + 1);
					Functionalities.removeFileOrDirectory(display, command.trim());
				}

				/*Write a text into the desired file or folder*/
				if (option.startsWith("echo")) {
					if (option.equals("echo *")) {
						Functionalities.listContentsOfCurrentDirectory(display);
					} else {
						String command = option.substring(option.indexOf(' ') + 1);
						if (Functionalities.writeToAPath(display, command)) {
							System.out.println("Successfuly written!!");
						}
					}

				}

				/*Copy the Files or folders to destination location*/
				if (option.startsWith("cp")) {
					String command = option.substring(option.indexOf(' ') + 1),
							source = command.substring(0, command.indexOf('>')),
							dest = command.substring(command.indexOf('>') + 1);
					if (Functionalities.copyFileOrFolder(display, source.stripTrailing(), dest.stripLeading())) {
						System.out.println("Copied " + source + " to " + dest + " successfully");
					}

				}

				/*Move the Files or folders to destination location*/
				if (option.startsWith("mv")) {
					String command = option.substring(option.indexOf(' ') + 1),
							source = command.substring(0, command.indexOf('>')),
							dest = command.substring(command.indexOf('>') + 1);
					if (Functionalities.moveFileOrFolder(display, source.stripTrailing(), dest.stripLeading())) {
						System.out.println("Moved " + source + " to " + dest + " successfully");
					}
				}

				/*Bonus Question*/
				/*Search into a given text with a specified pattern of text*/
				if (option.startsWith("grep")) {

					String command = option.substring(option.indexOf(' ') + 1),
							function = command.substring(0, command.indexOf(' '));
					int index = command.indexOf(' ');
					command = command.substring(index);
					Functionalities.grep(display, function, Arrays.stream(command.split(" ")).toList());

				}

				/*Exiting the Application*/
				if (option.equalsIgnoreCase("exit")) {
					System.out.println("Logging out...");
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writer != null) {
				writer.close();

			}
		}
		System.out.println("Successfully logged out!!");
		System.out.flush();
		s1.close();
	}

}
