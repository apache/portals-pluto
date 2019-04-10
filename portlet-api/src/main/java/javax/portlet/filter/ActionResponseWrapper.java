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

import java.io.IOException;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;

/**
 * <span class="changed_modified_3_0">The</span> 
 * <code>ActionResponseWrapper</code> provides a convenient 
 * implementation of the <code>ActionResponse</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see ActionResponse
 */
public class ActionResponseWrapper extends StateAwareResponseWrapper implements ActionResponse {

   /**
    * Creates an <code>ActionResponse</code> adaptor 
    * wrapping the given response object.
    * 
    * @param response  the action response to wrap
    * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
    */
   public ActionResponseWrapper(ActionResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public ActionResponse getResponse() {
      return (ActionResponse) response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response the response to set
    * @throws java.lang.IllegalArgumentException   if the response is null.
    */
   public void setResponse(ActionResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#sendRedirect(java.lang.String)
    */
   @Override
   public void sendRedirect(String location) throws IOException {
      ((ActionResponse)response).sendRedirect(location);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#sendRedirect(java.lang.String, java.lang.String)
    */
   @Override
   public void sendRedirect(String location, String renderUrlParamName) throws IOException {
      ((ActionResponse)response).sendRedirect(location, renderUrlParamName);
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#createRedirectURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public RenderURL createRedirectURL(Copy option) throws IllegalStateException {
      return ((ActionResponse)response).createRedirectURL(option);
   }

}
