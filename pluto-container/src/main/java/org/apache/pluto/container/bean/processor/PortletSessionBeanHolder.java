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

import java.io.Serializable;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a container for PortletSessionScoped CDI beans.
 * 
 * @author nick
 * 
 */
public class PortletSessionBeanHolder implements Serializable {
   private static final Logger  LOG              = LoggerFactory
                                                       .getLogger(PortletSessionBeanHolder.class);
   private static final boolean isTrace          = LOG.isTraceEnabled();

   private static final long    serialVersionUID = 4713451590109713169L;
   private static final String  ATTRIBNAME       = "portletSessionBeanHolder";

   // The ThreadLocal manages the holders so that there is one holder per thread.
   private static final ThreadLocal<PortletSessionBeanHolder> holders          = new ThreadLocal<PortletSessionBeanHolder>();

   // ========== Instance vars

   private final PortletSessionScopedBeanMap                  beans;
   private final PortletSessionScopedConfig                   config;
   private final String                                       windowId;

   /**
    * private constructor ... constructed once per thread
    */
   private PortletSessionBeanHolder(PortletSessionScopedBeanMap beans, String windowId,
         PortletSessionScopedConfig config) {
      this.beans = beans;
      this.windowId = windowId;
      this.config = config;
   }

   /**
    * Sets the portlet session bean holder in a ThreadLocal object for the given portlet session. If no bean holder
    * exists in the session, a new one is created.
    * 
    * @param ps
    *           The portlet session.
    * @return The portlet session bean holder
    */
   public static void setBeanHolder(PortletRequest req, PortletSessionScopedConfig config) {

      PortletSession ps = req.getPortletSession();
      String windowId = req.getWindowID();

      PortletSessionScopedBeanMap map = (PortletSessionScopedBeanMap) ps.getAttribute(ATTRIBNAME,
            PortletSession.APPLICATION_SCOPE);
      
      boolean createdMap = false;
      if (map == null) {
         map = new PortletSessionScopedBeanMap();
         ps.setAttribute(ATTRIBNAME, map, PortletSession.APPLICATION_SCOPE);
         createdMap = true;
      }

      PortletSessionBeanHolder holder = new PortletSessionBeanHolder(map, windowId, config);
      holders.set(holder);

      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Set portlet session bean holder.");
         txt.append(" ThreadId: ").append(Thread.currentThread().getId());
         txt.append(", PortletSession: ").append(ps.getId());
         txt.append(", WindowId: ").append(windowId);
         txt.append(", Added new BeanMap to session: ").append(createdMap);
         LOG.debug(txt.toString());
      }
   }

   /**
    * Removes the bean holder for the current session.
    */
   public static void removeBeanHolder() {
      holders.remove();

      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removed portlet session bean holder.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         LOG.debug(txt.toString());
      }
   }

   /**
    * Returns the portlet session bean holder that was set for the thread.
    * 
    * @return
    */
   public static PortletSessionBeanHolder getBeanHolder() {
      return holders.get();
   }
   
   /**
    * Removes the bean holder for the current thread and
    * returns the removed instance to the caller.
    * 
    * @return  the removed bean holder
    */
   public static PortletSessionBeanHolder deregister() {
      PortletSessionBeanHolder holder = holders.get();
      holders.remove();
      return holder;
   }
   
   /**
    * Registers the provided bean holder for the current thread.
    * 
    * @param holder the bean holder to register
    */
   public static void register(PortletSessionBeanHolder holder) {
      holders.set(holder);
   }

   /**
    * Returns an instance for the contextual type, or null if none available.
    * 
    * @param bean
    *           Contextual type (Bean) for which an instance is desired
    * @return The instance, or null if none exists
    */
   public <T> T getBean(Contextual<T> bean) {
      String id = null;
      if (config.isPortletScoped(bean)) {
         id = windowId;
      }
      return beans.getBeanInstance(id, bean);
   }

   /**
    * Adds a bean instance with associated creational context to the store for the given contextual object (bean).
    * 
    * @param bean
    *           The bean type
    * @param crco
    *           The creational context
    * @param instance
    *           The bean instance
    */
   public <T> void putBeanInstance(Contextual<T> bean, CreationalContext<T> crco, T instance) {
      String id = null;
      if (config.isPortletScoped(bean)) {
         id = windowId;
      }
      beans.putBeanInstance(id, bean, crco, instance);
   }
}
