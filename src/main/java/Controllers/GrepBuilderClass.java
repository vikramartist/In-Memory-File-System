package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GrepBuilderClass {

	private static File file;

	public static String mergeAllText(String text) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < text.length() - 1; i++) {
			builder.append(text.charAt(i));
		}
		return new String(builder);
	}

	public static void validatePatterns(String path, String option, String pattern, List<String> filePaths)
			throws IOException, FileNotFoundException {
		BufferedReader reader = null;
		try {
			for (int i = 2; i < filePaths.size(); i++) {
				file = new File(path + "\\" + filePaths.get(i));
				if (file.exists()) {
					if (file.isFile()) {
						reader = new BufferedReader(new FileReader(file));
						if (option.equals("-i") || option.equals("-v")) {
							caseIgnoreMatchingOrNonMatchingWords(option, reader, file, pattern);
						} else if (option.equals("-n") || option.equals("-c")) {
							countOfMatchedLinesOrMatchingWords(option,reader, file, pattern, 0);
						}else if(option.equals("-l")){
							String word;
							while((word=reader.readLine())!=null) {
								if(word.contains(pattern)) {
									System.out.println(file.getName());
									break;
								}
							}
						}

					} else {
						throw new FileNotFoundException("Please provide the path of a file not a directory or folder");
					}
				} else {
					throw new FileNotFoundException("File Does Not exist!!");
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	private static void caseIgnoreMatchingOrNonMatchingWords(String option,BufferedReader reader, File file, String pattern) throws IOException {
		String word,match = "",notMatch="";
		while ((word = reader.readLine()) != null) {
			if (word.toLowerCase().contains(pattern.toLowerCase())) {
				match += word+"\n";
			}else {
				notMatch += word+"\n";
			}
		}
		if(option.equals("-i")) {
			System.out.print(match);
		}else if(option.equals("-v")){
			System.out.print(notMatch);
		}
	}

	private static void countOfMatchedLinesOrMatchingWords(String option,BufferedReader reader, File file, String pattern,
			int initialValue) throws IOException {
		String word;
		int lineNo = initialValue, countOfMatchedWords = initialValue;
		while ((word = reader.readLine()) != null) {
			if (word.contains(pattern)) {
				System.out.println(lineNo + ": " + word);
				countOfMatchedWords++;
			}
			lineNo++;
		}
		if(option.equals("-c")) {
			System.out.println(countOfMatchedWords);
		}
		
	}

}
