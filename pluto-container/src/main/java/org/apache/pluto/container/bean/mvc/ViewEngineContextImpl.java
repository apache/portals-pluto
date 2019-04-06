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
package org.apache.pluto.container.bean.mvc;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.mvc.Models;
import javax.mvc.engine.ViewEngineContext;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public class ViewEngineContextImpl implements ViewEngineContext {

	private static final Logger LOG = LoggerFactory.getLogger(ViewEngineContextImpl.class);

	private Configuration configuration;
	private Locale locale;
	private MediaType mediaType;
	private MimeResponse mimeResponse;
	private Models models;
	private PortletRequest portletRequest;

	public ViewEngineContextImpl(Configuration configuration, PortletRequest portletRequest, MimeResponse mimeResponse,
		Models models, Locale locale) {
		this.configuration = configuration;
		this.portletRequest = portletRequest;
		this.mimeResponse = mimeResponse;
		this.models = models;
		this.locale = locale;
	}

	@Override
	public Configuration getConfiguration() {
		return configuration;
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	@Override
	public MediaType getMediaType() {

		if (mediaType == null) {
			String contentType = mimeResponse.getContentType();

			if (contentType == null) {
				mediaType = MediaType.TEXT_HTML_TYPE;
			}
			else {

				String type = contentType;
				String subtype = null;

				int pos = contentType.indexOf("/");

				if (pos > 0) {
					type = contentType.substring(0, pos);
					subtype = contentType.substring(pos + 1);
				}

				mediaType = new MediaType(type, subtype, mimeResponse.getCharacterEncoding());
			}
		}

		return mediaType;
	}

	@Override
	public Models getModels() {
		return models;
	}

	@Override
	public OutputStream getOutputStream() {

		try {
			return mimeResponse.getPortletOutputStream();
		}
		catch (IOException e) {
			LOG.error(e.getMessage(), e);

			return null;
		}
	}

	@Override
	public <T> T getRequest(Class<T> type) {
		return (T) portletRequest;
	}

	@Override
	public ResourceInfo getResourceInfo() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T getResponse(Class<T> type) {
		return (T) mimeResponse;
	}

	@Override
	public MultivaluedMap<String, Object> getResponseHeaders() {
		throw new UnsupportedOperationException();
	}

	@Override
	public UriInfo getUriInfo() {
		return new UriInfoImpl();
	}

	@Override
	public String getView() {
		return (String) portletRequest.getAttribute(ViewRenderer.VIEW_NAME);
	}
}
