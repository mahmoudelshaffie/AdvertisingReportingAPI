package com.crealytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.crealytics.*")
@EntityScan("com.crealytics.reporting.jpa.entities")
@EnableJpaRepositories("com.crealytics.reporting.jpa.repositories")
@SpringBootApplication
public class TestContext {
	
	public static void main(String[] args) {
		String reportsDirectory = TestContext.class.getClassLoader().getResource("reportsfiles").toString();
		ConfigurableApplicationContext context = SpringApplication.run(TestContext.class, "asdsadsadsd");
	}
}
