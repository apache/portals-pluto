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

import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.Description;

/**
 * @author Scott Nicklous
 *
 */
public class CustomPortletModeImpl implements CustomPortletMode {
   
   private String pm;
   private boolean managed;
   private final List<Description> descs = new ArrayList<Description>();

   /**
    * constructor
    */
   public CustomPortletModeImpl(String cpm) {
      pm = cpm;
      managed = true;
   }
   
   /**
    * Copy constructor
    */
   public CustomPortletModeImpl(CustomPortletMode cpm) {
      pm = cpm.getPortletMode();
      managed = cpm.isPortalManaged();
      for (Description desc : cpm.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
   }
   
   /**
    * Constructor
    * @param pm      portlet mode name
    * @param mngd    portal managed flag
    * @param descs   description map
    */
   public CustomPortletModeImpl(String pm, boolean mngd, List<Description> descs) {
      this.pm = pm;
      this.managed = mngd;
      this.descs.addAll(descs);
   }
   
   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#getPortletMode()
    */
   @Override
   public String getPortletMode() {
      return pm;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#isPortalManaged()
    */
   @Override
   public boolean isPortalManaged() {
      return managed;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#setPortalManaged(boolean)
    */
   @Override
   public void setPortalManaged(boolean portalManaged) {
      managed = portalManaged;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#getDescription(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.CustomPortletMode#addDescription(Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((pm == null) ? 0 : pm.hashCode());
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
      CustomPortletModeImpl other = (CustomPortletModeImpl) obj;
      if (pm == null) {
         if (other.pm != null) {
            return false;
         }
      } else if (!pm.equals(other.pm)) {
         return false;
      }
      return true;
   }

}
