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

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.enterprise.inject.Vetoed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is automatically picked up by Spring due to the presence of the annotation-config and component-scan
 * elements in the Spring bean descriptor. Its purpose is to enable only the CSRF protection provided by Spring
 * Security.
 *
 * @author Neil Griffin
 */
@Configuration
@EnableWebSecurity
@Vetoed
public class PortalSecurityConfigurer extends WebSecurityConfigurerAdapter {

	public PortalSecurityConfigurer() {

		// Disable defaults so that the configure(HttpSecurity) method can selectively enable features that are
		// relevant to portlets.
		super(true);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().and().exceptionHandling().accessDeniedHandler(new PortletAccessDeniedHandler());
	}

	private static class PortletAccessDeniedHandler implements
		AccessDeniedHandler {

		@Override
		public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
						   AccessDeniedException accessDeniedException) throws
			IOException, ServletException {
			throw accessDeniedException;
		}
	}
}
