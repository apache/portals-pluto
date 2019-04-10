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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.filter;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;

/**
 * <span class="changed_modified_3_0">The</span> 
 * <code>EventResponseWrapper</code> provides a convenient 
 * implementation of the <code>EventResponse</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see EventResponse
 */

public class EventResponseWrapper extends StateAwareResponseWrapper implements EventResponse {

   /**
    * Creates an <code>EventResponse</code> adaptor 
    * wrapping the given response object.
    * 
    * @param response  the event response to wrap
    * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
    */
   public EventResponseWrapper(EventResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public EventResponse getResponse() {
      return (EventResponse) response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response the response to set
    * @throws java.lang.IllegalArgumentException   if the response is null.
    */
   public void setResponse(EventResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.EventResponse#setRenderParameters(javax.portlet.EventRequest)
    */
   @Deprecated
   @Override
   public void setRenderParameters(EventRequest request) {
      ((EventResponse)response).setRenderParameters(request);         
   }
}
