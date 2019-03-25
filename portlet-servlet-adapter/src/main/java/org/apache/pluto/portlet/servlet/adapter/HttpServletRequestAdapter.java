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
package org.apache.pluto.portlet.servlet.adapter;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Provides a way to decorate a {@link PortletRequest} as an {@link HttpServletRequest}. Methods that have no
 * correspondence to {@link HttpServletRequest} throw {@link UnsupportedOperationException}.
 *
 * @author Neil Griffin
 */
public class HttpServletRequestAdapter implements HttpServletRequest {

	private PortletRequest portletRequest;
	private ServletContext servletContext;

	public HttpServletRequestAdapter(PortletRequest portletRequest) {
		this.portletRequest = portletRequest;
	}

	public HttpServletRequestAdapter(PortletRequest portletRequest, ServletContext servletContext) {
		this.portletRequest = portletRequest;
		this.servletContext = servletContext;
	}

	@Override
	public String getAuthType() {
		return portletRequest.getAuthType();
	}

	@Override
	public Cookie[] getCookies() {
		return portletRequest.getCookies();
	}

	@Override
	public long getDateHeader(String name) {
		return Long.valueOf(portletRequest.getProperty(name));
	}

	@Override
	public String getHeader(String name) {
		return portletRequest.getProperty(name);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		return portletRequest.getProperties(name);
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		return portletRequest.getPropertyNames();
	}

	@Override
	public int getIntHeader(String name) {
		return Integer.valueOf(getHeader(name));
	}

	@Override
	public String getMethod() {

		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getMethod();
		}

		return "";
	}

	@Override
	public String getPathInfo() {
		return "";
	}

	@Override
	public String getPathTranslated() {
		return "";
	}

	@Override
	public String getContextPath() {
		return portletRequest.getContextPath();
	}

	@Override
	public String getQueryString() {
		return "";
	}

	@Override
	public String getRemoteUser() {
		return portletRequest.getRemoteUser();
	}

	@Override
	public boolean isUserInRole(String role) {
		return portletRequest.isUserInRole(role);
	}

	@Override
	public Principal getUserPrincipal() {
		return portletRequest.getUserPrincipal();
	}

	@Override
	public String getRequestedSessionId() {
		return portletRequest.getRequestedSessionId();
	}

	@Override
	public String getRequestURI() {
		return "";
	}

	@Override
	public StringBuffer getRequestURL() {
		return new StringBuffer();
	}

	@Override
	public String getServletPath() {
		return "";
	}

	@Override
	public HttpSession getSession(boolean create) {
		PortletSession portletSession = portletRequest.getPortletSession(create);

		if (portletSession == null) {
			return null;
		}

		return new HttpSessionAdapter(portletSession);
	}

	@Override
	public HttpSession getSession() {
		return getSession(true);
	}

	@Override
	public String changeSessionId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return portletRequest.isRequestedSessionIdValid();
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		return false;
	}

	@Override
	public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
		return false;
	}

	@Override
	public void login(String username, String password) throws ServletException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void logout() throws ServletException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Part> getParts() throws IOException, ServletException {

		if (portletRequest instanceof ClientDataRequest) {
			try {
				return ((ClientDataRequest)portletRequest).getParts();
			}
			catch (PortletException e) {
				throw new ServletException(e);
			}
		}

		return null;
	}

	@Override
	public Part getPart(String name) throws IOException, ServletException {

		if (portletRequest instanceof ClientDataRequest) {
			try {
				return ((ClientDataRequest)portletRequest).getPart(name);
			}
			catch (PortletException e) {
				throw new ServletException(e);
			}
		}

		return null;
	}

	@Override
	public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getAttribute(String name) {
		return portletRequest.getAttribute(name);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return portletRequest.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getCharacterEncoding();
		}

		return "";
	}

	@Override
	public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
		if (portletRequest instanceof ClientDataRequest) {
			((ClientDataRequest)portletRequest).setCharacterEncoding(encoding);
		}
	}

	@Override
	public int getContentLength() {
		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getContentLength();
		}
		else {
			return 0;
		}
	}

	@Override
	public long getContentLengthLong() {
		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getContentLengthLong();
		}
		else {
			return 0;
		}
	}

	@Override
	public String getContentType() {
		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getContentType();
		}
		else {
			return "";
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getParameter(String name) {
		return portletRequest.getParameter(name);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return portletRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		return portletRequest.getParameterValues(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return portletRequest.getParameterMap();
	}

	@Override
	public String getProtocol() {
		return "";
	}

	@Override
	public String getScheme() {
		return portletRequest.getScheme();
	}

	@Override
	public String getServerName() {
		return portletRequest.getServerName();
	}

	@Override
	public int getServerPort() {
		return portletRequest.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {

		if (portletRequest instanceof ClientDataRequest) {
			return ((ClientDataRequest)portletRequest).getReader();
		}

		throw new UnsupportedOperationException();
	}

	@Override
	public String getRemoteAddr() {
		return "";
	}

	@Override
	public String getRemoteHost() {
		return "";
	}

	@Override
	public void setAttribute(String name, Object value) {
		portletRequest.setAttribute(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		portletRequest.removeAttribute(name);
	}

	@Override
	public Locale getLocale() {
		return portletRequest.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return portletRequest.getLocales();
	}

	@Override
	public boolean isSecure() {
		return portletRequest.isSecure();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getRealPath(String path) {
		return "";
	}

	@Override
	public int getRemotePort() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getLocalName() {
		return "";
	}

	@Override
	public String getLocalAddr() {
		return "";
	}

	@Override
	public int getLocalPort() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		throw new UnsupportedOperationException();
	}

	@Override
	public AsyncContext startAsync(
		ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAsyncStarted() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAsyncSupported() {
		throw new UnsupportedOperationException();
	}

	@Override
	public AsyncContext getAsyncContext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DispatcherType getDispatcherType() {
		throw new UnsupportedOperationException();
	}
}
