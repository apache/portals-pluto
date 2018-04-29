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

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * Listener for JSR 362 portlet preferences attribute testing. This validator tests for HttpSessionBindingListener
 *
 * @author ahmed
 *
 */
public class V2EnvironmentTests_PortletSession_ApiRender_Binding
    implements HttpSessionBindingListener, Serializable {

  private static final long serialVersionUID = 1L;

  private boolean tr34;

  @Override
  public void valueBound(HttpSessionBindingEvent arg0) {
    setTr34(true);
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent arg0) {
    setTr34(false);
  }

  public boolean getTr34() {
    return tr34;
  }

  public void setTr34(boolean tr34) {
    this.tr34 = tr34;
  }
}
