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

import java.io.Serializable;
import java.util.Map;

import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

/**
 * <div class="changed_added_3_0">
 * The <code>StateAwareResponseWrapper</code> provides a convenient 
 * implementation of the <code>StateAwareResponse</code> interface 
 * that can be subclassed by developers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped Response object.
 * </div>
 * 
 * @since 3.0
 */
public class StateAwareResponseWrapper extends PortletResponseWrapper implements StateAwareResponse {

   /**
    * @param response
    */
   public StateAwareResponseWrapper(StateAwareResponse response) {
      super(response);
   }

   /**
    * Return the wrapped response object.
    * 
    * @return the wrapped response
    */
   public StateAwareResponse getResponse() {
      return (StateAwareResponse) response;
   }

   /**
    * Sets the response object being wrapped.
    * 
    * @param response the response to set
    * @throws java.lang.IllegalArgumentException   if the response is null.
    */
   public void setResponse(StateAwareResponse response) {
      super.setResponse(response);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#getRenderParameters()
    */
   @Override
   public MutableRenderParameters getRenderParameters() {
      return ((StateAwareResponse)response).getRenderParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setWindowState(javax.portlet.WindowState)
    */
   @Override
   public void setWindowState(WindowState windowState)
         throws WindowStateException {
      ((StateAwareResponse)response).setWindowState(windowState);
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setPortletMode(javax.portlet.PortletMode)
    */
   @Override
   public void setPortletMode(PortletMode portletMode)
         throws PortletModeException {
      ((StateAwareResponse)response).setPortletMode(portletMode);
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      return ((StateAwareResponse)response).getPortletMode();
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      return ((StateAwareResponse)response).getWindowState();
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameters(java.util.Map)
    */
   @Deprecated
   @Override
   public void setRenderParameters(Map<String, String[]> parameters) {
      ((StateAwareResponse)response).setRenderParameters(parameters);
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameter(java.lang.String, java.lang.String)
    */
   @Deprecated
   @Override
   public void setRenderParameter(String key, String value) {
      ((StateAwareResponse)response).setRenderParameter(key, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameter(java.lang.String, java.lang.String[])
    */
   @Deprecated
   @Override
   public void setRenderParameter(String key, String... values) {
      ((StateAwareResponse)response).setRenderParameter(key, values);
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.io.Serializable)
    */
   @Override
   public void setEvent(QName name, Serializable value) {
      ((StateAwareResponse)response).setEvent(name, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setEvent(java.lang.String, java.io.Serializable)
    */
   @Override
   public void setEvent(String name, Serializable value) {
      ((StateAwareResponse)response).setEvent(name, value);
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#getRenderParameterMap()
    */
   @Deprecated
   @Override
   public Map<String, String[]> getRenderParameterMap() {
      return ((StateAwareResponse)response).getRenderParameterMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#removePublicRenderParameter(java.lang.String)
    */
   @Deprecated
   @Override
   public void removePublicRenderParameter(String name) {
      ((StateAwareResponse)response).removePublicRenderParameter(name);
   }

}
