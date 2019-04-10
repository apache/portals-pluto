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

import java.lang.annotation.Annotation;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.portlet.annotations.PortletSessionScoped;

/**
 * This is the Context implementation for the PortletSessionScoped custom CDI scope.
 * 
 * @author nick
 *
 */
public class PortletSessionScopedContext implements Context {

   public PortletSessionScopedContext() {
   }

   /* (non-Javadoc)
    * @see javax.enterprise.context.spi.Context#get(javax.enterprise.context.spi.Contextual)
    */
   @Override
   public <T> T get(Contextual<T> bean) {
      PortletSessionBeanHolder holder = PortletSessionBeanHolder.getBeanHolder();
      if (holder == null) {
         throw new ContextNotActiveException("The portlet session context is not active.");
      }
      return holder.getBean(bean);
   }

   /* (non-Javadoc)
    * @see javax.enterprise.context.spi.Context#get(javax.enterprise.context.spi.Contextual, javax.enterprise.context.spi.CreationalContext)
    */
   @Override
   public <T> T get(Contextual<T> bean, CreationalContext<T> crco) {
      PortletSessionBeanHolder holder = PortletSessionBeanHolder.getBeanHolder();
      
      if (holder == null) {
         throw new ContextNotActiveException("The portlet session context is not active.");
      }
      
      T inst = holder.getBean(bean);
      if (inst == null) {
         inst = bean.create(crco);
         holder.putBeanInstance(bean, crco, inst);
      }
      
      return inst;
   }

   /* (non-Javadoc)
    * @see javax.enterprise.context.spi.Context#getScope()
    */
   @Override
   public Class<? extends Annotation> getScope() {
      return PortletSessionScoped.class;
   }

   /* (non-Javadoc)
    * @see javax.enterprise.context.spi.Context#isActive()
    */
   @Override
   public boolean isActive() {
      PortletSessionBeanHolder holder = PortletSessionBeanHolder.getBeanHolder();
      return (holder != null);
   }

}
