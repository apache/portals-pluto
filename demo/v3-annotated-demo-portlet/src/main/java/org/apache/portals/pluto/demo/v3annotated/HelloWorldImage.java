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


package org.apache.portals.pluto.demo.v3annotated;

import javax.inject.Inject;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.MimeResponse;

/**
 * Contains a resource method and associated markup generator to insert 
 * an image.
 */
public class HelloWorldImage {

   public static final String RESPARAM_DISPLAY = "display";
   
   @Inject private            MimeResponse mimeresp;
   
   @Inject
   PortletRequest req;

   @Inject
   NameBean nameBean;
   
   // Some chimp pictures to associate with a name
   private final static String[] chimps = new String[] {
      "/resources/images/BabyChimp.gif",
      "/resources/images/bonoboMomKid.gif",
      "/resources/images/Chimpanzee_thinking-small.gif",
      "/resources/images/ChimpEatingDollar.gif"
   };

   @RenderMethod(portletNames = {"BeanPortlet"}, ordinal=100)
   public String getImageInclude() {
      
      StringBuilder txt = new StringBuilder(128);
      ResourceURL resurl = mimeresp.createResourceURL();
      if (nameBean.getName() != null) {
         resurl.getResourceParameters().setValue(RESPARAM_DISPLAY, "true");
      }
      
      String pid = mimeresp.getNamespace();
      txt.append("<div class='infobox' id='").append(pid).append("-putResourceHere'></div>\n");
      txt.append("<script>\n");
      txt.append("(function () {\n");
      txt.append("   var xhr = new XMLHttpRequest();\n");
      txt.append("   xhr.onreadystatechange=function() {\n");
      txt.append("      if (xhr.readyState==4 && xhr.status==200) {\n");
      txt.append("         document.getElementById('").append(pid).append("-putResourceHere').innerHTML=xhr.responseText;\n");
      txt.append("      }\n");
      txt.append("   };\n");
      txt.append("   xhr.open(\"GET\",\"").append(resurl.toString()).append("\",true);\n");
      txt.append("   xhr.send();\n");
      txt.append("})();\n");
      txt.append("</script>\n");

      return txt.toString();
   }

   // Inject the resource parameter to see if image should be displayed.
   @Inject  
   private ResourceParameters resparams;
   
   /**
    *  This resource method generates some output directly, then includes output
    *  from a JSP as specified in the annotation.
    *  
    * @return  The string for inclusion in the output.
    */
   @ServeResourceMethod(portletNames={"BeanPortlet"}, include="/WEB-INF/jsp/res-simple.jsp")
   public String getImage() {
      String result = "";
      String display = resparams.getValue(RESPARAM_DISPLAY);
      
      // illustrate use of the injected display resource parameter
      if (display != null) {
         
         // pick a chimp
         
         int ind = (int) (Math.random() * chimps.length);
         String imgSrc = req.getContextPath() + chimps[ind];
         imgSrc = mimeresp.encodeURL(imgSrc);
         req.setAttribute("imgSrc", imgSrc);
         
         // set the output
         
         result = "<p>Your image appears here:</p>";
      }
      return result;
   }

}
