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

import static javax.portlet.ActionRequest.ACTION_NAME;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.DispatcherType;
import javax.xml.namespace.QName;

import org.apache.pluto.container.PortletInvokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides an easy-to-use facade for the portlet methods.
 * 
 * @author nick
 *
 */
public class PortletInvoker implements Portlet, ResourceServingPortlet, EventPortlet, HeaderPortlet {

   public static final String LAST_METHOD = PortletInvoker.class.getName() + ".LAST_METHOD";

   private static final Logger       LOG     = LoggerFactory.getLogger(PortletInvoker.class);
   private static final boolean      isDebug = LOG.isDebugEnabled();

   private final AnnotatedMethodStore  methodStore;
   private final String                portletName;
   private PortletConfig               config;

   /**
    * Construct for given portlet name.
    */
   public PortletInvoker(AnnotatedMethodStore methodStore, String portletName) {
      this.methodStore = methodStore;
      this.portletName = portletName;
   }

   /**
    * Construct for given portlet name.
    */
   public PortletInvoker(AnnotatedConfigBean acb, String portletName) {
      this.methodStore = acb.getMethodStore();
      this.portletName = portletName;
   }

   public PortletInvoker(
       AnnotatedMethodStore ams, String portlet, PortletConfig config) {
      this(ams, portlet);
      this.config = config;
   }

   // =======================================================================

   /**
    * Returns a list of methods to be invoked for the given method identifier.
    * 
    * @param mi
    *           The method identifier
    * @return A list of methods. may be empty.
    */
   private List<AnnotatedMethod> getMethods(MethodIdentifier mi) {

      // get the method from the store. If the requested method cannot
      // be found,
      // retry with the default dispatch ID ("").

      if (isDebug) {
         LOG.debug("Retrieving method for method identifier: " + mi.toString());
      }

      List<AnnotatedMethod> meths = methodStore.getMethods(mi);
      if (meths.isEmpty()) {
         Object id = mi.getId();
         if ((id != null) && (id instanceof String) && ((String) id).length() > 0) {
            mi.setId("");
            if (isDebug) {
               LOG.debug("Retrying retrieval with method identifier: " + mi.toString());
            }
            meths = methodStore.getMethods(mi);
         }
      }

      return meths;
   }

   /**
    * Invokes the given method, handling exceptions.
    * 
    * @param meth
    *           The bean method to be invoked
    * @param args
    *           The method arguments
    * @throws PortletException
    *            If a portlet exception occurs
    * @throws IOException
    *            If an IO exception occurs
    * @return The object returned by the invoked method
    */
   private Object invokePortletMethod(AnnotatedMethod meth, Object... args) throws PortletException, IOException {
      Object result;

      try {
         // Now invoke the method
         result = meth.invoke(args);
      } catch (InvocationTargetException ite) {
         Throwable t = ite.getCause();
         if (t != null) {
            if (t instanceof PortletException) {
               throw (PortletException) t;
            } else if (t instanceof IOException) {
               throw (IOException) t;
            } else if (t instanceof RuntimeException) {
               throw (RuntimeException) t;
            }
         }
         String msg = "Problem invoking " + meth.toString() + ". Unknown InvocationTargetException Cause. ";
         throw new PortletException(msg, ite);
      } catch (RuntimeException re) {
         throw re;
      } catch (Exception e) {
         String msg = "Problem invoking " + meth.toString() + ". ";
         throw new PortletException(msg + e.getMessage());
      }
      return result;
   }

   // =======================================================================

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.config = config;

      MethodIdentifier mi = new MethodIdentifier(portletName, "", MethodType.INIT);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.size() == 0) {

         // If no init method, log debug trace and return

         if (isDebug) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Init method not found for portlet: ").append(portletName);
            LOG.debug(txt.toString());
         }
         return;
      }
      assert meths.size() == 1;
      AnnotatedMethod meth = meths.get(0);

      // Set up the method arguments and do the invocation

      Object[] args = new Object[] { config };
      try {
         invokePortletMethod(meth, args);
      } catch (Throwable t) {
         throw new PortletException("Portlet could not be initialized.", t);
      }

   }

   @Override
   public void destroy() {

      MethodIdentifier mi = new MethodIdentifier(portletName, "", MethodType.DESTROY);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.size() == 0) {

         // If no init method, log debug trace and return

         if (isDebug) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Destroy method not found for portlet: ").append(portletName);
            LOG.debug(txt.toString());
         }
         return;
      }
      assert meths.size() == 1;
      AnnotatedMethod meth = meths.get(0);

      // Set up the method arguments and do the incovation

      Object[] args = new Object[] {};
      try {
         invokePortletMethod(meth, args);
      } catch (Exception e) {
      }
   }

   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {

      String id = (req.getResourceID() != null) ? req.getResourceID() : "";
      MethodIdentifier mi = new MethodIdentifier(portletName, id, MethodType.RESOURCE);

      List<AnnotatedMethod> meths = new ArrayList<AnnotatedMethod>();
      if (req.getDispatcherType() == DispatcherType.ASYNC) {

         // Handle AsyncContest#dispatch() case

         AnnotatedMethod meth = (AnnotatedMethod) req.getAttribute(PortletInvokerService.ASYNC_METHOD);
         ;
         if (meth == null) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Async processing error. ServeResource method attribute could not be retrieved.");
            LOG.error(txt.toString());
            return;
         }
         LOG.debug("Processing async dispatch. method: " + meth.toString());
         meths.add(meth);
      } else {
         meths = getMethods(mi);
      }

      int totalMethods = meths.size();
      if (totalMethods == 0) {

         // If a resource URL was activated, but no resource method could be
         // found, add appropriate error string.

         StringBuilder txt = new StringBuilder(128);
         txt.append("ServeResource method not found. Resource ID=\"").append(id).append("\"");
         LOG.warn(txt.toString());
         return;
      }

      // now do the invocation

      for (int i = 0; i < totalMethods; i++) {

         if (i == (totalMethods - 1)) {
            req.setAttribute(LAST_METHOD, Boolean.TRUE);
         }

         // Set the character encoding & content type, if available
         AnnotatedMethod meth = meths.get(i);

         ServeResourceMethod rm = (ServeResourceMethod) meth.getAnnotation();
         if (rm != null) {
            if (rm.characterEncoding().length() > 0) {
               resp.setCharacterEncoding(rm.characterEncoding());
            }
            if (!rm.contentType().matches("(^$|\\*|\\*/\\*|text/\\*)")) {
               resp.setContentType(rm.contentType());
            }
         }

         // Set up the method arguments based on the signature variant

         Object[] args = {};
         Object result;
         MethodDescription methDescription = meth.getDescription();
         SignatureVariant signatureVariant = methDescription.getVariant();
         if ((signatureVariant == SignatureVariant.STRING_RESOURCEREQ_RESOURCERESP) ||
             (signatureVariant == SignatureVariant.VOID_RESOURCEREQ_RESOURCERESP)) {
            args = new Object[] { req, resp };
         }

         // invoke the resource method

         result = invokePortletMethod(meth, args);

         if (req.isAsyncStarted()) {

            // If async processing was started, handle the special case.
            // It doesn't make sense to write output, as the resource method may
            // be writing output through an async thread. Set up to process
            // async dispatch.
            // also, after async is started, no further methods can be invoked.

            LOG.debug("Async processing was started during method: " + meth.toString());
            req.setAttribute(PortletInvokerService.ASYNC_METHOD, meth);
            break;

         } else {

            // No async processing.
            // If output is to be expected, write it to the writer

            if (signatureVariant == SignatureVariant.STRING_VOID) {
               if (result != null) {
                  assert result instanceof String;
                  resp.getWriter().write((String) result);
               }
            }

            // If an include resource is provided, include it

            if ((rm != null) && (rm.include().length() > 0)) {
               PortletRequestDispatcher prd = config.getPortletContext().getRequestDispatcher(rm.include());
               prd.include(req, resp);
            }
         }
      }
   }

   @Override
   public void processEvent(EventRequest req, EventResponse resp) throws PortletException, IOException {

      QName qn = req.getEvent().getQName();
      MethodIdentifier mi = new MethodIdentifier(portletName, qn, MethodType.EVENT);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.size() == 0) {

         // retry with empty string (for portlet class processEvent method, for
         // example)
         mi.setId("");
         meths = getMethods(mi);
         if (meths.size() == 0) {

            // If an event to be processed, but event method could not be found,
            // add appropriate error string.

            StringBuilder txt = new StringBuilder(128);
            txt.append("Event method not found. Event qname=").append(qn);
            LOG.warn(txt.toString());
            return;
         }
      }
      assert meths.size() == 1;
      AnnotatedMethod meth = meths.get(0);

      // Set up the method arguments and do the incovation

      Object[] args = new Object[] { req, resp };
      invokePortletMethod(meth, args);
   }

   @Override
   public void processAction(ActionRequest req, ActionResponse resp) throws PortletException, IOException {

      ActionParameters actionParameters = req.getActionParameters();

      String an = actionParameters.getValue(ACTION_NAME);

      if (an == null) {
         an = actionParameters.getValue(resp.getNamespace() + ACTION_NAME);
      }

      String id = (an != null) ? an : "";
      MethodIdentifier mi = new MethodIdentifier(portletName, id, MethodType.ACTION);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.size() == 0) {

         // If an action URL was activated, but action method could not be
         // found,
         // add appropriate error string.

         StringBuilder txt = new StringBuilder(128);
         txt.append("Action method not found. Action name=\"").append(an).append("\"");
         LOG.warn(txt.toString());
         return;
      }
      assert meths.size() == 1;
      AnnotatedMethod meth = meths.get(0);

      // Set up the method arguments and do the incovation

      Object[] args = new Object[] { req, resp };
      invokePortletMethod(meth, args);

   }

   @Override
   public void render(RenderRequest req, RenderResponse resp) throws PortletException, IOException {

      // https://issues.apache.org/jira/browse/PLUTO-765
      ResourceBundle resourceBundle = config.getResourceBundle(req.getLocale());
      if (isDebug) {
         LOG.debug("PLUTO-765 resourceBundle={}", resourceBundle);
      }

      String pm = req.getPortletMode().toString();
      String id = (pm != null) ? pm.toUpperCase() : "";
      MethodIdentifier mi = new MethodIdentifier(portletName, id, MethodType.RENDER);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.isEmpty()) {
         // No render methods available
         StringBuilder txt = new StringBuilder(128);
         txt.append("Render method not found. Portlet mode: \"").append(pm).append("\"");
         LOG.warn(txt.toString());
         return;
      }

      int totalMethods = meths.size();
      for (int i = 0; i < totalMethods; i++) {

         if (i == (totalMethods - 1)) {
            req.setAttribute(LAST_METHOD, Boolean.TRUE);
         }

         // Set the content type, if available (determined by first render
         // method)
         AnnotatedMethod meth = meths.get(i);

         RenderMethod rm = (RenderMethod) meth.getAnnotation();
         if ((rm != null) && !rm.contentType().matches("(^$|\\*|\\*/\\*|text/\\*)")) {
            resp.setContentType(rm.contentType());
         }

         // Set up the method arguments based on the signature variant

         Object[] args = {};
         Object result;
         MethodDescription methodDescription = meth.getDescription();
         SignatureVariant variant = methodDescription.getVariant();
         if ((variant == SignatureVariant.DEFAULT.STRING_RENDERREQ_RENDERRESP) ||
             (variant == SignatureVariant.VOID_RENDERREQ_RENDERRESP)) {
            args = new Object[] { req, resp };
         }

         // invoke the render method

         result = invokePortletMethod(meth, args);

         // If output is to be expected, write it to the writer

         if (variant == SignatureVariant.STRING_VOID) {
            if (result != null) {
               assert result instanceof String;
               resp.getWriter().write((String) result);
            }
         }

         // If an include resource is provided, include it

         if ((rm != null) && (rm.include().length() > 0)) {
            PortletRequestDispatcher prd = config.getPortletContext().getRequestDispatcher(rm.include());
            prd.include(req, resp);
         }
      }
   }

   @Override
   public void renderHeaders(HeaderRequest req, HeaderResponse resp) throws PortletException, java.io.IOException {

      String pm = req.getPortletMode().toString();
      String id = (pm != null) ? pm.toUpperCase() : "";
      MethodIdentifier mi = new MethodIdentifier(portletName, id, MethodType.HEADER);

      List<AnnotatedMethod> meths = getMethods(mi);
      if (meths.isEmpty()) {
         // No header methods available
         StringBuilder txt = new StringBuilder(128);
         txt.append("Header method not found. Portlet mode: \"").append(pm).append("\"");
         LOG.warn(txt.toString());
         return;
      }

      for (AnnotatedMethod meth : meths) {

         // Set the content type, if available (determined by first render
         // method)

         HeaderMethod hm = (HeaderMethod) meth.getAnnotation();
         if ((hm != null) && !hm.contentType().matches("(^$|\\*|\\*/\\*|text/\\*)")) {
            resp.setContentType(hm.contentType());
         }

         // Set up the method arguments based on the signature variant

         Object[] args = {};
         Object result;
         if (meth.getDescription().getVariant() == SignatureVariant.VOID_HEADERREQ_HEADERRESP) {
            args = new Object[] { req, resp };
         }

         // invoke the render method

         result = invokePortletMethod(meth, args);

         // If output is to be expected, write it to the writer

         if (meth.getDescription().getVariant() == SignatureVariant.STRING_VOID) {
            if (result != null) {
               assert result instanceof String;
               resp.getWriter().write((String) result);
            }
         }

         // If an include resource is provided, include it

         if ((hm != null) && (hm.include().length() > 0)) {
            PortletRequestDispatcher prd = config.getPortletContext().getRequestDispatcher(hm.include());
            prd.include(req, resp);
         }
      }
   }

}
