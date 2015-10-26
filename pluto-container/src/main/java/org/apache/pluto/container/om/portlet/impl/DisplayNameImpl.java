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

import java.util.Locale;

import org.apache.pluto.container.om.portlet.DisplayName;

/**
 * A single locale-specific display name
 * 
 * @author Scott Nicklous
 *
 */
public class DisplayNameImpl implements DisplayName {
   
   private Locale locale;
   private String disp;
   
   /**
    * default: lang = english
    */
   public DisplayNameImpl() {
      locale = Locale.ENGLISH;
      disp = "";
   }
   
   /**
    * Constructor
    * @param locale     Locale language tag according to BCP 47
    * @param disp       description string
    */
   public DisplayNameImpl(Locale locale, String desc) {
      this.locale = locale;
      this.disp = desc;
   }
   
   /**
    * Copy constructor
    */
   public DisplayNameImpl(DisplayName di) {
      this.locale = (Locale) di.getLocale().clone();
      this.disp = di.getDisplayName();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.DisplayName#getLang()
    */
   @Override
   public String getLang() {
      return locale.toLanguageTag();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.DisplayName#getDisplayName()
    */
   @Override
   public String getDisplayName() {
      return disp;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.DisplayName#setDisplayName(java.lang.String)
    */
   @Override
   public void setDisplayName(String description) {
      disp = description;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.DisplayName#getLocale()
    */
   @Override
   public Locale getLocale() {
      return (Locale) locale.clone();
   }

}
