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
package org.apache.pluto.container.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.portlet.HeaderResponse;
import javax.portlet.PortletMode;

import org.apache.pluto.container.PortletHeaderResponseContext;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * Implementation of the <code>javax.portlet.RenderResponse</code> interface.
 * 
 */
@SuppressWarnings("unchecked")
public class HeaderResponseImpl extends MimeResponseImpl implements HeaderResponse {

   public HeaderResponseImpl(PortletHeaderResponseContext responseContext) {
      super(responseContext);
   }

   /**
    * Checks if the specified content type is valid (supported by the portlet). The specified content type should be a
    * tripped mime type without any character encoding suffix.
    * 
    * @param contentType
    *           the content type to check.
    * @return true if the content type is valid, false otherwise.
    */
   protected boolean isValidContentType(String contentType) {

      String[] parts = contentType.split("/");
      if (parts.length != 2) {
         return false;
      }      

      for (String supportedType : getResponseContentTypes()) {
         
         // Content type is supported by an exact or wildcard match.
         if (supportedType.matches("(?:\\*|\\*/\\*)") || supportedType.equals(contentType)) {
            return true;
         }
         
         String[] sp = supportedType.split("/");
         assert sp.length == 2;
         
         if (sp[0].equals("*") || sp[0].equals(parts[0])) {
            if (sp[1].equals("*") || sp[1].equals(parts[1])) {
               return true;
            }
         }
      }
      
      return false;
   }

   @Override
   public void setContentType(String contentType) {
      ArgumentUtility.validateNotNull("contentType", contentType);
      contentType = contentType.replaceAll("([^;]*).*", "$1").replaceAll(" ", "");
      if (!isValidContentType(contentType)) {
         throw new IllegalArgumentException("Specified content type '" + contentType + "' is not supported.");
      }
      super.setContentType(contentType);
   }

   public void setNextPossiblePortletModes(Collection<? extends PortletMode> portletModes) {
      ArgumentUtility.validateNotNull("portletModes", portletModes);
      if (portletModes.isEmpty()) {
         throw new IllegalArgumentException("At least one possible PortletMode should be specified.");
      }
      ArrayList<PortletMode> modes = new ArrayList<PortletMode>();
      for (PortletMode mode : portletModes) {
         if (isPortletModeAllowed(mode)) {
            modes.add(mode);
         }
      }
      if (modes.isEmpty()) {
         modes.add(getPortletWindow().getPortletMode());
      }
      ((PortletHeaderResponseContext) responseContext).setNextPossiblePortletModes(modes);
   }

   public void setTitle(String title) {
      ((PortletHeaderResponseContext) responseContext).setTitle(title);
   }

   @Override
   public void addDependency(String name, String scope, String version) {
      ((PortletHeaderResponseContext) responseContext).addDependency(name, scope, version);
   }

   @Override
   public void addDependency(String name, String scope, String version, String markup) {
      ((PortletHeaderResponseContext) responseContext).addDependency(name, scope, version, markup);
   }
}
