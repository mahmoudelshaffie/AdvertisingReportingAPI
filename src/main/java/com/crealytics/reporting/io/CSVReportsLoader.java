package com.crealytics.reporting.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CSVReportsLoader {

	private static String REPORT_FILE_SUFFIX = "_report.csv";
	
	/**
	 * Load all reports files if any in given directory into a map of report's name and report's file path
	 * @param reportsDirectory
	 * @return
	 */
	public static Map<String, Path> loadAllReportFiles(String reportsDirectory) {
		Path directoryPath = Paths.get(reportsDirectory);
		Map<String, Path> reportFiles = new HashMap<>();
		try {
			if (Files.isDirectory(directoryPath)) {
				DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath);
				for (Path path : stream) {
					if (path.toString().endsWith(REPORT_FILE_SUFFIX)) {
						String[] pathasda = path.toString().split("\\\\");
						String reportName = pathasda[pathasda.length - 1];
						reportFiles.put(reportName, path);
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return reportFiles;
	}
}
