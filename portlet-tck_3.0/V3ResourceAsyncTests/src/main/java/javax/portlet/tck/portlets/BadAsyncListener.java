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


package javax.portlet.tck.portlets;

import java.io.IOException;

import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;

/**
 * @author Scott Nicklous
 *
 */
public class BadAsyncListener implements PortletAsyncListener {
   
   public BadAsyncListener() {
      throw new Error("Unconstructable class.");
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onComplete(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onComplete(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onError(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onError(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onStartAsync(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onStartAsync(PortletAsyncEvent evt) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletAsyncListener#onTimeout(javax.portlet.PortletAsyncEvent)
    */
   @Override
   public void onTimeout(PortletAsyncEvent evt) throws IOException {
   }

}
