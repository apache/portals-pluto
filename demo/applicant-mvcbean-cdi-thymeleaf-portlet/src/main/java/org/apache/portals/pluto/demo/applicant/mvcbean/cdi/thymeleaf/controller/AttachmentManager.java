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
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.dto.Attachment;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
public class AttachmentManager {

	@Inject
	private ServletContext servletContext;

	public File getAttachmentDir(String sessionId) {

		File tempDir = (File) servletContext.getAttribute(ServletContext.TEMPDIR);

		return new File(tempDir, sessionId);
	}

	public List<Attachment> getAttachments(String sessionId) {
		return getAttachments(getAttachmentDir(sessionId));
	}

	public List<Attachment> getAttachments(File attachmentDir) {

		List<Attachment> attachments = new ArrayList<>();

		if (attachmentDir.exists()) {

			File[] files = attachmentDir.listFiles();

			for (File file : files) {
				attachments.add(new Attachment(file));
			}
		}

		return attachments;
	}
}
