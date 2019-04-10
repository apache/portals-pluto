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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.PortletQName;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * A bean portlet with configuration values.
 * 
 * @author Scott Nicklous
 *
 */
public class TestPortlet1a {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @ActionMethod(portletName="Portlet1", actionName="Fred", publishingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="event2"),
         @PortletQName(namespaceURI="", localPart="event3"),
         @PortletQName(namespaceURI="unknown", localPart="anotherBad"),
   })
   public void doAction(ActionRequest req, ActionResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#doAction");
      meths.setConfigExists(false);
   }
   
   @EventMethod(portletName="Portlet1", 
         processingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="event1"),
         @PortletQName(namespaceURI="", localPart="event3"),
         @PortletQName(namespaceURI="unknown", localPart="eventBad"),
   },
         publishingEvents = {
         @PortletQName(namespaceURI="", localPart="event4"),
   })
   public void doEvent(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#doEvent");
      meths.setConfigExists(false);
   }

}
