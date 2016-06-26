/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.attributes;

import javax.portlet.tck.portlets.EnvironmentTests_PortletSession_ApiRender;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Listener for JSR 362 portlet preferences attribute testing. This validator tests for HttpSessionAttributeListener
 *
 * @author ahmed
 *
 */
public class V2EnvironmentTests_PortletSession_ApiRender_Attribute implements HttpSessionAttributeListener {
  
  @Override
  public void attributeAdded(HttpSessionBindingEvent arg0) {
    EnvironmentTests_PortletSession_ApiRender.tr_36=1;
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent arg0) {
    EnvironmentTests_PortletSession_ApiRender.tr_36=2;
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent arg0) {
    EnvironmentTests_PortletSession_ApiRender.tr_36=3;
  }
  
}
