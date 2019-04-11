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

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;

/**
 * Portlet to test the portlet tag library URL tags.
 * 
 * @author Scott Nicklous
 *
 */
public class TagLibTagsPortlet {
   
   private static final String JSPURLS     = "/WEB-INF/jsp/tagLibTags.jsp";
   private static final String JSPRES      = "/WEB-INF/jsp/tagLibTagsResource.jsp";

   @RenderMethod(portletNames="TagLibTagsPortlet", include=JSPURLS)
   public void render() {
   }

   @ServeResourceMethod(portletNames="TagLibTagsPortlet", include=JSPRES)
   public void resource() {
   }
   
   @ActionMethod(portletName="TagLibTagsPortlet")
   public void action(ActionRequest req, ActionResponse resp) {
      ActionParameters ap = req.getActionParameters();
      req.getPortletSession().setAttribute("actparms", ap.clone());
   }

}
