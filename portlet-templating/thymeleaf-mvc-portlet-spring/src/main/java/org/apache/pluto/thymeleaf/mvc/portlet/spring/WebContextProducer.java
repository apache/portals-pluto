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
package org.apache.pluto.thymeleaf.mvc.portlet.spring;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.portlet.servlet.adapter.HttpServletRequestAdapter;
import org.apache.pluto.portlet.servlet.adapter.HttpServletResponseAdapter;
import org.apache.pluto.thymeleaf.portlet.VariableValidator;
import org.apache.pluto.thymeleaf.portlet.WebContextBase;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.thymeleaf.context.IWebContext;


/**
 * This class is a Spring producer that provides the ability to generate instances of {@link IWebContext}.
 *
 * @author  Neil Griffin
 */
@Configuration
public class WebContextProducer implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Scope(proxyMode = ScopedProxyMode.INTERFACES, value = "portletRequest")
	@Bean
	public IWebContext getWebContext(MvcContext mvcContext, Models models, PortletRequest portletRequest,
		MimeResponse mimeResponse, ServletContext servletContext) {

		return new SpringPortletWebContext(applicationContext, models,
				(String) portletRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE),
				new HttpServletRequestAdapter(portletRequest), new HttpServletResponseAdapter(mimeResponse),
				servletContext, mvcContext.getLocale(), mvcContext.getConfig());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private static class SpringPortletWebContext extends WebContextBase {

		private ApplicationContext applicationContext;
		private Set<String> beanNames;
		private Models models;

		public SpringPortletWebContext(ApplicationContext applicationContext, Models models, String lifecyclePhase,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			ServletContext servletContext, Locale locale, javax.ws.rs.core.Configuration configuration) {

			super(httpServletRequest, httpServletResponse, servletContext, locale);
			this.applicationContext = applicationContext;
			this.models = models;
			this.beanNames = new HashSet<>();

			boolean portletSpecBeans = false;

			VariableValidator variableValidator = applicationContext.getBean(VariableValidator.class);

			boolean headerPhase = lifecyclePhase.equals(PortletRequest.HEADER_PHASE);
			boolean renderPhase = lifecyclePhase.equals(PortletRequest.RENDER_PHASE);
			boolean resourcePhase = lifecyclePhase.equals(PortletRequest.RESOURCE_PHASE);

			for (String beanName : applicationContext.getBeanDefinitionNames()) {

				if ((beanName != null) &&
						variableValidator.isValidName(beanName, headerPhase, renderPhase, resourcePhase)) {
					this.beanNames.add(beanName);
				}
			}
		}

		@Override
		public boolean containsVariable(String name) {

			Map<String, Object> modelsMap = models.asMap();

			if (modelsMap.containsKey(name)) {
				return true;
			}

			return beanNames.contains(name);
		}

		@Override
		public Object getVariable(String name) {

			Object value = models.get(name);

			if (value == null) {
				value = applicationContext.getBean(name);
			}

			return value;
		}

		@Override
		public Set<String> getVariableNames() {

			Map<String, Object> modelsMap = models.asMap();
			Set<String> variableNames = new HashSet<>(modelsMap.keySet());
			variableNames.addAll(beanNames);

			return variableNames;
		}

	}
}
