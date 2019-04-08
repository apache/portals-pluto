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

import static org.apache.portals.samples.AsyncPortlet.ATTRIB_TIMEOUT;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.portals.samples.AsyncDialogBean.TimeoutType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott Nicklous
 * 
 */
public class AsyncListener implements PortletAsyncListener {
   private static final Logger logger = LoggerFactory.getLogger(AsyncListener.class);

   private long                           start  = System.currentTimeMillis();

   @Inject private PortletRequestRandomNumberBean reqnum;
   @Inject private AsyncCompleteBean              asyncCompleteBean;
   @Inject private AsyncDialogBean                asyncDialogBean;

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
    */
   @Override
   public void onComplete(PortletAsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Completed. Execution time: ").append(delta).append(" milliseconds.");
      logger.debug(txt.toString());
      
      asyncCompleteBean.setComplete(true);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
    */
   @Override
   public void onError(PortletAsyncEvent evt) throws IOException {

      // this doesn't seem to get called when an error occurs in the executor
      // thread.

      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Error after ").append(delta).append(" milliseconds.");
      
      String msg = "null";
      if (evt != null && evt.getThrowable() != null) {
         msg = evt.getThrowable().getMessage();
      }
      
      txt.append(", Exception: ").append(msg);

      logger.debug(txt.toString());
      evt.getPortletAsyncContext().complete();
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
    */
   @Override
   public void onStartAsync(PortletAsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Async started again after ").append(delta).append(" milliseconds.");
      logger.debug(txt.toString());

      // need to add this listener again so it gets called when finally
      // complete.

      PortletAsyncContext ctx = evt.getPortletAsyncContext();
      // ctx.addListener(this);

      // Try to write some output.

      try {
         if (asyncDialogBean.isShowListener()) {
            ResourceRequest req = ctx.getResourceRequest();
            ResourceResponse resp = ctx.getResourceResponse();
            txt.setLength(0);
            txt.append("<div class='orangebox'>");
            txt.append("Listener: restarting async.");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Request number: ").append(reqnum.getRandomNumber());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("DispatcherType: ").append(req.getDispatcherType());
            txt.append("</span>");
            txt.append("</div>");
            resp.getWriter().write(txt.toString());
         }
      } catch (Exception e) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         logger.debug("Exception producing output: \n" + sw.toString());
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
    */
   @Override
   public void onTimeout(PortletAsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      try {
         ResourceRequest resourceRequest = evt.getPortletAsyncContext().getResourceRequest();
         if (asyncDialogBean.isShowListener()) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("<div class='orangebox'>");
            txt.append("AsyncListener: Timeout after ").append(delta).append(" milliseconds.");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Action: ").append(asyncDialogBean.getHandleTimeout().toString());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("Request number: ").append(reqnum.getRandomNumber());
            txt.append("</span>");
            txt.append("<span style='margin-left: 2em;'>");
            txt.append("DispatcherType: ").append(resourceRequest.getDispatcherType());
            txt.append("</span>");
            txt.append("</div>");
            PrintWriter writer = evt.getPortletAsyncContext().getResourceResponse().getWriter();
            writer.println(txt.toString());
         }
         
         if (asyncDialogBean.getHandleTimeout() == TimeoutType.CPL) {
            evt.getPortletAsyncContext().complete();
         } else if (asyncDialogBean.getHandleTimeout() == TimeoutType.DIS) {
            resourceRequest.setAttribute(ATTRIB_TIMEOUT, ATTRIB_TIMEOUT);
            evt.getPortletAsyncContext().dispatch();
         }
      } catch (Exception e) {
         logger.warn(" Couldn't get response to generate output. Exception: " + e.toString());
      }
   }

}
