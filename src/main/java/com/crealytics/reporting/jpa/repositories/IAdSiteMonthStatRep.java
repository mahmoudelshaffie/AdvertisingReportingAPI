package com.crealytics.reporting.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crealytics.reporting.jpa.entities.AdSiteMonthStat;

public interface IAdSiteMonthStatRep extends PagingAndSortingRepository<AdSiteMonthStat, Long> {
	
	AdSiteMonthStat findOneBySiteAndMonth(String site, byte month);
	List<AdSiteMonthStat> findByMonth(byte month);
	List<AdSiteMonthStat> findBySite(String site);

}
