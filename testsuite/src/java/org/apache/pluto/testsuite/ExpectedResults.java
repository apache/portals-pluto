/*
 * Copyright 2004 The Apache Software Foundation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.apache.pluto.testsuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A Singleton which loads a properties file containing data expected
 * by the tests in the testsuite.
 *
 */
public class ExpectedResults {
	public static final String PROPERTY_FILENAME = "expectedResults.properties";
	
	public static final String EXPECTED_PORTAL_INFO_KEY = "expected.portalInfo";	
	
	private static ExpectedResults expectedResults;
	private Properties properties;
	
	private ExpectedResults() throws IOException {
		this.properties = new Properties();
		
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILENAME);
		if (in == null) {
			throw new IOException("Could not find " + PROPERTY_FILENAME);
		}
		this.properties.load(in);
	}
	
	public Properties getProperties() {
		return this.properties;
	}
	
	/**
	 * Retrieves properties expected by the test suite.
	 *  
	 * @return the Properties found in the properties file.
	 * @throws InvalidConfigurationException if an error occured reading the properties file.
	 */
	public static Properties getExpectedProperties() throws InvalidConfigurationException {
		try {
			if (expectedResults == null) {
				expectedResults = new ExpectedResults(); 
			}
			
			return expectedResults.getProperties(); 
		} catch (IOException e) {
			throw new InvalidConfigurationException("An error occured reading the resource " + PROPERTY_FILENAME + ". Error was " + e.getMessage());
		}
	}

}
