package com.crealytics.reporting.exceptions;

public class NoSiteMonthReportFoundedException extends Exception {

	public NoSiteMonthReportFoundedException(String month, String site) {
		super("No report found for site: " + site + " and month: "+ month);
	}
}
