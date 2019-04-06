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

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;


/**
 * @author  Neil Griffin
 */
public class ConfigurationImpl implements Configuration {

	public static final String DEFAULT_VIEW_EXTENSION = "org.apache.pluto.defaultViewExtension";

	private Map<String, Object> properties;

	@Inject
	private PortletConfig portletConfig;

	@Inject
	private PortletContext portletContext;

	@Override
	public Set<Class<?>> getClasses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Class<?>, Integer> getContracts(Class<?> componentClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Object> getInstances() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Object> getProperties() {

		if (properties == null) {

			properties = new HashMap<>();

			Enumeration<String> initParameterNames = portletConfig.getInitParameterNames();

			while (initParameterNames.hasMoreElements()) {
				String initParameterName = initParameterNames.nextElement();
				properties.put(initParameterName, portletConfig.getInitParameter(initParameterName));
			}

			initParameterNames = portletContext.getInitParameterNames();

			while (initParameterNames.hasMoreElements()) {
				String initParameterName = initParameterNames.nextElement();
				properties.put(initParameterName, portletContext.getInitParameter(initParameterName));
			}

			if (!properties.containsKey(DEFAULT_VIEW_EXTENSION)) {
				properties.put(DEFAULT_VIEW_EXTENSION, "jsp");
			}
		}

		return properties;
	}

	@Override
	public Object getProperty(String name) {

		Map<String, Object> properties = getProperties();

		return properties.get(name);
	}

	@Override
	public Collection<String> getPropertyNames() {

		Map<String, Object> properties = getProperties();

		return properties.keySet();
	}

	@Override
	public RuntimeType getRuntimeType() {
		return RuntimeType.SERVER;
	}

	@Override
	public boolean isEnabled(Feature feature) {
		return false;
	}

	@Override
	public boolean isEnabled(Class<? extends Feature> featureClass) {
		return false;
	}

	@Override
	public boolean isRegistered(Object component) {
		return false;
	}

	@Override
	public boolean isRegistered(Class<?> componentClass) {
		return false;
	}
}
