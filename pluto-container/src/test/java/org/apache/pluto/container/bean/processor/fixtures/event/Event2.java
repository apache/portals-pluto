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
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott
 *
 */
public class Event2 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @EventMethod(portletName="portlet3",
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc3a")
         },
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub1")
         })
   public void event1a(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event1a");
   }
   
   @EventMethod(portletName="portlet3",
         processingEvents= {
            @PortletQName(namespaceURI="", localPart="proc3b")
         },
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub2")
         })
   public void event1b(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event1b");
   }
   
   @EventMethod(portletName="portlet3",
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc3c")
         },
         publishingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="pub3"),
            @PortletQName(namespaceURI="", localPart="pub4")
         })
   public void event1c(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event1c");
   }
   
   // duplicate method
   @EventMethod(portletName="portlet2", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc2")
         })
   public void event2(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event2");
   }
   
   // invalid signature
   @EventMethod(portletName="portlet4", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc4")
         })
   public void event4(EventRequest req, EventResponse resp, int y) {
      meths.addMethod(this.getClass().getSimpleName() + "#event4");
   }
   
   // invalid signature
   @EventMethod(portletName="portlet5", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc5")
         })
   public String event5(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event5");
      return null;
   }

   // duplicate method in same class
   @EventMethod(portletName="portlet6", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc6")
         })
   public void event6(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event6");
   }

   // duplicate method in same class
   @EventMethod(portletName="portlet6", 
         processingEvents= {
            @PortletQName(namespaceURI="http://www.apache.org", localPart="proc6")
         })
   public void event7(EventRequest req, EventResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#event7");
   }
   
   // dummy render method to keep config processor happy
   
   @RenderMethod(portletNames= {"portlet3", "portlet6"})
   public void render1() {}


}
