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

import org.apache.pluto.container.om.portlet.LocaleText;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Portlet info
 * 
 * @author Scott Nicklous
 *
 */
public class PortletInfoImpl implements PortletInfo {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletInfoImpl.class);
   
   private final List<LocaleText> titles = new ArrayList<LocaleText>();
   private final List<LocaleText> keywords = new ArrayList<LocaleText>();
   private final List<LocaleText> sTitles = new ArrayList<LocaleText>();

   /**
    * default constructor
    */
   public PortletInfoImpl() {
   }
   
   /**
    * Copy constructor 
    */
   public PortletInfoImpl(PortletInfo pi) {
      
      for (LocaleText lt : pi.getTitles()) {
         this.titles.add(new LocaleTextImpl(lt));
      }
      
      for (LocaleText lt : pi.getShortTitles()) {
         this.sTitles.add(new LocaleTextImpl(lt));
      }
      
      for (LocaleText lt : pi.getKeywordsList()) {
         this.keywords.add(new LocaleTextImpl(lt));
      }
  }
   
   /**
    * Constructor - JSR 286 compat
    * @param ti      title
    * @param kw      keywords
    * @param sti     short title
    */
   public PortletInfoImpl(String ti, String kw, String sti) {
      
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, ti);
      titles.add(lt);
      lt = new LocaleTextImpl(Locale.ENGLISH, sti);
      sTitles.add(lt);
      lt = new LocaleTextImpl(Locale.ENGLISH, kw);
      keywords.add(lt);
      
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getTitle()
    */
   @Override
   public String getTitle() {
      LocaleText lt = null;
      for (LocaleText title : titles) {
         if (title.getLocale().equals(Locale.ENGLISH)) {
            lt = title;
            break;
         }
      }
      return (lt == null) ? null : lt.getText();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setTitle(java.lang.String)
    */
   @Override
   public void setTitle(String title) {
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, title);
      titles.add(lt);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getTitle(java.util.Locale)
    */
   @Override
   public LocaleText getTitle(Locale locale) {
      LocaleText ret = null;
      for (LocaleText item : titles) {
         if (item.getLocale().equals(locale)) {
            ret = new LocaleTextImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getTitles()
    */
   @Override
   public List<LocaleText> getTitles() {
      return new ArrayList<LocaleText>(titles);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addTitle(org.apache.pluto.container.om.portlet.LocaleText)
    */
   @Override
   public void addTitle(LocaleText title) {
      if (titles.remove(title)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate description for locale: ").append(title.getLocale().toString());
         txt.append(", description: ").append(title.getText());
         LOG.debug(txt.toString());
      }
      titles.add(title);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getKeywords()
    */
   @Override
   public String getKeywords() {
      LocaleText lt = null;
      for (LocaleText kw : keywords) {
         if (kw.getLocale().equals(Locale.ENGLISH)) {
            lt = kw;
            break;
         }
      }
      return (lt == null) ? null : lt.getText();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setKeywords(java.lang.String)
    */
   @Override
   public void setKeywords(String keywords) {
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, keywords);
      this.keywords.add(lt);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getKeywordsList(java.util.Locale)
    */
   @Override
   public LocaleText getKeywords(Locale locale) {
      LocaleText ret = null;
      for (LocaleText item : keywords) {
         if (item.getLocale().equals(locale)) {
            ret = new LocaleTextImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getKeywords()
    */
   @Override
   public List<LocaleText> getKeywordsList() {
      return new ArrayList<LocaleText>(keywords);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addKeywords(org.apache.pluto.container.om.portlet.LocaleText)
    */
   @Override
   public void addKeywords(LocaleText kw) {
      if (keywords.remove(kw)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate description for locale: ").append(kw.getLocale().toString());
         txt.append(", description: ").append(kw.getText());
         LOG.debug(txt.toString());
      }
      keywords.add(kw);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getShortTitle()
    */
   @Override
   public String getShortTitle() {
      LocaleText lt = null;
      for (LocaleText title : sTitles) {
         if (title.getLocale().equals(Locale.ENGLISH)) {
            lt = title;
            break;
         }
      }
      return (lt == null) ? null : lt.getText();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setShortTitle(java.lang.String)
    */
   @Override
   public void setShortTitle(String shortTitle) {
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, shortTitle);
      sTitles.add(lt);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getShortTitle(java.util.Locale)
    */
   @Override
   public LocaleText getShortTitle(Locale locale) {
      LocaleText ret = null;
      for (LocaleText item : sTitles) {
         if (item.getLocale().equals(locale)) {
            ret = new LocaleTextImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getShortTitles()
    */
   @Override
   public List<LocaleText> getShortTitles() {
      return new ArrayList<LocaleText>(sTitles);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addShortTitle(org.apache.pluto.container.om.portlet.LocaleText)
    */
   @Override
   public void addShortTitle(LocaleText st) {
      if (sTitles.remove(st)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate description for locale: ").append(st.getLocale().toString());
         txt.append(", description: ").append(st.getText());
         LOG.debug(txt.toString());
      }
      sTitles.add(st);
   }

}
