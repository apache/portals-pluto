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

package org.apache.portals.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;

/**
 * @author Scott Nicklous
 *
 */
public class AsyncPortletListener implements AsyncListener {
   private static final Logger LOGGER = Logger.getLogger(AsyncPortletListener.class.getName());

   private long                start  = System.currentTimeMillis();

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
    */
   @Override
   public void onComplete(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Completed. Execution time: ").append(delta).append(" milliseconds.");

      LOGGER.fine(txt.toString());
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
    */
   @Override
   public void onError(AsyncEvent evt) throws IOException {

      // this doesn't seem to get called when an error occurs in the executor
      // thread.

      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Error after ").append(delta).append(" milliseconds.");
      txt.append(", Exception: ").append(evt.getThrowable().getMessage());

      LOGGER.fine(txt.toString());
      evt.getAsyncContext().complete();
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
    */
   @Override
   public void onStartAsync(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;
      StringBuilder txt = new StringBuilder(128);
      txt.append("Async started again after ").append(delta).append(" milliseconds.");
      LOGGER.fine(txt.toString());

      // need to add this listener again so it gets called when finally
      // complete.

      AsyncContext ctx = evt.getAsyncContext();
      ctx.addListener(this);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
    */
   @Override
   public void onTimeout(AsyncEvent evt) throws IOException {
      long delta = System.currentTimeMillis() - start;

      StringBuilder txt = new StringBuilder(128);
      txt.append("Listener: Timeout after ").append(delta).append(" milliseconds.");

      try {
         PrintWriter writer = evt.getAsyncContext().getResponse().getWriter();
         writer.println("<p>");
         writer.println(txt.toString());
         writer.println("</p>");
         evt.getAsyncContext().complete();
      } catch (Exception e) {
         txt.append(" Couldn't get response and complete. Exception: " + e.toString());
      }
      LOGGER.fine(txt.toString());
   }

}
