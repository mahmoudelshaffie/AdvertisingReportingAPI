package com.crealytics.reporting.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.crealytics.TestContext;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestContext.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SitesReportsRESTIntegrationTest {
	private static final String BASE_URL = "http://localhost:8080/reports";
	
	@Test
	public void testGetAllReportsShouldReturnAllEntriesInDBSuccessfully() {
		Response response = RestAssured.get(BASE_URL);
		assertEquals(response.getStatusCode(), HttpStatus.OK.value());
		Integer body = response.getBody().jsonPath().get("$.size()");
		assertEquals(8, body, 0);
	}
	
	@Test
	public void testGetMonthSiteReportShouldReturnCorrespondingEntitySuccessfully() {
		String query = "?month=jan&site=android";
		Response response = RestAssured.get(BASE_URL + query);
		assertEquals(response.getStatusCode(), HttpStatus.OK.value());
		Integer month = response.getBody().jsonPath().get("month");
		String site = response.getBody().jsonPath().get("site");
		assertEquals(1, month, 0);
		assertEquals("android", site);
	}
	
	@Test
	public void testGetAllMonthReportsShouldReturnCorrespondingEntitySuccessfully() {
		String query = "?month=jan";
		Response response = RestAssured.get(BASE_URL + query);
		assertEquals(response.getStatusCode(), HttpStatus.OK.value());
		Integer body = response.getBody().jsonPath().get("$.size()");
		assertEquals(4, body, 0);
	}
	
	@Test
	public void testGetAllSiteReportsShouldReturnCorrespondingEntitySuccessfully() {
		String query = "?site=android";
		Response response = RestAssured.get(BASE_URL + query);
		assertEquals(response.getStatusCode(), HttpStatus.OK.value());
		Integer body = response.getBody().jsonPath().get("$.size()");
		assertEquals(2, body, 0);
	}
	
	@Test
	public void testGetMonthSiteWithInvalidMonthShouldFailAndResponsdWithBadRequest() {
		String query = "?month=ja&site=android";
		Response response = RestAssured.get(BASE_URL + query);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void testGetMonthSiteWithValidMonthButNotExistReportReportShouldFailAndResponsdWithNotFound() {
		String query = "?month=jan&site=androidasdsa";
		Response response = RestAssured.get(BASE_URL + query);
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND.value());
	}
}
