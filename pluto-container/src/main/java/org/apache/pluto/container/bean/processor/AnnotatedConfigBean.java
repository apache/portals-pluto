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


package org.apache.pluto.container.bean.processor;

import javax.enterprise.context.ApplicationScoped;

/**
 * A container for the annotated method configuration.
 * 
 * @author Scott Nicklous
 *
 */
@ApplicationScoped
public class AnnotatedConfigBean {

   private AnnotatedMethodStore methodStore = null;
   private ConfigSummary summary = null;
   private RedirectScopedConfig redirectScopedConfig = null;
   private PortletStateScopedConfig stateScopedConfig = null;
   private PortletSessionScopedConfig sessionScopedConfig = null;
   
   /**
    * @return the methodStore
    */
   public AnnotatedMethodStore getMethodStore() {
      return methodStore;
   }

   /**
    * @param methodStore the methodStore to set
    */
   public void setMethodStore(AnnotatedMethodStore methodStore) {
      this.methodStore = methodStore;
   }

   /**
    * @return the summary
    */
   public ConfigSummary getSummary() {
      return summary;
   }

   /**
    * @param summary the summary to set
    */
   public void setSummary(ConfigSummary summary) {
      this.summary = summary;
   }

   /**
    * @return the redirectScopedConfig
    */
   public RedirectScopedConfig getRedirectScopedConfig() {
      return redirectScopedConfig;
   }

   /**
    * @param redirectScopedConfig the redirectScopedConfig to set
    */
   public void setRedirectScopedConfig(RedirectScopedConfig redirectScopedConfig) {
      this.redirectScopedConfig = redirectScopedConfig;
   }

   /**
    * @return the stateScopedConfig
    */
   public PortletStateScopedConfig getStateScopedConfig() {
      return stateScopedConfig;
   }

   /**
    * @param stateScopedConfig the stateScopedConfig to set
    */
   public void setStateScopedConfig(PortletStateScopedConfig stateScopedConfig) {
      this.stateScopedConfig = stateScopedConfig;
   }

   /**
    * @return the sessionScopedConfig
    */
   public PortletSessionScopedConfig getSessionScopedConfig() {
      return sessionScopedConfig;
   }

   /**
    * @param sessionScopedConfig the sessionScopedConfig to set
    */
   public void setSessionScopedConfig(PortletSessionScopedConfig sessionScopedConfig) {
      this.sessionScopedConfig = sessionScopedConfig;
   }
   
   
}
