package Controllers;

import java.io.File;
import java.io.FileNotFoundException;

public class NewDirectoryBuilderClass {
	private static File file;
	private static String filePath;

	public static void mkdir(String path,String files) throws FileNotFoundException {
		if(path==null) {
			throw new FileNotFoundException("Path is not specified");
		}
		filePath = path;
		if (files.length() == 0 || files.isBlank() || files.equals("")) {
			createDirectory("New Folder",filePath);
		} else {
			String[] fileNames = files.split(" ");
			
			for(int i=0;i<fileNames.length;i++) {
				file = new File(filePath+"\\"+fileNames[i]);
				if(!file.exists()) {
					createDirectory(fileNames[i],filePath);
				}
			}
		}
	}
	
	private static void createDirectory(String fileName,String filePath) {
		String path = filePath + "\\" + fileName;
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
}
