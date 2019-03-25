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

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.annotations.PortletRequestScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.portlet.servlet.adapter.HttpServletRequestAdapter;
import org.apache.pluto.portlet.servlet.adapter.HttpServletResponseAdapter;
import org.apache.pluto.thymeleaf.portlet.VariableValidator;
import org.apache.pluto.thymeleaf.portlet.WebContextBase;

import org.thymeleaf.context.IWebContext;


/**
 * This class is a CDI producer that provides the ability to generate instances of {@link IWebContext}.
 *
 * @author  Neil Griffin
 */
public class WebContextProducer {

	@PortletRequestScoped
	@Produces
	public IWebContext getWebContext(BeanManager beanManager, VariableValidator variableValidator,
		MvcContext mvcContext, Models models, PortletRequest portletRequest, MimeResponse mimeResponse,
		ServletContext servletContext) {

		return new CDIPortletWebContext(beanManager, variableValidator, models,
				(String) portletRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE),
				new HttpServletRequestAdapter(portletRequest), new HttpServletResponseAdapter(mimeResponse),
				servletContext, mvcContext.getLocale());
	}

	private static class CDIPortletWebContext extends WebContextBase {

		private BeanManager beanManager;
		private Set<String> beanNames;
		private Models models;

		public CDIPortletWebContext(BeanManager beanManager, VariableValidator variableInspector, Models models,
			String lifecyclePhase, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			ServletContext servletContext, Locale locale) {

			super(httpServletRequest, httpServletResponse, servletContext, locale);
			this.beanManager = beanManager;
			this.models = models;
			this.beanNames = new HashSet<>();

			boolean headerPhase = lifecyclePhase.equals(PortletRequest.HEADER_PHASE);
			boolean renderPhase = lifecyclePhase.equals(PortletRequest.RENDER_PHASE);
			boolean resourcePhase = lifecyclePhase.equals(PortletRequest.RESOURCE_PHASE);

			Set<Bean<?>> beans = beanManager.getBeans(Object.class, new AnnotationLiteral<Any>() {
					});

			for (Bean<?> bean : beans) {
				String beanName = bean.getName();

				if ((beanName != null) &&
						variableInspector.isValidName(beanName, headerPhase, renderPhase, resourcePhase)) {
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

				Bean<?> resolvedBean = beanManager.resolve(beanManager.getBeans(name));

				if (resolvedBean != null) {
					Set<Type> types = resolvedBean.getTypes();

					if (!types.isEmpty()) {
						Iterator<Type> typeIterator = types.iterator();
						Type firstType = typeIterator.next();
						value = beanManager.getReference(resolvedBean, firstType,
								beanManager.createCreationalContext(resolvedBean));
					}
				}
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
