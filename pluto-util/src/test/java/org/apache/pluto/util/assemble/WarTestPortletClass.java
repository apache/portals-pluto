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


package org.apache.pluto.util.assemble;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Dummy portlet for test
 * 
 * @author Scott Nicklous
 *
 */
public class WarTestPortletClass implements Portlet {

   /* (non-Javadoc)
    * @see javax.portlet.Portlet#destroy()
    */
   @Override
   public void destroy() {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see javax.portlet.Portlet#init(javax.portlet.PortletConfig)
    */
   @Override
   public void init(PortletConfig arg0) throws PortletException {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
    */
   @Override
   public void processAction(ActionRequest arg0, ActionResponse arg1)
         throws PortletException, IOException {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
    */
   @Override
   public void render(RenderRequest arg0, RenderResponse arg1)
         throws PortletException, IOException {
      // TODO Auto-generated method stub

   }

}
