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

package org.apache.pluto.driver.services.container;

import java.io.IOException;
import java.util.logging.Logger;

import javax.portlet.ResourceRequest;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletResourceResponseContext;

/**
 * Releases portal resources when the async request completes.
 * 
 * @author Scott Nicklous
 */
public class PortletAsyncListener implements AsyncListener {
   private static final Logger LOGGER = Logger.getLogger(PortletAsyncListener.class.getName());

   private long                start  = System.currentTimeMillis();

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
    */
   @Override
   public void onComplete(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Completed. Execution time: ").append(delta).append(" milliseconds.");
      txt.append(" Releasing: ");

      HttpServletRequest hreq = (HttpServletRequest) evt.getSuppliedRequest();
      if (hreq != null) {
         ResourceRequest rreq = (ResourceRequest) hreq.getAttribute(PortletInvokerService.PORTLET_REQUEST);
         if (rreq != null) {

            // remove portlet-scoped barnacles

            txt.append("portlet-scoped attributes; ");
            rreq.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
            rreq.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
            rreq.removeAttribute(PortletInvokerService.PORTLET_CONFIG);
            rreq.removeAttribute(PortletInvokerService.ASYNC_METHOD);

            PortletResourceResponseContext respctx = (PortletResourceResponseContext) rreq
                  .getAttribute(PortletInvokerService.RESPONSE_CONTEXT);
            if (respctx != null) {
               txt.append("response context resources; ");
               respctx.close();
               respctx.release();
            }
         } else {
            txt.append("... no resource request stuff. Couldn't get resource request; ");
         }
         
         // remove container-scoped attributes

         txt.append("container-scoped attributes; ");
         hreq.removeAttribute(PortletInvokerService.METHOD_ID);
         hreq.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
         hreq.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
         hreq.removeAttribute(PortletInvokerService.FILTER_MANAGER);

      } else {
         txt.append("... nothing. Couldn't get servlet request.");
      }

      LOGGER.fine(txt.toString());

   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
    */
   @Override
   public void onError(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Error after ").append(delta).append(" milliseconds.");
      txt.append(", Exception: ").append(evt.getThrowable().getMessage());
      LOGGER.fine(txt.toString());
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

      // need to add this listener again so it gets called when finally complete.

      AsyncContext ctx = evt.getAsyncContext();
      ctx.addListener(this);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
    */
   @Override
   public void onTimeout(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Timeout after ").append(delta).append(" milliseconds.");
      LOGGER.fine(txt.toString());
   }

}
