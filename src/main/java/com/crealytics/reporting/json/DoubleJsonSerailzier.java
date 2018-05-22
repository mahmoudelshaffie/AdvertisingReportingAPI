package com.crealytics.reporting.json;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DoubleJsonSerailzier implements JsonSerializer<Double> {

	@Override
	public JsonElement serialize(Double val, Type type, JsonSerializationContext cxt) {
		BigDecimal percisedVal = new BigDecimal(val).setScale(2, BigDecimal.ROUND_UP);
		return new JsonPrimitive(percisedVal);
	}

}
