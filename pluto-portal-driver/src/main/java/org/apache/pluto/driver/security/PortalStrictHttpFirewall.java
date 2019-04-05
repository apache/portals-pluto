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
package org.apache.pluto.driver.security;

import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * This class is designed to override the default "strictHttpFirewall" bean that ships with Spring
 * Security. Its purpose is to override the {@link #getFirewalledRequest(HttpServletRequest)} method
 * so that the {@link FirewalledRequest#getParameter(String)} method can return the value of the
 * Spring "_csrf" URL parameter. This is necessary because Apache Pluto's portlet URLs do not follow
 * a conventional name=value URL parameter syntax. Instead, are delimited by forward slashes and
 * have a "lifecycle;name:value" type of syntax.
 *
 * @author Neil Griffin
 */
public class PortalStrictHttpFirewall extends StrictHttpFirewall {

	@Override
	public FirewalledRequest getFirewalledRequest(
		HttpServletRequest request) throws RequestRejectedException {
		return super.getFirewalledRequest(new PortalHttpServletRequest(request));
	}

	private static class PortalHttpServletRequest extends
		HttpServletRequestWrapper {

		private static final String DEFAULT_CSRF_PARAM_PATTERN = CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME + ":";

		public PortalHttpServletRequest(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {

			if ((name != null) && name.equals(CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME)) {

				String requestURI = getRequestURI();

				int pos = requestURI.indexOf(DEFAULT_CSRF_PARAM_PATTERN);

				if (pos > 0) {

					String parameterValue = requestURI.substring(pos + DEFAULT_CSRF_PARAM_PATTERN.length());

					pos = parameterValue.indexOf("/");

					if (pos > 0) {
						parameterValue = parameterValue.substring(0, pos);
					}

					return parameterValue;
				}
			}

			return super.getParameter(name);
		}
	}
}
