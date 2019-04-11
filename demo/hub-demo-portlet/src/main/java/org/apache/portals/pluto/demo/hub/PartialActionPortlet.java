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

package org.apache.portals.pluto.demo.hub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.portals.pluto.demo.hub.Constants.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;

import javax.portlet.ResourceResponse;
import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;

/**
 * A demo portlet exercising the partial action processing sequence
 */
@PortletConfiguration(portletName = "PartialActionPortlet", publicParams = "color",
                        title = @LocaleString("PH Partial Action Portlet"),
                        dependencies = @Dependency(name="PortletHub", scope="javax.portlet", version="3.0.0"))
public class PartialActionPortlet extends GenericPortlet {

   // Set up logging
   private final Logger logger = LoggerFactory.getLogger(PartialActionPortlet.class);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isDebugEnabled()) {
         logger.debug(this.getClass().getName(), "doView", "Entry");
      }
      
      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-pap.jsp");
      rd.include(req, resp);

   }

   @SuppressWarnings("deprecation")
   @Override
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {

      // the only action for this portlet is to increment the execition counter

      String val = req.getParameter(PARAM_NUM_ACTIONS);
      int na = 1;
      if (val != null) {
         try {
            na = Integer.parseInt(val) + 1;
         } catch (Exception e) {}
      }
      
      String actionName = req.getParameter("action");
      logger.debug("PAP: executing partial action. action number = " + na + ", name =  " + actionName);

      resp.setRenderParameter(PARAM_NUM_ACTIONS, Integer.toString(na));
   }
   
   @Override
   public void processEvent(EventRequest req, EventResponse resp) 
         throws PortletException ,IOException {
   };
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @SuppressWarnings("deprecation")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      String num = req.getParameter(PARAM_NUM_ACTIONS);
      num = (num == null) ? "error" : num;
      
      writer.write("<p>Partial Action has been executed " + num + " times.</p>\n");
   }

}
