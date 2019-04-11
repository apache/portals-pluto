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

import java.io.IOException;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;

import static javax.portlet.MimeResponse.Copy.*;
import static org.apache.portals.pluto.demo.v3.Constants.*;

/**
 * Portlet for testing the redirect funtionality, including the new getRedirectURL API.
 */
@PortletConfiguration(portletName="V3RedirectPortlet", title = @LocaleString(value = "Redirect Test Portlet"))
public class RedirectPortlet extends GenericPortlet {

   private static final Logger logger  = LoggerFactory.getLogger(RedirectPortlet.class);
   private static final boolean isDebug = logger.isDebugEnabled();

   protected void doView(RenderRequest req, RenderResponse resp) throws PortletException, IOException {

      resp.setContentType("text/html");
      
      // provide an action URL to the JSP as a workaround, since the tag library is still JSR 286
      ActionURL aurl = resp.createActionURL(ALL);
      req.setAttribute(ATTRIB_ACTURL, aurl.toString());

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher("/WEB-INF/jsp/view-rdp.jsp");
      rd.include(req, resp);

   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {
   }

   public void processAction(ActionRequest req, ActionResponse resp) throws PortletException, IOException {

      ActionParameters ap = req.getActionParameters();
      RenderParameters rp = req.getRenderParameters();

      StringBuilder txt = new StringBuilder(128);
      if (isDebug) {
         txt.append("Action parms: ").append(ap.getNames());
         txt.append(", Render parms: ").append(rp.getNames());
         txt.append(", Color: ").append(rp.getValue(PARAM_COLOR));
      }

      String color = ap.getValue(PARAM_COLOR);
      if (color != null && color.length() > 0) {
         if (!color.matches("^#(?:[A-Fa-f0-9]{3}){1,2}$")) {
            color = "FDD";
         }
      }
      
      String url = ap.getValue(PARAM_URL_INPUT);
      if (url == null || url.length() <= 0) {
         RenderURL rurl = resp.createRedirectURL(ALL);
         rurl.getRenderParameters().setValue(PARAM_COLOR, color);
         url = rurl.toString();
         if (isDebug) {
            txt.append(", redirecting to redirect URL with new color=").append(color);
         }
      }
      resp.sendRedirect(url);
      
      if (isDebug) {
         logger.debug(txt.toString());
      }

   }

}
