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

package org.apache.portals.pluto.demo.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.portals.pluto.demo.v3.Constants.ATTRIB_PMS;
import static org.apache.portals.pluto.demo.v3.Constants.ATTRIB_PRPS;
import static org.apache.portals.pluto.demo.v3.Constants.ATTRIB_WS;
import static org.apache.portals.pluto.demo.v3.Constants.ATTRIB_CTX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.xml.namespace.QName;

/**
 * A portlet for displaying config data
 */
public class PortletConfigPortlet extends GenericPortlet {

   // Set up logging
   private final Logger logger = LoggerFactory.getLogger(PortletConfigPortlet.class);
   
   @Override
   protected void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      doView(request, response);
   }
   
   @Override
   protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      doView(request, response);
   }
   
   @RenderMode(name="MyMode_nonPortalManaged_1")
   public void doMyMode_nonPortalManaged_1(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      doView(request, response);
   }
   
   @RenderMode(name="MyMode_nonPortalManaged_2")
   public void doMyMode_nonPortalManaged_2(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      doView(request, response);
   }

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isDebugEnabled()) {
         logger.debug(this.getClass().getName(), "doView", "Entry");
      }
      
      resp.setContentType("text/html");
      
      // Get the information from the new V3.0 PortletConfig APIs through
      // the GenericPortlet class in order to test the adapted GenericPortlet
      // interfaces as well. Store resulting strings in request attributes
      // for display through the JSP.
      
      ArrayList<String> prps = new ArrayList<String>();
      ArrayList<String> wss = new ArrayList<String>();
      ArrayList<String> pms = new ArrayList<String>();
      
      Map<String, QName> prpmap = getPublicRenderParameterDefinitions();
      for (String prp : prpmap.keySet()) {
         StringBuilder sb = new StringBuilder();
         sb.append("Name: ").append(prp);
         sb.append(", QName: ").append(prpmap.get(prp).toString());
         prps.add(sb.toString());
      }
      req.setAttribute(ATTRIB_PRPS, prps);
      
      String mimetype = "text/html";
      for (WindowState ws : Collections.list(getWindowStates(mimetype))) {
         StringBuilder sb = new StringBuilder();
         sb.append("MIME type: ").append(mimetype);
         sb.append(", WindowState: ").append(ws.toString());
         sb.append(", Allowed: ").append(req.isWindowStateAllowed(ws));
         wss.add(sb.toString());
      }
      for (PortletMode pm : Collections.list(getPortletModes(mimetype))) {
         StringBuilder sb = new StringBuilder();
         sb.append("MIME type: ").append(mimetype);
         sb.append(", PortletMode: ").append(pm.toString());
         sb.append(", Allowed: ").append(req.isPortletModeAllowed(pm));
         pms.add(sb.toString());
      }

      mimetype = "text/vnd.wap.wml";
      for (WindowState ws : Collections.list(getWindowStates(mimetype))) {
         StringBuilder sb = new StringBuilder();
         sb.append("MIME type: ").append(mimetype);
         sb.append(", WindowState: ").append(ws.toString());
         wss.add(sb.toString());
      }
      for (PortletMode pm : Collections.list(getPortletModes(mimetype))) {
         StringBuilder sb = new StringBuilder();
         sb.append("MIME type: ").append(mimetype);
         sb.append(", PortletMode: ").append(pm.toString());
         pms.add(sb.toString());
      }

      req.setAttribute(ATTRIB_WS, wss);
      req.setAttribute(ATTRIB_PMS, pms);
      
      // get the info from the new PortletContext APIs
      
      PortletContext ctx = getPortletContext();
      List<String> ctxinfo = new ArrayList<String>();
      String vers = "" + ctx.getEffectiveMajorVersion() + "." + ctx.getEffectiveMinorVersion();
      ctxinfo.add("Portlet application version: " + vers);
      ClassLoader cl = ctx.getClassLoader();
      String cltxt = null;
      if (cl != null) {
         cltxt = cl.toString().replaceAll("(\\n|\\r|\\t)", " ");
      }
      ctxinfo.add("ClassLoader: " + cltxt);
      ctxinfo.add("Portlet context path: " + ctx.getContextPath());
      
      req.setAttribute(ATTRIB_CTX, ctxinfo);

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-pcp.jsp");
      rd.include(req, resp);

   }

   @Override
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
   }
   
   @Override
   public void processEvent(EventRequest req, EventResponse resp) 
         throws PortletException ,IOException {
   };
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
   }

}
