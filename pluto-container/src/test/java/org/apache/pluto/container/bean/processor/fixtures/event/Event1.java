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


package org.apache.pluto.container.bean.processor.fixtures.event;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
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
            @EventDefinition(qname=@PortletQName(namespaceURI="https://www.java.net/", localPart="pub4")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="proc1")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="proc2")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="proc3a")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="proc3c")),
            @EventDefinition(qname=@PortletQName(namespaceURI="https://www.java.net/", localPart="proc3b")),
            @EventDefinition(qname=@PortletQName(namespaceURI="http://www.apache.org", localPart="proc6")),
            @EventDefinition(qname=@PortletQName(namespaceURI="", localPart="event4"))
      }
      )
public class Event1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @EventMethod(portletName="portlet1", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc1")
         },
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub1")
         })
   public void event1(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event1");
   }
   
   @EventMethod(portletName="portlet2", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc2")
         })
   public void event2(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event2");
   }
   
   // dummy render method to keep config processor happy
   
   @RenderMethod(portletNames= {"portlet1", "portlet2"})
   public void render1() {}
   

}
