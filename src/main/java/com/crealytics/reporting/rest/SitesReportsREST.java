package com.crealytics.reporting.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crealytics.reporting.exceptions.InvalidMonthFormatException;
import com.crealytics.reporting.exceptions.NoSiteMonthReportFoundedException;
import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;
import com.crealytics.reporting.jpa.repositories.IAdSiteMonthStatRep;
import com.crealytics.reporting.json.DoubleJsonSerailzier;
import com.crealytics.reporting.search.MonthSearchParamParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/reports")
public class SitesReportsREST {

	@Autowired
	private IAdSiteMonthStatRep rep;
	
	private Gson gson;
	
	public SitesReportsREST() {
		gson = new GsonBuilder().registerTypeAdapter(Double.class, new DoubleJsonSerailzier()).create();
	}

	private String getMonthSiteReport(String month, String site)
			throws InvalidMonthFormatException, NoSiteMonthReportFoundedException {
		
		Byte formattedMonth = MonthSearchParamParser.parse(month);
		AdSiteMonthStat report = rep.findOneBySiteAndMonth(site, formattedMonth);

		if (report == null) {
			throw new NoSiteMonthReportFoundedException(month, site);
		}

		return gson.toJson(report);
	}

	private String getMonthSitesReports(String month) throws InvalidMonthFormatException {
		Byte formattedMonth = MonthSearchParamParser.parse(month);
		List<AdSiteMonthStat> reports = rep.findByMonth(formattedMonth);
		return gson.toJson(reports);
	}
	
	private String getSiteMonthesReports(String site) throws InvalidMonthFormatException {
		List<AdSiteMonthStat> reports = rep.findBySite(site);
		return gson.toJson(reports);
	}

	private String getAll() {
		return gson.toJson(rep.findAll());
	}

	@GetMapping
	public @ResponseBody String getReports(@RequestParam(name = "month", required=false) String month,
			@RequestParam(name = "site", required=false) String site)
			throws InvalidMonthFormatException, NoSiteMonthReportFoundedException {
		String body;
		
		if (month != null && site != null) {
			body = getMonthSiteReport(month, site);
		} else if (month == null && site != null) {
			body = getSiteMonthesReports(site);
		} else if (month != null && site == null) {
			body = getMonthSitesReports(month);
		} else {
			body = getAll();
		}
		
		return body;
	}
}
