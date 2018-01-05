/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.tck.servlet;

import java.util.Map;

import javax.portlet.tck.util.ResourceReader;
import javax.portlet.tck.util.WebConfig;
import javax.portlet.tck.util.WebConfigScanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class StartupListener implements ServletContextListener {

	private static Map<String, String> configuredContextParams;
	private static String displayName;
	private static ServletContext servletContext;

	public static ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContext = servletContextEvent.getServletContext();

		ResourceReader resourceReader = new ResourceReader(servletContext);
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		boolean validating = false;
		saxParserFactory.setValidating(validating);
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser;
		try {
			saxParser = saxParserFactory.newSAXParser();
			boolean resolveEntities = false;
			boolean scanWebFragments = true;
			WebConfigScanner webConfigScanner = new WebConfigScanner(getClass().getClassLoader(), resourceReader,
					saxParser, resolveEntities, scanWebFragments);
			WebConfig webConfig = webConfigScanner.scan();
			configuredContextParams = webConfig.getConfiguredContextParams();
			displayName = webConfig.getDisplayName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, String> getConfiguredContextParams() {
		return configuredContextParams;
	}

	public static String getDisplayName() {
		return displayName;
	}
}
