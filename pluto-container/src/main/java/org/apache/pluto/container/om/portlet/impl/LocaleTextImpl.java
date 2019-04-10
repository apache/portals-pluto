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

import org.apache.pluto.container.om.portlet.LocaleText;

/**
 * A single locale-specific text
 * 
 * @author Scott Nicklous
 *
 */
public class LocaleTextImpl implements LocaleText {
   
   private Locale locale;
   private String text;
   
   /**
    * default: lang = english
    */
   public LocaleTextImpl() {
      locale = Locale.ENGLISH;
      text = "";
   }
   
   /**
    * Constructor
    * @param locale     Locale language tag according to BCP 47
    * @param disp       text string
    */
   public LocaleTextImpl(Locale locale, String text) {
      this.locale = locale;
      this.text = text;
   }
   
   /**
    * Copy constructor
    */
   public LocaleTextImpl(LocaleText lt) {
      this.locale = (Locale) lt.getLocale().clone();
      this.text = lt.getText();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Text#getLang()
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
    * @see org.apache.pluto.container.om.portlet.Text#getText()
    */
   @Override
   public String getText() {
      return text;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Text#setText(java.lang.String)
    */
   @Override
   public void setText(String text) {
      this.text = text;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Text#getLocale()
    */
   @Override
   public Locale getLocale() {
      return Locale.forLanguageTag(locale.toLanguageTag());
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
      LocaleTextImpl other = (LocaleTextImpl) obj;
      if (locale == null) {
         if (other.locale != null) {
            return false;
         }
      } else if (!locale.equals(other.locale)) {
         return false;
      }
      return true;
   }

}
