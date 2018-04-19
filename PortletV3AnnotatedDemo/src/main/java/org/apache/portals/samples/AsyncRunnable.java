/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.portals.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Implements the async resource method for the async portlet.
 *
 * @author Scott Nicklous
 *
 */
public class AsyncRunnable implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(AsyncRunnable.class);

	private PortletAsyncContext portletAsyncContext;
	private int delay;
	private AsyncDialogBean.OutputType outputType;

	@Inject
	private PortletRequestRandomNumberBean randomNumberBean;
	@Inject private AsyncCompleteBean asyncCompleteBean;

	public void init(PortletAsyncContext portletAsyncContext, int delay, AsyncDialogBean.OutputType outputType) {
		this.portletAsyncContext = portletAsyncContext;
		this.delay = delay;
		this.outputType = outputType;

		StringBuilder txt = new StringBuilder(128);
		txt.append("Initializing runnable.");
		txt.append(" delay: ").append(delay);
		txt.append(", outputType: ").append(outputType);
		logger.debug(txt.toString());
	}

	@Override
	public void run() {
		logger.debug("AsyncRunnable.run() BEGIN");
		try {
			Thread.sleep(delay);

			if (asyncCompleteBean.isComplete()) {
				logger.warn("Request completed before work was finished. processing will be aborted.");
				return;
			}

			ResourceRequest resourceRequest = portletAsyncContext.getResourceRequest();
			ResourceResponse resourceResponse = portletAsyncContext.getResourceResponse();
			PortletRequestDispatcher rd = resourceRequest.getPortletContext().getRequestDispatcher(AsyncConstants.JSP);

			AsyncPortlet.trace(resourceRequest, "Runnable: ");

			PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute("javax.portlet.config");
			String portletName = "Could not get PortletConfig";
			if (portletConfig != null) {
				portletName = portletConfig.getPortletName();
			}

			switch (outputType) {
				case TEXT:
					logger.debug("Producing text output.");
					StringBuilder txt = new StringBuilder(128);
					txt.append("<h5>Thread producing text output for portlet: " + portletName + "</h5>");
					txt.append("<p>Dispatcher outputType: ").append(resourceRequest.getDispatcherType().toString());
					txt.append("<span style='margin-left: 2em;'>Request #: ");
					try { // in case context not active
						txt.append(randomNumberBean.getRandomNumber());
					} catch (Exception e) {}
					txt.append("</span></p><hr>");
					resourceResponse.getWriter().write(txt.toString());
					portletAsyncContext.complete();
					break;
				case AUTO:
					StringBuilder str = new StringBuilder(128);
					str.append("Dispatching to resource method.");
					str.append(" context path: ").append(resourceRequest.getPortletContext().getContextPath());
					logger.debug(str.toString());
					resourceRequest.setAttribute(AsyncConstants.ATTRIB_AUTO, new Boolean(true));
					portletAsyncContext.dispatch();
					break;
				case DISPATCH:
					logger.debug("Dispatching to JSP.");
					resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Thread dispatching to JSP");
					portletAsyncContext.dispatch(AsyncConstants.JSP);
					break;
				case FWD:
					logger.debug("Doing request dispatcher forward to JSP: " + AsyncConstants.JSP);
					resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Thread forwarding to JSP");
					rd.forward(resourceRequest, resourceResponse);
					logger.debug("After request dispatcher forward to JSP.");
					portletAsyncContext.complete();
					break;
				case INC:
					logger.debug("Including JSP: " + AsyncConstants.JSP);
					resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Thread including JSP");
					rd.include(resourceRequest, resourceResponse);
					portletAsyncContext.complete();
					break;
			}

		} catch (IllegalStateException e) {
			logger.warn("Request may have timed out before it could complete. Exception: " + e.toString());
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			logger.debug("Exception during runner execution: \n" + sw.toString());
		}
		logger.debug("AsyncRunnable.run() END");
	}

	@Override
	protected void finalize() throws Throwable {
		logger.debug("AsyncRunnable.finalize() called");
	}
}
