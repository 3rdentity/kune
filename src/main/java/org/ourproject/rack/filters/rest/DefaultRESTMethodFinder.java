package org.ourproject.rack.filters.rest;

import java.lang.reflect.Method;


public class DefaultRESTMethodFinder implements RESTMethodFinder {

	public JsonMethod findMethod(String methodName, Parameters parameters, Class<?> serviceType) {
		Method[] allMethods = serviceType.getMethods();
		for (Method method : allMethods) {
			REST methodAnnotation = method.getAnnotation(REST.class);
			if (methodAnnotation != null && method.getName().equals(methodName)) {
				checkParams(methodAnnotation, parameters);
				return new JsonMethod(method, methodAnnotation.params(), parameters);
			}
		}
		return null;
	}

	private boolean checkParams(REST methodAnnotation, Parameters parameters) {
		for (String name : methodAnnotation.params()) {
			if (parameters.get(name) == null) {
				return false;
			}
		}
		return true;
	}
}