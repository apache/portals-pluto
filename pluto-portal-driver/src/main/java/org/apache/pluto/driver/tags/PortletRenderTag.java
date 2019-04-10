/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * The portlet render tag is used to print portlet rendering result (or error details) to the page.
 * 
 * @version 1.0
 * @since Oct 4, 2004
 */
public class PortletRenderTag extends TagSupport {
   private static final long serialVersionUID = 1L;

   // TagSupport Impl ---------------------------------------------------------

   /**
    * 
    * @see PortletTag
    */
   public int doEndTag() throws JspException {

      // Ensure that the portlet render tag resides within a portlet tag.
      PortletTag parentTag = (PortletTag) TagSupport.findAncestorWithClass(this, PortletTag.class);
      if (parentTag == null) {
         throw new JspException("Portlet render tag may only reside " + "within a pluto:portlet tag.");
      }

      // If the portlet is rendered successfully, print the rendering result.

      try {
         if (parentTag.getStatus() == PortletTag.SUCCESS) {
            StringBuffer buffer = parentTag.getPortalServletResponse().getInternalBuffer().getBuffer();
            pageContext.getOut().print(buffer.toString());
         } else {

            // Otherwise, print the error messages

            List<String> msgs = parentTag.getMessages();

            if (msgs.isEmpty()) {
               pageContext.getOut().print(" Unknown error rendering portlet.");
            } else {

               for (String msg : msgs) {
                  pageContext.getOut().print("<p>");
                  pageContext.getOut().print(msg);
                  pageContext.getOut().print("</p>");
               }
            }
         }
      } catch (IOException ex) {
         throw new JspException(ex);
      }

      // Return.
      return SKIP_BODY;
   }

}
