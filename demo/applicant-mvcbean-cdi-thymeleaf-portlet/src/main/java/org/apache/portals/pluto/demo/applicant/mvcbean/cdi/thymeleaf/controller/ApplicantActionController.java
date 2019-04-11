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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.controller;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.ParamError;
import javax.mvc.security.CsrfProtected;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.PortletRequestScoped;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;

import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.dto.Applicant;
import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.dto.Attachment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@Controller
@PortletRequestScoped // Injection of the @Dependent pseudo-scoped @BeanPram Applicant requires this controller to be
					  // @PortletRequestScoped instead of @ApplicationScoped.
public class ApplicantActionController {

	private static final Logger logger = LoggerFactory.getLogger(ApplicantActionController.class);

	@Inject
	@BeanParam
	@Valid
	private Applicant applicant;

	@Inject
	private AttachmentManager attachmentManager;

	@Inject
	private BindingResult bindingResult;

	@Inject
	private Models models;

	@ActionMethod(portletName = "portlet1", actionName = "submitApplicant")
	@CsrfProtected
	public String submitApplicant(ActionRequest actionRequest, ActionResponse actionResponse) {

		models.put("applicant", applicant);

		Set<ParamError> bindingErrors = bindingResult.getAllErrors();

		if (bindingErrors.isEmpty()) {

			PortletSession portletSession = actionRequest.getPortletSession();
			List<Attachment> attachments = attachmentManager.getAttachments(portletSession.getId());

			if (logger.isDebugEnabled()) {
				logger.debug("firstName=" + applicant.getFirstName());
				logger.debug("lastName=" + applicant.getLastName());
				logger.debug("emailAddress=" + applicant.getEmailAddress());
				logger.debug("phoneNumber=" + applicant.getPhoneNumber());
				logger.debug("dateOfBirth=" + applicant.getDateOfBirth());
				logger.debug("city=" + applicant.getCity());
				logger.debug("provinceId=" + applicant.getProvinceId());
				logger.debug("postalCode=" + applicant.getPostalCode());
				logger.debug("comments=" + applicant.getComments());
			}

			for (Attachment attachment : attachments) {

				logger.debug("attachment=[{}]", attachment.getName());

				File file = attachment.getFile();
				file.delete();
			}

			return "redirect:confirmation.html";
		}

		return null;
	}
}
