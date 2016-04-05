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


package javax.portlet;

import javax.servlet.ServletContext;


/**
 * <div class="changed_added_3_0">
 * Class representing the execution context for an asynchronous operation that was
 * initiated on a ResourceRequest.
 * <p>
 * A PortletAsyncContext is created and initialized by a call to
 * ResourceRequest#startAsync() or ResourceRequest#startAsync(ServletRequest,
 * ServletResponse). Repeated invocations of these methods will return the same
 * AsyncContext instance, reinitialized as appropriate.
 * <p>
 * In the event that an asynchronous operation has timed out, the container must
 * invoke, at their onTimeout method, all PortletAsyncListener instances registered
 * with the ResourceRequest on which the asynchronous operation was initiated.
 * If none of the listeners called complete() or any of the dispatch() methods,
 * complete the request on behalf of the application. * 
 * </div>
 * 
 * @see     javax.servlet.AsyncContext
 * @since   3.0
 */
public interface PortletAsyncContext {

   public void addListener(PortletAsyncListener listener);

   public void addListener(PortletAsyncListener listener, ResourceRequest request, ResourceResponse response);

   public void complete();

   public <T extends PortletAsyncListener> T createListener(Class<T> cls) throws PortletException;

   public void dispatch();

   public void dispatch(String path);

   public void dispatch(ServletContext context, String path);

   public ResourceRequest getRequest();

   public ResourceResponse getResponse();

   public long getTimeout();

   public boolean hasOriginalRequestAndResponse();

   public void setTimeout(long time);

   /**
    * <div class="changed_added_3_0">
    * </div>
    * 
    * @since   3.0
    * 
    * @param run
    */
   public void start(Runnable run);

}
