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


package org.apache.portals.samples;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.PortletSerializable;
import javax.portlet.annotations.RenderStateScoped;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.MimeResponse;
import javax.portlet.MimeResponse.Copy;

/**
 * Render state scoped bean. The bean is stored as a render parameter,
 * so it needs to be portlet serializable.
 */
@RenderStateScoped
public class NameBean implements PortletSerializable {
   
   // Inject the portlet namespace 
   @Inject @Namespace private String pid;
   
   // Inject the MimeResponse to allow URL creation
   @Inject private            MimeResponse mimeresp;
   
   private final static String PARAM_NAME = "name";

   //========== bean state in this block =======================
   private String name;
   //===========================================================

   @Inject 
   private ActionParameters actparams;

   // getters & setters
   //================
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   //================
   
   
   /**
    * writes the action form as string. This method is placed within the bean 
    * to allow easier access to form state data, which might be part of the bean
    * state, but not part of the bean public API.  
    * 
    * @return the action form as string
    */
   @RenderMethod(portletNames = {"BeanPortlet"}, ordinal=200)
   public String getActionForm() {
      StringBuilder txt = new StringBuilder(128);
      
      PortletURL aurl = mimeresp.createActionURL(Copy.ALL);
      txt.append("<FORM id='").append(pid).append("-setParams' METHOD='POST' ACTION='").append(aurl);
      txt.append("' enctype='application/x-www-form-urlencoded' accept-charset='UTF-8'>");
      txt.append("   <table><tr><td align='left'>");
      txt.append("   Enter your name:");
      txt.append("   </td><td>");
      txt.append("   <input name='").append(PARAM_NAME);
      txt.append("' type='text' value='").append((name == null) ? "" : name);
      txt.append("' size='50' maxlength='50'>");
      txt.append("   <input type='hidden' name='").append(ActionRequest.ACTION_NAME);
      txt.append("' value='setName'>");
      txt.append("   </td></tr><tr><td>");
      txt.append("   <INPUT VALUE='send' TYPE='submit'>");
      txt.append("   </td></tr></table>");
      txt.append("</FORM>");

      return txt.toString();
   }
   
   /**
    * Bean portlet action method for the "BeanHelloWorld" portlet.
    * Since the submitted form contains a hidden field with the action 
    * name set to "setName", the portlet container routes the request
    * to exactly this method.
    */
   @ActionMethod(portletName = "BeanPortlet", actionName="setName")
   public void setName(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      // The action parameter is injected, so just need to check it or
      // in this case, copy it to the state. Note that you can't inject directly 
      // into the state, since the injection is performed before the deserialization.
      name = actparams.getValue(PARAM_NAME);
   }

   /**
    * This method is called by the portlet container to 
    * initialize the bean at the beginning of a request.
    */
   @Override
   public void deserialize(String[] state) {
      if (state.length == 1) {
         name = state[0];
      }
   }

   /**
    * Called by the portlet container at the end of an action or event request
    * to store the serialized data as a portlet render parameter.
    */
   @Override
   public String[] serialize() {
      return new String[] {name};
   }

}
