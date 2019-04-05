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
package javax.portlet.tck.filter;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableActionParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.ActionParametersWrapper;
import javax.portlet.filter.ActionRequestWrapper;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletRequestWrapper;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class serves as a portlet filter for the ACTION_PHASE of the portlet lifecycle. It detects
 * whether or not the TCK is running in Apache Pluto and if so, it decorates the ActionRequest so
 * that the Spring Security "_csrf" action parameter is hidden. This is necessary because the TCK
 * does not take into account the possibility of a portlet container implementation automatically
 * including vendor-specific action parameters with every action request. For more information,
 * see https://issues.apache.org/jira/browse/PLUTO-768
 */
public class PlutoTckPortletFilter implements ActionFilter {

	@Override
	public void doFilter(
		ActionRequest actionRequest, ActionResponse actionResponse, FilterChain filterChain)
		throws IOException, PortletException {

		if (isPlutoRequest(actionRequest)) {
			actionRequest = new PlutoTckActionRequest(actionRequest);
		}

		filterChain.doFilter(actionRequest, actionResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
	}

	@Override
	public void destroy() {
	}

	public boolean isPlutoRequest(PortletRequest portletRequest) {

		portletRequest = unwrapPortletRequest(portletRequest);

		Class<? extends PortletRequest> portletRequestClass = portletRequest.getClass();

		String portletRequestClassName = portletRequestClass.getName();

		return portletRequestClassName.startsWith("org.apache.pluto");
	}

	private PortletRequest unwrapPortletRequest(PortletRequest portletRequest) {

		if (portletRequest instanceof PortletRequestWrapper) {
			PortletRequestWrapper portletRequestWrapper = (PortletRequestWrapper) portletRequest;

			return unwrapPortletRequest(portletRequestWrapper.getRequest());
		}

		return portletRequest;
	}

	private static class PlutoTckActionRequest extends ActionRequestWrapper {

		private ActionParameters actionParameters;
		private Set<String> parameterNames;
		private Map<String, String[]> parameterMap;

		public PlutoTckActionRequest(ActionRequest actionRequest) {
			super(actionRequest);
		}

		@Override
		public ActionParameters getActionParameters() {
			if (actionParameters == null) {
				actionParameters =
					new PlutoTckActionParameters(super.getActionParameters());
			}
			return actionParameters;
		}

		@Override
		public String getParameter(String name) {

			if ("_csrf".equals(name)) {
				return null;
			}

			return super.getParameter(name);
		}

		@Override
		public String[] getParameterValues(String name) {

			if ("_csrf".equals(name)) {
				return null;
			}

			return super.getParameterValues(name);
		}

		@Override
		public Enumeration<String> getParameterNames() {

			if (parameterNames == null) {
				parameterNames = new HashSet<>();
				Enumeration<String> actionRequestParameterNames =
					super.getParameterNames();
				while (actionRequestParameterNames.hasMoreElements()) {
					String actionRequestParameterName =
						actionRequestParameterNames.nextElement();
					if (!"_csrf".equals(actionRequestParameterName)) {
						parameterNames.add(actionRequestParameterName);
					}
				}
			}
			return Collections.enumeration(parameterNames);
		}

		@Override
		public Map<String, String[]> getParameterMap() {

			if (this.parameterMap == null) {
				this.parameterMap = new HashMap<>();

				Map<String, String[]> parameterMap = super.getParameterMap();
				for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
					if (!"_csrf".equals(entry.getKey())) {
						this.parameterMap.put(entry.getKey(), entry.getValue());
					}
				}
			}

			return parameterMap;
		}
	}

	private static class PlutoTckActionParameters extends ActionParametersWrapper {

		private Set<String> names;
		private Integer size;

		public PlutoTckActionParameters(ActionParameters actionParameters) {
			super(actionParameters);
		}

		@Override
		public Set<String> getNames() {

			if (names == null) {
				names = new HashSet<>(super.getNames());
				names.remove("_csrf");
			}

			return names;
		}

		@Override
		public String getValue(String name) {

			if ("_csrf".equals(name)) {
				return null;
			}

			return super.getValue(name);
		}

		@Override
		public String[] getValues(String name) {

			if ("_csrf".equals(name)) {
				return null;
			}

			return super.getValues(name);
		}

		@Override
		public MutableActionParameters clone() {
			MutableActionParameters mutableActionParameters = super.clone();
			mutableActionParameters.removeParameter("_csrf");
			return mutableActionParameters;
		}

		@Override
		public int size() {

			if (size == null) {
				size = getNames().size();
			}

			return size;
		}
	}
}
