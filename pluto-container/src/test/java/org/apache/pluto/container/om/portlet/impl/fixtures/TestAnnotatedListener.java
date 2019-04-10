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


package org.apache.pluto.container.om.portlet.impl.fixtures;

import javax.portlet.ActionURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletListener;

/**
 * Annotated listener for unit testing.
 * @author Scott Nicklous
 */

@PortletListener(ordinal = 100,
listenerName = "aListener",
description = {
   @LocaleString("Quite the listener"),
   @LocaleString(locale="DE", value = "Ein ordentlicher Listener")},
displayName = {
   @LocaleString("A Listener"),
   @LocaleString(locale="DE", value = "Ein Listener")})
public class  TestAnnotatedListener implements
      PortletURLGenerationListener<RenderURL, ActionURL> {

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterActionURL(javax.portlet.PortletURL)
    */
   @Override
   public void filterActionURL(ActionURL arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterRenderURL(javax.portlet.PortletURL)
    */
   @Override
   public void filterRenderURL(RenderURL arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletURLGenerationListener#filterResourceURL(javax.portlet.ResourceURL)
    */
   @Override
   public void filterResourceURL(ResourceURL arg0) {
   }

}
