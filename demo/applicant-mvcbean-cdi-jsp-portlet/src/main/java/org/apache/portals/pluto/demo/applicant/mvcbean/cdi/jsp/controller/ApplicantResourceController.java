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

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.security.CsrfProtected;
import javax.portlet.PortletSession;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.http.Part;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.dto.Attachment;
import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.dto.City;
import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
@Controller
public class ApplicantResourceController {

	private static final Logger logger = LoggerFactory.getLogger(ApplicantResourceController.class);

	@Inject
	private AttachmentManager attachmentManager;

	@Inject
	private CityService cityService;

	@CsrfProtected
	@ServeResourceMethod(portletNames = { "portlet1" }, resourceID = "autoFill")
	public void autoFill(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ResourceParameters resourceParameters = resourceRequest.getResourceParameters();

		String postalCode = resourceParameters.getValue(resourceResponse.getNamespace() + "postalCode");

		if (postalCode != null) {

			try {
				City city = cityService.getCityByPostalCode(postalCode);

				if (city != null) {

					Writer writer = resourceResponse.getWriter();

					writer.write("{");
					writer.write("\"cityName\": \"");
					writer.write(city.getCityName());
					writer.write("\",");
					writer.write("\"provinceId\": \"");
					writer.write(String.valueOf(city.getProvinceId()));
					writer.write("\"}");
				}
			}
			catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@CsrfProtected
	@ServeResourceMethod(portletNames = { "portlet1" }, resourceID = "deleteFile")
	@ValidateOnExecution(type = ExecutableType.NONE)
	public void deleteFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		PortletSession portletSession = resourceRequest.getPortletSession();

		List<Attachment> attachments = attachmentManager.getAttachments(portletSession.getId());

		ResourceParameters resourceParameters = resourceRequest.getResourceParameters();

		String attachmentIndex = resourceParameters.getValue(resourceResponse.getNamespace() + "attachmentIndex");

		if (attachmentIndex != null) {
			Attachment attachment = attachments.remove(Integer.valueOf(attachmentIndex).intValue());

			try {
				File file = attachment.getFile();
				file.delete();
				_writeTabularJSON(resourceResponse.getWriter(), attachments);
			}
			catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@CsrfProtected
	@ServeResourceMethod(portletNames = { "portlet1" }, resourceID = "uploadFiles")
	@ValidateOnExecution(type = ExecutableType.NONE)
	public void uploadFiles(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		PortletSession portletSession = resourceRequest.getPortletSession(true);
		List<Attachment> attachments = attachmentManager.getAttachments(portletSession.getId());

		try {
			Collection<Part> transientMultipartFiles = resourceRequest.getParts();

			if (!transientMultipartFiles.isEmpty()) {

				File attachmentDir = attachmentManager.getAttachmentDir(portletSession.getId());

				if (!attachmentDir.exists()) {
					attachmentDir.mkdir();
				}

				for (Part transientMultipartFile : transientMultipartFiles) {

					String submittedFileName = transientMultipartFile.getSubmittedFileName();

					if (submittedFileName != null) {
						File copiedFile = new File(attachmentDir, submittedFileName);

						transientMultipartFile.write(copiedFile.getAbsolutePath());

						attachments.add(new Attachment(copiedFile));
					}
				}

				_writeTabularJSON(resourceResponse.getWriter(), attachments);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void _writeTabularJSON(Writer writer, List<Attachment> attachments) {

		try {

			writer.write("[");

			boolean first = true;

			for (Attachment attachment : attachments) {

				if (first) {
					first = false;
				}
				else {
					writer.write(",");
				}

				writer.write("{\"fileName\": \"");

				writer.write(attachment.getName());
				writer.write("\",\"size\":\"");
				writer.write(String.valueOf(attachment.getSize()));
				writer.write("\"}");
			}

			writer.write("]");
		}
		catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
