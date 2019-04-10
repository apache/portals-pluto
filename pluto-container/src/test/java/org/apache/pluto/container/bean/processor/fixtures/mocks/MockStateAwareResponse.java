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
 * @author Scott
 *
 */
public class MockStateAwareResponse extends MockPortletResponse implements StateAwareResponse {

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#getRenderParameters()
    */
   @Override
   public MutableRenderParameters getRenderParameters() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setPortletMode(javax.portlet.PortletMode)
    */
   @Override
   public void setPortletMode(PortletMode arg0) throws PortletModeException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.MutableRenderState#setWindowState(javax.portlet.WindowState)
    */
   @Override
   public void setWindowState(WindowState arg0) throws WindowStateException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#getRenderParameterMap()
    */
   @Override
   public Map<String, String[]> getRenderParameterMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#removePublicRenderParameter(java.lang.String)
    */
   @Override
   public void removePublicRenderParameter(String arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.io.Serializable)
    */
   @Override
   public void setEvent(QName arg0, Serializable arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setEvent(java.lang.String, java.io.Serializable)
    */
   @Override
   public void setEvent(String arg0, Serializable arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameter(java.lang.String, java.lang.String)
    */
   @Override
   public void setRenderParameter(String arg0, String arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameter(java.lang.String, java.lang.String[])
    */
   @Override
   public void setRenderParameter(String arg0, String... arg1) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.StateAwareResponse#setRenderParameters(java.util.Map)
    */
   @Override
   public void setRenderParameters(Map<String, String[]> arg0) {
   }

}
