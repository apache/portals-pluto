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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.portals.samples.AsyncDialogBean.TimeoutType;
import static org.apache.portals.samples.AsyncPortletResource.*;

/**
 * @author Scott Nicklous
 * 
 */
public class AsyncPortletListener implements AsyncListener {
   private static final Logger            LOGGER = Logger.getLogger(AsyncPortletListener.class.getName());

   private long                           start  = System.currentTimeMillis();

   @Inject
   private PortletRequestRandomNumberBean reqnum;
   @Inject
   private AsyncDialogBean                adb;

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
    */
   @Override
   public void onComplete(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Completed. Execution time: ").append(delta).append(" milliseconds.");

      LOGGER.fine(txt.toString());
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
    */
   @Override
   public void onError(AsyncEvent evt) throws IOException {

      // this doesn't seem to get called when an error occurs in the executor
      // thread.

      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Error after ").append(delta).append(" milliseconds.");
      txt.append(", Exception: ").append(evt.getThrowable().getMessage());

      LOGGER.fine(txt.toString());
      evt.getAsyncContext().complete();
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
    */
   @Override
   public void onStartAsync(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Async started again after ").append(delta).append(" milliseconds.");
      LOGGER.fine(txt.toString());

      // need to add this listener again so it gets called when finally
      // complete.

      AsyncContext ctx = evt.getAsyncContext();
      // ctx.addListener(this);

      // Try to write some output.

      try {
         if (adb.isShowListener()) {
            HttpServletRequest req = (HttpServletRequest) ctx.getRequest();
            HttpServletResponse resp = (HttpServletResponse) ctx.getResponse();
            txt.setLength(0);
            txt.append("<div class='orangebox'>");
            txt.append("Listener: restarting async.");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Request number: ").append(reqnum.getRandomNumber());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Dispatcher type: ").append(req.getDispatcherType());
            txt.append("</span>");
            txt.append("</div>");
            resp.getWriter().write(txt.toString());
         }
      } catch (Exception e) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         LOGGER.fine("Exception producing output: \n" + sw.toString());
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
    */
   @Override
   public void onTimeout(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      try {
         HttpServletRequest req = (HttpServletRequest) evt.getAsyncContext().getRequest();
         if (adb.isShowListener()) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("<div class='orangebox'>");
            txt.append("AsyncPortletListener: Timeout after ").append(delta).append(" milliseconds.");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Action: ").append(adb.getHandleTimeout().toString());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Request number: ").append(reqnum.getRandomNumber());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Dispatcher type: ").append(req.getDispatcherType());
            txt.append("</span>");
            txt.append("</div>");
            PrintWriter writer = evt.getAsyncContext().getResponse().getWriter();
            writer.println(txt.toString());
         }
         
         if (adb.getHandleTimeout() == TimeoutType.CPL) {
            evt.getAsyncContext().complete();
         } else if (adb.getHandleTimeout() == TimeoutType.DIS) {
            req.setAttribute(ATTRIB_TIMEOUT, ATTRIB_TIMEOUT);
            evt.getAsyncContext().dispatch();
         }
      } catch (Exception e) {
         LOGGER.warning(" Couldn't get response to generate output. Exception: " + e.toString());
      }
   }

}
