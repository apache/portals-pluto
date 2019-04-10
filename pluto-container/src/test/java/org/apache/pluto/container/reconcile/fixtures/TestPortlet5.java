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
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.InitParameter;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletConfigurations;
import javax.portlet.annotations.PortletQName;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
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
@PortletConfigurations( {
   @PortletConfiguration(portletName="Portlet5", 
   initParams = {
         @InitParameter(name="color", value="#cafeba"),
      },
      description={
         @LocaleString("Portlet displaying the time in different time zones"),
      }, displayName={
         @LocaleString("Time Zone Clock Portlet"),
      }, title={
         @LocaleString("Annotated Portlet"),
      }, shortTitle={
         @LocaleString("Anno Portlet"),
      }, keywords={
         @LocaleString("One, Two, Three"),
      }
   ),
})
public class TestPortlet5 extends GenericPortlet {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();

   @Override
   public void destroy() {
      meths.addMethod(this.getClass().getSimpleName() + "#destroy");
      meths.setConfigExists(getPortletConfig() != null);
      super.destroy();
   }

   @Override
   public void init(PortletConfig config) throws PortletException {
      super.init(config);
      meths.addMethod(this.getClass().getSimpleName() + "#init");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void processAction(ActionRequest arg0, ActionResponse arg1) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#processAction");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   @EventMethod(portletName="Portlet5", processingEvents= {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="event1"),
         @PortletQName(namespaceURI="", localPart="event4"),
   })
   public void processEvent(EventRequest arg0, EventResponse arg1) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#processEvent");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void render(RenderRequest arg0, RenderResponse arg1) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#render");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void renderHeaders(HeaderRequest request, HeaderResponse response) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#renderHeaders");
      meths.setConfigExists(getPortletConfig() != null);
   }

   @Override
   public void serveResource(ResourceRequest arg0, ResourceResponse arg1) throws PortletException, IOException {
      meths.addMethod(this.getClass().getSimpleName() + "#serveResource");
      meths.setConfigExists(getPortletConfig() != null);
   }
   
}
