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
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.namespace.QName;


/**
 * A management portlet that displays the current deep link configuraion
 */
public class ColorSelPortlet extends GenericPortlet {

   // Set up logging
   // private static final String LOG_CLASS = ColorSelPortlet.class.getName();
   // private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      
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
      
      // pass the action params from the form submission as render parameters
      resp.setRenderParameter(PARAM_ERRMSG, " "); // hack as Pluto does not support deleting parameters
      String val = req.getParameter(PARAM_COLOR);
      if (val != null) {
         if (val.matches("^#(?:[A-Fa-f0-9]{3}){1,2}$")) {
            resp.setRenderParameter(PARAM_COLOR, val);
         } else {
            resp.setRenderParameter(PARAM_ERRMSG, "bad color. try again.");
         }
      } else {
         resp.setRenderParameter(PARAM_ERRMSG, "enter color #xxxxxx or #xxx.");
      }
      
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
      
      if (vals != null) {
         resp.setRenderParameter(PARAM_FG_COLOR, vals);
      }
      
      String clr = "#" + r + g + b;
      val = req.getParameter(PARAM_MSG_INPUT);
      
      String msg = val + DELIM + clr;
      QName qn = new QName(EVENT_NAMESPACE, EVENT_NAME);
      resp.setEvent(qn, msg);
      
   }

}
