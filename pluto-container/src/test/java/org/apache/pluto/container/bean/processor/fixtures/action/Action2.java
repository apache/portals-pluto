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
import javax.portlet.annotations.PortletQName;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class Action2 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @ActionMethod(portletName="portlet3",
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub1")
         })
   public void action1a(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action1a");
   }
   
   @ActionMethod(portletName="portlet3", actionName="Fred",
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub2")
         })
   public void action1b(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action1b");
   }
   
   @ActionMethod(portletName="portlet3", actionName="Barney",
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub3"),
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub4")
         })
   public void action1c(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action1c");
   }
   
   // duplicate method
   @ActionMethod(portletName="portlet2")
   public void action2(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action2");
   }
   
   // invalid signature
   @ActionMethod(portletName="portlet4")
   public void action4(ActionRequest req, ActionResponse resp, int y) {
      meths.addMethod(this.getClass().getSimpleName() + "#action3");
   }
   
   // invalid signature
   @ActionMethod(portletName="portlet5")
   public String action5(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action5");
      return null;
   }

   // duplicate method, same action name
   @ActionMethod(portletName="portlet6", actionName="Wilma")
   public void action6(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action6");
   }

   // duplicate method, same action name
   @ActionMethod(portletName="portlet6", actionName="Wilma")
   public void action7(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#action7");
   }

}
