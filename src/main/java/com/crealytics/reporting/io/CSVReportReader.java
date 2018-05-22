package com.crealytics.reporting.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class CSVReportReader {

	/**
	 * 
	 * @param reportPath
	 * @return
	 * @throws IOException 
	 */
	public static Iterator<String> readReportData(Path reportPath) throws IOException {
		BufferedReader reader = Files.newBufferedReader(reportPath);
		// Since there no of sites sounds to be very small, currently & future, so there is no need to partial reading from file
		return reader.lines().skip(1).iterator(); //Skipping header line
	}
}
