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

import org.apache.pluto.container.om.portlet.PortletInfo;

/**
 * Portlet info
 * 
 * @author Scott Nicklous
 *
 */
public class PortletInfoImpl implements PortletInfo {
   
   private String title;
   private String keywords;
   private String sTitle;
   
   
   /**
    * Copy constructor 
    */
   public PortletInfoImpl(PortletInfo pi) {
      title = pi.getTitle();
      keywords = pi.getKeywords();
      sTitle = pi.getShortTitle();
   }
   
   /**
    * Constructor
    * @param ti      title
    * @param kw      keywords
    * @param sti     short title
    */
   public PortletInfoImpl(String ti, String kw, String sti) {
      title = ti;
      keywords = kw;
      sTitle = sti;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getTitle()
    */
   @Override
   public String getTitle() {
      return title;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setTitle(java.lang.String)
    */
   @Override
   public void setTitle(String title) {
      this.title = title;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getKeywords()
    */
   @Override
   public String getKeywords() {
      return keywords;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setKeywords(java.lang.String)
    */
   @Override
   public void setKeywords(String keywords) {
      this.keywords = keywords;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#getShortTitle()
    */
   @Override
   public String getShortTitle() {
      return sTitle;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletInfo#setShortTitle(java.lang.String)
    */
   @Override
   public void setShortTitle(String shortTitle) {
      sTitle = shortTitle;
   }

}
