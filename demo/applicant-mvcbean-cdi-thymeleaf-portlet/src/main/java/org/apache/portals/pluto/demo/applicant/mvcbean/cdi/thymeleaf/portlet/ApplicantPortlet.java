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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletException;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Preference;
import javax.portlet.annotations.Supports;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
@PortletConfiguration(
	portletName = "portlet1", prefs = { @Preference(name = "datePattern", values = { "MM/dd/yyyy" }) },
	supports = { @Supports(portletModes = { "view", "edit", "help" }) }, resourceBundle = "content.portlet1"
)
public class ApplicantPortlet implements HeaderPortlet {

	@Override
	@HeaderMethod(portletNames = { "portlet1" })
	public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse) throws PortletException,
		IOException {

		boolean liferayDetected = PortletContainer.LIFERAY.isDetected(headerRequest);
		boolean plutoDetected = PortletContainer.PLUTO.isDetected(headerRequest);

		if (plutoDetected) {
			headerResponse.addDependency("jQuery", "com.jquery", "1.12.1",
				"<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>");
			headerResponse.addDependency("Bootstrap", "com.getbootstrap", "4.0.0",
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");

			PrintWriter writer = headerResponse.getWriter();
			writer.write(
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"></meta>");
		}

		if (liferayDetected || plutoDetected) {
			headerResponse.addDependency("jQueryUI", "com.jquery", "1.12.1",
				"<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>");
			headerResponse.addDependency("jQueryUICSS", "com.jquery", "1.12.1",
				"<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">");
		}
	}
}
