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

import javax.portlet.Event;
import javax.portlet.EventRequest;

/**
 * The <code>EventRequestWrapper</code> provides a convenient 
 * implementation of the <code>EventRequest</code> interface 
 * that can be subclassed by developers wishing to adapt the request.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 *
 * @since 2.0
 * @see EventRequest
 */
public class EventRequestWrapper extends PortletRequestWrapper implements EventRequest {

    EventRequest request;
    
    
    /**
     * Creates an <code>EventRequest</code> adaptor 
     * wrapping the given request object.
     * 
     * @param request  the event request to wrap
     * @throws java.lang.IllegalArgumentException if the request is <code>null</code>
     */
    public EventRequestWrapper(EventRequest request) {
    	super(request);
    	this.request = request;
    }

    /**
     * Return the wrapped request object.
     * 
     * @return the wrapped request
     */
    public EventRequest getRequest() {
        return request;
    }

    /**
     * Sets the request object being wrapped.
     * 
     * @param request the request to set
     * @throws java.lang.IllegalArgumentException   if the request is null.
     */
    public void setRequest(EventRequest request) {
    	if ( request == null)
    		throw new java.lang.IllegalArgumentException("Request is null");

        this.request = request;
    }

    /**
     * The default behavior of this method is to call 
     * <code>getEvent()</code> on the wrapped request object.
     */
    public Event getEvent() {
        return request.getEvent();
    }

    /**
     *  The default behavior of this method is to call 
     * <code>getMethod()</code> on the wrapped request object.
     */
    public String getMethod() {
        return request.getMethod();
    }


}
