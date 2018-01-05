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
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class WebConfigParser extends SAXHandlerBase {

	// Private Constants
	private static final String CONTEXT_PARAM = "context-param";
	private static final String DISPLAY_NAME = "display-name";
	private static final String PARAM_VALUE = "param-value";
	private static final String PARAM_NAME = "param-name";

	// Private Data Members
	private Map<String, String> configuredContextParams;
	private String displayName;
	private boolean parsingContextParam;
	private boolean parsingDisplayName;
	private boolean parsingParamName;
	private boolean parsingParamValue;
	private String paramValue;
	private String paramName;
	private SAXParser saxParser;

	public WebConfigParser(SAXParser saxParser, boolean resolveEntities) {
		super(resolveEntities);
		this.saxParser = saxParser;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (parsingDisplayName) {
			displayName = content.toString().trim();
			parsingDisplayName = false;
		} else if (parsingContextParam) {

			if (parsingParamName) {
				paramName = content.toString().trim();
				parsingParamName = false;
			} else if (parsingParamValue) {
				paramValue = content.toString().trim();
				parsingParamValue = false;
			}

			if (CONTEXT_PARAM.equals(qName)) {
				System.out.println("    Found context-param name=" + paramName + " value=" + paramValue);
				configuredContextParams.put(paramName, paramValue);
				parsingContextParam = false;
			}
		}
	}

	public WebConfig parse(InputStream inputStream, WebConfig webConfig) throws IOException {

		Map<String, String> configuredContextParams = webConfig.getConfiguredContextParams();
		this.configuredContextParams = new HashMap<String, String>(configuredContextParams);

		try {
			saxParser.parse(inputStream, this);
			webConfig = new WebConfig(this.configuredContextParams, this.displayName);
			saxParser.reset();

			return webConfig;
		} catch (SAXException e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public void startElement(String uri, String localName, String elementName, Attributes attributes)
			throws SAXException {

		content = new StringBuilder();

		if (localName.equals(DISPLAY_NAME)) {
			parsingDisplayName = true;
		} else if (localName.equals(CONTEXT_PARAM)) {
			parsingContextParam = true;
		} else if (localName.equals(PARAM_NAME)) {
			parsingParamName = true;
		} else if (localName.equals(PARAM_VALUE)) {
			parsingParamValue = true;
		}
	}
}
