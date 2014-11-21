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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.namespace.QName;


/**
 * A management portlet that displays the current deep link configuraion
 */
public class ColorSelPortlet extends GenericPortlet {

   // Set up logging
   // private static final String LOG_CLASS = ColorSelPortlet.class.getName();
   // private final Logger logger = Logger.getLogger(LOG_CLASS);

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      writer.write("<h3>Color Selector & Message Sender</h3><hr/>\n");
      
      String pid = resp.getNamespace();
      
      String clr = req.getParameter(PARAM_COLOR);
      clr = (clr == null) ? "#FFFFFF" : clr;
      
      String[] vals = req.getParameterValues(PARAM_FG_COLOR);
      String r = "";
      String g = "";
      String b = "";
      if (vals != null) {
         for (String v : vals) {
            if (v.equals(PARAM_FG_RED)) r = "checked";
            if (v.equals(PARAM_FG_GREEN)) g = "checked";
            if (v.equals(PARAM_FG_BLUE)) b = "checked";
         }
      }
      
      writer.write("<FORM id='" + pid + "-setParams'  onsubmit='return false;'>");
      writer.write("   <table><tr><td align='left'>");

      writer.write("   Enter background color (public param):");
      writer.write("   </td><td colspan=3>");
      writer.write("   <input id='" + pid + "-color' name='" + PARAM_COLOR + "' type='text' value='" + clr + "' size='10' maxlength='10'>");
      writer.write("   </td><td><div id='" + pid + "-putMsgHere'>");
      writer.write("   </div></td></tr><tr><td>");

      writer.write("   Select active foreground colors:");
      writer.write("   </td><td>");
      writer.write("   <input name='" + PARAM_FG_COLOR + "' value='" + PARAM_FG_RED + "' type='checkbox' " + r + ">");
      writer.write("   </td><td>Red");
      writer.write("   </td><td>");
      writer.write("   <input name='" + PARAM_FG_COLOR + "' value='" + PARAM_FG_GREEN + "' type='checkbox' " + g + ">");
      writer.write("   </td><td>Green");
      writer.write("   </td><td>");
      writer.write("   <input name='" + PARAM_FG_COLOR + "' value='" + PARAM_FG_BLUE + "' type='checkbox' " + b + ">");
      writer.write("   </td><td>Blue");

      writer.write("   </td></tr><tr><td>");
      writer.write("   Enter message:");
      writer.write("   </td><td colspan=6>");
      writer.write("   <input name='" + PARAM_MSG_INPUT + "' type='text' value='' size='50' maxlength='50'>");
      writer.write("   </td><td>");

      writer.write("   </td></tr><tr><td>");
      writer.write("   <INPUT VALUE='send' CLASS='portlet-form-button' TYPE='submit'>");
      writer.write("   </td></tr></table>");
      writer.write("</FORM>");
      writer.write("<p><hr/></p>\n");

      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var pid = '" + pid + "',\n");
      writer.write("       colorEntry = '" + pid + "-color',\n");
      writer.write("       msgdiv = '" + pid + "-putMsgHere',\n");
      writer.write("       currState,\n");
      writer.write("       portletInit;\n");

      writer.write("   var update = function (type, state) {\n");
      writer.write("      var oldColor = ((currState === undefined) || (currState.parameters.color === undefined)) ? '#FFFFFF' : currState.parameters.color[0];\n");
      writer.write("      var newColor = (state.parameters.color === undefined) ? '#FFFFFF' : state.parameters.color[0];\n");
      writer.write("      console.log(\"CSP: state updated. color=\" + newColor);\n");
      writer.write("      if ((currState === undefined) || (newColor !== oldColor)) {\n");
      writer.write("         document.getElementById(msgdiv).innerHTML = '';\n");
      writer.write("         document.getElementById(colorEntry).value = newColor;\n");
      writer.write("      }\n");
      writer.write("      currState = state;\n");
      writer.write("   }\n");
      writer.write("   \n");

      writer.write("   var handleEntry = function () {\n");
      writer.write("      var oldColor = ((currState === undefined) || (currState.parameters.color === undefined)) ? '#FFFFFF' : currState.parameters.color[0];\n");
      writer.write("      var newColor = this.value;\n");
      writer.write("      console.log(\"CSP: entry field updated. color=\" + newColor);\n");
      writer.write("      if ((newColor === undefined) || (newColor === null) || !newColor.match(\"^#(?:[A-Fa-f0-9]{3}){1,2}$\")) {\n");
      writer.write("         document.getElementById(msgdiv).innerHTML = 'Bad color. Enter #xxxxxx or #xxx.';\n");
      writer.write("      } else {\n");
      writer.write("         var newState = portletInit.cloneState(currState);\n");
      writer.write("         newState.parameters.color = [newColor];\n");
      writer.write("         portletInit.setPortletState(newState);\n");
      writer.write("      }\n");
      writer.write("   }\n");
      writer.write("   document.getElementById(colorEntry).onchange = handleEntry;\n");
      writer.write("   \n");

      writer.write("   portlet.register(pid).then(function (pi) {\n");
      writer.write("      console.log(\"CSP Color Selection Portlet: registered: \" + pid);\n");
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
   }

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      
      // pass the action params from the form submission as render parameters
      resp.setRenderParameter(PARAM_ERRMSG, "");
      String val = req.getParameter(PARAM_COLOR);
      if (val != null) {
         if (val.matches("^#(?:[A-Fa-f0-9]{3}){1,2}$")) {
            resp.setRenderParameter(PARAM_COLOR, val);
         } else {
            resp.setRenderParameter(PARAM_ERRMSG, "bad color. try again.");
         }
      } else {
         resp.setRenderParameter(PARAM_ERRMSG, "enter color #xxxxxx or #xxx.");
      }
      
      String[] vals = req.getParameterValues(PARAM_FG_COLOR);
      String r = "0";
      String g = "0";
      String b = "0";
      if (vals != null) {
         for (String v : vals) {
            if (v.equals(PARAM_FG_RED)) r = "F";
            if (v.equals(PARAM_FG_GREEN)) g = "F";
            if (v.equals(PARAM_FG_BLUE)) b = "F";
         }
      }
      
      if (vals != null) {
         resp.setRenderParameter(PARAM_FG_COLOR, vals);
      }
      
      String clr = "#" + r + g + b;
      val = req.getParameter(PARAM_MSG_INPUT);
      
      String msg = val + DELIM + clr;
      QName qn = new QName(EVENT_NAMESPACE, EVENT_NAME);
      resp.setEvent(qn, msg);
      
   }

}
