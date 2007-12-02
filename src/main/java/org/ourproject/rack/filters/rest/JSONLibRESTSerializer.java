package org.ourproject.rack.filters.rest;

import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JSONLibRESTSerializer implements RESTSerializer {
	private final JsonConfig config;

	public JSONLibRESTSerializer() {
		config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
	}

	public String serialize(Object target, String format) {
		if (format.equals(RESTMethod.FORMAT_JSON))
			return JSONSerializer.toJSON(target, config).toString();
		else
			throw new RuntimeException("format not implemented!");
	}

}
