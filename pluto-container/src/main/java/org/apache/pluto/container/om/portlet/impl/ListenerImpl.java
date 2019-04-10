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
import java.util.Locale;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.Listener;

/**
 * A single event declaration
 * 
 * @author Scott Nicklous
 */
public class ListenerImpl implements Listener {
   
   private final List<Description> descs = new ArrayList<Description>();
   private final List<DisplayName> dispNames = new ArrayList<DisplayName>();
   private String listenerClass = "";
   private String listenerName = "";
   private int ordinal = 0;

   
   /**
    * Copy constructor
    * 
    * @param lis
    */
   public ListenerImpl(Listener lis) {
      for (Description desc : lis.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
      for (DisplayName disp : lis.getDisplayNames()) {
         dispNames.add(new DisplayNameImpl(disp));
      }
      listenerClass = lis.getListenerClass();
      listenerName = lis.getListenerName();
      ordinal = lis.getOrdinal();
   }
   
   /**
    * Constructor
    * @param fn   Listener name
    */
   public ListenerImpl(String cls) {
      this.listenerClass = cls;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#getDescription(java.util.Locale)
    */
   @Override
   public Description getDescription(Locale locale) {
      Description ret = null;
      for (Description item : descs) {
         if (item.getLocale().equals(locale)) {
            ret = new DescriptionImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#getDisplayName(java.util.Locale)
    */
   @Override
   public DisplayName getDisplayName(Locale locale) {
      DisplayName ret = null;
      for (DisplayName item : dispNames) {
         if (item.getLocale().equals(locale)) {
            ret = new DisplayNameImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#getDisplayNames()
    */
   @Override
   public List<DisplayName> getDisplayNames() {
      return new ArrayList<DisplayName>(dispNames);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#addDisplayName(org.apache.pluto.container.om.portlet.DisplayName)
    */
   @Override
   public void addDisplayName(DisplayName desc) {
      dispNames.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#getListenerClass()
    */
   @Override
   public String getListenerClass() {
      return listenerClass;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Listener#setListenerClass(java.lang.String)
    */
   @Override
   public void setListenerClass(String filterClass) {
      listenerClass = filterClass;
   }

   /**
    * @return the listenerName
    */
   @Override
   public String getListenerName() {
      return listenerName;
   }

   /**
    * @param listenerName the listenerName to set
    */
   @Override
   public void setListenerName(String listenerName) {
      this.listenerName = listenerName;
   }

   /**
    * @return the ordinal
    */
   @Override
   public int getOrdinal() {
      return ordinal;
   }

   /**
    * @param ordinal the ordinal to set
    */
   @Override
   public void setOrdinal(int ordinal) {
      this.ordinal = ordinal;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((listenerClass == null) ? 0 : listenerClass.hashCode());
      return result;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      ListenerImpl other = (ListenerImpl) obj;
      if (listenerClass == null) {
         if (other.listenerClass != null) {
            return false;
         }
      } else if (!listenerClass.equals(other.listenerClass)) {
         return false;
      }
      return true;
   }

}
