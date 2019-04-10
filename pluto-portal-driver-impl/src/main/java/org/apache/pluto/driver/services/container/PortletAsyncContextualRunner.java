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


package org.apache.pluto.driver.services.container;

import org.apache.pluto.container.PortletAsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner that is launched in thread on behalf of the portlet application runnable 
 * in order to initialize contextual information.
 * 
 * @author Scott Nicklous
 *
 */
public class PortletAsyncContextualRunner implements Runnable {
   private static final Logger LOG = LoggerFactory.getLogger(PortletAsyncContextualRunner.class);
   private static final boolean isTrace = LOG.isTraceEnabled();
   

   private PortletAsyncManager pactx;
   private Runnable targetRunner; 

   public PortletAsyncContextualRunner() {
   }
   
   public void init(PortletAsyncManager pactx, Runnable targetRunner) {
      this.pactx = pactx;
      this.targetRunner = targetRunner;
   }

   @Override
   public void run() {
      if (isTrace) {
         LOG.trace("Initializing contextual environment and launching runner in thread: " + Thread.currentThread().getId());
      }

      try {
         pactx.registerContext(false);
         targetRunner.run();
      } catch (Exception e) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Exception running thread: ").append(e.toString());
      } finally {
         if (isTrace) {
            LOG.trace("Shutting down contextual environment for thread: " + Thread.currentThread().getId());
         }
         pactx.deregisterContext(false);
      }
}

}
