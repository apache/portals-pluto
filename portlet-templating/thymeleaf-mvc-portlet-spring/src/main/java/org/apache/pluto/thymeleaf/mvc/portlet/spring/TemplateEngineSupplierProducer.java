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

import javax.mvc.MvcContext;
import javax.mvc.engine.ViewEngine;
import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.thymeleaf.portlet.DefaultTemplateEngineSupplier;
import org.apache.pluto.thymeleaf.portlet.PortletMessageResolver;
import org.apache.pluto.thymeleaf.portlet.PortletTemplateResolver;
import org.apache.pluto.thymeleaf.portlet.TemplateEngineSupplier;
import org.apache.pluto.thymeleaf.portlet.TemplateLocationSupplier;

import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.thymeleaf.TemplateEngine;


/**
 * This class is a Spring producer that provides the ability to generate an instance of {@link TemplateEngineSupplier}.
 *
 * @author  Neil Griffin
 */
@Configuration
public class TemplateEngineSupplierProducer {

	@Bean
	@Scope(proxyMode = ScopedProxyMode.INTERFACES)
	public TemplateEngineSupplier getTemplateEngineSupplier(PortletConfig portletConfig, ServletContext servletContext,
		BeanFactory beanFactory) {
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setMessageResolver(new PortletMessageResolver(portletConfig));
		templateEngine.setTemplateResolver(new PortletTemplateResolver(servletContext,
				new SpringConfigurationSupplier(beanFactory)));

		return new DefaultTemplateEngineSupplier(templateEngine);
	}

	private static class SpringConfigurationSupplier implements TemplateLocationSupplier {

		private BeanFactory beanFactory;

		public SpringConfigurationSupplier(BeanFactory beanFactory) {
			this.beanFactory = beanFactory;
		}

		@Override
		public String get() {
			MvcContext mvcContext = beanFactory.getBean(MvcContext.class);

			javax.ws.rs.core.Configuration configuration = mvcContext.getConfig();

			String templateLocation = (String) configuration.getProperty(ViewEngine.VIEW_FOLDER);

			if (templateLocation == null) {
				templateLocation = ViewEngine.DEFAULT_VIEW_FOLDER;
			}

			return templateLocation;
		}
	}
}
