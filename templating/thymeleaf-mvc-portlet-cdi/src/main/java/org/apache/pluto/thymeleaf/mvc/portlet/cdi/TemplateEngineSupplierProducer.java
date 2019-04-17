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
package org.apache.pluto.thymeleaf.mvc.portlet.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.mvc.MvcContext;
import javax.mvc.engine.ViewEngine;
import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Configuration;

import org.apache.pluto.thymeleaf.portlet.DefaultTemplateEngineSupplier;
import org.apache.pluto.thymeleaf.portlet.PortletMessageResolver;
import org.apache.pluto.thymeleaf.portlet.PortletTemplateResolver;
import org.apache.pluto.thymeleaf.portlet.TemplateEngineSupplier;
import org.apache.pluto.thymeleaf.portlet.TemplateLocationSupplier;

import org.thymeleaf.TemplateEngine;


/**
 * This class is a CDI producer that provides the ability to generate an instance of {@link TemplateEngineSupplier}.
 *
 * @author  Neil Griffin
 */
public class TemplateEngineSupplierProducer {

	@ApplicationScoped
	@Produces
	public TemplateEngineSupplier getTemplateEngineSupplier(PortletConfig portletConfig, ServletContext servletContext,
															MvcContext mvcContext) {

		TemplateEngine templateEngine = new TemplateEngine();

		templateEngine.setMessageResolver(new PortletMessageResolver(portletConfig));

		Configuration configuration = mvcContext.getConfig();

		String templateLocation = (String) configuration.getProperty(ViewEngine.VIEW_FOLDER);

		if (templateLocation == null) {
			templateLocation = ViewEngine.DEFAULT_VIEW_FOLDER;
		}

		templateEngine.setTemplateResolver(new PortletTemplateResolver(servletContext,
				new CDITemplateLocationSupplier(templateLocation)));

		return new DefaultTemplateEngineSupplier(templateEngine);
	}

	private static class CDITemplateLocationSupplier implements TemplateLocationSupplier {

		private String templateLocation;

		public CDITemplateLocationSupplier(String templateLocation) {
			this.templateLocation = templateLocation;
		}

		@Override
		public String get() {
			return templateLocation;
		}
	}
}
