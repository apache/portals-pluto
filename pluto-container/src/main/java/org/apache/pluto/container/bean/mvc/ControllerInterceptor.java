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
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Priority;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.mvc.View;
import javax.mvc.event.MvcEvent;
import javax.portlet.ActionResponse;
import javax.portlet.BaseURL;
import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.MutableResourceParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.DestroyMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.InitMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.filter.RenderURLWrapper;
import javax.portlet.filter.ResourceURLWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import org.apache.pluto.container.bean.processor.MethodType;
import org.apache.pluto.container.bean.processor.PortletInvoker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author  Neil Griffin
 */
@Interceptor
@ControllerInterceptorBinding
@Priority(Interceptor.Priority.LIBRARY_BEFORE)
public class ControllerInterceptor implements Serializable {

	private static final long serialVersionUID = 1573287230987622411L;

	private static final Logger LOG = LoggerFactory.getLogger(ControllerInterceptor.class);

	@Inject
	private ActionResponse actionResponse;

	@Inject
	private Event<MvcEvent> mvcEvent;

	@Inject
	private MimeResponse mimeResponse;

	@Inject
	private PortletConfig portletConfig;

	@Inject
	private PortletRequest portletRequest;

	@Inject
	private ResourceResponse resourceResponse;

	@Inject
	private ViewRenderer viewRenderer;

	@AroundInvoke
	public Object processView(InvocationContext invocationContext) throws Exception {

		PortletRequest portletRequest = this.portletRequest;
		MimeResponse mimeResponse = this.mimeResponse;

		// Set the viewName request attribute before invoking the controller
		// @RenderMethod or @ServeResourceMethod. This makes it possible for
		// the developer to determine the viewName that may have been set by an
		// @ActionMethod in the ACTION_PHASE (or ResourceURL redirect) by
		// calling the ViewEngineContext.getView() method.

		String viewNameFromSession = null;

		Method invocationContextMethod = invocationContext.getMethod();

		MethodType methodType = _getMethodType(invocationContextMethod);

		if ((methodType == MethodType.RENDER) || (methodType == MethodType.RESOURCE)) {

			Object[] parameters = invocationContext.getParameters();

			if ((parameters != null) && (parameters.length > 1)) {

				portletRequest = (PortletRequest) parameters[0];
				mimeResponse = (MimeResponse) parameters[1];
			}

			if (portletRequest.getParameter(ViewRenderer.REDIRECTED_VIEW) != null) {

				PortletSession portletSession = portletRequest.getPortletSession(true);

				viewNameFromSession = (String) portletSession.getAttribute(ViewRenderer.VIEW_NAME);

				portletSession.removeAttribute(ViewRenderer.VIEW_NAME);

				if (viewNameFromSession != null) {
					portletRequest.setAttribute(ViewRenderer.VIEW_NAME, viewNameFromSession);
				}
			}
		}

		Object target = invocationContext.getTarget();

		mvcEvent.fire(new BeforeControllerEventImpl(new ResourceInfoImpl(target.getClass(), invocationContextMethod),
				new UriInfoImpl()));

		Object result = invocationContext.proceed();

		BaseURL redirectURL = null;

		boolean renderView = true;

		String viewName = null;

		if (_isNull(result)) {
			View view = invocationContextMethod.getAnnotation(View.class);

			if (view != null) {
				viewName = view.value();
			}
		}
		else {
			viewName = result.toString();
		}

		if (!_isNull(viewName) && ((methodType == MethodType.ACTION) || (methodType == MethodType.RESOURCE))) {

			PortletSession portletSession = portletRequest.getPortletSession(true);

			if (viewName.startsWith(ViewRenderer.REDIRECT_PREFIX)) {
				viewName = viewName.substring(ViewRenderer.REDIRECT_PREFIX.length());

				if (methodType == MethodType.ACTION) {
					redirectURL = new ActionRedirectURL(actionResponse);
				}
				else {
					redirectURL = new ResourceRedirectURL(resourceResponse);
				}
			}

			portletSession.setAttribute(ViewRenderer.VIEW_NAME, viewName);

			if (methodType == MethodType.ACTION) {

				if (redirectURL == null) {
					MutableRenderParameters mutableRenderParameters = actionResponse.getRenderParameters();

					mutableRenderParameters.setValue(ViewRenderer.REDIRECTED_VIEW, Boolean.TRUE.toString());
				}
				else {

					try {
						actionResponse.sendRedirect(redirectURL.toString());
					}
					catch (IOException ioe) {
						LOG.error(ioe.getMessage(), ioe);
					}
				}
			}
			else {

				if (redirectURL != null) {
					resourceResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					resourceResponse.addProperty(HttpHeaders.LOCATION, redirectURL.toString());

					renderView = false;
				}
			}
		}

		if (renderView) {

			if (_isNull(viewName)) {
				viewName = viewNameFromSession;
			}

			if (!_isNull(viewName)) {
				portletRequest.setAttribute(ViewRenderer.VIEW_NAME, viewName);
			}
		}

		target = invocationContext.getTarget();

		mvcEvent.fire(new AfterControllerEventImpl(new ResourceInfoImpl(target.getClass(), invocationContextMethod),
				new UriInfoImpl()));

		if (redirectURL != null) {

			try {
				URI location = new URI(redirectURL.toString());

				mvcEvent.fire(new ControllerRedirectEventImpl(
						new ResourceInfoImpl(target.getClass(), invocationContextMethod), new UriInfoImpl(), location));
			}
			catch (URISyntaxException urise) {
				LOG.error(urise.getMessage(), urise);
			}
		}

		if ((viewName != null) && (portletRequest.getAttribute(PortletInvoker.LAST_METHOD) != null)) {
			portletRequest.removeAttribute(PortletInvoker.LAST_METHOD);
			viewRenderer.render(portletRequest, mimeResponse, portletConfig);
		}

		return null;
	}

	private MethodType _getMethodType(Method invocationContextMethod) {

		if (invocationContextMethod.isAnnotationPresent(ActionMethod.class)) {
			return MethodType.ACTION;
		}

		if (invocationContextMethod.isAnnotationPresent(DestroyMethod.class)) {
			return MethodType.DESTROY;
		}

		if (invocationContextMethod.isAnnotationPresent(EventMethod.class)) {
			return MethodType.EVENT;
		}

		if (invocationContextMethod.isAnnotationPresent(InitMethod.class)) {
			return MethodType.INIT;
		}

		if (invocationContextMethod.isAnnotationPresent(RenderMethod.class)) {
			return MethodType.RENDER;
		}

		return MethodType.RESOURCE;
	}

	private boolean _isNull(Object viewName) {
		return (viewName == null) || viewName.toString().trim().toLowerCase().equals("null");
	}

	private static class ActionRedirectURL extends RenderURLWrapper {

		public ActionRedirectURL(ActionResponse actionResponse) {
			super(actionResponse.createRedirectURL(MimeResponse.Copy.ALL));

			MutableRenderParameters mutableRenderParameters = getRenderParameters();

			mutableRenderParameters.setValue(ViewRenderer.REDIRECTED_VIEW, Boolean.TRUE.toString());
		}

	}

	private static class ResourceRedirectURL extends ResourceURLWrapper {

		public ResourceRedirectURL(ResourceResponse resourceResponse) {
			super(resourceResponse.createResourceURL());

			MutableResourceParameters mutableResourceParameters = getResourceParameters();

			mutableResourceParameters.setValue(ViewRenderer.REDIRECTED_VIEW, Boolean.TRUE.toString());

			setResourceID(null);
		}

	}

}
