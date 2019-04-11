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


package org.apache.portals.pluto.demo.chat;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;

/**
 * Implements simple chat room functionality based on the asynchronous resource request.
 * 
 * @author Scott Nicklous
 */
@ApplicationScoped
@PortletConfiguration(
    portletName = "BeanPortletDemo",
    dependencies = {
        @Dependency(name="PortletHub", scope = "javax.portlet", version="3.0.0")
    }
)
public class ChatRoom {
   
   @Inject private ChatHistory history;
   @Inject private ChatRoomRunner runner;
   @Inject private ChatRoomListener listener;
   

   /**
    * Renders the chatroom markup through included jsp. Nothing needs to be done in the
    * renderChatRoom() method itself, so it is just more of a carrier for the annotation.  
    */
   @RenderMethod(portletNames="BeanPortletDemo", 
                 ordinal=400, 
                 include="/WEB-INF/jsp/chatroom.jsp")
   public void renderChatRoom() {}
   
   /**
    * Asynchronous resource method for obtaining chat history. The annotation activates
    * asynchronous support and specifies a resource ID that the client code can use 
    * when creating a resource URL to address this specific resource method. 
    */
   @ServeResourceMethod(portletNames = "BeanPortletDemo", 
                        asyncSupported = true,
                        resourceID="getChatHistory")
   public void getChatHistory(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
      
      // This is a resource parameter set by the client to indicate that the current
      // history should be provided even if there was no change since last checked.
      boolean refresh = new Boolean(req.getResourceParameters().getValue("refresh"));
      
      // When asynchronous processing is started, a PortletAsyncContext object is returned,
      // which can be used analogously to the AsyncContext object from the servlet world.
      // Here, we just set the timeout.
      
      PortletAsyncContext portletAsyncContext = req.startPortletAsync();
      portletAsyncContext.setTimeout(60000);
      portletAsyncContext.addListener(listener);
      
      // The injected ChatRoomRunner Runnable object is initialized by passing 
      // it the portlet async context and the refresh flag. After that, the asynchronous
      // thread is started through the PortletAsyncContext#start() method. If the thread
      // is started in this manner, the portlet container will maintain the proper 
      // execution context to allow portlet artifacts to be injected within the async
      // thread. This is not guaranteed if the thread is started in another manner.
      
      runner.init(portletAsyncContext, refresh);
      portletAsyncContext.start(runner);
      
   }
   
   /**
    * Action method for processing the message entry form.
    * If the action request contains an action parameter with the reserved
    * name 'javax.portlet.action' and value matching the actionName attribute,
    * the portlet the portlet container routes the request to this method.
    */
   @ActionMethod(portletName="BeanPortletDemo", actionName="addMessage")
   public void addMessage(ActionRequest req, ActionResponse resp) {
      String msg = req.getActionParameters().getValue("message");
      if (msg != null && msg.length() > 0) {
         history.addMessage(msg);
      }
   }
   
   /**
    * Action method for processing the history clear button.
    * If the action request contains an action parameter with the reserved
    * name 'javax.portlet.action' and value matching the actionName attribute,
    * the portlet the portlet container routes the request to this method.
    */
   @ActionMethod(portletName="BeanPortletDemo", actionName="clearHistory")
   public void clearHistory(ActionRequest req, ActionResponse resp) {
      history.clear();
   }

}
