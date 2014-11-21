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

import static basic.portlet.Constants.PARAM_IMGNAME;
import static basic.portlet.Constants.PARAM_SELTYPE;
import static basic.portlet.Constants.PARAM_SELTYPE_RADIO;
import static basic.portlet.Constants.imgMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
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
public class ImageSelPortlet extends GenericPortlet {

   // Set up logging
   private static final String LOG_CLASS = ImageSelPortlet.class.getName();
   private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {
      
      if (logger.isLoggable(Level.FINE)) {
         logger.logp(Level.FINE, this.getClass().getName(), "doView", "Entry");
      }
      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      writer.write("<h3>Image Selector</h3><hr/>\n");
      
      String pid = resp.getNamespace();
      String selType = req.getParameter(PARAM_SELTYPE);
      selType = (selType == null) ? PARAM_SELTYPE_RADIO : selType;
      String imgName = req.getParameter(PARAM_IMGNAME);
      imgName = (imgName == null) ? "default" : imgName;
      
      writer.write("<FORM id='" + pid + "-setParams' onsubmit='return false;'>");
      writer.write("   <table><tr><td align='left'>");
      writer.write("   Selection type (private param):");
      writer.write("   </td><td>");
      writer.write("   <input id='" + pid + "-radio' type='radio' name='selType' value='radio'>Radio Button");
      writer.write("   <input id='" + pid + "-dropdown' type='radio' name='selType' value='dropdown'>Drop Down");
      writer.write("   </td></tr><tr><td>");
      writer.write("   Select Image (public param):");
      writer.write("   </td><td>");

      writer.write("   <div id='" + pid + "-putResourceHere'></div>\n");

      writer.write("   </td></tr></table>");
      writer.write("</FORM>");
      writer.write("<p><hr/></p>\n");

      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var pid = '" + pid + "',\n");
      writer.write("       fid = '" + pid + "-setParams',\n");
      writer.write("       resdiv = '" + pid + "-putResourceHere',\n");
      writer.write("       st_radio = '" + pid + "-radio',\n");
      writer.write("       st_dropdown = '" + pid + "-dropdown',\n");
      writer.write("       selBox = '" + pid + "-selBox',\n");
      writer.write("   \n");
      writer.write("       last_st = 'radio',\n");
      writer.write("       lastImg = 'default',\n");
      writer.write("       currState,\n");
      writer.write("       portletInit;\n");
      writer.write("   \n");
      writer.write("   // Set image name PRP if radio button clicked - \n");
      writer.write("   var handleImgRadio = function () {\n");
      writer.write("      console.log(\"ISP: image selected (radio): \" + this.value);\n");
      writer.write("      \n");
      writer.write("      if (currState.parameters.imgName !== this.value) {\n");
      writer.write("         var newState = portletInit.cloneState(currState);\n");
      writer.write("         newState.parameters.imgName = [this.value];\n");
      writer.write("         portletInit.setPortletState(newState);\n");
      writer.write("      }\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   // Set image name PRP if image selected in selection box - \n");
      writer.write("   var handleImgDropdown = function () {\n");
      writer.write("      console.log(\"ISP: image selected (dropdown): \" + this.value);\n");
      writer.write("      \n");
      writer.write("      if (currState.parameters.imgName !== this.value) {\n");
      writer.write("         var newState = portletInit.cloneState(currState);\n");
      writer.write("         newState.parameters.imgName = [this.value];\n");
      writer.write("         portletInit.setPortletState(newState);\n");
      writer.write("      }\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   var update = function (type, state) {\n");
      writer.write("      var oldST = ((currState === undefined) || (currState.parameters.selType === undefined)) ? undefined : currState.parameters.selType[0];\n");
      writer.write("      var newST = (state.parameters.selType === undefined) ? undefined : state.parameters.selType[0];\n");
      writer.write("      var newImg = (state.parameters.imgName === undefined) ? undefined : state.parameters.imgName[0];\n");
      writer.write("      console.log(\"ISP: state updated. selType=\" + newST + \", imgName=\" + newImg);\n");
      writer.write("      \n");
      writer.write("      if ((currState === undefined) || (oldST !== newST)) {");
      writer.write("         portletInit.createResourceUrl({}).then(function (url) {\n");
      writer.write("            console.log(\"ISP: got url: \" + url);\n");
//      writer.write("            document.getElementById(resdiv).innerHTML=\"Waiting for update.\";\n");
      writer.write("            var xhr = new XMLHttpRequest();\n");
      writer.write("            xhr.onreadystatechange=function() {\n");
      writer.write("               if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("                  document.getElementById(resdiv).innerHTML=xhr.responseText;\n");

      writer.write("                  // default is radio buttons\n");
      writer.write("                  var ii, f = document.getElementById(fid);\n");
      writer.write("                  if ((newST === undefined) || (newST === 'radio')) {\n");
      writer.write("                     for (ii=0; ii < f.imgName.length; ii++) {\n");
      writer.write("                        console.log(\"ISP: adding selection handler for: \" + f.imgName[ii].value);\n");
      writer.write("                        f.imgName[ii].onclick = handleImgRadio;\n");
      writer.write("                        if (f.imgName[ii].value === newImg) {\n");
      writer.write("                           console.log(\"ISP: image clicked: \" + newImg);\n");
      writer.write("                           f.imgName[ii].clicked = true;\n");
      writer.write("                        }\n");
      writer.write("                     }\n");
      writer.write("                  } else if (newST === 'dropdown') {\n");
      writer.write("                     console.log(\"ISP: adding selection handler to dropdown list element: \" + selBox);\n");
      writer.write("                     document.getElementById(selBox).onchange = handleImgDropdown;\n");
      writer.write("                     for (ii=0; ii < f.imgName.length; ii++) {\n");
      writer.write("                        if (f.imgName[ii].value === newImg) {\n");
      writer.write("                           console.log(\"ISP: image selected: \" + newImg);\n");
      writer.write("                           f.imgName[ii].selected = true;\n");
      writer.write("                        }\n");
      writer.write("                     }\n");
      writer.write("                  }\n");

      writer.write("               }\n");
      writer.write("            };\n");
      writer.write("            xhr.open(\"GET\",url,true);\n");
      writer.write("            xhr.send();\n");
      writer.write("         });\n");
      writer.write("      }\n");

      writer.write("      if (newST === 'dropdown') {\n");
      writer.write("         document.getElementById(st_dropdown).checked = true;\n");
      writer.write("      } else {\n");
      writer.write("         document.getElementById(st_radio).checked = true;\n");
      writer.write("      }\n");

      writer.write("      currState=state;\n");
      writer.write("   }\n");
      writer.write("   \n");
      writer.write("   // set private parameter selType to store the selection display type\n");
      writer.write("   var handleST = function () {\n");
      writer.write("      console.log(\"ISP: select display type clicked: \" + this.value);\n");
      writer.write("      if (currState.parameters.selType !==  this.value) {\n");
      writer.write("         var newState = portletInit.cloneState(currState);\n");
      writer.write("         newState.parameters.selType = [this.value];\n");
      writer.write("         portletInit.setPortletState(newState);\n");
      writer.write("      }\n");
      writer.write("   }\n");
      writer.write("   document.getElementById(st_radio).onclick = handleST;\n");
      writer.write("   document.getElementById(st_dropdown).onclick = handleST;\n");
      writer.write("   \n");
      writer.write("   portlet.register(pid).then(function (pi) {\n");
      writer.write("      console.log(\"ISP Image Selection Portlet: registered: \" + pid);\n");
      writer.write("      portletInit = pi;\n");
      writer.write("      portletInit.addEventListener(\"portlet.onStateChange\", update);\n");
      writer.write("   });\n");
      writer.write("   \n");
      writer.write("   \n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {

	      resp.setContentType("text/html");
	      PrintWriter writer = resp.getWriter();

	      String pid = resp.getNamespace();
	      Set<String> names = imgMap.keySet();
	      String selType = req.getParameter(PARAM_SELTYPE);
	      selType = (selType == null) ? PARAM_SELTYPE_RADIO : selType;
	      String imgName = req.getParameter(PARAM_IMGNAME);
	      imgName = (imgName == null) ? "default" : imgName;

	      if (selType.equals(PARAM_SELTYPE_RADIO)) {
	         for (String name : names) {
	            writer.write("   <input type='radio' name='" + PARAM_IMGNAME + "' value='" + 
	               name + "'" + (name.equals(imgName) ? "checked" : "") + ">" + name);
	         }
	      } else {
	         writer.write("<select id='" + pid + "-selBox' name='" + PARAM_IMGNAME + "' size='1'>");
	         writer.write("   <option value='default' " + 
	               ("default".equals(imgName) ? "selected" : "") + ">-</option>");
	         for (String name : names) {
	            writer.write("   <option value='" + name + "'" + 
	               (name.equals(imgName) ? "selected" : "") + ">" + name + "</option>");
	         }
	         writer.write("</select>");
	      }
	}

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
   }

}
