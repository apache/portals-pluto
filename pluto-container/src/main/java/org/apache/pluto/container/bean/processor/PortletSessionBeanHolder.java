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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a container for PortletSessionScoped CDI beans.
 * 
 * @author nick
 *
 */
public class PortletSessionBeanHolder implements HttpSessionBindingListener, Serializable {
   private static final Logger LOG = LoggerFactory.getLogger(PortletSessionBeanHolder.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   

   private static final long serialVersionUID = 4713451590109713169L;
   private static final String ATTRIBNAME = "portletSessionBeanHolder";

   private class BeanInstance<T> implements Serializable {
      private static final long serialVersionUID = -2094530892049932082L;
      CreationalContext<T>    crco;
      T                       instance;
   }
   
   // Each instance of the bean holder gets its own map
   private Map<Contextual<?>, BeanInstance<?>> beans = 
         new ConcurrentHashMap<Contextual<?>, BeanInstance<?>>();
   
   // The ThreadLocal manages the holders so that there is one holder per thread.
   private static final ThreadLocal<PortletSessionBeanHolder> holders =
         new ThreadLocal<PortletSessionBeanHolder>();
   
   /**
    * private constructor
    */
   private PortletSessionBeanHolder() {
   }

   /**
    * Sets the portlet session bean holder in a ThreadLocal object for the given 
    * portlet session. If no bean holder exists in the session, a new one is created.
    * 
    * @param ps      The portlet session.
    * @return        The portlet session bean holder
    */
   public static void setBeanHolder(PortletSession ps) {
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Setting portlet session bean holder.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         txt.append(", PortletSession=").append(ps.getId());
         LOG.debug(txt.toString());
      }
      
      PortletSessionBeanHolder holder = (PortletSessionBeanHolder) ps.getAttribute(ATTRIBNAME);
      if (holder == null) {
         holder = new PortletSessionBeanHolder();
         ps.setAttribute(ATTRIBNAME, holder);

         if (isDebug) {
            StringBuilder txt = new StringBuilder(80);
            txt.append("Created new portlet session holder.");
            LOG.debug(txt.toString());
         }
      }
      holders.set(holder);
   }
   
   /**
    * Removes the bean holder for the current session.
    */
   public static void removeBeanHolder() {
      holders.remove();

      if (isDebug) {
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
    * Returns an instance for the contextual type, or null if none available.
    * 
    * @param bean       Contextual type (Bean) for which an instance is desired
    * @return           The instance, or null if none exists
    */
   @SuppressWarnings("unchecked")
   public <T> T getBean(Contextual<T> bean) {
      BeanInstance<?> bi = beans.get(bean);
  
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Getting bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         }
         if (bi == null) {
            txt.append(", instance is null.");
         }
         LOG.debug(txt.toString());
      }

      return (bi == null) ? null : (T) bi.instance;
   }
   
   /**
    * Adds a bean instance with associated creational context to the store for the
    * given contextual object (bean).
    * 
    * @param bean          The bean type
    * @param crco          The creational context
    * @param instance      The bean instance
    */
   public <T> void putBeanInstance(Contextual<T> bean, CreationalContext<T> crco, T instance) {
      BeanInstance<T> bi = new BeanInstance<T>();
      bi.crco = crco;
      bi.instance = instance;
      beans.put(bean, bi);
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Added bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         }
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Removes & destroys the given bean
    * @param bean
    */
   @SuppressWarnings("unchecked")
   protected <T> void remove(Contextual<T> bean) {
      BeanInstance<?> bi = beans.get(bean);
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removing bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         }
         if (bi == null) {
            txt.append(", instance is null.");
         }
         LOG.debug(txt.toString());
      }

      if (bi != null) {
         beans.remove(bean);
         bi.crco.release();
         bean.destroy((T)bi.instance, (CreationalContext<T>)bi.crco);
      }
   }
   
   /**
    * Remove & destroy all beans
    */
   protected void removeAll() {
      for (Contextual<?> bean : beans.keySet()) {
         remove(bean);
      }
   }

   /**
    * Session binding listener method - binding to session
    * 
    * @param arg0
    */
   @Override
   public void valueBound(HttpSessionBindingEvent arg0) {
   }

   /**
    * Session binding listener method - unbinding from session. 
    * This occurs only when the session times out or is destroyed (in our case).
    * 
    * @param arg0
    */
   @Override
   public void valueUnbound(HttpSessionBindingEvent evt) {
      if (isDebug) {
         LOG.debug("PortletSessionBeanHolder unbound from session. ID=" + evt.getName());
      }
      removeAll();
   }
}
