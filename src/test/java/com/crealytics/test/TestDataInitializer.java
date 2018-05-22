package com.crealytics.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;
import com.crealytics.reporting.jpa.repositories.IAdSiteMonthStatRep;
import com.crealytics.reporting.parsing.CSVReportParser;

@Configuration
public class TestDataInitializer {


	@Autowired
	private IAdSiteMonthStatRep repository;

	@EventListener(ApplicationReadyEvent.class)
	public void init() throws IOException {		
		List<String> report1CSVData = new ArrayList<>(4);
		report1CSVData.add("desktop web,	12483775,	11866157,	30965,	7608,	23555.46");
		report1CSVData.add("mobile web,	9905942,	9401153,	25291,	6216,	19053.61");
		report1CSVData.add("android,	9914106,	9412958,	24395,	6018,	18110.41");
		report1CSVData.add("iOS,	2550165,	2419733,	6331,	1564,	4692.28");
		
		List<AdSiteMonthStat> report1Entities = CSVReportParser.parse("2018_01", report1CSVData.iterator());
		repository.saveAll(report1Entities);
		
		List<String> report2CSVData = new ArrayList<>(4);
		report2CSVData.add("desktop web,	11243875,	10366355,	40456,	1456,	15745.32");
		report2CSVData.add("mobile web,	8804521,	8101153,	15365,	5267,	18053.34");
		report2CSVData.add("android,	8921215,	8342439,	22934,	5347,	17210.12");
		report2CSVData.add("iOS,	5000221,	4512765,	18987,	6001,	11931.37");
		
		List<AdSiteMonthStat> report2Entities = CSVReportParser.parse("2018_02", report2CSVData.iterator());
		repository.saveAll(report2Entities);
	}
}
