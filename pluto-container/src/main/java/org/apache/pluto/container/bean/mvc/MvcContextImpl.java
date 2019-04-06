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

import java.net.URI;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.MvcContext;
import javax.mvc.locale.LocaleResolver;
import javax.mvc.security.Csrf;
import javax.mvc.security.Encoders;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.annotations.PortletRequestScoped;
import javax.servlet.http.Cookie;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriBuilder;


/**
 * @author  Neil Griffin
 */
@Named("mvc")
@PortletRequestScoped
public class MvcContextImpl implements MvcContext {

	@Inject
	private Configuration configuration;

	private Csrf csrf;

	@Inject
	private Encoders encoders;

	private Locale locale;

	@Inject
	private LocaleResolverChain localeResolverChain;

	@Inject
	private PortletContext portletContext;

	@Inject
	private PortletRequest portletRequest;

	@Override
	public String getBasePath() {
		return portletContext.getContextPath();
	}

	@Override
	public Configuration getConfig() {
		return configuration;
	}

	@Override
	public Csrf getCsrf() {
		return csrf;
	}

	@Override
	public Encoders getEncoders() {
		return encoders;
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	@PostConstruct
	public void postConstruct() {

		SpringCsrfToken springCsrfToken = new SpringCsrfToken(portletRequest.getAttribute(
					"org.springframework.security.web.csrf.CsrfToken"));

		csrf = new CsrfImpl(springCsrfToken.getName(), springCsrfToken.getValue());

		List<LocaleResolver> localeResolvers = localeResolverChain.getLocaleResolvers();

		Map<String, javax.ws.rs.core.Cookie> cookieMap = new HashMap<>();

		Cookie[] cookies = portletRequest.getCookies();

		for (Cookie cookie : cookies) {
			cookieMap.put(cookie.getName(), new javax.ws.rs.core.Cookie(cookie.getName(), cookie.getValue()));
		}

		Map<String, String> headerMap = new HashMap<>();

		Enumeration<String> propertyNames = portletRequest.getPropertyNames();

		while (propertyNames.hasMoreElements()) {
			String header = propertyNames.nextElement();
			headerMap.put(header, portletRequest.getProperty(header));
		}

		LocaleResolverContextImpl localeResolverContext = new LocaleResolverContextImpl(Collections.list(
					portletRequest.getLocales()), configuration, cookieMap, headerMap, new UriInfoImpl());

		for (LocaleResolver localeResolver : localeResolvers) {
			locale = localeResolver.resolveLocale(localeResolverContext);

			if (locale != null) {
				break;
			}
		}
	}

	@Override
	public URI uri(String identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI uri(String identifier, Map<String, Object> params) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UriBuilder uriBuilder(String s) {
		throw new UnsupportedOperationException();
	}
}
