package com.crealytics.reporting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalRESTControllerExceptionHandler {

	@ExceptionHandler(value=NoSiteMonthReportFoundedException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public @ResponseBody String handleNoReportFoundException(NoSiteMonthReportFoundedException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(value=InvalidMonthFormatException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleInvalidMonthFormatException(InvalidMonthFormatException ex) {
		return ex.getMessage();
	}
}
