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

package javax.portlet.tck.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import javax.xml.parsers.SAXParser;

public class WebConfigScanner {

	// Private Constants
	private static final String WEB_XML_PATH = "/WEB-INF/web.xml";
	private static final String WEB_FRAGMENT_META_INF_PATH = "META-INF/web-fragment.xml";

	// Private Data Members
	private ClassLoader classLoader;
	private boolean resolveEntities;
	private ResourceReader resourceReader;
	private SAXParser saxParser;
	private boolean scanWebFragments;

	public WebConfigScanner(ClassLoader classLoader, ResourceReader resourceReader, SAXParser saxParser,
			boolean resolveEntities, boolean scanWebFragments) {
		this.classLoader = classLoader;
		this.resourceReader = resourceReader;
		this.saxParser = saxParser;
		this.resolveEntities = resolveEntities;
		this.scanWebFragments = scanWebFragments;
	}

	protected WebConfigParser newWebConfigParser() {
		return new WebConfigParser(saxParser, resolveEntities);
	}

	public WebConfig scan() throws IOException {

		// Parse the Servlet 3.0 META-INF/web-fragment.xml descriptor files
		// found in the classpath.
		WebConfig webConfig = new WebConfig();
		InputStream inputStream = null;
		if (scanWebFragments) {
			Enumeration<URL> webFragmentURLs = classLoader.getResources(WEB_FRAGMENT_META_INF_PATH);

			if (webFragmentURLs != null) {

				while (webFragmentURLs.hasMoreElements()) {
					URL webFragmentURL = webFragmentURLs.nextElement();
					System.out.println("Processing web-fragment: [" + webFragmentURL + "]");
					inputStream = webFragmentURL.openStream();

					WebConfigParser webConfigParser = newWebConfigParser();

					try {
						webConfig = webConfigParser.parse(inputStream, webConfig);
						inputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		// Parse the WEB-INF/web.xml descriptor.
		inputStream = resourceReader.getResourceAsStream(WEB_XML_PATH);

		if (inputStream != null) {
			System.out.println("Processing web-app: [" + WEB_XML_PATH + "]");

			WebConfigParser webConfigParser = newWebConfigParser();

			try {
				webConfig = webConfigParser.parse(inputStream, webConfig);
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException(e.getMessage());
			}
		}

		return webConfig;
	}
}
