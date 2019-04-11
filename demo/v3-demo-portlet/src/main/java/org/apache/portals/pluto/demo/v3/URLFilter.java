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


package org.apache.portals.pluto.demo.v3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.portlet.ActionURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;

/**
 * @author nick
 *
 */
public class URLFilter implements PortletURLGenerationListener<RenderURL, ActionURL> {
   private static final Logger logger = LoggerFactory.getLogger(URLFilter.class);

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterActionURL(javax.portlet.PortletURL)
    */
   @Override
   public void filterActionURL(ActionURL actionURL) {
      if (logger.isDebugEnabled()) {
         logger.debug(this.getClass().getName(), "filterActionURL",
               "Filtered action URL. argument class: " + actionURL.getClass().getCanonicalName());
      }
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterRenderURL(javax.portlet.PortletURL)
    */
   @Override
   public void filterRenderURL(RenderURL renderURL) {
      // do nothing
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterResourceURL(javax.portlet.ResourceURL)
    */
   @Override
   public void filterResourceURL(ResourceURL resourceURL) {
      // do nothing
   }

}
