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
import org.apache.pluto.container.om.portlet.UserDataConstraint;

/**
 * A single event declaration
 * 
 * @author Scott Nicklous
 */
public class UserDataConstraintImpl implements UserDataConstraint {
   
   private String transportGuarantee;
   private final List<Description> descs = new ArrayList<Description>();
   
   
   /**
    * Copy constructor
    * @param udc
    */
   public UserDataConstraintImpl(UserDataConstraint udc) {
      this.transportGuarantee = udc.getTransportGuarantee();
      for (Description desc : udc.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
   }

   /**
    * Constructor
    * @param fn   UserDataConstraint name
    */
   public UserDataConstraintImpl(String udc) {
      this.transportGuarantee = udc;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.UserDataConstraint#getUserDataConstraintName()
    */
   @Override
   public String getTransportGuarantee() {
      return transportGuarantee;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.UserDataConstraint#getDescription(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.UserDataConstraint#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.UserDataConstraint#addDescription(org.apache.pluto.container.om.portlet.Description)
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
      result = prime * result + ((transportGuarantee == null) ? 0 : transportGuarantee.hashCode());
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
      UserDataConstraintImpl other = (UserDataConstraintImpl) obj;
      if (transportGuarantee == null) {
         if (other.transportGuarantee != null) {
            return false;
         }
      } else if (!transportGuarantee.equals(other.transportGuarantee)) {
         return false;
      }
      return true;
   }

}
