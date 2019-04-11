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
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.RenderMethod;

/**
 * This portlet exercises the dynamic dependency provisioning and declaration functions.
 * 
 * @author Scott Nicklous
 *
 */
@ApplicationScoped
public class DependencyPortlet {
   private static final Logger logger = LoggerFactory.getLogger(DependencyPortlet.class);
   
   public static final String PARAM_VER     = "version";
   public static final String PARAM_VER_1   = "1.12.3";
   public static final String PARAM_VER_2   = "2.2.3";
   public static final String PARAM_VER_3   = "2.1.1";

   private static final String DEP_VER_2 = "<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js'></script>";
   private static final String DEP_VER_3 = "<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js'></script>";
   
   private static final String ATTRIB_XMAP = "xmap";
   private static final String[] invalidDeps = {"Hi there!", "<script dffsfssf", 
      "<p>bad head tag</p>", "<link href='hi'>bad string<link href='bye'>"};

   @Inject 
   private PortletConfig      pcfg;

   /**
    * Adds required dynamic dependencies
    */
   @HeaderMethod(portletNames="DependencyPortlet")
   public void header(HeaderRequest req, HeaderResponse resp) throws IOException {

      // Add link tag to head section to include the style sheet

      String contextRoot = req.getContextPath();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<link href='").append(contextRoot);
      txt.append("/resources/css/infobox.css' rel='stylesheet' type='text/css'>");
      resp.addDependency("infobox", "org.apache.pluto", "0.4.0", txt.toString());

      String vers = req.getRenderParameters().getValue(PARAM_VER);
      if (vers == null) {
         resp.addDependency("jQuery", "com.jquery", PARAM_VER_1);
      } else {
         switch (vers) {
         case PARAM_VER_2:
            resp.addDependency("jQuery", "com.jquery", PARAM_VER_2, DEP_VER_2);
            break;
         case PARAM_VER_3:
            resp.addDependency("jQuery", "com.jquery", PARAM_VER_3, DEP_VER_3);
            break;
         default:
            resp.addDependency("jQuery", "com.jquery", PARAM_VER_1);
         }
      }
      
      // Now do some tests with invalid dependency strings
      
      Map<String, String> xmap = new HashMap<String, String>();
      for (String dep : invalidDeps) {
         String disp = dep.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
         try {
            resp.addDependency("Invalid", "attempt", "1.1.1", dep);
            xmap.put(disp, "No exception");
         } catch (Exception e) {
            String exceptionMsg = e.toString();
            exceptionMsg = exceptionMsg.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
            xmap.put(disp, exceptionMsg);
         }
      }
      req.getPortletSession().setAttribute(ATTRIB_XMAP, xmap);

   }
   
   /**
    * Renders the dialog through a JSP
    */
   @RenderMethod(portletNames = "DependencyPortlet", ordinal = 100, include = "/WEB-INF/jsp/dependencyDialog.jsp")
   public void getDialog(RenderRequest req, RenderResponse resp) {
      String vers = req.getRenderParameters().getValue(PARAM_VER);
      if (vers == null) {
         vers = PARAM_VER_1;
      }
      req.setAttribute(PARAM_VER, vers);
      
      @SuppressWarnings("unchecked")
      Map<String, String> xmap = (Map<String, String>) req.getPortletSession().getAttribute(ATTRIB_XMAP);
      if (xmap == null) {
         xmap = new HashMap<String, String>();
      }
      req.setAttribute(ATTRIB_XMAP, xmap);
      req.getPortletSession().removeAttribute(ATTRIB_XMAP);
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Portlet name: ").append(pcfg.getPortletName());
      txt.append(", parameter: ").append(PARAM_VER);
      txt.append(", value: ").append(vers);
      logger.debug(txt.toString());
      
   }

   @ActionMethod(portletName = "DependencyPortlet")
   public void handleDialog(ActionRequest req, ActionResponse resp) throws PortletException, IOException {
      String vers = req.getActionParameters().getValue(PARAM_VER);
      if (vers != null) {
         resp.getRenderParameters().setValue(PARAM_VER, vers);
      }
      
      StringBuilder txt = new StringBuilder(128);
      txt.append("Parameter: ").append(PARAM_VER);
      txt.append(", value: ").append(vers);
      logger.debug(txt.toString());

   }


}
