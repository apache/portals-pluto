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
import java.util.Enumeration;
import java.util.Locale;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.annotations.ActionParam;
import javax.portlet.annotations.BeanPortlet;
import javax.portlet.annotations.ContextPath;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.PortletRequestScoped;
import javax.portlet.annotations.RenderParam;
import javax.portlet.annotations.ResourceParam;
import javax.portlet.annotations.URLFactory;
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
   private static final boolean isDebug = LOG.isDebugEnabled();
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
    * @return
    */
   @Produces @PortletRequestScoped @BeanPortlet @Named("portletConfig")
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
    * Producer method for the portlet request. 
    * @return
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
    * Producer method for the ActionRequest.
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
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
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
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
    * Producer method for the RenderRequest.
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("renderRequest") @Typed(RenderRequest.class)
   public static RenderRequest produceRenderRequest() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      RenderRequest req = null;
      if (pap.req instanceof RenderRequest) {
         req = (RenderRequest) pap.req;
      }
      return req;
   }

   /**
    * Producer method for the RenderResponse. 
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
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
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
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
    * Dependent scoped because it sometimes returns <code>null</code>. 
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
    * Dependent scoped because it sometimes returns <code>null</code>. 
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
    * Dependent scoped because it sometimes returns <code>null</code>. 
    * @return
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
    * @return
    */
   @Produces @Named("portletMode")
   public static PortletMode producePortletMode() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPortletMode();
   }

   /**
    * Producer method for the window state. 
    * @return
    */
   @Produces @Named("windowState")
   public static WindowState produceWindowState() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getWindowState();
   }

   /**
    * Producer method for the portlet preferences. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("portletPreferences")
   public static PortletPreferences producePortletPreferences() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPreferences();
   }

   /**
    * Producer method for the cookies. 
    * @return
    */
   @Produces @Named("cookies")
   public static Cookie[] produceCookies() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getCookies();
   }

   /**
    * Producer method for the portlet session. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("portletSession")
   public static PortletSession producePortletSession() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getPortletSession();
   }

   /**
    * Producer method for the window ID. 
    * @return
    */
   @Produces @WindowId @Named("windowId")
   public static String produceWindowID() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getWindowID();
   }

   /**
    * Producer method for the Locale. 
    * @return
    */
   @Produces @Named("locale")
   public static Locale produceLocale() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getLocale();
   }

   /**
    * Producer method for the window ID. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("locales") 
   public static Enumeration<Locale> produceLocales() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getLocales();
   }

   /**
    * Producer method for the window ID. 
    * @return
    */
   @Produces @Namespace @Named("namespace")
   public static String produceNamespace() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.resp.getNamespace();
   }

   /**
    * Producer method for the context root. 
    * @return
    */
   @Produces @ContextPath @Named("contextPath")
   public static String produceContextPath() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return pap.req.getContextPath();
   }

   /**
    * Producer method for the URL factory. 
    * @return
    */
   @Produces @PortletRequestScoped @Named("urlFactory")
   public static URLFactory produceURLFactory() {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      return new URLFactoryImpl(pap.resp);
   }
   
   /**
    * Producer method for the parameter as String.
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @ActionParam("")
   public static String getActionParameter(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String val = null;
      if (pap.req instanceof ActionRequest) {
         ActionRequest areq = (ActionRequest) pap.req;
         ActionParam ap = (ActionParam) ip.getAnnotated().getAnnotation(ActionParam.class);
         val = areq.getActionParameters().getValue(ap.value());
         trace("@ActionParam", "String", ap.value(), val);
      }
      return val;
   }
   
   /**
    * Producer method for the parameter as String[].
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @ActionParam("")
   public static String[] getActionParameterValues(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String[] vals = null;
      if (pap.req instanceof ActionRequest) {
         ActionRequest areq = (ActionRequest) pap.req;
         ActionParam ap = (ActionParam) ip.getAnnotated().getAnnotation(ActionParam.class);
         vals = areq.getActionParameters().getValues(ap.value());
         trace("ActionParam", "String[]", ap.value(), Arrays.toString(vals));
      }
      return vals;
   }
   
   /**
    * Producer method for the parameter as String.
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @RenderParam("")
   public static String getRenderParameter(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String val = null;
      RenderParam rp = (RenderParam) ip.getAnnotated().getAnnotation(RenderParam.class);
      val = pap.req.getRenderParameters().getValue(rp.value());
      trace("@RenderParam", "String", rp.value(), val);
      return val;
   }
   
   /**
    * Producer method for the parameter as String[].
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @RenderParam("")
   public static String[] getRenderParameterValues(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String[] vals = null;
      RenderParam rp = (RenderParam) ip.getAnnotated().getAnnotation(RenderParam.class);
      vals = pap.req.getRenderParameters().getValues(rp.value());
      trace("@RenderParam", "String[]", rp.value(), Arrays.toString(vals));
      return vals;
   }
   
   /**
    * Producer method for the parameter as String.
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @ResourceParam("")
   public static String getResourceParameter(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String val = null;
      if (pap.req instanceof ResourceRequest) {
         ResourceRequest rreq = (ResourceRequest) pap.req;
         ResourceParam rp = (ResourceParam) ip.getAnnotated().getAnnotation(ResourceParam.class);
         val = rreq.getResourceParameters().getValue(rp.value());
         trace("@ResourceParam", "String", rp.value(), val);
      }
      return val;
   }
   
   /**
    * Producer method for the parameter as String[].
    * <p>
    * Dependent scoped to allow reading the injection point.
    *  
    * @param ip      The injection point
    * @return
    */
   @Produces @ResourceParam("")
   public static String[] getResourceParameterValues(InjectionPoint ip) {
      PortletArtifactProducer pap = producers.get();
      assert pap != null;
      String[] vals = null;
      if (pap.req instanceof ResourceRequest) {
         ResourceRequest rreq = (ResourceRequest) pap.req;
         ResourceParam rp = (ResourceParam) ip.getAnnotated().getAnnotation(ResourceParam.class);
         vals = rreq.getResourceParameters().getValues(rp.value());
         trace("@ResourceParam", "String[]", rp.value(), Arrays.toString(vals));
      }
      return vals;
   }

   
   /**
    * Private helper method to trace parameter injection
    * 
    * @param anno
    * @param sig
    * @param pname
    * @param pval
    */
   private static void trace(String anno, String sig, String pname, String pval) {
      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Parameter injection trace.");
         txt.append(" Annotation: ").append(anno);
         txt.append(" Signature: ").append(sig);
         txt.append(" Param name: ").append(pname);
         txt.append(" Param value(s): ").append(pval);
         LOG.debug(txt.toString());
      }
   }
}
