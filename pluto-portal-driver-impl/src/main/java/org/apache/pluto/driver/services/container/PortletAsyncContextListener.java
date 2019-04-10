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
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.impl.HttpServletPortletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages the listeners registered by the application. Releases portal resources when 
 * the async request completes and provides contextual services for the listeners. 
 * 
 * @author Scott Nicklous
 */
public class PortletAsyncContextListener implements AsyncListener {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletAsyncContextListener.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   
   // Data for one listener
   private class Entry {

      public AsyncListener          hlis;
      public ServletRequest         hreq;
      public ServletResponse        hresp;
      public PortletAsyncListener   plis;
      public ResourceRequest        preq;
      public ResourceResponse       presp;

      public Entry(AsyncListener lis, ServletRequest req, ServletResponse resp) {
         this.hlis  = lis;
         this.hreq  = req;
         this.hresp = resp;
      }
      
      public Entry(PortletAsyncListener lis, ResourceRequest req, ResourceResponse resp) {
         this.plis  = lis;
         this.preq  = req;
         this.presp = resp;
      }
   }
   
   // The registered listeners
   List<Entry> listeners = new ArrayList<Entry>();
   
   private long start  = System.currentTimeMillis();
   private final PortletAsyncContextImpl pactx;
   
 
   public PortletAsyncContextListener(PortletAsyncContextImpl pactx) {
      this.pactx = pactx;
   }
   
   public void addListener(AsyncListener l) {
      listeners.add(new Entry(l, null, null));
   }
   
   public void addListener(AsyncListener l, ServletRequest req, ServletResponse resp) {
      listeners.add(new Entry(l, req, resp));
   }
   
   public void addListener(PortletAsyncListener l) {
      listeners.add(new Entry(l, null, null));
   }
   
   public void addListener(PortletAsyncListener l, ResourceRequest req, ResourceResponse resp) {
      listeners.add(new Entry(l, req, resp));
   }
   
   private void trace (String meth) {
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Firing ").append(meth).append(" event for ");
         txt.append(listeners.size()).append(" listeners.");
         int hcnt=0, pcnt=0;
         for (Entry e : listeners) {
            if (e.hlis != null) hcnt++;
            if (e.plis != null) pcnt++;
         }
         txt.append(", # AsyncListeners: ").append(hcnt);
         txt.append(", # PortletAsyncListeners: ").append(pcnt);
         LOG.trace(txt.toString());
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
    */
   @Override
   public void onComplete(AsyncEvent evt) throws IOException {

      trace("onComplete");
      
      pactx.registerContext(true);
      for (Entry l : listeners) {
         if (l.hlis != null) {
            AsyncEvent lisevt = new AsyncEvent(pactx, l.hreq, l.hresp);
            l.hlis.onComplete(lisevt);
         } else {
            PortletAsyncEvent lisevt = new PortletAsyncEvent(pactx, l.preq, l.presp);
            l.plis.onComplete(lisevt);
         }
      }
      pactx.deregisterContext(true);
      pactx.setComplete(true);
      
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
         txt.append("... no servlet request stuff. Couldn't get servlet request.");
      }
      
      txt.append(" Removing contextual info.");
      pactx.removeContext();
      
      HttpServletPortletRequestWrapper wrapper = 
            (HttpServletPortletRequestWrapper) pactx.getAsyncRequestWrapper();
      if (wrapper != null) {
         txt.append(" Closing the request wrapper.");
         wrapper.endAsyncProcessing();
      } else {
         txt.append(" Couldn't get the request wrapper.");
      }

      if (isDebug) {
         LOG.debug(txt.toString());
      }

   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
    */
   @Override
   public void onError(AsyncEvent evt) throws IOException {
      
      trace("onError");      
      pactx.registerContext(true);
      for (Entry l : listeners) {
         if (l.hlis != null) {
            AsyncEvent lisevt = new AsyncEvent(pactx, l.hreq, l.hresp);
            l.hlis.onError(lisevt);
         } else {
            PortletAsyncEvent lisevt = new PortletAsyncEvent(pactx, l.preq, l.presp);
            l.plis.onError(lisevt);
         }
      }
      pactx.deregisterContext(true);
      
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Error after ").append(delta).append(" milliseconds.");

      // attempt to complete

      try {
         AsyncContext ctx = evt.getAsyncContext();
         ctx.complete();
         txt.append(" Portlet container completed request processing on behalf of the application.");
      } catch (IllegalStateException e) {
         txt.append(" An earlier listener has already dispatched or completed request.");
      } catch (Exception e) {
      }

      txt.append(", Exception: ").append(evt.getThrowable().getMessage());
      if (isDebug) {
         LOG.debug(txt.toString());
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
    */
   @Override
   public void onStartAsync(AsyncEvent evt) throws IOException {

      trace("onStartAsync");
      
      // copy & clear the original listener list. If a listener wants to be notified
      // again, it will add itself again.
      
      ArrayList<Entry> entries = new ArrayList<Entry>(listeners);
      listeners.clear();

      pactx.registerContext(true);
      for (Entry l : entries) {
         if (l.hlis != null) {
            AsyncEvent lisevt = new AsyncEvent(pactx, l.hreq, l.hresp);
            l.hlis.onStartAsync(lisevt);
         } else {
            PortletAsyncEvent lisevt = new PortletAsyncEvent(pactx, l.preq, l.presp);
            l.plis.onStartAsync(lisevt);
         }
      }
      pactx.deregisterContext(true);
      
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Async started again after ").append(delta).append(" milliseconds.");
      if (isDebug) {
         LOG.debug(txt.toString());
      }

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

      trace("onTimeout");
      
      pactx.registerContext(true);
      for (Entry l : listeners) {
         if (l.hlis != null) {
            AsyncEvent lisevt = new AsyncEvent(pactx, l.hreq, l.hresp);
            l.hlis.onTimeout(lisevt);
         } else {
            PortletAsyncEvent lisevt = new PortletAsyncEvent(pactx, l.preq, l.presp);
            l.plis.onTimeout(lisevt);
         }
      }
      pactx.deregisterContext(true);
      
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Timeout after ").append(delta).append(" milliseconds.");
      
      // if the application has properly registered a listener and has not processed the 
      // timeout by calling onComplete or dispatch, complete the request.
      
      boolean warn = false;
      AsyncContext ctx = evt.getAsyncContext();
      try {
         ctx.getRequest();
         
         try {
            ctx.complete();
            txt.append(" Portlet container completed request processing on behalf of the application.");
            warn = true;
         } catch (IllegalStateException e) {
            txt.append(" An earlier listener has dispatched again.");
         } catch (Exception e) {
            txt.append(" Exception occured while completing request: " + e.toString());
         }
         
      } catch(Exception e) {
         txt.append(" Async processing was completed by the application.");
      }

      if (warn) {
         LOG.warn(txt.toString());
      } else {
         if (isDebug) {
            LOG.debug(txt.toString());
         }
      }
   }

}
