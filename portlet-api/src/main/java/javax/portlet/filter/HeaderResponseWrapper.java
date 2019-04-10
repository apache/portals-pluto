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

package javax.portlet.filter;

import javax.portlet.HeaderResponse;

/**
 * <div class="changed_added_3_0"> The <code>HeaderResponseWrapper</code>
 * provides a convenient implementation of the <code>HeaderResponse</code>
 * interface that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. Methods default to
 * calling through to the wrapped Response object. </div>
 * 
 * @since 3.0
 */
public class HeaderResponseWrapper extends MimeResponseWrapper implements HeaderResponse {

   /**
    * @param response
    */
   public HeaderResponseWrapper(HeaderResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public HeaderResponse getResponse() {
      return (HeaderResponse) response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response
    *           the response to set
    * @throws java.lang.IllegalArgumentException
    *            if the response is null.
    */
   public void setResponse(HeaderResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.HeaderResponse#setTitle(java.lang.String)
    */
   @Override
   public void setTitle(String title) {
      ((HeaderResponse)response).setTitle(title);
   }

   /* (non-Javadoc)
    * @see javax.portlet.HeaderResponse#addDependency(java.lang.String, java.lang.String, java.lang.String)
    */
   @Override
   public void addDependency(String name, String scope, String version) {
      ((HeaderResponse)response).addDependency(name, scope, version);
   }

   /* (non-Javadoc)
    * @see javax.portlet.HeaderResponse#addDependency(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
    */
   @Override
   public void addDependency(String name, String scope, String version, String markup) {
      ((HeaderResponse)response).addDependency(name, scope, version, markup);
   }

}
