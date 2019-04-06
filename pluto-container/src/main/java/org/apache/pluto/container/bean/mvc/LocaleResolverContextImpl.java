/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.bean.mvc;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mvc.locale.LocaleResolverContext;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


/**
 * @author  Neil Griffin
 */
public class LocaleResolverContextImpl implements LocaleResolverContext {

	private List<Locale> acceptableLanguages;
	private Configuration configuration;
	private Map<String, Cookie> cookies;
	private Map<String, String> headers;
	private UriInfo uriInfo;

	public LocaleResolverContextImpl(List<Locale> acceptableLanguages, Configuration configuration,
		Map<String, Cookie> cookies, Map<String, String> headers, UriInfo uriInfo) {
		this.acceptableLanguages = acceptableLanguages;
		this.configuration = configuration;
		this.cookies = cookies;
		this.headers = headers;
		this.uriInfo = uriInfo;
	}

	@Override
	public List<Locale> getAcceptableLanguages() {
		return acceptableLanguages;
	}

	@Override
	public Configuration getConfiguration() {
		return configuration;
	}

	@Override
	public Cookie getCookie(String name) {
		return cookies.get(name);
	}

	@Override
	public String getHeaderString(String name) {
		return headers.get(name);
	}

	@Override
	public Request getRequest() {
		return new RequestImpl();
	}

	@Override
	public UriInfo getUriInfo() {
		return uriInfo;
	}
}
