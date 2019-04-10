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
package org.apache.pluto.driver;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.HeaderData;
import org.apache.pluto.container.PageResourceId;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Dependency;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PageResources;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURL.URLType;
import org.apache.pluto.driver.util.PageState;
import org.apache.pluto.driver.util.RenderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The controller servlet used to drive the Portal Driver. All requests mapped to this servlet will be processed as
 * Portal Requests.
 * 
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalDriverServlet extends HttpServlet {

   private static final long   serialVersionUID = 1L;

   /** Internal Logger. */
   private static final Logger LOG              = LoggerFactory.getLogger(PortalDriverServlet.class);

   /** The Portal Driver sServlet Context */
   private ServletContext      servletContext   = null;

   public static final String  DEFAULT_PAGE_URI = "/WEB-INF/themes/pluto-default-theme.jsp";

   /** The portlet container to which we will forward all portlet requests. */
   protected PortletContainer  container        = null;

   /** Character encoding and content type of the response */
   private String              contentType      = "";

   // HttpServlet Impl --------------------------------------------------------

   public String getServletInfo() {
      return "Pluto Portal Driver Servlet";
   }

   /**
    * Initialize the Portal Driver. This method retrieves the portlet container instance from the servlet context scope.
    * 
    * @see PortletContainer
    */
   public void init() {
      servletContext = getServletContext();
      container = (PortletContainer) servletContext.getAttribute(AttributeKeys.PORTLET_CONTAINER);
      String charset = getServletConfig().getInitParameter("charset");
      if (charset != null && charset.length() > 0) {
         contentType = "text/html; charset=" + charset;
      }

   }

   /**
    * Handle all requests. All POST requests are passed to this method.
    * 
    * @param request
    *           the incoming HttpServletRequest.
    * @param response
    *           the incoming HttpServletResponse.
    * @throws ServletException
    *            if an internal error occurs.
    * @throws IOException
    *            if an error occurs writing to the response.
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (LOG.isDebugEnabled()) {
         LOG.debug("Start of PortalDriverServlet.doGet() to process portlet request . . .");
      }

      if (contentType != "") {
         response.setContentType(contentType);
      }

      PortalRequestContext portalRequestContext = new PortalRequestContext(getServletContext(), request, response);

      PortalURL portalURL = null;

      try {
         portalURL = portalRequestContext.getRequestedPortalURL();
      } catch (Exception ex) {
         String msg = "Cannot handle request for portal URL. Problem: " + ex.getMessage();
         LOG.error(msg, ex);
         throw new ServletException(msg, ex);
      }

      String targetWindow = portalURL.getTargetWindow();

      // Handle Action, Ajax Action, Partial Action, & Resource requests.
      // Render requests handled subsequently.

      if (targetWindow != null && portalURL.getType() != URLType.Render && portalURL.getType() != URLType.Portal) {

         String reqType = portalURL.getType().toString();
         PortletWindowConfig windowConfig = PortletWindowConfig.fromId(targetWindow);
         PortletWindowImpl portletWindow = new PortletWindowImpl(container, windowConfig, portalURL);

         if (LOG.isDebugEnabled()) {
            LOG.debug("Processing " + reqType + " request for window: " + portletWindow.getId().getStringId());
         }

         try {
            PageState ps;
            String jsondata;
            switch (portalURL.getType()) {
            case Action:
               container.doAction(portletWindow, request, response, true);
               break;
            case AjaxAction:
               container.doAction(portletWindow, request, response, false);
               response.setContentType("application/json");
               ps = new PageState(request);
               Writer writer = response.getWriter();
               jsondata = ps.toJSONString();
               LOG.debug("Ajax Action: returning new page state to client: " + jsondata);
               writer.write(jsondata);
               break;
            case PartialAction:
               container.doAction(portletWindow, request, response, false);
               Map<String, RenderData> renderDataMap = new HashMap<String, RenderData>();
               PartialActionResponse partialActionResponse = new PartialActionResponse(response);
               container.doServeResource(portletWindow, request, partialActionResponse);
               String pid = portletWindow.getId().getStringId();
               renderDataMap.put(pid, partialActionResponse.getRenderData());
               ps = new PageState(request, renderDataMap);
               jsondata = ps.toJSONString();
               LOG.debug("Ajax Action: returning new page state to client: " + jsondata);
               response.setContentType("application/json");
               Writer responseWriter = response.getWriter();
               responseWriter.write(jsondata);

               break;
            case Resource:
               container.doServeResource(portletWindow, request, response);
               break;
            default:
               LOG.warn("Unknown request: " + reqType);
            }
         } catch (PortletContainerException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new ServletException(ex);
         } catch (PortletException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new ServletException(ex);
         }
         if (LOG.isDebugEnabled()) {
            LOG.debug(reqType + " request processed.\n");
         }

      }

      // Otherwise, handle the render request.
      else {
         if (LOG.isDebugEnabled()) {
            LOG.debug("Processing render request.");
         }

         PageConfig pageConfig = portalURL.getPageConfig(servletContext);

         if (pageConfig == null) {
            String renderPath = (portalURL == null ? "" : portalURL.getRenderPath());
            String msg = "PageConfig for render path [" + renderPath + "] could not be found.";
            LOG.error(msg);
            throw new ServletException(msg);
         }

         request.setAttribute(AttributeKeys.CURRENT_PAGE, pageConfig);
         String uri = (pageConfig.getUri() != null) ? pageConfig.getUri() : DEFAULT_PAGE_URI;

         // Execute header request for each portlet on the page

         if (LOG.isDebugEnabled()) {
            LOG.debug("Executing header requests for target portlets.");
         }

         response.setContentType("text/html;charset=UTF-8");
         doHeaders(request, response, portalURL);

         if (LOG.isDebugEnabled()) {
            LOG.debug("Dispatching to: " + uri);
         }

         // Dispatch to the JSP that aggregates the page.
         RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
         dispatcher.forward(request, response);

         if (LOG.isDebugEnabled()) {
            LOG.debug("Render request processed.\n");
         }
      }
   }

   /**
    * Pass all POST requests to {@link #doGet(HttpServletRequest, HttpServletResponse)}.
    * 
    * @param request
    *           the incoming servlet request.
    * @param response
    *           the incoming servlet response.
    * @throws ServletException
    *            if an exception occurs.
    * @throws IOException
    *            if an exception occurs writing to the response.
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

   private void doHeaders(HttpServletRequest req, HttpServletResponse resp, PortalURL purl) throws ServletException,
         IOException {

      ServletContext sc = req.getServletContext();
      DriverConfiguration dc = (DriverConfiguration) sc.getAttribute(AttributeKeys.DRIVER_CONFIG);
      StringBuilder markup = new StringBuilder(128);
      List<PageResourceId> portletdeps = new ArrayList<PageResourceId>();
      List<PageResourceId> dynamicdeps = new ArrayList<PageResourceId>();
      Map<PageResourceId, String> dynamicResources = new HashMap<PageResourceId, String>();

      for (String pid : purl.getPortletIds()) {

         HeaderData hd = null;
         PortletWindowConfig wcfg = null;
         PortletWindowImpl pwin = null;
         try {
            wcfg = PortletWindowConfig.fromId(pid);
            pwin = new PortletWindowImpl(container, wcfg, purl);
         } catch (Throwable e) {
            LOG.warn("Could not retrieve configuration for portlet ID: " + pid);
            continue;
         }
         

         try {

            String appName = wcfg.getContextPath();
            String portletName = PortletWindowConfig.parsePortletName(pid);
            PortletDefinition pd = dc.getPortletRegistryService().getPortletApplication(appName)
                  .getPortlet(portletName);

            if (purl.isVersion3(pid)) {
               hd = container.doHeader(pwin, req, resp);

               // collect the page dependencies
               for (Dependency dep : pd.getDependencies()) {
                  portletdeps.add(new PageResourceId(dep.getName(), dep.getScope(), dep.getVersion()));
               }

               // Process any dependencies that were dynamically added during the header request
               Map<PageResourceId, String> resources = hd.getDynamicResources();
               for (PageResourceId id : resources.keySet()) {
                  dynamicdeps.add(id);
                  if (resources.get(id) != null) {
                     dynamicResources.put(id, resources.get(id));
                  }
               }

            } else if (purl.getVersion(pid).equalsIgnoreCase("2.0")) {
               ContainerRuntimeOption crt = pd.getContainerRuntimeOption("javax.portlet.renderHeaders");
               if (crt != null) {
                  List<String> headers = crt.getValues();
                  if (headers.size() == 1 && headers.get(0).equalsIgnoreCase("true")) {
                     hd = container.doRender(pwin, req, resp, PortletRequest.RENDER_HEADERS);
                  }
               }
            }

            if (hd != null) {

               // handle markup for document head section
               markup.append(hd.getHeadSectionMarkup()).append("\n");

               // add the cookies & http headers to the response
               
               List<Cookie> cookies = hd.getCookies();
               for (Cookie c : cookies) {
                  resp.addCookie(c);
               }

               // Add the HTTP headers to the response
               Map<String, List<String>> headers = hd.getHttpHeaders();
               for (String name : headers.keySet()) {
                  for (String val : headers.get(name)) {
                     resp.addHeader(name, val);
                  }
               }
            }

         } catch (PortletContainerException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new ServletException(ex);
         } catch (PortletException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new ServletException(ex);
         }
      }

      // Set the header section markup provided by the portlets as an attribute
      // The main rendering JSP uses this when rendering the head section.
      req.setAttribute(AttributeKeys.HEAD_SECTION_MARKUP, markup.toString());

      // Now generate the markup for the configured page resources
      markup.setLength(0);
      PageResources pageres = dc.getRenderConfigService().getPageResources();
      if (!dynamicResources.isEmpty()) {

         // the dynamically added resources are only valid for this rendering, so
         // avoid modifying the original configured resources.

         pageres = new PageResources(pageres);
         for (PageResourceId id : dynamicResources.keySet()) {
            pageres.addResource(id, PageResources.Type.MARKUP, dynamicResources.get(id));
         }
      }

      // start with the default page resources
      List<PageResourceId> deps = new ArrayList<PageResourceId>(dc.getRenderConfigService()
            .getDefaultPageDependencies());
      int defDespSize = deps.size();

      // add in the page-specific resources
      List<PageResourceId> pagedeps = purl.getPageConfig(req.getServletContext()).getPageResources();
      deps.addAll(pagedeps);

      // and the portlet dependencies
      deps.addAll(portletdeps);

      // and finally the dynamic portlet dependencies
      deps.addAll(dynamicdeps);

      if (LOG.isDebugEnabled()) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Page dependency list.");
         txt.append(" total deps: ").append(deps.size());
         txt.append(", default deps: ").append(defDespSize);
         txt.append(", page deps: ").append(pagedeps.size());
         txt.append(", portlet deps: ").append(portletdeps.size());
         txt.append(", dynamic deps: ").append(dynamicdeps.size());
         for (PageResourceId id : deps) {
            txt.append("\n   ").append(id.toString());
         }
         LOG.debug(txt.toString());
      }

      // Set the markup resulting from the specified page resources as an attribute
      // The main rendering JSP uses this when rendering the head section.
      markup.append(pageres.getMarkup(deps, req.getContextPath()));
      req.setAttribute(AttributeKeys.DYNAMIC_PAGE_RESOURCES, markup.toString());

      return;
   }
}
