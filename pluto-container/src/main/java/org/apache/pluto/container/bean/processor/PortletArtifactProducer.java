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


package org.apache.pluto.container.bean.processor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.inject.Named;
import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ClientDataRequest;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.annotations.ContextPath;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.PortletName;
import javax.portlet.annotations.PortletRequestScoped;
import javax.portlet.annotations.WindowId;
import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains producer methods for portlet artifacts that are dependent on the portlet
 * request, response, or configuration.
 *  
 * @author Scott Nicklous
 *
 */
public class PortletArtifactProducer {
   private static final Logger LOG = LoggerFactory.getLogger(PortletArtifactProducer.class);
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   
   // There needs to be a single producer instance per thread.
   private static final ThreadLocal<PortletArtifactProducer> producers = 
         new ThreadLocal<PortletArtifactProducer>();
   
   private PortletRequest    req;
   private PortletResponse   resp;
   private PortletConfig     config;   
   
   /**
    * Private constructor. Each instance gets put into the thread local.
    */
   private PortletArtifactProducer() { }
  
   /**
    * Producer method to make this into a managed bean, so that CDI can use the other 
    * producer methods. 
    * @return
    */
   @Produces
   public static PortletArtifactProducer getPAP() {
      PortletArtifactProducer pap = producers.get();
      if (pap == null) {
         pap = new PortletArtifactProducer();
         producers.set(pap);
         
         if (isTrace) {
            StringBuilder txt = new StringBuilder(80);
            txt.append("Created new empty PortletArtifactProducer");
            txt.append(", ThreadId=").append(Thread.currentThread().getId());
            LOG.trace(txt.toString());
         }

      }
      return producers.get();
   }
   
   /**
    * Must be called at the end of a request to remove the current instance
    * from the thread local.
    */
   public static void remove() {
      producers.remove();
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Disposed of the PortletArtifactProducer");
         txt.append(", ThreadId=").append(Thread.currentThread().getId());
         LOG.trace(txt.toString());
      }
   }
   
   /**
    * Creates a new producer for this thread and stores it in the thread local.
    * @param req        The portlet request
    * @param resp       The portlet response
    * @param config     The portlet config
    */
   public static void setPrecursors(PortletRequest req, PortletResponse resp, PortletConfig config) {
      PortletArtifactProducer pap = getPAP();
      pap.req = req;
      pap.resp = resp;
      pap.config = config;
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Set precursors.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         txt.append(", Portlet name: ").append(config == null ? "null" : config.getPortletName());
         LOG.trace(txt.toString());
      }

   }

   /**
    * Producer method for the portlet config. 
    */
   @Produces @PortletRequestScoped @Named("portletConfig")
   public static PortletConfig producePortletConfig() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         txt.append(", Portlet name: ").append(pap.config.getPortletName());
         txt.append(", Init param names: ").append(Collections.list(pap.config.getInitParameterNames()).toString());
         LOG.trace(txt.toString());
      }

      return pap.config;
   }

   /**
    * Producer method for the portlet context. 
    */
   @Produces @PortletRequestScoped @Named("portletContext")
   public static PortletContext producePortletContext() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.config.getPortletContext();
   }

   /**
    * Producer method for the portlet request. 
    */
   @Produces @PortletRequestScoped @Named("portletRequest")
   public static PortletRequest producePortletRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req;
   }

   /**
    * Producer method for the portlet response. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("portletResponse")
   public static PortletResponse producePortletResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.resp;
   }

   /**
    * Producer method for the ClientDataRequest.
    */
   @Produces @PortletRequestScoped @Named("clientDataRequest") @Typed(ClientDataRequest.class)
   public static ClientDataRequest produceClientDataRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ClientDataRequest req = null;
      if (pap.req instanceof ClientDataRequest) {
         req = (ClientDataRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the MimeResponse. 
    */
   @Produces @PortletRequestScoped @Named("mimeResponse") @Typed(MimeResponse.class)
   public static MimeResponse produceMimeResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      MimeResponse resp = null;
      if (pap.resp instanceof MimeResponse) {
         resp = (MimeResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the StateAwareResponse. 
    */
   @Produces @PortletRequestScoped @Named("stateAwareResponse") @Typed(StateAwareResponse.class)
   public static StateAwareResponse produceStateAwareResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      StateAwareResponse resp = null;
      if (pap.resp instanceof StateAwareResponse) {
         resp = (StateAwareResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the ActionRequest.
    */
   @Produces @PortletRequestScoped @Named("actionRequest") @Typed(ActionRequest.class)
   public static ActionRequest produceActionRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ActionRequest req = null;
      if (pap.req instanceof ActionRequest) {
         req = (ActionRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the ActionResponse. 
    */
   @Produces @PortletRequestScoped @Named("actionResponse") @Typed(ActionResponse.class)
   public static ActionResponse produceActionResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ActionResponse resp = null;
      if (pap.resp instanceof ActionResponse) {
         resp = (ActionResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the HeaderRequest.
    */
   @Produces @PortletRequestScoped @Named("headerRequest") @Typed(HeaderRequest.class)
   public static HeaderRequest produceHeaderRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      HeaderRequest req = null;
      if (pap.req instanceof HeaderRequest) {
         req = (HeaderRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the HeaderResponse. 
    */
   @Produces @PortletRequestScoped @Named("headerResponse") @Typed(HeaderResponse.class)
   public static HeaderResponse produceHeaderResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      HeaderResponse resp = null;
      if (pap.resp instanceof HeaderResponse) {
         resp = (HeaderResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the RenderRequest.
    */
   @Produces @PortletRequestScoped @Named("renderRequest") @Typed(RenderRequest.class)
   public static RenderRequest produceRenderRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      RenderRequest req = null;
      if ((pap.req instanceof RenderRequest) && !(pap.req instanceof HeaderRequest)) {
         req = (RenderRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the RenderResponse. 
    */
   @Produces @PortletRequestScoped @Named("renderResponse") @Typed(RenderResponse.class)
   public static RenderResponse produceRenderResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      RenderResponse resp = null;
      if (pap.resp instanceof RenderResponse) {
         resp = (RenderResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the EventRequest.
    */
   @Produces @PortletRequestScoped @Named("eventRequest") @Typed(EventRequest.class)
   public static EventRequest produceEventRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      EventRequest req = null;
      if (pap.req instanceof EventRequest) {
         req = (EventRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the EventResponse. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("eventResponse") @Typed(EventResponse.class)
   public static EventResponse produceEventResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      EventResponse resp = null;
      if (pap.resp instanceof EventResponse) {
         resp = (EventResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the ResourceRequest.
    * @return
    */
   @Produces @PortletRequestScoped @Named("resourceRequest") @Typed(ResourceRequest.class)
   public static ResourceRequest produceResourceRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ResourceRequest req = null;
      if (pap.req instanceof ResourceRequest) {
         req = (ResourceRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the ResourceResponse. 
    */
   @Produces @PortletRequestScoped @Named("resourceResponse") @Typed(ResourceResponse.class)
   public static ResourceResponse produceResourceResponse() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ResourceResponse resp = null;
      if (pap.resp instanceof ResourceResponse) {
         resp = (ResourceResponse) pap.resp;
      }
      return resp;
   }

   /**
    * Producer method for the portlet mode. 
    */
   @Produces @PortletRequestScoped @Named("portletMode")
   public static PortletMode producePortletMode() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPortletMode();
   }

   /**
    * Producer method for the window state. 
    */
   @Produces @PortletRequestScoped @Named("windowState")
   public static WindowState produceWindowState() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getWindowState();
   }

   /**
    * Producer method for the portlet preferences. 
    */
   @Produces @PortletRequestScoped @Named("portletPreferences")
   public static PortletPreferences producePortletPreferences() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPreferences();
   }

   /**
    * Producer method for the cookies. 
    */
   @Produces @PortletRequestScoped @Named("cookies")
   public static List<Cookie> produceCookies() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return Arrays.asList(pap.req.getCookies());
   }

   /**
    * Producer method for the portlet session. 
    */
   @Produces @PortletRequestScoped @Named("portletSession")
   public static PortletSession producePortletSession() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPortletSession();
   }

   /**
    * Producer method for the Locales
    */
   @Produces @PortletRequestScoped @Named("locales") 
   public static List<Locale> produceLocales() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return Collections.list(pap.req.getLocales());
   }
   
   /**
    * Producer method for the render paramters.
    */
   @Produces @PortletRequestScoped @Named("renderParams") @Typed(RenderParameters.class)
   public static RenderParameters getRenderParameters() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getRenderParameters();
   }
   
   /**
    * Producer method for the mutable render parameters.
    */
   @Produces @PortletRequestScoped @Named("mutableRenderParams") @Typed(MutableRenderParameters.class)
   public static MutableRenderParameters getMutableRenderParameters() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      MutableRenderParameters obj = null;
      if (pap.resp instanceof StateAwareResponse) {
         obj = ((StateAwareResponse)pap.resp).getRenderParameters();
      }
      return obj;
   }
   
   /**
    * Producer method for the action parameters.
    */
   @Produces @PortletRequestScoped @Named("actionParams") @Typed(ActionParameters.class)
   public static ActionParameters getActionParameters() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ActionParameters obj = null;
      if (pap.req instanceof ActionRequest) {
         obj = ((ActionRequest)pap.req).getActionParameters();
      }
      return obj;
   }
   
   /**
    * Producer method for the resource parameters.
    */
   @Produces @PortletRequestScoped @Named("resourceParams") @Typed(ResourceParameters.class)
   public static ResourceParameters getResourceParameters() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      ResourceParameters obj = null;
      if (pap.req instanceof ResourceRequest) {
         obj = ((ResourceRequest)pap.req).getResourceParameters();
      }
      return obj;
   }

   
   // ==================================
   // Dependent-Scoped producer methods
   // ==================================
   
   /**
    * Producer method for the window ID. 
    */
   @Produces @WindowId @Named("windowId")
   public static String produceWindowID() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getWindowID();
   }

   /**
    * Producer method for the namespace. 
    */
   @Produces @Namespace @Named("namespace")
   public static String produceNamespace() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.resp.getNamespace();
   }

   /**
    * Producer method for the portlet name. 
    */
   @Produces @PortletName @Named("portletName")
   public static String producePortletName() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.config.getPortletName();
   }

   /**
    * Producer method for the context root. 
    */
   @Produces @ContextPath @Named("contextPath")
   public static String produceContextPath() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getContextPath();
   }
   
}
