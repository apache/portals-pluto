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


package org.apache.pluto.tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ClientDataRequest;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderParameters;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.VariableInfo;


/**
 * A tag handler for the <CODE>defineObjects</CODE> tag as defined in the JSR 362.
 * Uses the superclass to set the JSR 286 stuff, so this class just sets the delta
 * between v2 & v3.
 *  
 * @author Scott Nicklous
 *
 * @version 3.0
 */
public class DefineObjectsTag362 extends DefineObjectsTag286 {
   private static final long serialVersionUID = -6107224582740650955L;
   
   public static class TEI extends DefineObjectsTag286.TEI {

      protected static List<VariableInfo> info362 = 
            new ArrayList<VariableInfo>(Arrays.asList(info286));
      
      static {
         info362.add(new VariableInfo("headerRequest",
               HeaderRequest.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("headerResponse",
               HeaderResponse.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("clientDataRequest",
               ClientDataRequest.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("mimeResponse",
               MimeResponse.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("stateAwareResponse",
               StateAwareResponse.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("renderParams",
               RenderParameters.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("mutableRenderParams",
               MutableRenderParameters.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("actionParams",
               ActionParameters.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("resourceParams",
               ResourceParameters.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("portletContext",
               PortletContext.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));

         info362.add(new VariableInfo("portletMode",
               PortletMode.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("windowState",
               WindowState.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("cookies",
               Cookie[].class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("locale",
               Locale.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("locales",
               Locale[].class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("namespace",
               String.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("contextPath",
               String.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("windowId",
               String.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
         info362.add(new VariableInfo("portletName",
               String.class.getCanonicalName(),
               true,
               VariableInfo.AT_BEGIN));
      }
      
      @Override
      public VariableInfo[] getVariableInfo(TagData tagData) {
         return info362.toArray(new VariableInfo[0]);
      }
      
   }
   
   @Override
   protected void setPortletRequestResponseAttribute(PortletRequest request, PortletResponse response) {
      
      PortletContext poco = request.getPortletContext();
      setAttribute(poco, "portletContext");
      
      PortletConfig config = (PortletConfig) pageContext.getRequest().getAttribute(Constants.PORTLET_CONFIG);
      setAttribute(config.getPortletName(), "portletName");
      
      setAttribute(request.getRenderParameters(), "renderParams");
      setAttribute(request.getPortletMode(), "portletMode");
      setAttribute(request.getWindowState(), "windowState");
      setAttribute(request.getCookies(), "cookies");
      setAttribute(Collections.list(request.getLocales()).toArray(new Locale[0]), "locales");
      setAttribute(request.getLocale(), "locale");
      setAttribute(request.getWindowID(), "windowId");
      setAttribute(request.getContextPath(), "contextPath");
      setAttribute(response.getNamespace(), "namespace");
      
      if (request instanceof ClientDataRequest) {
         setAttribute(request, "clientDataRequest");
         if (request instanceof ActionRequest) {
            setAttribute(((ActionRequest) request).getActionParameters(), "actionParameters");
         } else {
            setAttribute(((ResourceRequest) request).getResourceParameters(), "resourceParameters");
         }
      }
      
      if (response instanceof StateAwareResponse) {
         setAttribute(response, "stateAwareResponse");
         setAttribute(((StateAwareResponse) response).getRenderParameters(), "mutableRenderParams");
      }
      
      if (response instanceof MimeResponse) {
         setAttribute(response, "mimeResponse");
      }

      if(request instanceof HeaderRequest){
         setAttribute(request, "headerRequest");
         setAttribute(response, "headerResponse");
      }     

      super.setPortletRequestResponseAttribute(request, response);
   }

}
