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

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.portlet.PortletAsyncContext;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletRequestScoped;

/**
 * The asynchronous thread for the chat room application. The run() method is executed
 * in an asynchronous thread started by the resource method. This is a portlet request
 * scoped bean so that each resource method call gets a new instance.
 * 
 * @author Scott Nicklous
 */
@PortletRequestScoped
public class ChatRoomRunner implements Runnable {
   
   private static long DELAY = 100;       // check for changes every 100mS

   private PortletAsyncContext portletAsyncContext;
   private boolean refresh;
   
   // Illustrates use of CDI injection in the asynchronous thread
   @Inject private ChatHistory history;
   @Inject private ChatRoomListener listener;
   
   public void init(PortletAsyncContext ctx, boolean refresh) {
      this.portletAsyncContext = ctx;
      this.refresh = refresh;
   }

   @Override
   public void run() {
      
      try {
         ResourceResponse resp = portletAsyncContext.getResourceResponse();
         PrintWriter writer = resp.getWriter();
         
         // 1st time after page refresh
         if (refresh && history.getNumberOfMessages() > 0) {
            writer.write(history.getMarkup());
            portletAsyncContext.complete();
            return;
         }

         // The runner works by polling for a change in the number of stored messages
         // in the chat history. When the number of messages changes, the runner retrieves
         // the markup and sends it to the client through the resource response.
         
         int oldMsgs = history.getNumberOfMessages();
         int newMsgs;
         do {
            Thread.sleep(DELAY);
            newMsgs = history.getNumberOfMessages();
            if (listener.isTimeout()) {
               return;
            }
         } while (newMsgs == oldMsgs);
         
         String markup = "<p/>";
         if (newMsgs > 0) {
            markup = history.getMarkup();
         }
         
         writer.write(markup);
         
         // After writing output to the response, the asynchronous response must be
         // marked as complete using the portlet asynchronous context complete() method,
         // otherwise the container won't respond until the asynchronous request times out.
         
         portletAsyncContext.complete();
         
      } catch (Exception e) {}

   }

}
