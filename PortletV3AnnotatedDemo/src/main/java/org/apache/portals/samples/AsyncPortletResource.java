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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
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
   private static final Logger LOGGER      = Logger.getLogger(AsyncPortletResource.class.getName());

   private final static String JSP         = "/WEB-INF/jsp/asyncOutput.jsp";
   private final static String ATTRIB_REPS = "reps";
   private final static String ATTRIB_AUTO = "auto";

   private class AsyncRunnable implements Runnable {

      private final AsyncContext ctx;
      private final int          delay;
      private final OutputType   type;
      private final boolean      done;

      public AsyncRunnable(AsyncContext ctx, int delay, OutputType type, boolean done) {
         this.ctx = ctx;
         this.delay = delay;
         this.type = type;
         this.done = done;
      }

      @Override
      public void run() {
         try {
            Thread.sleep(delay);

            HttpServletRequest hreq = (HttpServletRequest) ctx.getRequest();
            HttpServletResponse hresp = (HttpServletResponse) ctx.getResponse();
            RequestDispatcher rd;

            switch (type) {
            case TEXT:
               LOGGER.fine("Producing text output.");
               StringBuilder txt = new StringBuilder(128);
               txt.append("<p>AsyncRunnable.");
               txt.append(" dispatcher type: ").append(hreq.getDispatcherType().toString());
               txt.append("</p>");
               hresp.getWriter().write(txt.toString());
               if (done) {
                  ctx.complete();
               }
               break;
            case AUTO:
               LOGGER.fine("Dispatching to resource method.");
               hreq.setAttribute(ATTRIB_AUTO, new Boolean(true));
               ctx.dispatch();
               break;
            case DISPATCH:
               LOGGER.fine("Dispatching to JSP.");
               ctx.dispatch(JSP);
               break;
            case FWD:
               LOGGER.fine("Doing request dispatcher forward to JSP.");
               rd = hreq.getRequestDispatcher(JSP);
               rd.forward(hreq, hresp);
               if (done) {
                  ctx.complete();
               }
               break;
            case INC:
               LOGGER.fine("Doing request dispatcher include of JSP.");
               rd = hreq.getRequestDispatcher(JSP);
               rd.include(hreq, hresp);
               if (done) {
                  ctx.complete();
               }
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

      Integer reps = (Integer) req.getAttribute(ATTRIB_REPS);
      if (reps == null) {
         reps = adb.getReps();
      }

      boolean done = false;
      if (--reps <= 0 || !adb.isAutoDispatch()) {
         done = true;
      }
      req.setAttribute(ATTRIB_REPS, reps);

      Boolean auto = (Boolean) req.getAttribute(ATTRIB_AUTO);
      req.removeAttribute(ATTRIB_AUTO);

      if ((adb.getDelay() <= 0) || (auto != null)) {
         
         PortletRequestDispatcher rd;
         AsyncContext ctx = null;
         try {
            ctx = req.getAsyncContext();
         } catch (Exception e) {}

         switch (adb.getType()) {
         case TEXT:
            LOGGER.fine("Producing text output.");
            StringBuilder txt = new StringBuilder(128);
            txt.append("<p>AsyncRunnable.");
            txt.append(" dispatcher type: ").append(req.getDispatcherType().toString());
            txt.append("</p>");
            resp.getWriter().write(txt.toString());
            if (done && ctx != null) {
               ctx.complete();
            }
            break;
         case DISPATCH:
            LOGGER.fine("Dispatching to JSP.");
            if (ctx != null) {
               ctx.dispatch(JSP);
            }
            break;
         case FWD:
            LOGGER.fine("Doing request dispatcher forward to JSP.");
            rd = req.getPortletContext().getRequestDispatcher(JSP);
            rd.forward(req, resp);
            if (done && ctx != null) {
               ctx.complete();
            }
            break;
         case INC:
            LOGGER.fine("Doing request dispatcher include of JSP.");
            rd = req.getPortletContext().getRequestDispatcher(JSP);
            rd.include(req, resp);
            if (done && ctx != null) {
               ctx.complete();
            }
            break;
         default:
            break;
         }
      }
      
      if (adb.getDelay() > 0 && (!done || auto == null)) {
         AsyncContext ctx = req.startAsync();
         ctx.setTimeout(4000);
         OutputType type = adb.getType();
         if (adb.isAutoDispatch()) {
            type = OutputType.AUTO;
         }
         AsyncRunnable ar = new AsyncRunnable(ctx, adb.getDelay(), type, done);
         ctx.start(ar);
      }

   }
}
