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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

/**
 * A management portlet that displays the current deep link configuraion
 */
public class MessageBoxPortlet extends GenericPortlet {

   // Set up logging
   private static final String LOG_CLASS = MessageBoxPortlet.class.getName();
   private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isLoggable(Level.FINE)) {
         logger.logp(Level.FINE, this.getClass().getName(), "doView", "Entry");
      }
      
      String pid = resp.getNamespace();
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      String style = "\"border-style:solid; border-width:3px; padding:4px; overflow:auto;" + 
           "border-color:#000088; min-height:70px; background:#E0E0E0;\"";
      
      writer.write("<div style='clear:both;'>\n");
      writer.write("<div style='float:left;'><h3>Image Viewer</h3></div>\n");
      writer.write("<div style='float:right;'>\n");
      writer.write("<form   onsubmit='return false;'><input id='" + pid + "-clear' type='submit' name='action' value='clear' /></form>\n");
      writer.write("</div>\n");
      writer.write("</div><div style='clear:both;'><hr/>\n");
      writer.write("<h3>Message Box Portlet</h3>\n");
      writer.write("<p>Messages that arrive via events from other portlets are displayed in this box.</p>\n");
      writer.write("<div id='" + pid + "-responseDiv' style=" + style + "></div>\n");
      writer.write("</div>\n");
   
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var pid = '" + pid + "',\n");
      writer.write("       resdiv = '" + pid + "-responseDiv',\n");
      writer.write("       clrButton = '" + pid + "-clear',\n");
      writer.write("   \n");
      writer.write("       state,\n");
      writer.write("       resparms = {},\n");
      writer.write("       cacheability = 'cacheLevelPage',\n");
      writer.write("       portletInit;\n");
      writer.write("   \n");
      writer.write("   var update = function (type, state) {\n");
      writer.write("      console.log(\"Resource Portlet: state updated.\");\n");
      writer.write("      \n");
      writer.write("      portletInit.createResourceUrl(resparms, cacheability).then(function (url) {\n");
      writer.write("         var brdr = (resparms.border == undefined) ? undefined : resparms.border[0];\n");
      writer.write("         console.log(\"Resource Portlet: got url: \" + url + \", res parm border=\" + brdr);\n");
      writer.write("         var xhr = new XMLHttpRequest();\n");
      writer.write("         xhr.onreadystatechange=function() {\n");
      writer.write("            if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("               document.getElementById(resdiv).innerHTML=xhr.responseText;\n");
      writer.write("            }\n");
      writer.write("         };\n");
      writer.write("         xhr.open(\"GET\",url,true);\n");
      writer.write("         xhr.send();\n");
      writer.write("      });\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   document.getElementById(clrButton).onclick = function () {\n");
      writer.write("      console.log(\"clear button clicked. \");\n");
      writer.write("      portletInit.action();\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   portlet.register(pid).then(function (pi) {\n");
      writer.write("      console.log(\"Message Box portlet registered: \" + pid);\n");
      writer.write("      portletInit = pi;\n");
      writer.write("      portletInit.addEventListener(\"portlet.onStateChange\", update);\n");
      writer.write("   });\n");
      writer.write("   \n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }

   @Override
   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {

      // the only action for this portlet is to reset the stored messages
      
      String actionName = req.getParameter("action");
      logger.fine("MBP: Resetting messages. numMsgs = 0,  actionName = " + actionName);

      ArrayList<String> msgs = new ArrayList<String>();
      StringBuffer sb = new StringBuffer();
      sb.append("<p style='margin:2px 5px 2px 5px; color:#00D;"
            + " background-color:#AAF;'>");
      sb.append("Reset - No messages.");
      sb.append("</p>");
      msgs.add(sb.toString());

      resp.setRenderParameter(PARAM_NUM_MSGS, "0");
      req.getPortletSession().setAttribute(ATTRIB_MSGS, msgs);
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public void processEvent(EventRequest req, EventResponse resp) 
         throws PortletException ,IOException {
      
      ArrayList<String> msgs = (ArrayList<String>) req.getPortletSession().getAttribute(ATTRIB_MSGS);
      if (msgs == null) {
         msgs = new ArrayList<String>();
      }
      
      String[] msg;
      int numMsgs = 0;
      try {
         numMsgs = Integer.parseInt(req.getParameter(PARAM_NUM_MSGS));
      } catch (Exception e) {}
      
      if (numMsgs == 0) {
         msgs.clear();
      }
      
      logger.fine("MBP: Processing message event. Current # messages = " + msgs.size());

      try {
         // Both pieces of info are transported in a delimted string rather than 
         // an array since the Pluto impl doesn't seem to get along with array types as 
         // event payload types.
         String val = (String) req.getEvent().getValue();
         msg = val.split(DELIM);
      } catch (Exception e) {
         msg = new String[2];
         msg[0] = "error getting message from event.";
         msg[1] = "#D00";
      }
      
      String clr = req.getParameter(PARAM_COLOR);
      clr = (clr == null) ? "#FFFFFF" : clr;
      
      StringBuffer sb = new StringBuffer();
      sb.append("<p style='margin:2px 5px 2px 5px; color:" + msg[1] 
            + "; background-color:" + clr + ";'>");
      sb.append("" + (msgs.size() + 1) + ": " + msg[0]);
      sb.append("</p>");
      
      msgs.add(sb.toString());
      
      logger.fine("Adding message: " + sb.toString());

      resp.setRenderParameter(PARAM_NUM_MSGS, Integer.toString(msgs.size()));
      req.getPortletSession().setAttribute(ATTRIB_MSGS, msgs);
   };
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @SuppressWarnings("unchecked")
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      ArrayList<String> msgs = (ArrayList<String>) req.getPortletSession().getAttribute(ATTRIB_MSGS);
      if (msgs == null) {
         msgs = new ArrayList<String>();
         
         StringBuffer sb = new StringBuffer();
         sb.append("<p style='margin:0px 5px 0px 5px; color:#00D;"
               + " background-color:#FFA;'>");
         sb.append("No messages.");
         sb.append("</p>");
         msgs.add(sb.toString());
      }

      for (String msg : msgs) {
         writer.write(msg);
      }

   }

}
