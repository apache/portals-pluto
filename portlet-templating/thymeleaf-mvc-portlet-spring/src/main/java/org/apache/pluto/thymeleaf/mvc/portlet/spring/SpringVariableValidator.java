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
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;

import org.apache.pluto.thymeleaf.portlet.VariableValidator;
import org.apache.pluto.thymeleaf.portlet.VariableValidatorBase;


/**
 * This class provides a Spring implementation of the {@link org.apache.pluto.thymeleaf.portlet.VariableValidator}
 * interface.
 *
 * @author  Neil Griffin
 */
public class SpringVariableValidator extends VariableValidatorBase {

	private static final Set<String> literalBeanNames;

	static {
		literalBeanNames = new HashSet<>();
		literalBeanNames.add("beanMethodDecorator");
		literalBeanNames.add("bindingResultImpl");
		literalBeanNames.add("configurationImpl");
		literalBeanNames.add("encodersImpl");
		literalBeanNames.add("getBooleanParam");
		literalBeanNames.add("getDateParam");
		literalBeanNames.add("getDoubleParam");
		literalBeanNames.add("getFloatParam");
		literalBeanNames.add("getIntegerParam");
		literalBeanNames.add("getLongParam");
		literalBeanNames.add("getMessageInterpolator");
		literalBeanNames.add("getParamConverterProviders");
		literalBeanNames.add("getStringParam");
		literalBeanNames.add("getTemplateEngineSupplier");
		literalBeanNames.add("getViewEngine");
		literalBeanNames.add("getWebContext");
		literalBeanNames.add("getValidator");
		literalBeanNames.add("localeResolverImpl");
		literalBeanNames.add("messageSource");
		literalBeanNames.add("paramConverterProviderImpl");
		literalBeanNames.add("springBeanPortletFilter");
		literalBeanNames.add("springPostProcessor");
		literalBeanNames.add("variableValidator");
		literalBeanNames.add("viewEngineContextInjectableImpl");
		literalBeanNames.add("viewEngineJspImpl");
		literalBeanNames.add("viewRenderer");
	}

	// Instance field must be declared volatile in order for the double-check idiom to work (requires JRE 1.5+)
	private volatile Boolean includeStandardBeans;

	private PortletConfig portletConfig;
	private PortletContext portletContext;

	public SpringVariableValidator(PortletConfig portletConfig, PortletContext portletContext) {
		this.portletConfig = portletConfig;
		this.portletContext = portletContext;
	}

	public PortletConfig getPortletConfig() {
		return portletConfig;
	}

	public PortletContext getPortletContext() {
		return portletContext;
	}

	@Override
	public boolean isIncludeStandardBeans() {

		Boolean include = this.includeStandardBeans;

		// First check without locking (not yet thread-safe)
		if (include == null) {

			synchronized (this) {
				include = this.includeStandardBeans;

				// Second check with locking (thread-safe)
				if (include == null) {

					PortletConfig portletConfig = getPortletConfig();
					String initParameterValue = portletConfig.getInitParameter(
							VariableValidator.INCLUDE_STANDARD_BEANS);

					boolean initParameterFlag = false;

					if (initParameterValue != null) {
						initParameterFlag = Boolean.valueOf(initParameterValue.toString());
					}

					PortletContext portletContext = getPortletContext();
					initParameterValue = portletContext.getInitParameter(VariableValidator.INCLUDE_STANDARD_BEANS);

					if (initParameterValue != null) {
						initParameterFlag = Boolean.valueOf(initParameterValue.toString());
					}

					include = this.includeStandardBeans = initParameterFlag;
				}
			}
		}

		return include;
	}

	@Override
	public boolean isValidName(String name, boolean headerPhase, boolean renderPhase, boolean resourcePhase) {

		boolean valid = super.isValidName(name, headerPhase, renderPhase, resourcePhase);

		if (!valid) {
			return false;
		}

		if (literalBeanNames.contains(name)) {
			return false;
		}

		if (name.endsWith("ConverterProvider") || name.startsWith("org.springframework") || name.endsWith("Producer") ||
				name.startsWith("scopedTarget.") || name.endsWith("VariableValidator")) {
			return false;
		}

		return true;
	}
}
