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

import static org.apache.portals.pluto.demo.v3.Constants.PARAM_STATUSCODE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.inject.Inject;
import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


/**
 * A portlet that causes the resource request status code to be set.
 * 
 * @author Scott Nicklous
 */
public class AuthSCPortlet extends GenericPortlet {

   // Set up logging
   private static final Logger logger = LoggerFactory.getLogger(AuthSCPortlet.class);
   private static final boolean isDebug = logger.isDebugEnabled();

   @Override
   public void init() throws PortletException {
      super.init();
   }

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      resp.setContentType("text/html");

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-ascp.jsp");
      rd.include(req, resp);

   }
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {

      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      StringBuilder txt = new StringBuilder();
      
      String scText = req.getRenderParameters().getValue(PARAM_STATUSCODE);
      if (scText != null && scText.matches("\\d+")) {
         int sc = Integer.parseInt(scText);
         if (isDebug) {
            logger.debug("Setting HTTP status code to: " + sc);
         }
         resp.setStatus(sc);
      }
      
      txt.append("<p>serveResource</p>");
      txt.append("<p>Status code: ").append(scText);
      txt.append("<br>Status code from getStatus(): ").append(resp.getStatus());
      txt.append("<br>Content length: ");
      int len = txt.length() + "</p>".length() + 3;
      txt.append(String.format("%3d", len));
      txt.append("</p>");
      
      resp.setContentLengthLong(txt.length());
      writer.write(txt.toString());
   }

   @Inject private ActionParameters ap;
   @Inject private MutableRenderParameters mrp;

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      
      mrp.set(ap);

      if (isDebug) {
         StringBuffer sb = new StringBuffer();
         sb.append("Long portlet action parameters:");
         for (String k : ap.getNames()) {
            sb.append("\nName: ").append(k);
            sb.append(", Values: ").append(Arrays.toString(ap.getValues(k)));
         }
         logger.debug(sb.toString());
      }

   }

}
