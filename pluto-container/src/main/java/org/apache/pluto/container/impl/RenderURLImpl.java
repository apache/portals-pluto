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

import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;

import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * @author Scott Nicklous
 *
 */
public class RenderURLImpl extends PortletURLImpl implements RenderURL {

   /**
    * @param responseContext
    * @param copy 
    */
   public RenderURLImpl(PortletResponseContext responseContext, Copy copy) {
      super(responseContext,
            responseContext.getPortletURLProvider(PortletURLProvider.TYPE.RENDER), copy);
   }

   @Override
   public void setFragmentIdentifier(String fragment) {
      urlProvider.setFragmentIdentifier(fragment);
   }

   @Override
   public String getFragmentIdentifier() {
      return urlProvider.getFragmentIdentifier();
   }

}
