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

import java.util.Collection;

import javax.portlet.PortletMode;
import javax.portlet.RenderResponse;

/**
 * <span class="changed_modified_3_0">The</span> <code>RenderResponseWrapper</code> provides a convenient 
 * implementation of the <code>RenderResponse</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see RenderResponse
 */

public class RenderResponseWrapper extends MimeResponseWrapper implements RenderResponse {

   /**
    * Creates an <code>RenderResponse</code> adaptor 
    * wrapping the given response object.
    * 
    * @param response  the event response to wrap
    * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
    */
   public RenderResponseWrapper(RenderResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public RenderResponse getResponse() {
      return (RenderResponse) response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response the response to set
    * @throws java.lang.IllegalArgumentException   if the response is null.
    */
   public void setResponse(RenderResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderResponse#setTitle(java.lang.String)
    */
   @Deprecated
   @Override
   public void setTitle(String title) {
      ((RenderResponse)response).setTitle(title);
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderResponse#setNextPossiblePortletModes(java.util.Collection)
    */
   @Override
   public void setNextPossiblePortletModes(Collection<? extends PortletMode> portletModes) {
      ((RenderResponse)response).setNextPossiblePortletModes(portletModes);
   }

}
