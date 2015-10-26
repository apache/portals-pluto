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


package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.pluto.container.om.portlet.Supports;

/**
 * @author Scott Nicklous
 *
 */
public class SupportsImpl implements Supports {
   
   private String mime;
   private final ArrayList<String> portletModes = new ArrayList<String>();
   private final ArrayList<String> windowStates = new ArrayList<String>();
   
   /**
    * Copy constructor
    */
   public SupportsImpl(Supports sup) {
      mime = sup.getMimeType();
      for (String pm : sup.getPortletModes()) {
         portletModes.add(pm);
      }
      for (String ws : sup.getWindowStates()) {
         windowStates.add(ws);
      }
   }

   /**
    * Constructor
    */
   public SupportsImpl(String mt) {
      mime = mt;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#getMimeType()
    */
   @Override
   public String getMimeType() {
      return mime;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#setMimeType(java.lang.String)
    */
   @Override
   public void setMimeType(String mt) {
      mime = mt;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#getPortletModes()
    */
   @Override
   public List<String> getPortletModes() {
      return new ArrayList<String>(portletModes);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#addPortletMode(java.lang.String)
    */
   @Override
   public void addPortletMode(String portletMode) {
      portletModes.add(portletMode);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#getWindowStates()
    */
   @Override
   public List<String> getWindowStates() {
      return new ArrayList<String>(windowStates);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Supports#addWindowState(java.lang.String)
    */
   @Override
   public void addWindowState(String windowState) {
      windowStates.add(windowState);
   }

}
