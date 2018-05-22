package com.crealytics;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.crealytics.reporting.io.CSVReportReader;
import com.crealytics.reporting.io.CSVReportsLoader;
import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;
import com.crealytics.reporting.jpa.repositories.IAdSiteMonthStatRep;
import com.crealytics.reporting.parsing.CSVReportParser;

@Configuration
public class DataInitializer {
		
	@Autowired
	private ApplicationArguments appArgs;
	
	@Autowired
	private IAdSiteMonthStatRep repository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		String reportsFolderPath = appArgs.getSourceArgs()[0];
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Map<String, Path> reportsFiles = CSVReportsLoader.loadAllReportFiles(reportsFolderPath);
		for (String reportName : reportsFiles.keySet()) {
			Path reportPath = reportsFiles.get(reportName);
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Iterator<String> reportCSVData = CSVReportReader.readReportData(reportPath);
						List<AdSiteMonthStat> reportEntities = CSVReportParser.parse(reportName, reportCSVData);
						repository.saveAll(reportEntities);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			});
		}
	}
}
