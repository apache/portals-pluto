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


package org.apache.pluto.container.bean.processor.fixtures.mocks;

import java.util.Map;

import javax.portlet.PortletAsyncContext;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.DispatcherType;

/**
 * @author Scott Nicklous
 *
 */
public class MockResourceRequest extends MockClientDataRequest implements ResourceRequest {
   
   private String resourceId;

   /**
    * @return the resourceId
    */
   public String getResourceId() {
      return resourceId;
   }

   /**
    * @param resourceId the resourceId to set
    */
   public void setResourceId(String resourceId) {
      this.resourceId = resourceId;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceRequest#getCacheability()
    */
   @Override
   public String getCacheability() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceRequest#getETag()
    */
   @Override
   public String getETag() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceRequest#getPrivateRenderParameterMap()
    */
   @Override
   public Map<String, String[]> getPrivateRenderParameterMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceRequest#getResourceID()
    */
   @Override
   public String getResourceID() {
      return resourceId;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceRequest#getResourceParameters()
    */
   @Override
   public ResourceParameters getResourceParameters() {
      return null;
   }

   @Override
   public PortletAsyncContext startPortletAsync() throws IllegalStateException {
      return null;
   }

   @Override
   public PortletAsyncContext startPortletAsync(ResourceRequest request, ResourceResponse response) throws IllegalStateException {
      return null;
   }

   @Override
   public boolean isAsyncStarted() {
      return false;
   }

   @Override
   public boolean isAsyncSupported() {
      return false;
   }

   @Override
   public PortletAsyncContext getPortletAsyncContext() {
      return null;
   }

   @Override
   public DispatcherType getDispatcherType() {
      return null;
   }

}
