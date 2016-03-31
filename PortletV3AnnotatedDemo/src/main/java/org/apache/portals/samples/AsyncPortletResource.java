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

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.portals.samples.AsyncDialogBean.OutputType;

/**
 * Implements the async resource method for the async portlet.
 * 
 * @author Scott Nicklous
 * 
 */
public class AsyncPortletResource {
   private static final Logger LOGGER = Logger.getLogger(AsyncPortletResource.class.getName());
   private static final boolean isDebug = LOGGER.isLoggable(Level.FINE);
   private static final boolean isTrace = LOGGER.isLoggable(Level.FINEST);
   
   private final static String JSP         = "/WEB-INF/jsp/asyncOutput.jsp";
   private final static String ATTRIB_REPS = "reps";
   private final static String ATTRIB_AUTO = "auto";
   public  final static String ATTRIB_TITLE = "title";

   private class AsyncRunnable implements Runnable {

      private final AsyncContext ctx;
      private final int          delay;
      private final OutputType   type;

      public AsyncRunnable(AsyncContext ctx, int delay, OutputType type) {
         this.ctx = ctx;
         this.delay = delay;
         this.type = type;
         
         StringBuilder txt = new StringBuilder(128);
         txt.append("Constructing runnable.");
         txt.append(" delay: ").append(delay);
         txt.append(", type: ").append(type);
         LOGGER.fine(txt.toString());
      }

      @Override
      public void run() {
         try {
            Thread.sleep(delay);

            HttpServletRequest hreq = (HttpServletRequest) ctx.getRequest();
            HttpServletResponse hresp = (HttpServletResponse) ctx.getResponse();
            RequestDispatcher rd;
            
            AsyncPortletResource.trace(hreq, "Runnable: ");
            
            PortletConfig config = (PortletConfig) hreq.getAttribute("javax.portlet.config");
            String portletName = "Could not get PortletConfig";
            if (config != null) {
               portletName = config.getPortletName();
            }

            switch (type) {
            case TEXT:
               LOGGER.fine("Producing text output.");
               StringBuilder txt = new StringBuilder(128);
               txt.append("<h5>Thread producing text output for portlet: " + portletName + "</h5>");
               txt.append("<p>dispatcher type: ").append(hreq.getDispatcherType().toString());
               txt.append("</p>");
               hresp.getWriter().write(txt.toString());
               ctx.complete();
               break;
            case AUTO:
               StringBuilder str = new StringBuilder(128);
               str.append("Dispatching to resource method.");
               str.append(" context path: ").append(hreq.getServletContext().getContextPath());
               str.append(", Servlet patch: ").append(hreq.getServletPath());
               LOGGER.fine(str.toString());
               hreq.setAttribute(ATTRIB_AUTO, new Boolean(true));
               ctx.dispatch(hreq.getServletContext(), hreq.getServletPath());
               break;
            case DISPATCH:
               LOGGER.fine("Dispatching to JSP.");
               hreq.setAttribute(ATTRIB_TITLE, "Thread dispatching to JSP");
               ctx.dispatch(hreq.getServletContext(), JSP);
               break;
            case FWD:
               LOGGER.fine("Doing request dispatcher forward to JSP: " + JSP);
               hreq.setAttribute(ATTRIB_TITLE, "Thread forwarding to JSP");
               rd = hreq.getRequestDispatcher(JSP);
               rd.forward(hreq, hresp);
               LOGGER.fine("After request dispatcher forward to JSP.");
               ctx.complete();
               break;
            case INC:
               LOGGER.fine("Including JSP: " + JSP);
               hreq.setAttribute(ATTRIB_TITLE, "Thread including JSP");
               rd = hreq.getRequestDispatcher(JSP);
               rd.include(hreq, hresp);
               ctx.complete();
               break;
            }

         } catch (Exception e) {
            LOGGER.warning("Exception during async processing: " + e.toString());
         }
      }

   }

   @Inject
   private AsyncDialogBean adb;

   @ServeResourceMethod(portletNames = "AsyncPortlet", asyncSupported = true)
   public void getResource(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {

      Boolean auto = (Boolean) req.getAttribute(ATTRIB_AUTO);
      if (auto == null) {
         auto = false;
      }
      req.removeAttribute(ATTRIB_AUTO);

      Integer reps = (Integer) req.getAttribute(ATTRIB_REPS);
      if (reps == null) {
         reps = adb.getReps();
      }
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Resource method.");
      txt.append(" delay: ").append(adb.getDelay());
      txt.append(", type: ").append(adb.getType());
      txt.append(", reps: ").append(reps);
      txt.append(", total reps: ").append(adb.getReps());
      txt.append(", auto: ").append(adb.isAutoDispatch());
      txt.append(", auto-dispatch: ").append(auto);
      LOGGER.fine(txt.toString());
      
      AsyncContext ctx = null;

      if (reps > 0) {
         reps--;
         req.setAttribute(ATTRIB_REPS, reps);
         
         ctx = req.startAsync();
         ctx.setTimeout(4000);
      }

      if (auto || (adb.getDelay() <= 0)) {
         
         // produce output if dispatched from work thread or if there is no delay requested
         
         PortletRequestDispatcher rd;
         
         if (ctx == null) {
            // last iteration of auto-dispatch
            LOGGER.fine("Retrieving async context for the last run.");
            try {
               ctx = req.getAsyncContext();
            } catch (Exception e) {
               txt.setLength(0);
               txt.append("Could not get AsyncContext. Exception: ").append(e.toString());
               LOGGER.warning(txt.toString());
               resp.getWriter().write(txt.toString());
               return;
            }
         }

         HttpServletRequest hreq = (HttpServletRequest) req.getAttribute("javax.portlet.debug.ServletRequest");
         trace(hreq, "Resource method: ");
         
         // HttpServletRequest hreq = (HttpServletRequest) ctx.getRequest();
         PortletConfig config = (PortletConfig) req.getAttribute("javax.portlet.config");
         String portletName = "Could not get PortletConfig";
         if (config != null) {
            portletName = config.getPortletName();
         }

         switch (adb.getType()) {
         case DISPATCH:
            LOGGER.fine("Dispatching to JSP.");
            ctx.dispatch(JSP);
            break;
         case FWD:
            LOGGER.fine("Doing request dispatcher forward to JSP.");
            req.setAttribute(ATTRIB_TITLE, "Resource Method forwarding to JSP");
            rd = req.getPortletContext().getRequestDispatcher(JSP);
            rd.forward(req, resp);
            resp.flushBuffer();
            if (!auto) {
               ctx.complete();
            }
            break;
         case INC:
            LOGGER.fine("Doing request dispatcher include of JSP.");
            req.setAttribute(ATTRIB_TITLE, "Resource Method including JSP");
            rd = req.getPortletContext().getRequestDispatcher(JSP);
            rd.include(req, resp);
            resp.flushBuffer();
            if (!auto) {
               ctx.complete();
            }
            break;
         default:
            LOGGER.fine("Producing text output.");
            txt.setLength(0);
            txt.append("<h5>Async portlet resource method producing text output for portlet: " + portletName + "</h5>");
            txt.append("<p>dispatcher type: ").append(req.getDispatcherType().toString());
            txt.append("</p>");
            resp.getWriter().write(txt.toString());
            resp.flushBuffer();
            if (!auto) {
               ctx.complete();
            }
            break;
         }
      }
      
      if (adb.getDelay() > 0 && req.isAsyncStarted()) {
         
         // now start the executor thread 
         
         OutputType type = adb.getType();
         if (adb.isAutoDispatch()) {
            type = OutputType.AUTO;
         }

         AsyncRunnable ar = new AsyncRunnable(ctx, adb.getDelay(), type);
         ctx.start(ar);
      }
   }
   
   public static void trace(HttpServletRequest hreq, String src) {
      if (isTrace) {
         List<String> attrNames = Collections.list(hreq.getAttributeNames());
         StringBuilder txt = new StringBuilder(128);
         txt.append(src);
         txt.append("\nAttribute names: ").append(attrNames);
         txt.append("\nasync_request_uri:      ").append((String) hreq.getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:      ").append((String) hreq.getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:      ").append((String) hreq.getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) hreq.getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:      ").append((String) hreq.getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:      ").append((String) hreq.getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path:      ").append((String) hreq.getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path:      ").append((String) hreq.getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:      ").append((String) hreq.getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string:      ").append((String) hreq.getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:      ").append((String) hreq.getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path:      ").append((String) hreq.getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path:      ").append((String) hreq.getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:      ").append((String) hreq.getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string:      ").append((String) hreq.getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_request_uri:      ").append(hreq.getRequestURI());
         txt.append("\nmethod_context_path:      ").append(hreq.getContextPath());
         txt.append("\nmethod_servlet_path:      ").append(hreq.getServletPath());
         txt.append("\nmethod_path_info:      ").append(hreq.getPathInfo());
         txt.append("\nmethod_query_string:      ").append(hreq.getQueryString());
         LOGGER.fine(txt.toString());
      }

   }
}
