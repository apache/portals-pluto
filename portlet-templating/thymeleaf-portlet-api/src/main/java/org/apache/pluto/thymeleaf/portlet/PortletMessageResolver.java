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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;

import org.thymeleaf.messageresolver.StandardMessageResolver;

import org.thymeleaf.templateresource.ITemplateResource;


/**
 * This is a convenient utility class that provides Thymeleaf with a way to resolve messages in a portlet application.
 *
 * @author  Neil Griffin
 */
public class PortletMessageResolver extends StandardMessageResolver {

	private PortletConfig portletConfig;

	public PortletMessageResolver(PortletConfig portletConfig) {
		this.portletConfig = portletConfig;
	}

	@Override
	protected Map<String, String> resolveMessagesForTemplate(String template, ITemplateResource templateResource,
		Locale locale) {

		Map<String, String> messages = super.resolveMessagesForTemplate(template, templateResource, locale);

		if (messages.isEmpty()) {

			ResourceBundle resourceBundle = portletConfig.getResourceBundle(locale);

			if (resourceBundle != null) {
				messages = new HashMap<>();

				Enumeration<String> resourceBundleKeys = resourceBundle.getKeys();

				while (resourceBundleKeys.hasMoreElements()) {
					String key = resourceBundleKeys.nextElement();
					Object value = resourceBundle.getObject(key);

					if ((key != null) && (value != null)) {
						messages.put(key, value.toString());
					}
				}
			}
		}

		return messages;
	}
}
