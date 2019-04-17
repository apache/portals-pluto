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
package org.apache.pluto.thymeleaf.mvc.portlet;

import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;

import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.IWebContext;


/**
 * This class implements the MVC {@link ViewEngine} interface in order to help support Thymeleaf views in a portlet
 * application.
 *
 * @author  Neil Griffin
 */
public class ThymeleafViewEngine implements ViewEngine {

	private TemplateEngine templateEngine;
	private IWebContext webContext;
	private WriterSupplier writerSupplier;

	public ThymeleafViewEngine(TemplateEngine templateEngine, IWebContext webContext, WriterSupplier writerSupplier) {
		this.templateEngine = templateEngine;
		this.webContext = webContext;
		this.writerSupplier = writerSupplier;
	}

	@Override
	public void processView(ViewEngineContext viewEngineContext) throws ViewEngineException {
		templateEngine.process(viewEngineContext.getView(), webContext, writerSupplier.get(viewEngineContext));
	}

	@Override
	public boolean supports(String view) {

		if (view == null) {
			return false;
		}

		return view.endsWith(".html");
	}
}
