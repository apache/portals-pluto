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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import java.io.Serializable;

/**
 * This is a container for RedirectScoped CDI beans.
 * 
 * @author Scott Nicklous
 * @author Neil Griffin
 *
 */
public class RedirectScopedBeanHolder implements Serializable {
   private static final Logger  LOG              = LoggerFactory
                                                       .getLogger(RedirectScopedBeanHolder.class);
   private static final boolean isTrace          = LOG.isTraceEnabled();

   private static final long    serialVersionUID = 3856727894564632122L;
   private static final String  ATTRIBNAME       = "redirectScopedBeanHolder";

   // The ThreadLocal manages the holders so that there is one holder per thread.
   private static final ThreadLocal<RedirectScopedBeanHolder> holders = new ThreadLocal<>();

   // ========== Instance vars

   private final PortletSessionScopedBeanMap beans;
   private final String                      windowId;

   /**
    * private constructor ... constructed once per thread
    */
   private RedirectScopedBeanHolder(PortletSessionScopedBeanMap beans, String windowId) {
      this.beans = beans;
      this.windowId = windowId;
   }

   /**
    * Sets the redirect scope bean holder in a ThreadLocal object for the portlet session associated with the given request. If no bean holder
    * exists in the session, a new one is created.
    * 
    * @param req The portlet request.
    * @return The redirect scope bean holder
    */
   public static void setBeanHolder(PortletRequest req) {

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

      RedirectScopedBeanHolder
		  holder = new RedirectScopedBeanHolder(map, windowId);
      holders.set(holder);

      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Set redirect scope bean holder.");
         txt.append(" ThreadId: ").append(Thread.currentThread().getId());
         txt.append(", PortletSession: ").append(ps.getId());
         txt.append(", WindowId: ").append(windowId);
         txt.append(", Added new BeanMap to session: ").append(createdMap);
         LOG.debug(txt.toString());
      }
   }

   /**
    * Removes the bean holder for the current session.
    * @param destroyBeans Flag indicating whether or not the beans stored in the session should be destroyed.
    */
   public static void removeBeanHolder(boolean destroyBeans) {

      if (destroyBeans) {
        RedirectScopedBeanHolder holder = holders.get();
        holder.removeBeans();
      }
      holders.remove();

      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removed redirect scope bean holder.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         LOG.debug(txt.toString());
      }
   }

   /**
    * Returns the redirect scope bean holder that was set for the thread.
    * 
    * @return
    */
   public static RedirectScopedBeanHolder getBeanHolder() {
      return holders.get();
   }
   
   /**
    * Removes the bean holder for the current thread and
    * returns the removed instance to the caller.
    * 
    * @return  the removed bean holder
    */
   public static RedirectScopedBeanHolder deregister() {
      RedirectScopedBeanHolder holder = holders.get();
      holders.remove();
      return holder;
   }
   
   /**
    * Registers the provided bean holder for the current thread.
    * 
    * @param holder the bean holder to register
    */
   public static void register(RedirectScopedBeanHolder holder) {
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
      return beans.getBeanInstance(windowId, bean);
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
      beans.putBeanInstance(windowId, bean, crco, instance);
   }

   private void removeBeans() {
   	  beans.removeByWindowId(windowId);
   }
}
