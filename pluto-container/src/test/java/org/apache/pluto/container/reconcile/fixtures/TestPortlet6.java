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
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * Portlet for testing invocation of GenericPortlet method features.
 *  
 * @author Scott Nicklous
 *
 */
@PortletApplication(
      defaultNamespaceURI="https://www.java.net/",
      events = {
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org/", localPart="event1")),
            @EventDefinition(qname=@PortletQName(namespaceURI="", localPart="event4"))
      }
)
@PortletConfiguration(portletName="Portlet6")
public class TestPortlet6 extends GenericPortlet {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();

   @Override
   public void init() {
      meths.addMethod(this.getClass().getSimpleName() + "#init");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void doView(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#doView");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doEdit");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void doHeaders(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doHeaders");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doHelp");
      meths.setConfigExists(getPortletConfig() != null);
   }
 
   @RenderMode(name="config")
   public void doConfig(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doConfig");
      meths.setConfigExists(getPortletConfig() != null);
   }
   
   @RenderMode(name="admin")
   public void doAdmin(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doAdmin");
      meths.setConfigExists(getPortletConfig() != null);
   }
   
   @ProcessAction(name="Fred")
   public void doFred(ActionRequest request, ActionResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doFred");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @ProcessEvent(qname="{http://www.apache.org/}event1")
   public void doEvent1(EventRequest request, EventResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doEvent1");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @ProcessEvent(qname="{https://www.java.net/}event4")
   public void doEvent4(EventRequest request, EventResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#doEvent4");
      meths.setConfigExists(getPortletConfig() != null);
   }

}
