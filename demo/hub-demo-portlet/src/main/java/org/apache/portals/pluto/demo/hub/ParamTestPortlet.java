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

import static org.apache.portals.pluto.demo.hub.Constants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
 * A purtlet hub portlet that allows parameter names & values to be entered and set.
 * 
 * @author Scott Nicklous
 */
@PortletConfiguration(portletName = "ParamTestPortlet", publicParams = {"color", "imgName"},
                        title = @LocaleString("PH Parameter Test Portlet"),
                        dependencies = @Dependency(name="PortletHub", scope="javax.portlet", version="3.0.0"))
public class ParamTestPortlet extends GenericPortlet {

   private final HashSet<String> prpNames = new HashSet<String>();
   
   @Override
   public void init() throws PortletException {
      super.init();
      Enumeration<String> names = getPublicRenderParameterNames();
      for (String name : Collections.list(names)) {
         prpNames.add(name);
      }
   }

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      
      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-ptp.jsp");
      rd.include(req, resp);

   }
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @SuppressWarnings("deprecation")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      
      StringBuilder txt = new StringBuilder();
      String style = "style='min-width: 100px;'";
      List<String> pnList = Collections.list(req.getParameterNames());
      
      // don't display the control  params
      pnList.remove(PARAM_SETTYPE);
      pnList.remove(PARAM_REMTYPE);
      
      for (String pn : pnList) {
         // try to test all parameter apis
         String val = req.getParameter(pn);
         String[] vals = req.getParameterValues(pn);
         txt.append("      <tr><td " + style + ">Name: ")
            .append(pn)
            .append("</td><td " + style + ">Val: ")
            .append(val)
            .append("</td><td " + style + ">Len: ")
            .append(vals.length)
            .append("</td><td " + style + ">Values: ")
            .append(Arrays.toString(vals))
            .append("</td></tr>\n");
      }
      
      writer.write("<h3>Currently set render parameters:</h3>\n");
      writer.write("<p>\n");
      writer.write("   <table>");
      writer.write(txt.toString());
      writer.write("   </table>");
      writer.write("</p>\n");

      writer.write("<p><hr/></p>\n");
      
   }

   // nothing to do in processAction
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
   }

}
