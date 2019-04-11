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

import static org.apache.portals.pluto.demo.hub.Constants.DELIM;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_FG_BLUE;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_FG_COLOR;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_FG_GREEN;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_FG_RED;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_MSG_INPUT;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_SUBTYPE;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletParameters;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.xml.namespace.QName;


/**
 * An example color selection portlet that uses the portlet hub.
 */
@PortletConfiguration(portletName = "PH-ColorSelPortlet", publicParams = "color", 
                      title = @LocaleString("PH Color Selection Portlet"),
                      dependencies = @Dependency(name="PortletHub", scope="javax.portlet", version="3.0.0"))
public class ColorSelPortlet extends GenericPortlet {

   // Set up logging
   private final Logger logger = LoggerFactory.getLogger(ColorSelPortlet.class);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      logger.debug("Doing view.");
      
      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-csp.jsp");
         rd.include(req, resp);
      
}
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
   }

   @ActionMethod(portletName="PH-ColorSelPortlet", publishingEvents= {
         @PortletQName(namespaceURI="http://www.apache.org/portals/pluto/ResourcePortlet", localPart="Message")
   })
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
            
      dumpParameters("Action", req.getActionParameters());
      dumpParameters("Render", req.getRenderParameters());
      
      String[] vals = req.getActionParameters().getValues(PARAM_FG_COLOR);
      String r = "0";
      String g = "0";
      String b = "0";
      if (vals != null) {
         for (String v : vals) {
            if (v.equals(PARAM_FG_RED)) r = "F";
            if (v.equals(PARAM_FG_GREEN)) g = "F";
            if (v.equals(PARAM_FG_BLUE)) b = "F";
         }
      }
      String clr = "#" + r + g + b;
      
      // make sure the private parameter are all on the URL for 
      // potential back button support
      if (vals != null) {
         resp.getRenderParameters().setValues(PARAM_FG_COLOR, vals);
      }
      
      String subType = req.getActionParameters().getValue(PARAM_SUBTYPE);
      if (subType != null) {
         resp.getRenderParameters().setValue(PARAM_SUBTYPE, subType);
      }
      
      String text = req.getActionParameters().getValue(PARAM_MSG_INPUT);
      if (text != null) {
         resp.getRenderParameters().setValue(PARAM_MSG_INPUT, text);
      }
      
      String msg = text + DELIM + clr;

      // there should only be one publishing event, so take the first QName
      Enumeration<QName> eqn = getPublishingEventQNames();
      if (eqn.hasMoreElements()) {
         QName qn = eqn.nextElement(); 
         resp.setEvent(qn, msg);
         logger.debug("Firing event with QName: " + qn.toString());
      } else {
         logger.warn("No publishing event QName available. Check portlet configuration.");
      }
      
      StringBuilder sb = new StringBuilder("Color: ").append(Arrays.toString(vals));
      sb.append(", Submission type: ").append(subType);
      sb.append(", Text: ").append(text);
      logger.debug(sb.toString());
   }
   
   private void dumpParameters(String type, PortletParameters parms) {
      if (logger.isDebugEnabled()) {
         StringBuilder sb = new StringBuilder();
         sb.append("Portlet ").append(type).append(" parameters:");
         for (String name : parms.getNames()) {
            sb.append("\nName: ").append(name);
            sb.append(", Values: ").append(Arrays.toString(parms.getValues(name)));
         }
         logger.debug(sb.toString());
      }
   }

}
