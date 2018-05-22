package com.crealytics.reporting.search;

import java.util.HashMap;
import java.util.Map;

import com.crealytics.reporting.exceptions.InvalidMonthFormatException;

public class MonthSearchParamParser {

	private static Map<String, Byte> months;
	
	static {
		months = new HashMap<>();
		months.put("jan", (byte) 1);
		months.put("feb", (byte) 2);
		months.put("mar", (byte) 3);
		months.put("apr", (byte) 4);
		months.put("may", (byte) 5);
		months.put("jun", (byte) 6);
		months.put("jul", (byte) 7);
		months.put("aug", (byte) 8);
		months.put("sep", (byte) 9);
		months.put("oct", (byte) 10);
		months.put("nov", (byte) 11);
		months.put("dec", (byte) 12);
	}
	
	public static byte parse(String monthStr) throws InvalidMonthFormatException {
		Byte month;
		if (monthStr.matches("[0-9]+") && monthStr.length() > 0 && monthStr.length() <= 2) {
			month = new Byte(monthStr);
		} else if (monthStr.matches("[a-zA-Z]+")) {
			monthStr = monthStr.toLowerCase();
			if (monthStr.length() > 3) {
				monthStr = monthStr.substring(0, 3);
			}
			month = months.get(monthStr);
		} else {
			throw new InvalidMonthFormatException(monthStr);
		}
		
		if (month == null || month < 1 || month > 12) {
			throw new InvalidMonthFormatException(monthStr);
		}
		
		return month;
	}

}
