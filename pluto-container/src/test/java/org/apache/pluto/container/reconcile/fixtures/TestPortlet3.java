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


package org.apache.pluto.container.reconcile.fixtures;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class TestPortlet3 implements Portlet {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   private PortletConfig config;

   @Override
   public void destroy() {
      meths.addMethod(this.getClass().getSimpleName() + "#destroy");
      meths.setConfigExists(config != null);
   }

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.config = config;
      meths.addMethod(this.getClass().getSimpleName() + "#init");
      meths.setConfigExists(config != null);
   }

   @Override
   public void processAction(ActionRequest arg0, ActionResponse arg1)
         throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#processAction");
      meths.setConfigExists(config != null);
   }

   @Override
   public void render(RenderRequest arg0, RenderResponse arg1)
         throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#render");
      meths.setConfigExists(config != null);
   }

}
