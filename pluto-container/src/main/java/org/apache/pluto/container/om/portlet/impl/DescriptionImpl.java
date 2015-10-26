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

import org.apache.pluto.container.om.portlet.Description;

/**
 * A single locale-specific description
 * 
 * @author Scott Nicklous
 *
 */
public class DescriptionImpl implements Description {
   
   private Locale locale;
   private String desc;
   
   /**
    * default: lang = english
    */
   public DescriptionImpl() {
      locale = Locale.ENGLISH;
      desc = "";
   }
   
   /**
    * Constructor
    * @param locale     Locale language tag according to BCP 47
    * @param disp       description string
    */
   public DescriptionImpl(Locale locale, String desc) {
      this.locale = locale;
      this.desc = desc;
   }
   
   /**
    * Copy constructor
    */
   public DescriptionImpl(Description di) {
      this.locale = (Locale) di.getLocale().clone();
      this.desc = di.getDescription();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Description#getLang()
    */
   @Override
   public String getLang() {
      return locale.toLanguageTag();
   }
   
   @Override
   public void setLang(String lang) {
      this.locale = Locale.forLanguageTag(lang);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Description#getDescription()
    */
   @Override
   public String getDescription() {
      return desc;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Description#setDescription(java.lang.String)
    */
   @Override
   public void setDescription(String description) {
      desc = description;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Description#getLocale()
    */
   @Override
   public Locale getLocale() {
      return Locale.forLanguageTag(locale.toLanguageTag());
   }

}
