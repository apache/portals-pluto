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

import static basic.portlet.Constants.PARAM_BORDER_COLOR;
import static basic.portlet.Constants.PARAM_COLOR;
import static basic.portlet.Constants.PARAM_IMGNAME;
import static basic.portlet.Constants.imgMap;
import static basic.portlet.Constants.DEFAULT_IMAGE;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


/**
 * A management portlet that displays the current deep link configuraion
 */
public class ResourcePortlet extends GenericPortlet {

   // Set up logging
   private static final String LOG_CLASS = ResourcePortlet.class.getName();
   private final Logger logger = Logger.getLogger(LOG_CLASS);


   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isLoggable(Level.FINE)) {
         logger.logp(Level.FINE, this.getClass().getName(), "doView", "Entry");
      }
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();

      String pid = resp.getNamespace();

      writer.write("<div style='clear:both;'>\n");
      writer.write("<div style='float:left;'><h3>Image Viewer</h3></div>\n");
      writer.write("<div id=" + pid + "-counter style='float:right; font-size:250%; color:#0B0;'>1</div>\n");
      writer.write("</div><div style='clear:both;'><hr/>\n");
      
      writer.write("<FORM id='" + pid + "-setParams'  onsubmit='return false;'>");
      writer.write("   <table><tr><td align='left'>");
      writer.write("   Cacheability setting:");
      writer.write("   </td><td>");
      writer.write("   <input id='" + pid + "-page' type='radio' name='cacheability' value='cacheLevelPage'>Page");
      writer.write("   <input id='" + pid + "-portlet' type='radio' name='cacheability' value='cacheLevelPortlet'>Portlet");
      writer.write("   <input id='" + pid + "-full' type='radio' name='cacheability' value='cacheLevelFull'>Full");
      writer.write("   </td></tr><tr><td>");
      writer.write("   Set border (resource parameter)");
      writer.write("   </td><td>");
      writer.write("   <input id='" + pid + "-border' type='checkbox' name='border' value='border'>");
      writer.write("   </td></tr></table>");
      writer.write("</FORM><hr/>");

      writer.write("<div id='" + pid + "-putResourceHere'></div>\n");
      
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var pid = '" + pid + "',\n");
      writer.write("       resdiv = '" + pid + "-putResourceHere',\n");
      writer.write("       border = '" + pid + "-border',\n");
      writer.write("       ca_page = '" + pid + "-page',\n");
      writer.write("       ca_portlet = '" + pid + "-portlet',\n");
      writer.write("       ca_full = '" + pid + "-full',\n");
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
//      writer.write("         document.getElementById(resdiv).innerHTML=\"Waiting for update.\";\n");
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
      writer.write("   document.getElementById(border).checked = false;\n");
      writer.write("   document.getElementById(border).onclick = function () {\n");
      writer.write("      console.log(\"border checked: \" + this.checked);\n");
      writer.write("      if (this.checked) {\n");
      writer.write("         resparms.border = ['#00F'];\n");
      writer.write("      } else {\n");
      writer.write("         resparms = {};\n");
      writer.write("      }\n");
      writer.write("      update();\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   document.getElementById(ca_page).checked = true;\n");
      writer.write("   var handleCA = function () {\n");
      writer.write("      console.log(\"cacheability button clicked: \" + this.value);\n");
      writer.write("      if (cacheability !== this.value) {\n");
      writer.write("         cacheability = this.value;\n");
      writer.write("         update();\n");
      writer.write("      }\n");
      writer.write("   }\n");
      writer.write("   document.getElementById(ca_page).onclick = handleCA;\n");
      writer.write("   document.getElementById(ca_portlet).onclick = handleCA;\n");
      writer.write("   document.getElementById(ca_full).onclick = handleCA;\n");
      writer.write("   \n");
      writer.write("   portlet.register(pid).then(function (pi) {\n");
      writer.write("      console.log(\"registered: \" + pid);\n");
      writer.write("      portletInit = pi;\n");
      writer.write("      portletInit.addEventListener(\"portlet.onStateChange\", update);\n");
      writer.write("   });\n");
      writer.write("   \n");
      writer.write("   var cntrId = '" + pid + "-counter', cntr = 1;\n");
      writer.write("   window.setInterval(function () {\n");
      writer.write("      document.getElementById(cntrId).innerHTML = ++cntr;\n");
      writer.write("   }, 1000);\n");
      writer.write("   \n");
      writer.write("})();\n");
      writer.write("</script>\n");

      writer.write("<p><hr/></p></div>\n");

   }
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {

      String key = req.getParameter(PARAM_IMGNAME);
      String imgDir = DEFAULT_IMAGE;
      if ((key != null) && imgMap.containsKey(key)) {
         imgDir = imgMap.get(key);
      }
      
      String bc = req.getParameter(PARAM_BORDER_COLOR);
      String imgStyle = "";
      if (bc != null) {
         imgStyle = " style='border:1px solid " + bc + ";' ";
      }
      
      String ctx = req.getContextPath();
      String ca = req.getCacheability();
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      
      String clr = req.getParameter(PARAM_COLOR);
      clr = (clr == null) ? "#FFFFFF" : clr;

      writer.write("<div style='background-color:" + clr + ";'>\n");
      writer.write("   <table style='background-color:" + clr + ";'>");
      writer.write("   <tr><td align='center' style='background-color:" + clr + ";'>");
      writer.write("   <img src='" + ctx + imgDir + "'" + imgStyle + ">\n");
      writer.write("   </td><td style='background-color:" + clr + ";'>");
      writer.write("   Cacheability: " + ca);
      writer.write("   </td></tr>");
      writer.write("   </table>");
      writer.write("</div>\n");


   }

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
   }

}
