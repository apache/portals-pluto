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


package org.apache.portals.pluto.demo.chat;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.inject.Inject;
import javax.portlet.annotations.RenderMethod;

/**
 * Simple hello world bean portlet
 */
public class HelloWorldRender {
   
   // This is an @RenderStateScoped bean containing the name entered through the form.
   @Inject
   private NameBean nameBean;

   /**
    * Bean portlet render method for "BeanHelloWorld" portlet. The portletNames
    * attribute specifies the portlet name or list of portlet names using the method.
    * This annotation implicitly defines a portlet or list of portlets. Further 
    * configuration can be provided, but is not required. 
    */
   @RenderMethod(portletNames = {"BeanPortletDemo"})
   public String methodName() {
      
      // In it's simplest form, the render method just returns text.
      // The content type is set through the annotation.
      
      StringBuilder txt = new StringBuilder(128);
      
      txt.append("<h3>Hello \n");
      // Get the name from the bean. If it hasn't been set, just greet the world.
      if (nameBean.getName() != null) {
         txt.append(StringEscapeUtils.escapeHtml4(nameBean.getName()));
      } else {
         txt.append("World\n");
      }
      txt.append("!!</h3>");
      
      return txt.toString();
   }

}
