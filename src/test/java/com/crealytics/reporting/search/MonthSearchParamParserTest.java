package com.crealytics.reporting.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crealytics.reporting.exceptions.InvalidMonthFormatException;

public class MonthSearchParamParserTest {

	@Test
	public void testParseWithValidDigitsShouldBeParsedSuccessfully() throws InvalidMonthFormatException {
		String valildMonthStr = "10";
		Byte output = MonthSearchParamParser.parse(valildMonthStr);
		Byte expectedOutput = new Byte((byte) 10);
		assertEquals(expectedOutput, output);
	}
	
	@Test(expected=InvalidMonthFormatException.class)
	public void testParseWithInValidNegativeDigitsShouldBeParsedShouldFailExpectInvalidMonthFormatException() throws InvalidMonthFormatException {
		String valildMonthStr = "-9";
		Byte output = MonthSearchParamParser.parse(valildMonthStr);
	}
	
	@Test(expected=InvalidMonthFormatException.class)
	public void testParseWithDigitsGreaterThan12ShouldBeParsedShouldFailExpectInvalidMonthFormatException() throws InvalidMonthFormatException {
		String valildMonthStr = "54";
		Byte output = MonthSearchParamParser.parse(valildMonthStr);
	}
	
	@Test
	public void testParseWithJanPrefixShouldReturn01Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "jan";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 1);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithFebPrefixShouldReturn02Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "feb";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 2);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithMarPrefixShouldReturn03Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "mar";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 3);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithAprPrefixShouldReturn04Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "apr";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 4);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithMayPrefixShouldReturn05Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "may";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 5);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithJunPrefixShouldReturn06Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "jun";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 6);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithJulPrefixShouldReturn07Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "jul";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 7);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithAugPrefixShouldReturn08Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "aug";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 8);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithSepPrefixShouldReturn09Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "sep";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 9);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithOctPrefixShouldReturn10Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "oct";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 10);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithNovPrefixShouldReturn11Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "nov";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 11);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithDecPrefixShouldReturn12Successfully() throws InvalidMonthFormatException {
		String monthPrefix = "dec";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithJanuaryShouldReturn01Successfully() throws InvalidMonthFormatException {
		String monthName = "january";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 1);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithFebrauaryShouldReturn02Successfully() throws InvalidMonthFormatException {
		String month = "febrauary";
		Byte output = MonthSearchParamParser.parse(month);
		Byte expectedOutput = new Byte((byte) 2);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithMarchShouldReturn03Successfully() throws InvalidMonthFormatException {
		String monthName = "march";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 3);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithAprilShouldReturn04Successfully() throws InvalidMonthFormatException {
		String monthName = "april";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 4);
		assertEquals(expectedOutput, output);
	}
	
	
	@Test
	public void testParseWithJunePrefixShouldReturn06Successfully() throws InvalidMonthFormatException {
		String monthName = "june";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 6);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithJulyShouldReturn07Successfully() throws InvalidMonthFormatException {
		String month = "july";
		Byte output = MonthSearchParamParser.parse(month);
		Byte expectedOutput = new Byte((byte) 7);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithAugustShouldReturn08Successfully() throws InvalidMonthFormatException {
		String monthName = "august";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 8);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithSeptemberShouldReturn09Successfully() throws InvalidMonthFormatException {
		String monthName = "september";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 9);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithOctoberShouldReturn10Successfully() throws InvalidMonthFormatException {
		String monthName = "october";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 10);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithNovemberShouldReturn11Successfully() throws InvalidMonthFormatException {
		String monthNAme = "november";
		Byte output = MonthSearchParamParser.parse(monthNAme);
		Byte expectedOutput = new Byte((byte) 11);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseWithDecemberShouldReturn12Successfully() throws InvalidMonthFormatException {
		String monthName= "december";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
	
	@Test(expected=InvalidMonthFormatException.class)
	public void testParseWithInvaidMonthNameShouldFailAndThrowsInvalidMonthFormatException() throws InvalidMonthFormatException {
		String invalidMonthName= "invalid";
		Byte output = MonthSearchParamParser.parse(invalidMonthName);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
	
	@Test(expected=InvalidMonthFormatException.class)
	public void testParseWithInvaidMonthPrefixShouldFailAndThrowsInvalidMonthFormatException() throws InvalidMonthFormatException {
		String invalidMonthPrefix= "inv";
		Byte output = MonthSearchParamParser.parse(invalidMonthPrefix);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseCaseInsensitiveWithPrefixShouldParseSuccessfully() throws InvalidMonthFormatException {
		String monthPrefix= "Dec";
		Byte output = MonthSearchParamParser.parse(monthPrefix);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
	
	@Test
	public void testParseCaseInsensitiveWithMonthNameShouldParseSuccessfully() throws InvalidMonthFormatException {
		String monthName= "December";
		Byte output = MonthSearchParamParser.parse(monthName);
		Byte expectedOutput = new Byte((byte) 12);
		assertEquals(expectedOutput, output);
	}
}
