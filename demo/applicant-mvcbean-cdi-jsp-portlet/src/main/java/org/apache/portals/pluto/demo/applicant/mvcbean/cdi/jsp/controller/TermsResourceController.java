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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.security.CsrfProtected;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
@Controller
public class TermsResourceController {

	private static final Logger logger = LoggerFactory.getLogger(TermsResourceController.class);

	@Inject
	private Models models;

	@CsrfProtected
	@ServeResourceMethod(portletNames = "portlet1", contentType = "text/html", resourceID = "acceptTerms")
	public String acceptTerms(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		return "redirect:acceptance.jspx";
	}

	@ServeResourceMethod(portletNames = "portlet1", contentType = "text/html")
	public void redirectedView(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ResourceParameters resourceParameters = resourceRequest.getResourceParameters();

		logger.debug("redirectedView=[{}]", resourceParameters.getValue("redirectedView"));
	}

	@ServeResourceMethod(portletNames = "portlet1", contentType = "text/html", resourceID = "viewTerms")
	@View("terms.jspx")
	public void viewTerms(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy");

		Calendar todayCalendar = Calendar.getInstance();

		models.put("thisYear", dateFormat.format(todayCalendar.getTime()));
	}

	@ServeResourceMethod(portletNames = "portlet1", contentType = "text/html", resourceID = "viewTermsAgain")
	@View("redirect:terms.jspx")
	public void viewTermsAgain(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		logger.debug("Redirecting to Terms of Service");
	}
}
