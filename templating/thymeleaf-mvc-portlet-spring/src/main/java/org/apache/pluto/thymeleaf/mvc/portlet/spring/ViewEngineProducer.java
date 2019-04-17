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

import java.io.IOException;

import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineException;
import javax.portlet.MimeResponse;

import org.apache.pluto.thymeleaf.mvc.portlet.ThymeleafViewEngine;
import org.apache.pluto.thymeleaf.portlet.TemplateEngineSupplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.thymeleaf.context.IWebContext;


/**
 * This class is a Spring producer that provides the ability to generate instances of {@link ViewEngine}.
 *
 * @author  Neil Griffin
 */
@Configuration
public class ViewEngineProducer {

	@Bean
	@Scope(proxyMode = ScopedProxyMode.INTERFACES, value = "portletRequest")
	public ViewEngine getViewEngine(TemplateEngineSupplier templateEngineSupplier, IWebContext webContext) {
		return new ThymeleafViewEngine(templateEngineSupplier.get(), webContext,
				viewEngineContext -> {
					MimeResponse mimeResponse = viewEngineContext.getResponse(MimeResponse.class);

					try {
						return mimeResponse.getWriter();
					}
					catch (IOException e) {
						throw new ViewEngineException(e);
					}
				});
	}
}
