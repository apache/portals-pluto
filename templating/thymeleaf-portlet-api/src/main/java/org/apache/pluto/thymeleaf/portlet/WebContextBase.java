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
package org.apache.pluto.thymeleaf.portlet;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.IWebContext;


/**
 * This is a convenient abstract base class that partially implements the {@link IWebContext} interface from Thymeleaf.
 * Sub-classes must implement the {@link #containsVariable(String)}, {@link #getVariableNames()}, and
 * {@link #getVariable(String)} methods.
 *
 * @author  Neil Griffin
 */
public abstract class WebContextBase implements IWebContext {

	private final HttpServletRequest httpServletRequest;
	private final HttpServletResponse httpServletResponse;
	private final Locale locale;
	private final ServletContext servletContext;

	public WebContextBase(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
		ServletContext servletContext, Locale locale) {

		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
		this.locale = locale;
		this.servletContext = servletContext;
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	@Override
	public HttpServletRequest getRequest() {
		return httpServletRequest;
	}

	@Override
	public HttpServletResponse getResponse() {
		return httpServletResponse;
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public HttpSession getSession() {
		return httpServletRequest.getSession();
	}
}
