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

import java.util.Map;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

/**
 * The <code>EventResponseWrapper</code> provides a convenient 
 * implementation of the <code>EventResponse</code> interface 
 * that can be subclassed by developers wishing to adapt the response.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see EventResponse
 */

public class EventResponseWrapper extends PortletResponseWrapper implements EventResponse {

    EventResponse response;
     
     /**
      * Creates an <code>EventResponse</code> adaptor 
      * wrapping the given response object.
      * 
      * @param response  the event response to wrap
      * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
      */
     public EventResponseWrapper(EventResponse response) {
    	 super(response);
         this.response = response;
     }

     /**
      * The default behavior of this method is to call 
      * <code>setEvent(name, value)</code> on the wrapped response object.
      */
     public void setEvent(QName name, java.io.Serializable value) {
         response.setEvent(name, value);
     }

     /**
      * The default behavior of this method is to call 
      * <code>setPortletMode(portletMode)</code> on the wrapped response object.
      */
     public void setPortletMode(PortletMode portletMode)
             throws PortletModeException {
         response.setPortletMode(portletMode);
     }

     /**
      * The default behavior of this method is to call 
      * <code>setRenderParameter(key, value)</code> on the wrapped response object.
      */
     public void setRenderParameter(String key, String value) {
         response.setRenderParameter(key, value);
     }

     /**
      * The default behavior of this method is to call 
      * <code>setRenderParameter(key, value)</code> on the wrapped response object.
      */
     public void setRenderParameter(String key, String[] values) {
         response.setRenderParameter(key, values);
     }

     /**
      * The default behavior of this method is to call 
      * <code>setRenderParameters(parameters)</code> on the wrapped response object.
      */
     public void setRenderParameters(Map<String, String[]> parameters) {
         response.setRenderParameters(parameters);
     }

     /**
      * The default behavior of this method is to call 
      * <code>setWindowState(windowState)</code> on the wrapped response object.
      */
     public void setWindowState(WindowState windowState)
             throws WindowStateException {
         response.setWindowState(windowState);
     }

     /**
      * Return the wrapped response object.
      * 
      * @return the wrapped response
      */
     public EventResponse getResponse() {
         return response;
     }

     /**
      * Sets the response object being wrapped.
      * 
      * @param response the response to set
      * @throws java.lang.IllegalArgumentException   if the response is null.
      */
     public void setResponse(EventResponse response) {
	    	if ( response == null)
	    		throw new java.lang.IllegalArgumentException("Response is null");

	    	this.response = response;
     }

     /**
      * The default behavior of this method is to call 
      * <code>getPortletMode()</code> on the wrapped response object.
      */
     public PortletMode getPortletMode() {
         return response.getPortletMode();
     }

     /**
      * The default behavior of this method is to call 
      * <code>getRenderParameterMap()</code> on the wrapped response object.
      */
     public Map<String, String[]> getRenderParameterMap() {
         return response.getRenderParameterMap();
     }

     /**
      * The default behavior of this method is to call 
      * <code>getWindowState()</code> on the wrapped response object.
      */
     public WindowState getWindowState() {
         return response.getWindowState();
     }

     /**
      *  The default behavior of this method is to call 
      * <code>setRenderParameters()</code> on the wrapped response object.
      */
     public void setRenderParameters(EventRequest request) {
         response.setRenderParameters(request);         
     }

     /**
      *  The default behavior of this method is to call 
      * <code>setEvent()</code> on the wrapped response object.
      */
 	public void setEvent(String name, java.io.Serializable value) {
 		response.setEvent(name, value);
 	}
 	
    /**
     *  The default behavior of this method is to call 
     * <code>removePublicRenderParameter()</code> on the wrapped response object.
     */
	public void removePublicRenderParameter(String name) {
		response.removePublicRenderParameter(name);		
	}

}
