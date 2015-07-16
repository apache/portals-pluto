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

package basic.portlet;

import static basic.portlet.Constants.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.namespace.QName;


/**
 * A management portlet that displays the current deep link configuration
 */
public class ColorSelPortlet extends GenericPortlet {

   // Set up logging
   private static final String LOG_CLASS = ColorSelPortlet.class.getName();
   private final Logger logger = Logger.getLogger(LOG_CLASS);

   // private static final String LOG_CLASS = ColorSelPortlet.class.getName();
   // private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      logger.fine("Doing view.");
      
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

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
            
      dumpParameters(req);
      
      String[] vals = req.getParameterValues(PARAM_FG_COLOR);
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
         resp.setRenderParameter(PARAM_FG_COLOR, vals);
      }
      
      String subType = req.getParameter(PARAM_SUBTYPE);
      if (subType != null) {
         resp.setRenderParameter(PARAM_SUBTYPE, subType);
      }
      
      String text = req.getParameter(PARAM_MSG_INPUT);
      if (text != null) {
         resp.setRenderParameter(PARAM_MSG_INPUT, text);
      }
      
      String msg = text + DELIM + clr;

      // there should only be one publishing event, so take the first QName
      Enumeration<QName> eqn = getPublishingEventQNames();
      if (eqn.hasMoreElements()) {
         QName qn = eqn.nextElement(); 
         resp.setEvent(qn, msg);
         logger.fine("Firing event with QName: " + qn.toString());
      } else {
         logger.warning("No publishing event QName available. Check portlet deployment descriptor.");
      }
      
      StringBuilder sb = new StringBuilder("Color: ").append(Arrays.toString(vals));
      sb.append(", Submission type: ").append(subType);
      sb.append(", Text: ").append(text);
      logger.fine(sb.toString());
   }
   
   private void dumpParameters(PortletRequest req) {
      if (logger.isLoggable(Level.FINEST)) {
         StringBuilder sb = new StringBuilder();
         sb.append("Portlet request parameters:");
         Map<String, String[]> parms = req.getParameterMap();
         for (String name : parms.keySet()) {
            sb.append("\nName: ").append(name);
            sb.append(", Values: ").append(Arrays.toString(parms.get(name)));
         }
         logger.finest(sb.toString());
      }
   }

}
