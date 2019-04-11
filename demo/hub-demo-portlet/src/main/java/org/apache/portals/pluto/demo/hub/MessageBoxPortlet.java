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

import static org.apache.portals.pluto.demo.hub.Constants.ATTRIB_MSGS;
import static org.apache.portals.pluto.demo.hub.Constants.DELIM;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_COLOR;
import static org.apache.portals.pluto.demo.hub.Constants.PARAM_NUM_MSGS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;

/**
 * A demo portlet that displays messages sent via event
 */
@PortletConfiguration(portletName = "MessageBoxPortlet", publicParams = "color", 
                      title = @LocaleString("PH Message Box Portlet"),
                      dependencies = @Dependency(name="PortletHub", scope="javax.portlet", version="3.0.0"))
public class MessageBoxPortlet extends GenericPortlet {

   // Set up logging
   private final Logger logger = LoggerFactory.getLogger(MessageBoxPortlet.class);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isDebugEnabled()) {
         logger.debug(this.getClass().getName(), "doView", "Entry");
      }
      
      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-mbp.jsp");
      rd.include(req, resp);

   }

   @Override
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {

      // the only action for this portlet is to reset the stored messages
      
      String actionName = req.getActionParameters().getValue(ActionRequest.ACTION_NAME);
      logger.debug("MBP: Resetting messages. numMsgs = 0,  actionName = " + actionName);

      ArrayList<String> msgs = new ArrayList<String>();
      StringBuffer sb = new StringBuffer();
      sb.append("<p style='margin:2px 5px 2px 5px; color:#00D;"
            + " background-color:#AAF;'>");
      sb.append("Reset - No messages.");
      sb.append("</p>");
      msgs.add(sb.toString());

      resp.getRenderParameters().setValue(PARAM_NUM_MSGS, "0");
      req.getPortletSession().setAttribute(ATTRIB_MSGS, msgs);
   }
   
   @EventMethod(portletName="MessageBoxPortlet", processingEvents= {
         @PortletQName(namespaceURI="http://www.apache.org/portals/pluto/ResourcePortlet", localPart="Message")
   })
   @Override
   public void processEvent(EventRequest req, EventResponse resp) 
         throws PortletException ,IOException {
      
      @SuppressWarnings("unchecked")
      ArrayList<String> msgs = (ArrayList<String>) req.getPortletSession().getAttribute(ATTRIB_MSGS);
      if (msgs == null) {
         msgs = new ArrayList<String>();
      }
      
      String[] msg;
      int numMsgs = 0;
      try {
         numMsgs = Integer.parseInt(req.getRenderParameters().getValue(PARAM_NUM_MSGS));
      } catch (Exception e) {}
      
      if (numMsgs == 0) {
         msgs.clear();
      }
      
      logger.debug("Processing message event. Current # messages = " + msgs.size());

      try {
         // Both pieces of info are transported in a delimted string rather than 
         // an array since the Pluto impl doesn't seem to get along with array types as 
         // event payload types.
         String val = (String) req.getEvent().getValue();
         msg = val.split(DELIM);
      } catch (Exception e) {
         msg = new String[2];
         msg[0] = "error getting message from event.";
         msg[1] = "#D00";
      }
      
      String clr = req.getRenderParameters().getValue(PARAM_COLOR);
      clr = (clr == null) ? "#FFFFFF" : clr;
      
      StringBuffer sb = new StringBuffer();
      sb.append("<p style='margin:2px 5px 2px 5px; color:" + msg[1] 
            + "; background-color:" + clr + ";'>");
      sb.append("" + (msgs.size() + 1) + ": " + msg[0]);
      sb.append("</p>");
      
      msgs.add(sb.toString());
      
      logger.debug("Adding message: " + sb.toString());

      resp.getRenderParameters().setValue(PARAM_NUM_MSGS, Integer.toString(msgs.size()));
      req.getPortletSession().setAttribute(ATTRIB_MSGS, msgs);
   };
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @SuppressWarnings("unchecked")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      ArrayList<String> msgs = (ArrayList<String>) req.getPortletSession().getAttribute(ATTRIB_MSGS);
      if (msgs == null) {
         msgs = new ArrayList<String>();
         
         StringBuffer sb = new StringBuffer();
         sb.append("<p style='margin:0px 5px 0px 5px; color:#00D;"
               + " background-color:#FFA;'>");
         sb.append("No messages.");
         sb.append("</p>");
         msgs.add(sb.toString());
      }

      for (String msg : msgs) {
         writer.write(msg);
      }

      int n = msgs.size();
      logger.debug("Served messages. latest message: " + (n > 0 ? msgs.get(n-1) : "null"));
   }

}
