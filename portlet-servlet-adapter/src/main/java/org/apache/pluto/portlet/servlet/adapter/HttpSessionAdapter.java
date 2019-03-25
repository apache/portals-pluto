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

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.Map;


/**
 * Provides a way to decorate a {@link PortletSession} as an {@link HttpSession}. Methods that have no correspondence to
 * {@link HttpSession} throw {@link UnsupportedOperationException}
 *
 * @author  Neil Griffin
 */
public class HttpSessionAdapter implements PortletSession, HttpSession {

	// Private Data Members
	private PortletSession wrappedPortletSession;

	public HttpSessionAdapter(PortletSession portletSession) {
		this.wrappedPortletSession = portletSession;
	}

	@Override
	public Object getAttribute(String name) {
		Object value = wrappedPortletSession.getAttribute(name, PortletSession.PORTLET_SCOPE);

		if (value == null) {
			value = wrappedPortletSession.getAttribute(name, PortletSession.APPLICATION_SCOPE);
		}

		return value;
	}

	@Override
	public Object getAttribute(String name, int scope) {
		return wrappedPortletSession.getAttribute(name, scope);
	}

	@Override
	public Map<String, Object> getAttributeMap() {
		return wrappedPortletSession.getAttributeMap();
	}

	@Override
	public Map<String, Object> getAttributeMap(int scope) {
		return wrappedPortletSession.getAttributeMap(scope);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return wrappedPortletSession.getAttributeNames();
	}

	@Override
	public Enumeration<String> getAttributeNames(int scope) {
		return wrappedPortletSession.getAttributeNames(scope);
	}

	@Override
	public long getCreationTime() {
		return wrappedPortletSession.getCreationTime();
	}

	@Override
	public String getId() {
		return wrappedPortletSession.getId();
	}

	@Override
	public long getLastAccessedTime() {
		return wrappedPortletSession.getLastAccessedTime();
	}

	@Override
	public int getMaxInactiveInterval() {
		return wrappedPortletSession.getMaxInactiveInterval();
	}

	@Override
	public PortletContext getPortletContext() {
		return wrappedPortletSession.getPortletContext();
	}

	@Override
	public ServletContext getServletContext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public HttpSessionContext getSessionContext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getValue(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getValueNames() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void invalidate() {
		wrappedPortletSession.invalidate();
	}

	@Override
	public boolean isNew() {
		return wrappedPortletSession.isNew();
	}

	@Override
	public void putValue(String name, Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeAttribute(String name) {
		wrappedPortletSession.removeAttribute(name);
	}

	@Override
	public void removeAttribute(String name, int scope) {
		wrappedPortletSession.removeAttribute(name, scope);
	}

	@Override
	public void removeValue(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAttribute(String name, Object value) {
		wrappedPortletSession.setAttribute(name, value);
	}

	@Override
	public void setAttribute(String name, Object value, int scope) {
		wrappedPortletSession.setAttribute(name, value, scope);
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		wrappedPortletSession.setMaxInactiveInterval(interval);
	}
}
