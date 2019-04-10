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

import javax.portlet.RenderRequest;

/**
 * <span class="changed_modified_3_0">The</span> 
 * <code>RenderRequestWrapper</code> provides a convenient 
 * implementation of the <code>RenderRequest</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 *
 * @since 2.0
 * @see RenderRequest
 */
public class RenderRequestWrapper extends PortletRequestWrapper implements RenderRequest {

   /**
    * Creates an <code>RenderRequest</code> adaptor 
    * wrapping the given request object.
    * 
    * @param request  the render request to wrap
    * @throws java.lang.IllegalArgumentException if the request is <code>null</code>
    */
   public RenderRequestWrapper(RenderRequest request) {
      super(request);
   }



   /**
    * Return the wrapped request object.
    * 
    * @return the wrapped request
    */
   public RenderRequest getRequest() {
      return (RenderRequest) super.getRequest();
   }

   /**
    * Sets the request object being wrapped.
    * 
    * @param request the request to set
    * @throws java.lang.IllegalArgumentException   if the request is null.
    */
   public void setRequest(RenderRequest request) {
      super.setRequest(request);
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderRequest#getETag()
    */
   @Override
   public String getETag() {
      return ((RenderRequest)wrapped).getETag();
   }


}
