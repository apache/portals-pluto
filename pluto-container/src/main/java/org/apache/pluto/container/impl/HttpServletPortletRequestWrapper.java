/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ClientDataRequest;
import javax.portlet.HeaderRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletWindowID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides special handling for servlet request methods to make them behave as defined by the portlet specification
 * during forwards, includes, and async dispatches. Summary:
 * 
 * javax.servlet.forward.* values: represent first forward target javax.servlet.include.* values: handled by underlying
 * servlet container javax.servlet.async.* values: handled by underlying servlet container query and path methods:
 * represent first forward or include target query string: merged with portlet parameters according to spec
 * 
 * The wrapper is designed to be applied once and reinitialized for each nested RequestDispatcher forward or include.
 * 
 * @author Scott Nicklous
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class HttpServletPortletRequestWrapper extends HttpServletRequestWrapper {
   private static final Logger       LOG                  = LoggerFactory
                                                                .getLogger(HttpServletPortletRequestWrapper.class);
   private static final boolean      isDebug              = LOG.isDebugEnabled();
   private static final boolean      isTrace              = LOG.isTraceEnabled();

   private static final String       FORWARD_CONTEXT_PATH = "javax.servlet.forward.context_path";
   private static final String       FORWARD_PATH_INFO    = "javax.servlet.forward.path_info";
   private static final String       FORWARD_QUERY_STRING = "javax.servlet.forward.query_string";
   private static final String       FORWARD_REQUEST_URI  = "javax.servlet.forward.request_uri";
   private static final String       FORWARD_SERVLET_PATH = "javax.servlet.forward.servlet_path";

   @SuppressWarnings("unused")
   private static final String       INCLUDE_CONTEXT_PATH = "javax.servlet.include.context_path";
   @SuppressWarnings("unused")
   private static final String       INCLUDE_PATH_INFO    = "javax.servlet.include.path_info";
   @SuppressWarnings("unused")
   private static final String       INCLUDE_QUERY_STRING = "javax.servlet.include.query_string";
   @SuppressWarnings("unused")
   private static final String       INCLUDE_REQUEST_URI  = "javax.servlet.include.request_uri";
   private static final String       INCLUDE_SERVLET_PATH = "javax.servlet.include.servlet_path";

   private final Map<String, String> origin               = new HashMap<String, String>();
   {
      origin.put(FORWARD_CONTEXT_PATH, null);
      origin.put(FORWARD_PATH_INFO, null);
      origin.put(FORWARD_QUERY_STRING, null);
      origin.put(FORWARD_REQUEST_URI, null);
      origin.put(FORWARD_SERVLET_PATH, null);
   }

   private enum Type {
      INC, FWD, ASYNC_DISPATCH, ASYNC_PROCESSING, NAMED
   }

   private class DispatchElement {
      public Map<String, List<String>> qparms = new HashMap<String, List<String>>();
      public String                    path;
      public Type                      type;
   }

   private final ArrayList<DispatchElement> dispatches            = new ArrayList<DispatchElement>();

   private final PortletRequest preq;
   private boolean              isMethSpecialHandling = false;
   private boolean              isAttrSpecialHandling = false;
   private boolean              isClosed = true;      // needed for async support
   private final HttpSession    session;
   private final PortletRequestContext reqctx;
   private final NamespaceMapper mapper;
   private final PortletWindowID winId;
   private final String phase;

   public HttpServletPortletRequestWrapper(HttpServletRequest hreq, HttpSession session, PortletRequest preq) {
      super(hreq);
      this.preq = preq;
      this.session = session;
      reqctx = (PortletRequestContext) preq.getAttribute(PortletInvokerService.REQUEST_CONTEXT);
      this.mapper = reqctx.getContainer().getContainerServices().getNamespaceMapper();
      this.winId = reqctx.getPortletWindow().getId();
      this.phase = (String) preq.getAttribute(PortletRequest.LIFECYCLE_PHASE);
   }

   private HttpServletRequest getHreq() {
      return (HttpServletRequest) getRequest();
   }

   /**
    * the path info and servlet path can't be extracted beforehand, since we don't have access to the servlet mappings.
    * Extract the correct values.
    */
   private void handleServletPathInfo() {
      String sp = null;
      if (dispatches.size() == 1) {

         if (dispatches.get(0).type == Type.INC || !isForwardingPossible()) {
            sp = (String) getHreq().getAttribute(INCLUDE_SERVLET_PATH);
         } else if (dispatches.get(0).type == Type.FWD) {
            sp = getHreq().getServletPath();
         }

         // the FORWARD_SERVLET_PATH initially contains servlet path + pathinfo
         String osp = origin.get(FORWARD_SERVLET_PATH);
         if (sp != null && !sp.equals(osp)) {
            if (!osp.startsWith(sp)) {
               // this happens when the servlet container dispatcher sets up. just ignore
               if (isTrace) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Servlet path from method not substring of original path.");
                  txt.append(" original: ").append(osp);
                  txt.append(", current: ").append(sp);
                  LOG.trace(txt.toString());
               }
            } else {
               String pathinfo = osp.substring(sp.length());
               pathinfo = (pathinfo.length() == 0) ? null : pathinfo;
               origin.put(FORWARD_SERVLET_PATH, sp);
               origin.put(FORWARD_PATH_INFO, pathinfo);

               if (isDebug) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append(": servlet path (httpreq): ").append(sp);
                  txt.append(", servlet path (origin): ").append(origin.get(FORWARD_SERVLET_PATH));
                  txt.append(", path info: ").append(origin.get(FORWARD_PATH_INFO));
                  txt.append(", req URI: ").append(origin.get(FORWARD_REQUEST_URI));
                  txt.append(", context path: ").append(origin.get(FORWARD_CONTEXT_PATH));
                  txt.append(", query string: ").append(origin.get(FORWARD_QUERY_STRING));
                  LOG.debug(txt.toString());
               }

            }
         }
      }
   }

   /**
    * handles path and query string info extracted from initial path.
    * 
    * @param path
    * @return
    */
   private Map<String, List<String>> processPath(String path) {
      Map<String, List<String>> qp = new HashMap<String, List<String>>();

      if (path != null) {

         String[] pq = path.split("\\?", 2);

         if (dispatches.size() == 0) {

            // If initial include / forward, get the original path info

            String ctxpath = getHreq().getServletContext().getContextPath();
            origin.put(FORWARD_CONTEXT_PATH, ctxpath);
            origin.put(FORWARD_REQUEST_URI, (ctxpath + pq[0]));
            origin.put(FORWARD_SERVLET_PATH, pq[0]);
            if (pq.length > 1) {
               origin.put(FORWARD_QUERY_STRING, pq[1]);
            }
         } else if (dispatches.size() == 1) {

            // make sure the path info and servlet path properly retrieved

            handleServletPathInfo();
         }

         if (pq.length == 2 && pq[1].length() > 0) {

            // handle the query parameters

            String[] params = pq[1].split("&");
            for (String param : params) {
               String[] nv = param.split("=", 2);
               String name = nv[0];
               String val = (nv.length == 2) ? nv[1] : "";
               List<String> vals = qp.get(name);
               if (vals == null) {
                  vals = new ArrayList<String>();
                  qp.put(name, vals);
               }
               vals.add(val);
            }

         }

         // merge in query string parameters from previous dispatches

         int ii = dispatches.size() - 1;
         if (ii >= 0) {
            Map<String, List<String>> oqps = dispatches.get(ii).qparms;
            for (String name : oqps.keySet()) {
               List<String> vals = qp.get(name);
               if (vals == null) {
                  vals = new ArrayList<String>();
                  qp.put(name, vals);
               }
               vals.addAll(oqps.get(name));
            }
         }
      }
      
      isLogged = false;
      return qp;
   }

   private void logSetupValues() {
      if (isTrace) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Wrapper initialized.");
         txt.append(" dispatches.size(): ").append(dispatches.size());
         if (dispatches.size() > 0) {
            DispatchElement de = dispatches.get(dispatches.size() - 1);
            txt.append("\nType: ").append(de.type);
            txt.append(", Path: ").append(de.path);
            txt.append(", meth special: ").append(isMethSpecialHandling);
            txt.append(", attrib special: ").append(isAttrSpecialHandling);
            txt.append(", fwd possible: ").append(isForwardingPossible());
            txt.append(", isClosed: ").append(isClosed);
            txt.append("\nQuery String names: ");
            String sep = "";
            for (String name : de.qparms.keySet()) {
               txt.append(sep).append(name);
               txt.append(", vals: ").append(de.qparms.get(name).toString());
               sep = ", ";
            }

            List<String> attrNames = Collections.list(getAttributeNames());
            txt.append("\nAttribute names: ").append(attrNames);
            txt.append("\norigin_request_uri:    ").append(origin.get("javax.servlet.forward.request_uri"));
            txt.append("\norigin_context_path:   ").append(origin.get("javax.servlet.forward.context_path"));
            txt.append("\norigin_servlet_path:   ").append(origin.get("javax.servlet.forward.servlet_path"));
            txt.append("\norigin_path_info:      ").append(origin.get("javax.servlet.forward.path_info"));
            txt.append("\norigin_query_string:   ").append(origin.get("javax.servlet.forward.query_string"));
         }
         LOG.debug(txt.toString());
      }
   }

   private boolean isLogged = false;
   private void logPathValues() {
      if (isTrace && !isLogged) {
         isLogged = true;
         StringBuilder txt = new StringBuilder(128);
         txt.append("Path values:");
         txt.append("\nasync_request_uri:    ").append((String) getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:   ").append((String) getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:   ").append((String) getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:   ").append((String) getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:  ").append((String) getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path: ").append((String) getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path: ").append((String) getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:    ").append((String) getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string: ").append((String) getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:  ").append((String) getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path: ").append((String) getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path: ").append((String) getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:    ").append((String) getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string: ").append((String) getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_request_uri:   ").append(getRequestURI());
         txt.append("\nmethod_context_path:  ").append(getContextPath());
         txt.append("\nmethod_servlet_path:  ").append(getServletPath());
         txt.append("\nmethod_path_info:     ").append(getPathInfo());
         txt.append("\nmethod_query_string:  ").append(getQueryString());

         txt.append("\n\nPath values (from wrapped servlet request):");
         txt.append("\nasync_request_uri:    ").append((String) getHreq().getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:   ").append((String) getHreq().getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:   ").append((String) getHreq().getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) getHreq().getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:   ").append((String) getHreq().getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:  ").append((String) getHreq().getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path: ").append((String) getHreq().getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path: ").append((String) getHreq().getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:    ").append((String) getHreq().getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string: ").append((String) getHreq().getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:  ").append((String) getHreq().getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path: ").append((String) getHreq().getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path: ").append((String) getHreq().getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:    ").append((String) getHreq().getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string: ").append((String) getHreq().getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_request_uri:   ").append(getHreq().getRequestURI());
         txt.append("\nmethod_context_path:  ").append(getHreq().getContextPath());
         txt.append("\nmethod_servlet_path:  ").append(getHreq().getServletPath());
         txt.append("\nmethod_path_info:     ").append(getHreq().getPathInfo());
         txt.append("\nmethod_query_string:  ").append(getHreq().getQueryString());
         LOG.debug(txt.toString());
      }
   }

   /* ================ Used by dispatcher code in same package ======================= */

   public void startInclude(String path) {
      DispatchElement de = new DispatchElement();
      de.path = path;
      de.type = Type.INC;
      de.qparms = processPath(path);
      dispatches.add(de);

      // always need attribute special handling. Need method special handing only if
      // there was no preceding forward, async, or named dispatch

      isMethSpecialHandling = true;
      isAttrSpecialHandling = true;
      for (int ii = 1; ii < dispatches.size(); ii++) {
         if (dispatches.get(ii).type != Type.INC) {
            isMethSpecialHandling = false;
         }
      }
      
      reqctx.startDispatch(this, de.qparms, phase);
      
      isClosed = false;
      logSetupValues();
   }

   public void startForward(String path) {
      DispatchElement de = new DispatchElement();
      de.path = path;
      de.type = Type.FWD;
      de.qparms = processPath(path);
      dispatches.add(de);
      isMethSpecialHandling = true;       //!isForwardingPossible(); (logical, but not to spec)
      isAttrSpecialHandling = true;
      
      reqctx.startDispatch(this, de.qparms, phase);
      
      isClosed = false;
      logSetupValues();
   }

   public void startAsyncDispatch(String path) {
      DispatchElement de = new DispatchElement();
      de.path = path;
      de.type = Type.ASYNC_DISPATCH;
      de.qparms = processPath(path);
      dispatches.add(de);
      isMethSpecialHandling = false;
      isAttrSpecialHandling = false;
      
      reqctx.startDispatch(this, de.qparms, phase);
      
      isClosed = false;
      logSetupValues();
   }

   public void startAsyncProcessing() {
      DispatchElement de = new DispatchElement();
      de.path = null;
      de.type = Type.ASYNC_PROCESSING;
      de.qparms = Collections.emptyMap();
      dispatches.add(de);
      isMethSpecialHandling = false;
      isAttrSpecialHandling = false;
      isClosed = false;
      reqctx.setAsyncServletRequest(this);
      logSetupValues();
   }
   
   public void endAsyncProcessing() {
      
      if (isTrace) {
         ArrayList<String> types = new ArrayList<String>();
         for (int ii = dispatches.size()-1; ii >= 0; ii--) {
            types.add(dispatches.get(ii).type.toString());
         }
         StringBuilder txt = new StringBuilder();
         txt.append("Ending async processing.");
         txt.append(" remaining dispatch stack: ").append(types.toString());
         LOG.debug(txt.toString());
      }

      dispatches.clear();
      isClosed = true;
      reqctx.setAsyncServletRequest(null);
   }

   public void startNamed(String path) {
      DispatchElement de = new DispatchElement();
      de.path = path;
      de.type = Type.NAMED;
      de.qparms = processPath(path);
      dispatches.add(de);
      isMethSpecialHandling = false;
      isAttrSpecialHandling = false;
      isClosed = false;
      logSetupValues();
   }

   public void endDispatch() {
      DispatchElement oldde = null;
      if (dispatches.size() > 0) {
         oldde = dispatches.remove(dispatches.size() - 1);
      }
      
      // make sure request context is set up properly during nested dispatches
      
      reqctx.endDispatch();
      if (dispatches.size() > 0) {
         DispatchElement de = dispatches.get(dispatches.size() - 1);
         if ((de.type == Type.INC) || (de.type == Type.FWD)) {
            reqctx.startDispatch(this, de.qparms, phase);
         }
      } else {
         // mark that processing completed 
         isClosed = true;
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Ending dispatch.");
         txt.append(" dispatched type: ").append(oldde.type);
         txt.append(",  # remaining nesting levels: ").append(dispatches.size());
         if (!dispatches.isEmpty()) {
            txt.append(",  active dispatch type: ");
            txt.append(dispatches.get(dispatches.size()-1).type);
         }
         LOG.debug(txt.toString());
      }
   }

   // real forwarding is only possible for resource requests.
   boolean isForwardingPossible() {
      return (preq instanceof ResourceRequest);
   }

   /* ================ Override Servlet Methods ======================= */

   @Override
   public Map<String, String[]> getParameterMap() {
      if (isClosed) return Collections.emptyMap();
      Map<String, String[]> pm = reqctx.getParameterMap();
      return pm;
   }

   @Override
   public String getParameter(String name) {
      if (isClosed) return null;
      Map<String, String[]> pm = reqctx.getParameterMap();
      String[] vals = pm.get(name);
      return (vals == null) ? null : vals[0];
   }

   @Override
   public Enumeration<String> getParameterNames() {
      if (isClosed) return Collections.emptyEnumeration();
      Map<String, String[]> pm = reqctx.getParameterMap();
      return Collections.enumeration(pm.keySet());
   }

   @Override
   public String[] getParameterValues(String name) {
      if (isClosed) return null;
      Map<String, String[]> pm = reqctx.getParameterMap();
      return pm.get(name);
   }

   @Override
   public String getContextPath() {
      if (isClosed) return null;
      String val;
      handleServletPathInfo();

      if (isMethSpecialHandling) {
         val = origin.get(FORWARD_CONTEXT_PATH);
      } else {
         val = getHreq().getContextPath();
      }

      return val;
   }

   @Override
   public String getPathInfo() {
      if (isClosed) return null;
      String val;
      handleServletPathInfo();

      if (isMethSpecialHandling) {
         val = origin.get(FORWARD_PATH_INFO);
      } else {
         val = getHreq().getPathInfo();
      }

      return val;
   }

   @Override
   public String getPathTranslated() {
      if (isClosed) return null;
      handleServletPathInfo();
      
      String pinfo = getPathInfo();
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Returning real path for: ").append(pinfo);
         LOG.trace(txt.toString());
      }

      // base the return value on the derived path method value
      if (pinfo != null && isMethSpecialHandling && 
            origin.get(FORWARD_CONTEXT_PATH).equals(preq.getContextPath())) {
         // can only (and possibly) do this while still within the same context
         return getHreq().getServletContext().getRealPath(pinfo);
      }
      return null;
   }

   @Override
   public String getQueryString() {
      if (isClosed) return null;
      String val;
      handleServletPathInfo();

      if (isMethSpecialHandling) {
         val = origin.get(FORWARD_QUERY_STRING);
      } else {
         val = getHreq().getQueryString();
      }

      return val;
   }

   @Override
   public String getRequestURI() {
      if (isClosed) return null;
      String val;
      handleServletPathInfo();

      if (isMethSpecialHandling) {
         val = origin.get(FORWARD_REQUEST_URI);
      } else {
         val = getHreq().getRequestURI();
      }

      return val;
   }

   @Override
   public String getServletPath() {
      if (isClosed) return null;
      String val;
      handleServletPathInfo();

      if (isMethSpecialHandling) {
         val = origin.get(FORWARD_SERVLET_PATH);
      } else {
         val = getHreq().getServletPath();
      }

      return val;
   }

   @Override
   public Object getAttribute(String name) {
      if (isClosed) return null;
      handleServletPathInfo();
      
      Object val;
      if (isAttrSpecialHandling && origin.containsKey(name)) {
         val = origin.get(name);
      } else {
         boolean encoded = true;
         val = getRequest().getAttribute(mapper.encode(winId, name));
         if (val == null) {
            val = getRequest().getAttribute(name);
            encoded = false;
         }
         if (isTrace) {
            StringBuilder txt = new StringBuilder();
            txt.append("Getting: ");
            txt.append(name).append(", value: ").append((val == null) ? "null" : val.toString());
            txt.append(", encoded: ").append(encoded);
            LOG.debug(txt.toString());
         }
         return val;
      }
      
      // try to capture a log after the servlet container dispatcher init 
      // has been carried out
      if (name.equals(PortletInvokerService.PORTLET_CONFIG)) {
         logPathValues();
      }

      return val;
   }

   @Override
   public void setAttribute(String name, Object o) {
      if (isClosed) return;
      if (origin.containsKey(name)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Attempt to set protected attribute ").append(name);
         txt.append(" will be ignored.");
         LOG.warn(txt.toString());
      } else {
         
         // if attribute by encoded name exists, store with encoded name. otherwise
         // use unencoded name
         
         boolean encoded = false;
         Object val = getRequest().getAttribute(mapper.encode(winId, name));
         if (val != null) {
            getRequest().setAttribute(mapper.encode(winId, name), o);
            encoded = true;
         } else {
            getRequest().setAttribute(name, o);
         }

         if (isTrace) {
            StringBuilder txt = new StringBuilder();
            txt.append("Setting: ");
            txt.append(name).append(", value: ").append((o == null) ? "null" : o.toString());
            txt.append(", encoded: ").append(encoded);
            LOG.debug(txt.toString());
         }
      }
      handleServletPathInfo();
   }

   @Override
   public void removeAttribute(String name) {
      if (isClosed) return;
      handleServletPathInfo();
      if (origin.containsKey(name)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Attempt to remove protected attribute ").append(name);
         txt.append(" will be ignored.");
         LOG.warn(txt.toString());
      } else {
         
         // if attribute by encoded name exists, remove with encoded name.

         boolean encoded = false;
         Object val = getRequest().getAttribute(mapper.encode(winId, name));
         if (val != null) {
            getRequest().removeAttribute(mapper.encode(winId, name));
            encoded = true;
         } else {
            getRequest().removeAttribute(name);
         }

         if (isTrace) {
            StringBuilder txt = new StringBuilder();
            txt.append("Removing: ");
            txt.append(name);
            txt.append(", encoded: ").append(encoded);
            LOG.debug(txt.toString());
         }
      }
   }

   @Override
   public Enumeration<String> getAttributeNames() {
      if (isClosed) return Collections.emptyEnumeration();
      handleServletPathInfo();
      ArrayList<String> names = new ArrayList<String>();
      if (isAttrSpecialHandling) {
         for (String name : origin.keySet()) {
            if (origin.get(name) != null) {
               names.add(name);
            }
         }
      }

      Enumeration<String> rawnames = getRequest().getAttributeNames();
      for (String name : Collections.list(rawnames)) {
         String dn = mapper.decode(winId, name);
         if (dn != null) {
            names.add(dn);
         } else {
            names.add(name);
         }
      }
      return Collections.enumeration(names);
   }

   @Override
   public RequestDispatcher getRequestDispatcher(String path) {
      if (isClosed) return null;
      if (path != null) {
         RequestDispatcher dispatcher = super.getRequestDispatcher(path);
         if (dispatcher != null) {
            return new PortletRequestDispatcherImpl(dispatcher, path, false);
         }
      }
      return null;
   }

   @Override
   public long getDateHeader(String name) {
      if (isClosed) return -1L;
      String value = preq.getProperty(name);
      if (value == null) {
         return (-1L);
      }
      // Let the servlet request do the conversion
      return getHreq().getDateHeader(name);
   }

   @Override
   public String getAuthType() {
      if (isClosed) return null;
      return preq.getAuthType();
   }

   @Override
   public Cookie[] getCookies() {
      if (isClosed) return null;
      return preq.getCookies();
   }

   @Override
   public String getHeader(String name) {
      if (isClosed) return null;
      return preq.getProperty(name);
   }

   @Override
   public Enumeration<String> getHeaderNames() {
      if (isClosed) return Collections.emptyEnumeration();
      return preq.getPropertyNames();
   }

   @Override
   public Enumeration<String> getHeaders(String name) {
      if (isClosed) return Collections.emptyEnumeration();
      return preq.getProperties(name);
   }

   @Override
   public int getIntHeader(String name) {
      if (isClosed) return -1;
      String property = preq.getProperty(name);
      if (property == null) {
         return -1;
      }
      return Integer.parseInt(property);
   }

   @Override
   public String getMethod() {
      if (isClosed) return "GET";
      String meth;
      if ((preq instanceof HeaderRequest) || (preq instanceof RenderRequest)) {
         meth = "GET";
      } else {
         meth = getHreq().getMethod();
      }
      return meth;
   }

   @Override
   public HttpSession getSession() {
      if (isClosed) return null;
      return session != null ? session : super.getSession();
   }

   @Override
   public HttpSession getSession(boolean create) {
      if (isClosed) return null;
      return session != null ? session : super.getSession(create);
   }

   @Override
   public String getRemoteUser() {
      if (isClosed) return null;
      return preq.getRemoteUser();
   }

   @Override
   public String getRequestedSessionId() {
      if (isClosed) return null;
      return preq.getRequestedSessionId();
   }

   @Override
   public StringBuffer getRequestURL() {
      return null;
   }

   @Override
   public Principal getUserPrincipal() {
      if (isClosed) return null;
      return preq.getUserPrincipal();
   }

   @Override
   public boolean isRequestedSessionIdValid() {
      if (isClosed) return false;
      return preq.isRequestedSessionIdValid();
   }

   @Override
   public boolean isUserInRole(String role) {
      if (isClosed) return false;
      return preq.isUserInRole(role);
   }

   @Override
   public String getCharacterEncoding() {
      if (isClosed) return null;
      if (preq instanceof ClientDataRequest) {
         return ((ClientDataRequest) preq).getCharacterEncoding();
      }
      return null;
   }

   @Override
   public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
      if (isClosed) return;
      if (preq instanceof ClientDataRequest) {
         ((ClientDataRequest) preq).setCharacterEncoding(enc);
      }
   }

   @Override
   public int getContentLength() {
      if (isClosed) return 0;
      if (preq instanceof ClientDataRequest) {
         return ((ClientDataRequest) preq).getContentLength();
      }
      return 0;
   }

   @Override
   public long getContentLengthLong() {
      if (isClosed) return 0L;
      if (preq instanceof ClientDataRequest) {
         return ((ClientDataRequest) preq).getContentLengthLong();
      }
      return 0L;
   }

   @Override
   public String getContentType() {
      if (isClosed) return null;
      if (preq instanceof ClientDataRequest) {
         return ((ClientDataRequest) preq).getContentType();
      }
      return null;
   }

   @Override
   public ServletInputStream getInputStream() throws IOException {
      if (isClosed) return null;
      if (preq instanceof ClientDataRequest) {
         return (ServletInputStream) ((ClientDataRequest) preq).getPortletInputStream();
      }
      return null;
   }

   @Override
   public String getLocalAddr() {
      return null;
   }

   @Override
   public Locale getLocale() {
      if (isClosed) return null;
      return preq.getLocale();
   }

   @Override
   public Enumeration<Locale> getLocales() {
      if (isClosed) return null;
      return preq.getLocales();
   }

   @Override
   public String getLocalName() {
      return null;
   }

   @Override
   public int getLocalPort() {
      return 0;
   }

   @Override
   public String getProtocol() {
      return "HTTP/1.1";
   }

   @Override
   public BufferedReader getReader() throws IOException {
      if (preq instanceof ClientDataRequest) {
         return ((ClientDataRequest) preq).getReader();
      }
      return null;
   }

   @Override
   public String getRealPath(String path) {
      return null;
   }

   @Override
   public String getRemoteAddr() {
      return null;
   }

   @Override
   public String getRemoteHost() {
      return null;
   }

   @Override
   public int getRemotePort() {
      return 0;
   }

   @Override
   public String getScheme() {
      if (isClosed) return null;
      return preq.getScheme();
   }

   @Override
   public String getServerName() {
      if (isClosed) return null;
      return preq.getServerName();
   }

   @Override
   public int getServerPort() {
      if (isClosed) return 0;
      return preq.getServerPort();
   }

   @Override
   public boolean isSecure() {
      if (isClosed) return false;
      return preq.isSecure();
   }

   /**
    * The async methods can only be used if async proecssing has been started
    */
   
   @Override
   public AsyncContext startAsync() throws IllegalStateException {
      if (!dispatches.isEmpty() && dispatches.get(0).type == Type.ASYNC_PROCESSING) {
         return ((PortletResourceRequestContext) reqctx).startAsync();
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("The async context cannot be initialized after a ");
         txt.append("include or forward from a portlet resource request method. ");
         txt.append("The first async context initialization must be performed within the portlet resource method.");
         throw new IllegalStateException(txt.toString());
      }
   }

   @Override
   public AsyncContext startAsync(ServletRequest request, ServletResponse response) throws IllegalStateException {
      if (!dispatches.isEmpty() && dispatches.get(0).type == Type.ASYNC_PROCESSING) {
         return ((PortletResourceRequestContext) reqctx).startAsync(request, response);
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("The async context cannot be initialized after a ");
         txt.append("include or forward from a portlet resource request method. ");
         txt.append("The first async context initialization must be performed within the portlet resource method.");
         throw new IllegalStateException(txt.toString());
      }
   }

   @Override
   public boolean isAsyncStarted() {
      if (!dispatches.isEmpty() && dispatches.get(0).type == Type.ASYNC_PROCESSING) {
         return ((PortletResourceRequestContext) reqctx).isAsyncStarted();
      }
     return false;
   }

   @Override
   public boolean isAsyncSupported() {
      if (!dispatches.isEmpty() && dispatches.get(0).type == Type.ASYNC_PROCESSING) {
         return ((PortletResourceRequestContext) reqctx).isAsyncSupported();
      }
      return false;
   }
   
   @Override
   public AsyncContext getAsyncContext() {
      if (!dispatches.isEmpty() && dispatches.get(0).type == Type.ASYNC_PROCESSING) {
         return ((PortletResourceRequestContext) reqctx).getAsyncContext();
      }
      return null;
   }

   @Override
   public DispatcherType getDispatcherType() {
      return super.getDispatcherType();
   }
   
   @Override
   public String changeSessionId() {
      return null;
   }
   
   @Override
   public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
      return false;
   }
   
   @Override
   public void login(String username, String password) throws ServletException {
   }
   
   @Override
   public void logout() throws ServletException {
   }

   @Override
   public Part getPart(String name) throws IOException, ServletException {
      if (preq instanceof ClientDataRequest) {
         try {
            return ((ClientDataRequest) preq).getPart(name);
         } catch (PortletException e) {
            throw new ServletException(e.getCause());
         }
      }
      return null;
   }
   
   @Override
   public Collection<Part> getParts() throws IOException, ServletException {
      if (preq instanceof ClientDataRequest) {
         try {
            return ((ClientDataRequest) preq).getParts();
         } catch (PortletException e) {
            throw new ServletException(e.getCause());
         }
      }
      return null;
   }
   
   @Override
   public <T extends HttpUpgradeHandler> T upgrade(Class<T> httpUpgradeHandlerClass) throws IOException,
         ServletException {
      throw new ServletException("Not Supported");
   }
}
