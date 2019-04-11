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

package org.apache.portals.pluto.demo.v3annotated;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;

import org.apache.portals.pluto.demo.v3annotated.AsyncDialogBean.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the async resource method for the async portlet.
 * 
 * @author Scott Nicklous
 * 
 */
public class AsyncPortlet {

   private static final Logger logger = LoggerFactory.getLogger(AsyncPortlet.class);
   private static final boolean isTrace = logger.isDebugEnabled();
   
   private final static String ATTRIB_REPS = "reps";
   public  final static String ATTRIB_TIMEOUT = "timeout";

   @Inject private AsyncDialogBean asyncDialogBean;
   @Inject private PortletRequestRandomNumberBean randomNumberBean;
   @Inject private AsyncRunnable asyncRunnable;

   @PostConstruct
   public void postConstruct() {
      logger.debug("AsyncPortlet @PostConstruct called");
   }

   @PreDestroy
   public void preDestroy() {
      logger.debug("AsyncPortlet @PreDestroy called");
   }

   @ServeResourceMethod(portletNames = "AsyncPortlet", asyncSupported = true)
   public void getResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

      if (resourceRequest.getAttribute(ATTRIB_TIMEOUT) != null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("<p>Resource method: listener reports timout.");
         txt.append("<span style='margin-left: 2em;'>Request #: ");
         txt.append("DispatcherType: ").append(resourceRequest.getDispatcherType().toString());
         txt.append("</span>");
         txt.append("<span style='margin-left: 2em;'>Request #: ");
         txt.append(randomNumberBean.getRandomNumber());
         txt.append("</span></p><hr>");
         resourceResponse.getWriter().write(txt.toString());
         return;
      }

      Boolean auto = (Boolean) resourceRequest.getAttribute(AsyncConstants.ATTRIB_AUTO);
      if (auto == null) {
         auto = false;
      }
      resourceRequest.removeAttribute(AsyncConstants.ATTRIB_AUTO);

      Integer reps = (Integer) resourceRequest.getAttribute(ATTRIB_REPS);
      if (reps == null) {
         reps = asyncDialogBean.getReps();
      }
      
      boolean done = (reps <= 0) || (asyncDialogBean.getDelay() <= 0);

      reps--;
      resourceRequest.setAttribute(ATTRIB_REPS, reps);
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Resource method.");
      txt.append(" delay: ").append(asyncDialogBean.getDelay());
      txt.append(", type: ").append(asyncDialogBean.getType());
      txt.append(", reps: ").append(reps);
      txt.append(", total reps: ").append(asyncDialogBean.getReps());
      txt.append(", auto: ").append(asyncDialogBean.isAutoDispatch());
      txt.append(", auto-dispatch: ").append(auto);
      logger.debug(txt.toString());
      
      PortletAsyncContext portletAsyncContext = resourceRequest.startPortletAsync();
      portletAsyncContext.setTimeout(4000);
      try {
         portletAsyncContext.addListener(portletAsyncContext.createPortletAsyncListener(AsyncListener.class));
      } catch (PortletException e) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         logger.debug("Exception adding listener: \n" + sw.toString());
      }

      if (auto || (asyncDialogBean.getDelay() <= 0)) {
         
         // produce output if dispatched from work thread or if there is no delay requested
         
         PortletRequestDispatcher portletRequestDispatcher;

         trace(resourceRequest, "Resource method: ");
         
         PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute("javax.portlet.config");
         String portletName = "Could not get PortletConfig";
         if (portletConfig != null) {
            portletName = portletConfig.getPortletName();
         }

         switch (asyncDialogBean.getType()) {
         case DISPATCH:
            logger.debug("Dispatching to JSP.");
            resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Resource Method dispatching to JSP");
            portletAsyncContext.dispatch(AsyncConstants.JSP);
            break;
         case FWD:
            logger.debug("Doing request dispatcher forward to JSP.");
            resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Resource Method forwarding to JSP");
            portletRequestDispatcher = resourceRequest.getPortletContext().getRequestDispatcher(AsyncConstants.JSP);
            portletRequestDispatcher.forward(resourceRequest, resourceResponse);
            resourceResponse.flushBuffer();
            if (done) {
               portletAsyncContext.complete();
            }
            break;
         case INC:
            logger.debug("Doing request dispatcher include of JSP.");
            resourceRequest.setAttribute(AsyncConstants.ATTRIB_TITLE, "Resource Method including JSP");
            portletRequestDispatcher = resourceRequest.getPortletContext().getRequestDispatcher(AsyncConstants.JSP);
            portletRequestDispatcher.include(resourceRequest, resourceResponse);
            resourceResponse.flushBuffer();
            if (done) {
               portletAsyncContext.complete();
            }
            break;
         default:
            logger.debug("Producing text output.");
            txt.setLength(0);
            txt.append("<h5>Resource method producing text output for portlet: " + portletName + "</h5>");
            txt.append("<p>DispatcherType: ").append(resourceRequest.getDispatcherType().toString());
            txt.append("<span style='margin-left: 2em;'>Request #: ");
            txt.append(randomNumberBean.getRandomNumber());
            txt.append("</span></p><hr>");
            resourceResponse.getWriter().write(txt.toString());
            resourceResponse.flushBuffer();
            if (done) {
               portletAsyncContext.complete();
            }
            break;
         }
      }
      
      if (!done) {
         
         // now start the executor thread 
         
         OutputType type = asyncDialogBean.getType();
         if (asyncDialogBean.isAutoDispatch()) {
            type = OutputType.AUTO;
         }

         asyncRunnable.init(portletAsyncContext, asyncDialogBean.getDelay(), type);
         portletAsyncContext.start(asyncRunnable);
      }
   }
   
   public static void trace(ResourceRequest req, String src) {
      if (isTrace) {
         List<String> attrNames = Collections.list(req.getAttributeNames());
         StringBuilder txt = new StringBuilder(128);
         txt.append(src);
         txt.append("\nAttribute names: ").append(attrNames);
         txt.append("\nasync_request_uri:      ").append((String) req.getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:      ").append((String) req.getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:      ").append((String) req.getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) req.getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:      ").append((String) req.getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:      ").append((String) req.getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path:      ").append((String) req.getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path:      ").append((String) req.getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:      ").append((String) req.getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string:      ").append((String) req.getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:      ").append((String) req.getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path:      ").append((String) req.getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path:      ").append((String) req.getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:      ").append((String) req.getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string:      ").append((String) req.getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_context_path:      ").append(req.getContextPath());
         logger.debug(txt.toString());
      }

   }
}
