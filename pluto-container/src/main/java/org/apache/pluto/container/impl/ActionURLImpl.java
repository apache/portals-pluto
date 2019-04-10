package org.apache.pluto.container.impl;

import javax.portlet.ActionURL;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.MutableActionParameters;

import org.apache.pluto.container.PortletMimeResponseContext;
import org.apache.pluto.container.PortletURLProvider;

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

/**
 * @author nick
 *
 */
public class ActionURLImpl extends PortletURLImpl implements ActionURL {

   /**
    * @param responseContext
    * @param copy
    */
   public ActionURLImpl(PortletMimeResponseContext responseContext, Copy copy) {
      super(responseContext, 
            responseContext.getPortletURLProvider(PortletURLProvider.TYPE.ACTION), copy);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionURL#getActionParameters()
    */
   public MutableActionParameters getActionParameters() {
      return new MutableActionParametersImpl(urlProvider, windowId);
   }

}
