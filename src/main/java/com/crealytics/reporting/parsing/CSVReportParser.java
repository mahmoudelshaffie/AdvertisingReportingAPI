package com.crealytics.reporting.parsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.crealytics.reporting.exceptions.CSVReportParsingExcpetion;
import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;

public class CSVReportParser {
	
	private static AdSiteMonthStat toEntity(String reportName, String siteCSV) {
		AdSiteMonthStat entity = new AdSiteMonthStat();
		
		String[] reportDateParts = reportName.split("_");
		Short year = new Short(reportDateParts[0]);
		Byte month = new Byte(reportDateParts[1]);
		entity.setYear(year);
		entity.setMonth(month);
		
		StringTokenizer tokenizer = new StringTokenizer(siteCSV, ",");
		
		String site = tokenizer.nextToken().trim();
		site = site.replaceAll("\\s", "_");
		entity.setSite(site);
		
		Long requests = new Long(tokenizer.nextToken().trim());
		entity.setRequests(requests);
		
		Long impressions = new Long(tokenizer.nextToken().trim());
		entity.setImpressions(impressions);
		
		Long clicks = new Long(tokenizer.nextToken().trim());
		entity.setClicks(clicks);
		
		Long conversions = new Long(tokenizer.nextToken().trim());
		entity.setConversions(conversions);
		
		Double revenue = new Double(tokenizer.nextToken().trim());
		entity.setRevenue(revenue);
		
		Double ctr = (double) (((float) clicks / impressions) * 100);
		entity.setCtr(ctr);
		
		Double cr = (double) ((float) conversions / impressions) * 100;
		entity.setCr(cr);
		
		Double fillRate = (double) ((float) impressions / requests) * 100;
		entity.setFillRate(fillRate);
		
		Double eCPM = (revenue * 1000) / impressions;
		entity.seteCPM(eCPM);
		
		return entity;		
	}

	public static List<AdSiteMonthStat> parse(String reportName, Iterator<String> csv)  {
		try {
			List<AdSiteMonthStat> monthsStats = new LinkedList<>();
			
			while(csv.hasNext()) {
				String siteCSV = csv.next();
				monthsStats.add(toEntity(reportName, siteCSV));
			}
			
			return monthsStats;			
		} catch (Exception e) {
			throw new CSVReportParsingExcpetion(e);
		}
	}
}
