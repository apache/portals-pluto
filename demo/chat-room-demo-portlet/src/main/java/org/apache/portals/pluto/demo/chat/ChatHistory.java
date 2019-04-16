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

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Manages the chat history by maintaining a list of messages entered. This is an
 * application scoped bean, so all portlet instances see the same view.
 * 
 * @author Scott Nicklous
 */
@ApplicationScoped
public class ChatHistory {

   private List<String>        messages = Collections.synchronizedList(new ArrayList<String>());
   
   // Injects the name bean in order to prepend the name to the message

   @Inject
   private NameBean            nameBean;

   /**
    * Adds a new chat message
    */
   public void addMessage(String message) {
      String name = nameBean.getName();
      if (name == null || name.length() == 0) {
         name = "World";
      }
      messages.add(name + ": " + message);
   }

   /**
    * returns the number of messages. Used in order to poll for changes.
    */
   public int getNumberOfMessages() {
      return messages.size();
   }

   /**
    * returns the markup for the stored messages
    */
   public String getMarkup() {
      StringBuilder txt = new StringBuilder(128);
      synchronized (messages) {
         for (String msg : messages) {
            txt.append("<p>").append(StringEscapeUtils.escapeHtml4(msg)).append("</p>\n");
         }
      }
      return txt.toString();
   }

   /**
    * clears all stored messages
    */
   public void clear() {
      messages.clear();
   }
}
