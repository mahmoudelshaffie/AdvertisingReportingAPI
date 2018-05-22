package com.crealytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.crealytics.reporting.jpa.entities")
@EnableJpaRepositories("com.crealytics.reporting.jpa.repositories")
@SpringBootApplication
public class AdvertisingReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisingReportingApplication.class, args);
	}
}
