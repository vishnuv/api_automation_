package org.api.automation;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("test"+generatedString);
	}
	
	public static String getSalary() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("123"+generatedString);
	}
	
	public static String getAge() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("23"+generatedString);
	}
	
	public static String getJob() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("Leader"+generatedString);
	}

}
