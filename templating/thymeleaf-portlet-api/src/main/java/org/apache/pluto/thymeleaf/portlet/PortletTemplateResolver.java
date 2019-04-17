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

import java.util.Map;

import javax.servlet.ServletContext;

import org.thymeleaf.IEngineConfiguration;

import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


/**
 * This is a convenient utility class that provides Thymeleaf with a way to resolve templates in a portlet application.
 *
 * @author  Neil Griffin
 */
public class PortletTemplateResolver extends ServletContextTemplateResolver {

	private TemplateLocationSupplier templateLocationSupplier;

	public PortletTemplateResolver(ServletContext servletContext, TemplateLocationSupplier templateLocationSupplier) {
		super(servletContext);
		this.templateLocationSupplier = templateLocationSupplier;
	}

	@Override
	protected String computeResourceName(IEngineConfiguration engineConfiguration, String ownerTemplate,
		String template, String prefix, String suffix, boolean forceSuffix, Map<String, String> templateAliases,
		Map<String, Object> templateResolutionAttributes) {

		String resourceName = super.computeResourceName(engineConfiguration, ownerTemplate, template, prefix, suffix,
				forceSuffix, templateAliases, templateResolutionAttributes);

		if (resourceName.startsWith("/")) {
			return resourceName;
		}

		String templateLocation = templateLocationSupplier.get();

		if (!templateLocation.endsWith("/")) {
			templateLocation = templateLocation.concat("/");
		}

		return templateLocation.concat(resourceName);
	}
}
