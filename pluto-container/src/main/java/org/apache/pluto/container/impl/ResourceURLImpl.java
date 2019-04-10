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

package org.apache.pluto.container.impl;

import javax.portlet.MutableResourceParameters;
import javax.portlet.ResourceURL;

import org.apache.pluto.container.PortletMimeResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * @author nick
 * 
 */
public class ResourceURLImpl extends BaseURLImpl implements ResourceURL {

   private String cacheLevel = ResourceURL.PAGE;

   /**
    * @param responseContext
    */
   public ResourceURLImpl(PortletMimeResponseContext responseContext) {
      super(responseContext, 
            responseContext.getPortletURLProvider(PortletURLProvider.TYPE.RESOURCE));
   }

   /**
    * @param responseContext
    * @param cacheLevel
    */
   public ResourceURLImpl(PortletMimeResponseContext responseContext,
         String cacheLevel) {
      this(responseContext);
      if (cacheLevel != null) {
         this.cacheLevel = cacheLevel;
      }
      urlProvider.setCacheability(this.cacheLevel);
   }

   public String getCacheability() {
      return urlProvider.getCacheability();
   }

   public void setCacheability(String cacheLevel) {
      ArgumentUtility.validateNotEmpty("cachelevel", cacheLevel);
      if (FULL.equals(cacheLevel)) {
         // always OK
      } else if (PORTLET.equals(cacheLevel)) {
         if (FULL.equals(this.cacheLevel)) {
            throw new IllegalStateException(
                  "Current request cacheablility is FULL: URLs with cacheability PORTLET not allowed");
         }

      } else if (PAGE.equals(cacheLevel)) {
         if (FULL.equals(this.cacheLevel)) {
            throw new IllegalStateException(
                  "Current request cacheablility is FULL: URLs with cacheability PORTLET not allowed");
         } else if (PORTLET.equals(this.cacheLevel)) {
            throw new IllegalStateException(
                  "Current request cacheablility is PORTLET: URLs with cacheability PAGE not allowed");
         }
      } else {
         throw new IllegalArgumentException("Unknown cacheLevel: " + cacheLevel);
      }
      urlProvider.setCacheability(cacheLevel);
   }

   public void setResourceID(String resourceID) {
      urlProvider.setResourceID(resourceID);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.ResourceURL#getResourceParameters()
    */
   public MutableResourceParameters getResourceParameters() {
      return new MutableResourceParametersImpl(urlProvider, windowId);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.ResourceURL#getResourceID()
    */
   public String getResourceID() {
      return urlProvider.getResourceID();
   }

}
