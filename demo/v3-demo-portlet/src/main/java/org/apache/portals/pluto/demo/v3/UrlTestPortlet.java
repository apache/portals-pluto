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

import static org.apache.portals.pluto.demo.v3.Constants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;

import static javax.portlet.MimeResponse.Copy.*;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import static javax.portlet.ResourceURL.*;


/**
 * A portlet that creates various types of URL.
 * 
 * @author Scott Nicklous
 */
public class UrlTestPortlet extends GenericPortlet {

   // Set up logging
   private static final Logger logger = LoggerFactory.getLogger(UrlTestPortlet.class);
   private static final boolean isDebug = logger.isDebugEnabled();
   
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
      
      String style = "style='min-width: 100px;'";
      RenderParameters rp = req.getRenderParameters();
      Set<? extends String> pnSet = rp.getNames();
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Render parameter names: ").append(pnSet.toString());
         logger.debug(txt.toString());
      }
      
      // don't display the control parameters
      pnSet.remove(PARAM_SETTYPE);
      pnSet.remove(PARAM_REMTYPE);
      pnSet.remove(PARAM_AURLCOPY);
      
      StringBuilder txt = new StringBuilder();
      txt.append("<h3>Currently set render parameters:</h3>\n");
      txt.append("<div>\n");
      txt.append("   <table>");

      for (String pn : pnSet) {
         // try to test all parameter apis
         String val = rp.getValue(pn);
         String[] vals = rp.getValues(pn);
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
      
      txt.append("   </table>");
      txt.append("</div>\n");
      
      req.setAttribute(ATTRIB_PARAMS, txt.toString());
      
      // Generate some URL test parameters based on current val
      
      int ctr = 0;
      int currCtr = 0;
      for (String pn : pnSet) {
         if (pn.startsWith("UrlParm")) {
            try {
               currCtr = Integer.parseInt(rp.getValue(pn));
            } catch(Exception e) {}
            ctr = (currCtr > ctr) ? currCtr : ctr;
         }
      }
      
      String name1 = "UrlParm" + (++ctr);
      String val1 = "" + ctr;
      
      String name2 = "UrlParm" + (++ctr);
      String val2 = "" + ctr;
      
      // Generate some render URLs with differing copy parameter and
      // additional parameters. Use a TreeSet to have sorted output
      
      TreeMap<String, String> urls = new TreeMap<String, String>();
      
      RenderURL rurl = resp.createRenderURL(NONE);
      urls.put(" 1 Copy no params, 0 new", rurl.toString());

      rurl = resp.createRenderURL(PUBLIC);
      urls.put(" 2 Copy public params, 0 new", rurl.toString());
      
      rurl = resp.createRenderURL(ALL);
      urls.put(" 3 Copy all params, 0 new", rurl.toString());
      
      rurl = resp.createRenderURL(NONE);
      rurl.getRenderParameters().setValue(name1, val1);
      rurl.getRenderParameters().setValue(name2, val2);
      urls.put(" 4 Copy no params, 2 new", rurl.toString());

      rurl = resp.createRenderURL(PUBLIC);
      rurl.getRenderParameters().setValue(name1, val1);
      rurl.getRenderParameters().setValue(name2, val2);
      urls.put(" 5 Copy public params, 2 new", rurl.toString());
      
      rurl = resp.createRenderURL(ALL);
      rurl.getRenderParameters().setValue(name1, val1);
      rurl.getRenderParameters().setValue(name2, val2);
      urls.put(" 6 Copy all params, 2 new", rurl.toString());
      
      req.setAttribute(ATTRIB_RENURLS, urls);
      
      // Add some resource URLs for display. Try to make one of the 
      // resource parameters names the same as a render parameter
      // name, if a render link setting render parameters has been clicked
      
      urls = new TreeMap<String, String>();
      
      name1 = "UrlParm" + (currCtr);
      val1 = "" + currCtr;
      
      name2 = "UrlParm-Resource" + (currCtr);
      val2 = "" + currCtr;
      
      ResourceURL resurl = resp.createResourceURL();
      resurl.setCacheability(PAGE);
      urls.put("0 ca=PAGE, 0 res params", resurl.toString());
      
      resurl = resp.createResourceURL();
      resurl.setCacheability(PORTLET);
      urls.put("1 ca=PORTLET, 0 res params", resurl.toString());
      
      resurl = resp.createResourceURL();
      resurl.setCacheability(FULL);
      urls.put("2 ca=FULL, 0 res params", resurl.toString());

      resurl = resp.createResourceURL();
      resurl.setCacheability(PAGE);
      resurl.getResourceParameters().setValue(name1, val1);
      resurl.getResourceParameters().setValue(name2, val2);
      urls.put("3 ca=PAGE, 2 res params", resurl.toString());

      resurl = resp.createResourceURL();
      resurl.setCacheability(PORTLET);
      resurl.getResourceParameters().setValue(name1, val1);
      resurl.getResourceParameters().setValue(name2, val2);
      urls.put("4 ca=PORTLET, 2 res params", resurl.toString());

      resurl = resp.createResourceURL();
      resurl.setCacheability(FULL);
      resurl.getResourceParameters().setValue(name1, val1);
      resurl.getResourceParameters().setValue(name2, val2);
      urls.put("5 ca=FULL, 2 res params", resurl.toString());
      
      req.setAttribute(ATTRIB_RESURLS, urls);

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-utp.jsp");
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
      
      RenderParameters rp = req.getRenderParameters();
      ResourceParameters rsp = req.getResourceParameters();
      
      // get the resource request render & resource parameters; put them into 
      // table and write them out.
      
      StringBuilder txt = new StringBuilder();
      String style = "style='min-width: 100px;'";
      
      txt.append("<h3>Render parameters for the ResourceRequest:</h3>\n");
      txt.append("<div>\n");
      txt.append("   <table>");

      // don't display the control parameters
      for (String pn : rp.getNames()) {
         if (!pn.equals(PARAM_AURLCOPY) && !pn.equals(PARAM_REMTYPE) && !pn.equals(PARAM_SETTYPE)) {
            String val = rp.getValue(pn);
            String[] vals = rp.getValues(pn);
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
      }
      
      txt.append("   </table>");
      txt.append("</div>\n");
      
      txt.append("<h3>Resource parameters for the ResourceRequest:</h3>\n");
      txt.append("<div>\n");
      txt.append("   <table>");

      for (String pn : rsp.getNames()) {
         String val = rsp.getValue(pn);
         String[] vals = rsp.getValues(pn);
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
      
      txt.append("   </table>");
      txt.append("</div>\n");
      
      writer.write(txt.toString());
   }

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      
      ActionParameters ap = req.getActionParameters();
      MutableRenderParameters mrp = resp.getRenderParameters();
      Set<? extends String> rpNames = mrp.getNames();

      if (isDebug) {
         StringBuffer sb = new StringBuffer();
         sb.append("Action parameters:");
         for (String k : ap.getNames()) {
            sb.append("\nName: ").append(k);
            sb.append(", Values: ").append(Arrays.toString(ap.getValues(k)));
         }
         logger.debug(sb.toString());
      }
      
      // get the action request render & action parameters; put them into 
      // session for later display
      
      StringBuilder txt = new StringBuilder();
      String style = "style='min-width: 100px;'";
      
      txt.append("<h3>Render parameters for the last ActionRequest:</h3>\n");
      txt.append("<div>\n");
      txt.append("   <table>");

      // don't display the control parameters
      for (String pn : mrp.getNames()) {
         if (!pn.equals(PARAM_AURLCOPY) && !pn.equals(PARAM_REMTYPE) && !pn.equals(PARAM_SETTYPE)) {
            String val = mrp.getValue(pn);
            String[] vals = mrp.getValues(pn);
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
      }
      
      txt.append("   </table>");
      txt.append("</div>\n");
      
      txt.append("<h3>Action parameters for the last ActionRequest:</h3>\n");
      txt.append("<div>\n");
      txt.append("   <table>");

      for (String pn : ap.getNames()) {
         String val = ap.getValue(pn);
         String[] vals = ap.getValues(pn);
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
      
      txt.append("   </table>");
      txt.append("</div>\n");

      req.getPortletSession().setAttribute(ATTRIB_ACTPARAMS, txt.toString());

      // Handle the control parameters
      
      String setType = ap.getValue(PARAM_SETTYPE);
      setType = (setType == null) ? PARAM_SETTYPE_VARRAY : setType;
      mrp.setValue(PARAM_SETTYPE, setType);
      
      String remType = ap.getValue(PARAM_REMTYPE);
      remType = (remType == null) ? PARAM_REMTYPE_SET : remType;
      mrp.setValue(PARAM_REMTYPE, remType);
      
      String aurlCopy = ap.getValue(PARAM_AURLCOPY);
      aurlCopy = (aurlCopy == null) ? PARAM_AURLCOPY_ALL : aurlCopy;
      mrp.setValue(PARAM_AURLCOPY, aurlCopy);
      
      // Get the parameter name & values. Parse values string into individual values.
      // if string is 'null', change it into null.
      
      String pn = ap.getValue(PARAM_NAME);
      String pv = ap.getValue(PARAM_VALUES);

      String[] parsedVals = null;
      txt = new StringBuilder("Setting values to ");
      if (pn != null && pn.length() > 0 && pv != null) {
         parsedVals = pv.split(",", -1);
         if (pv.length() == 0) {
            txt.append("array containing single empty string");
            parsedVals = new String[] {""};
         } else if (parsedVals.length == 1) {
            if (parsedVals[0].equals("null")) {
               txt.append("null");
               parsedVals = null;
            } else if (parsedVals[0].equals("empty")) {
               txt.append("an empty array.");
               parsedVals = new String[0];
            } else {
               txt.append("an array containing the single item");
            }
         } else {
            txt.append("an array of values");
            for (int ii = 0; ii < parsedVals.length; ii++) {
               if (parsedVals[ii].equals("null")) {
                  parsedVals[ii] = null;
               }
            }
         }
         try {
            if (remType.equals(PARAM_REMTYPE_REM)) {
               txt.append(". Removing parameter");
               mrp.removeParameter(pn);
            } else {
               if (setType.equals(PARAM_SETTYPE_VARRAY)) {
                  txt.append(" using values array");
                  mrp.setValues(pn, parsedVals);
               } else {
                  txt.append(" using first value in array");
                  String tval = (parsedVals == null) ? null : parsedVals[0];
                  mrp.setValue(pn, tval);
               }
            }
         } catch(Exception e) {
            StringBuilder err = new StringBuilder("Exception setting parameter: ");
            err.append(e.toString());
            mrp.setValue("Error:", "<span style='color: red;'>" + err.toString() + "</span>");
         }
      } else if (rpNames.isEmpty()) {
         txt.append("the error message");
         mrp.setValue("Error:", "<span style='color: red;'>No parameters available!</span>");
      }
      
      if (isDebug) {
         logger.debug(txt.toString());
         txt = new StringBuilder("Parsed Action Parameters: ");
         txt.append(", Name: ").append(pn);
         txt.append(", Value string: >>").append(pv).append("<<");
         txt.append(", Parsed Values: ").append(Arrays.toString(parsedVals));
         logger.debug(txt.toString());
      }

   }

}
