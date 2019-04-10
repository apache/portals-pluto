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


package org.apache.pluto.container.bean.processor.fixtures.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
@PortletApplication(
      defaultNamespaceURI="https://www.java.net/",
      events = {
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="pub1")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="pub2")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="pub3")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="pub4")),
            @EventDefinition(qname=@PortletQName(namespaceURI="", localPart="event4"))
      }
      )
public class Action1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @ActionMethod(portletName="portlet1", 
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub1")
         })
   public void action1(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action1");
   }
   
   @ActionMethod(portletName="portlet2")
   public void action2(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action2");
   }
   
   // dummy render method to keep config processor happy
   
   @RenderMethod(portletNames= {"portlet1", "portlet2", "portlet3", "portlet6"})
   public void render1() {}

}
