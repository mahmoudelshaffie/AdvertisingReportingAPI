package com.crealytics.reporting.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crealytics.reporting.exceptions.CSVReportParsingExcpetion;
import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;

public class CSVReportParserTest {
	private DecimalFormat decimalFormat = new DecimalFormat("#.000");

	@Test
	public void testWithValidReportAndValidCSVEntriesShouldBeParsedSuccessfully() {
		List<String> validCSV = new ArrayList<>(3);
		validCSV.add("desktop web, 12483775, 11866157, 30965, 7608, 23555.46");

		String validReportName = "2018_02_report.csv";
		
		List<AdSiteMonthStat> output = CSVReportParser.parse(validReportName, validCSV.iterator());
		byte expectedMonth = (byte) 2;
		short expectedYear = 2018;
		double expectedCR = 0.064115;
		double expectedCTR = 0.260952;
		double expectedECPM = 1.9850959;
		double expectedFileRate= 95.0526343;
				
		AdSiteMonthStat entity = output.get(0);
		assertNotNull(entity);
		assertFalse("Expect spaces to be replaced with '_' underscore", entity.getSite().contains(" "));
		assertEquals("Invalid Calcluated CR", decimalFormat.format(expectedCR), decimalFormat.format(entity.getCr()));
		assertEquals("Invalid Calcluated CTR", decimalFormat.format(expectedCTR), decimalFormat.format(entity.getCtr()));
		assertEquals("Invalid Calcluated eCPM", decimalFormat.format(expectedECPM), decimalFormat.format(entity.geteCPM()));
		assertEquals("Invalid Calcluated FILE_RATE", decimalFormat.format(expectedFileRate), decimalFormat.format(entity.getFillRate()));
		assertEquals("Invalid Month", expectedMonth, entity.getMonth(), 0);
		assertEquals("Invalid Year", expectedYear, entity.getYear(), 0);
	}
	
	@Test(expected=CSVReportParsingExcpetion.class)
	public void testWithInValidReportNameAndValidCSVEntriesShouldFailedAndThrowsCSVReportParsingExcpetion() {
		List<String> validCSV = new ArrayList<>(3);
		validCSV.add("desktop web, 12483775, 11866157, 30965, 7608, 23555.46");

		String inValidReportName = "201_asd_report.csv";
		
		List<AdSiteMonthStat> output = CSVReportParser.parse(inValidReportName, validCSV.iterator());
	}
	
	@Test(expected=CSVReportParsingExcpetion.class)
	public void testWithValidReportNameAndInvalidCSVEntriesShouldFailedAndThrowsCSVReportParsingExcpetion() {
		List<String> invalidCSV = new ArrayList<>(3);
		invalidCSV.add("desktop web, 12483775, oi080, 30965, 7608, 23555.46");

		String validReportName = "2018_02_report.csv";
		
		List<AdSiteMonthStat> output = CSVReportParser.parse(validReportName, invalidCSV.iterator());
	}
	
}

