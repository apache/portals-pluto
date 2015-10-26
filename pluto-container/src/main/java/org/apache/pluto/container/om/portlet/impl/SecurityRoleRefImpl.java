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
import org.apache.pluto.container.om.portlet.SecurityRoleRef;

/**
 * A single event declaration
 * 
 * @author Scott Nicklous
 */
public class SecurityRoleRefImpl implements SecurityRoleRef {
   
   private String roleLink;
   private String roleName;
   private final List<Description> descs = new ArrayList<Description>();
   
   
   /**
    * Copy constructor
    * @param srr
    */
   public SecurityRoleRefImpl(SecurityRoleRef srr) {
      this.roleName = srr.getRoleName();
      this.roleLink = srr.getRoleLink();
      for (Description desc : srr.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
   }

   /**
    * Constructor
    * @param roleName      Role name
    */
   public SecurityRoleRefImpl(String roleName) {
      this.roleName = roleName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#getRoleName()
    */
   @Override
   public String getRoleName() {
      return roleName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#getRoleLink()
    */
   @Override
   public String getRoleLink() {
      return roleLink;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#setRoleLink(String)
    */
   @Override
   public void setRoleLink(String roleLink) {
      this.roleLink = roleLink;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#getDescription(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.SecurityRoleRef#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

}
