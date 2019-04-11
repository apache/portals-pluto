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

import javax.portlet.ActionURL;
import javax.portlet.MutableActionParameters;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


/**
 * A portlet that allows render parameter names & values to be entered and set.
 * 
 * @author Scott Nicklous
 */
public class UrlAPTestPortlet extends GenericPortlet {

   // Set up logging
   private static final Logger logger = LoggerFactory.getLogger(UrlAPTestPortlet.class);
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
         boolean isPublic = rp.isPublic(pn);
         txt.append("      <tr><td " + style + ">Name: ")
            .append(pn)
            .append("</td><td " + style + ">Val: ")
            .append(val)
            .append("</td><td " + style + ">Len: ")
            .append(vals.length)
            .append("</td><td " + style + ">Values: ")
            .append(Arrays.toString(vals))
            .append("</td><td " + style + ">Public: ")
            .append(isPublic)
            .append("</td></tr>\n");
      }
      
      txt.append("   </table>");
      txt.append("</div>\n");
      
      req.setAttribute(ATTRIB_PARAMS, txt.toString());
      
      // Generate some URL test parameters based on current val
      
      int ctr = 0;
      int currCtr = 0;
      for (String pn : pnSet) {
         if (pn.startsWith("UParm")) {
            try {
               currCtr = Integer.parseInt(rp.getValue(pn));
            } catch(Exception e) {}
            ctr = (currCtr > ctr) ? currCtr : ctr;
         }
      }
      
      String name1 = "UParm" + (++ctr);
      String val1 = "" + ctr;
      
      String name2 = "UParm" + (++ctr);
      String val2 = "" + ctr;
      
      String name3 = "UParm" + (++ctr);
      String val3 = "" + ctr;
     
      // Generate some action URLs with differing render parameters.
      // Use a TreeSet to have sorted output
      
      TreeMap<String, String> urls = new TreeMap<String, String>();
      MutableRenderParameters mrp = req.getRenderParameters().clone();
      
      ActionURL aurl = resp.createActionURL(NONE);
      urls.put(" 1 No render parameters", aurl.toString());

      aurl = resp.createActionURL(NONE);
      aurl.getRenderParameters().set(mrp);
      urls.put(" 2 Copy with req clone", aurl.toString());

      aurl = resp.createActionURL(NONE);
      mrp.setValue(name1, val1);
      aurl.getRenderParameters().set(mrp);
      urls.put(" 3 Copy with req clone, 1 addl", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      aurl.getRenderParameters().clearPrivate();
      urls.put(" 4 Clear private", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      aurl.getRenderParameters().clearPublic();;
      urls.put(" 5 Clear public", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      aurl.getRenderParameters().clear();
      urls.put(" 6 Clear all", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      mrp = aurl.getRenderParameters().clone();
      logger.debug("MRP from request # entries: " + mrp.size());
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clearPrivate();
         logger.debug("MRP2 afer clearPrivate # entries: " + mrp2.size());
         aurl.getRenderParameters().set(mrp2);
         urls.put(" 7 Clear clone private", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clearPublic();
         logger.debug("MRP2 afer clearPublic # entries: " + mrp2.size());
         aurl.getRenderParameters().set(mrp2);
         urls.put(" 8 Clear clone public", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clear();
         logger.debug("MRP2 afer clear # entries: " + mrp2.size());
         aurl.getRenderParameters().set(mrp2);
         urls.put(" 9 Clear clone all", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clear();
         mrp2.setValue(name1, val1);
         logger.debug("MRP2 afer adding 1: # entries: " + mrp2.size());
         aurl.getRenderParameters().add(mrp2);
         urls.put(" A Add thru clone 1", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clear();
         mrp2.setValue(name1, val1);
         mrp2.setValue(name2, val2);
         logger.debug("MRP2 afer adding 2: # entries: " + mrp2.size());
         aurl.getRenderParameters().add(mrp2);
         urls.put(" B Add thru clone 2", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableRenderParameters mrp2 = mrp.clone();
         mrp2.clear();
         mrp2.setValue(name1, val1);
         mrp2.setValue(name2, val2);
         mrp2.setValue(name3, val3);
         logger.debug("MRP2 afer adding 3: # entries: " + mrp2.size());
         aurl.getRenderParameters().add(mrp2);
         urls.put(" C Add thru clone 3", aurl.toString());
      }
      
      req.setAttribute(ATTRIB_RENURLS, urls);
      
      // Generate some action URLs with differing render parameters.
      // Use a TreeSet to have sorted output
      
      urls = new TreeMap<String, String>();
      mrp = req.getRenderParameters().clone();
      
      aurl = resp.createActionURL(ALL);
      urls.put(" 1 No action parameters", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      aurl.getActionParameters().setValue(name1, val1);
      aurl.getActionParameters().setValues(name2, new String[]{val2});
      aurl.getActionParameters().clear();
      urls.put(" 2 set & clear action params", aurl.toString());
      
      aurl = resp.createActionURL(ALL);
      MutableActionParameters map = aurl.getActionParameters().clone();
      map.setValue(name3, val3);
      map.setValues(name1, new String[]{val1, val2});
      logger.debug("MAP from request # entries: " + map.size());
      
      {
         aurl = resp.createActionURL(ALL);
         MutableActionParameters map2 = map.clone();
         map2.clear();
         logger.debug("MAP2 afer clear # entries: " + map2.size());
         aurl.getActionParameters().set(map2);
         urls.put(" 3 AP Clear clone all", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableActionParameters map2 = map.clone();
         logger.debug("MAP2 afer adding 2: # entries: " + map2.size());
         aurl.getActionParameters().add(map2);
         urls.put(" 4 AP Add thru clone 2", aurl.toString());
      }
      
      {
         aurl = resp.createActionURL(ALL);
         MutableActionParameters map2 = map.clone();
         map2.clear();
         map2.setValue(name1, val1);
         map2.setValue(name2, val2);
         map2.setValue(name3, val3);
         logger.debug("MAP2 after adding 3: # entries: " + map2.size());
         aurl.getActionParameters().add(map2);
         urls.put(" 5 AP Add thru clone 3", aurl.toString());
      }
      
      req.setAttribute(ATTRIB_ACTURLS, urls);

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-uaptp.jsp");
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
      if (mrp.isEmpty()) {
         txt.append("Render parameters is empty.");
      } else {
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
      }
      txt.append("</div>\n");
      
      txt.append("<h3>Action parameters for the last ActionRequest:</h3>\n");
      txt.append("<div>\n");
      if (ap.isEmpty()) {
         txt.append("Action parameters is empty.");
      } else {
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
      }
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
         txt.append("nothing.");
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
