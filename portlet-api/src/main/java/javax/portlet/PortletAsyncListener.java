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

import java.io.IOException;

/**
 * <div class="changed_added_3_0">
 * Listener that will be notified in the event that an asynchronous operation
 * initiated on a <code>ResourceRequest</code> to which the listener had been added has
 * completed, timed out, or resulted in an error.
 * </div>
 * 
 * @see     PortletAsyncContext
 * @see     PortletAsyncEvent
 * @since   3.0
 */
public interface PortletAsyncListener {

   /**
    * <div class="changed_added_3_0">
    * Notifies this <code>PortletAsyncListener</code> that an asynchronous operation
    * has been completed.
    * <p>
    * The <code>PortletAsyncContext</code> corresponding to the asynchronous
    * operation that has been completed may be obtained by calling
    * <code>getAsyncContext</code> on the given event.
    * <p>
    * In addition, if this <code>PortletAsyncListener</code> had been registered
    * via a call to <code>PortletAsyncContext#addListener(PortletAsyncListener,
    * ResourceRequest, ResourceResponse)</code>, the supplied
    * <code>ResourceRequest</code> and <code>ResourceResponse</code> objects may
    * be retrieved by calling <code>getSuppliedRequest</code> and
    * <code>getSuppliedResponse</code>, respectively, on the given event.
    * <p>
    * The <code>PortletAsyncContext</code> dispatch and complete methods may not be invoked
    * within this method.
    * </div>
    * 
    * @param evt  the <code>PortletAsyncEvent</code> indicating that an asynchronous operation has been completed 
    * @throws IOException  if an I/O related error has occurred during the processing
    */
   public void onComplete(PortletAsyncEvent evt) throws IOException;

   /**
    * <div class="changed_added_3_0">
    * Notifies this <code>PortletAsyncListener</code> that an asynchronous
    * operation has failed to complete.
    * <p>
    * The <code>PortletAsyncContext</code> corresponding to the asynchronous
    * operation that failed to complete may be obtained by calling
    * <code>getAsyncContext</code> on the given event.
    * <p>
    * In addition, if this <code>PortletAsyncListener</code> had been registered
    * via a call to <code>PortletAsyncContext#addListener(PortletAsyncListener,
    * ResourceRequest, ResourceResponse)</code>, the supplied
    * <code>ResourceRequest</code> and <code>ResourceResponse</code> objects may
    * be retrieved by calling <code>getSuppliedRequest</code> and
    * <code>getSuppliedResponse</code>, respectively, on the given event.
    * <p>
    * The <code>PortletAsyncContext</code> dispatch and complete methods may be invoked
    * within this method.
    * </div>
    * 
    * @param evt  the PortletAsyncEvent indicating that an asynchronous operation has 
    * encountered an error
    * @throws IOException  if an I/O related error has occurred during the processing
    */
   public void onError(PortletAsyncEvent evt) throws IOException;

   /**
    * <div class="changed_added_3_0">
    * Notifies this <code>PortletAsyncListener</code> that a new asynchronous cycle is
    * being initiated via a call to one of the <code>ResourceRequest</code>#startAsync
    * methods.
    * <p>
    * The <code>PortletAsyncContext</code> corresponding to the asynchronous
    * operation that is being reinitialized may be obtained by calling
    * <code>getAsyncContext</code> on the given event.
    * <p>
    * In addition, if this <code>PortletAsyncListener</code> had been registered
    * via a call to <code>PortletAsyncContext#addListener(PortletAsyncListener,
    * ResourceRequest, ResourceResponse)</code>, the supplied
    * <code>ResourceRequest</code> and <code>ResourceResponse</code> objects may
    * be retrieved by calling <code>getSuppliedRequest</code> and
    * <code>getSuppliedResponse</code>, respectively, on the given event.
    * <p> 
    * This <code>PortletAsyncListener</code> will not receive any events related
    * to the new asynchronous cycle unless it registers itself (via a call to
    * <code>PortletAsyncContext</code>#addListener) with the
    * <code>PortletAsyncContext</code> that is delivered as part of the given
    * event.
    * </div>
    * 
    * @param evt  the PortletAsyncEvent indicating that an asynchronous operation 
    * is being initiated
    * @throws IOException  if an I/O related error has occurred during the processing
    */
   public void onStartAsync(PortletAsyncEvent evt) throws IOException;

   /**
    * <div class="changed_added_3_0">
    * Notifies this <code>PortletAsyncListener</code> that an asynchronous operation
    * has timed out.
    * <p>
    * The <code>PortletAsyncContext</code> corresponding to the asynchronous
    * operation that has timed out may be obtained by calling
    * <code>getAsyncContext</code> on the given event.
    * <p>
    * In addition, if this <code>PortletAsyncListener</code> had been registered
    * via a call to <code>PortletAsyncContext#addListener(PortletAsyncListener,
    * ResourceRequest, ResourceResponse)</code>, the supplied
    * <code>ResourceRequest</code> and <code>ResourceResponse</code> objects may
    * be retrieved by calling <code>getSuppliedRequest</code> and
    * <code>getSuppliedResponse</code>, respectively, on the given event.
    * <p>
    * The <code>PortletAsyncContext</code> dispatch and complete methods may be invoked
    * within this method.
    * 
    * </div>
    * 
    * @param evt  the PortletAsyncEvent indicating that an asynchronous operation has
    * timed out
    * @throws IOException  if an I/O related error has occurred during the processing
    */
   public void onTimeout(PortletAsyncEvent evt) throws IOException;

}
