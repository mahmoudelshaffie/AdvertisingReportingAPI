package com.crealytics.reporting.exceptions;

public class InvalidMonthFormatException extends Exception {

	public InvalidMonthFormatException(String invalidVal) {
		super(invalidVal + " Is not a valid month, please provide a value like '01' or 'Jan' or 'January'");
	}
}
